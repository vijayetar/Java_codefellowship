package com.vijayetar.Codefellowship;

import com.vijayetar.Codefellowship.controllers.ApplicationUserController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

// Necessary to manually import
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

// necessary matchers to manually import
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CodefellowshipApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ApplicationUserController applicationUserController;


	@Test
	void contextLoads() {
	}

	@Test
	public void homePageShouldRenderWithH1() throws Exception {
		this.mockMvc.perform(get("/"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>Home Page </h1>")));
	}
	@Test
	public void loginPageShouldRenderWithH1andForm() throws Exception {
		this.mockMvc.perform(get("/login"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1 >Login</h1>")))
				.andExpect(content().string(containsString("<form action=\"/login\" method=\"POST\">")));
	}
	@Test
	public void signInPageShouldRenderWithH1andForm() throws Exception {
		this.mockMvc.perform(get("/newUser"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("<h1>Signup</h1>")))
				.andExpect(content().string(containsString("<form action=\"/signIn\" method=\"POST\">")));
	}

}
