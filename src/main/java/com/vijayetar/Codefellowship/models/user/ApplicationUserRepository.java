package com.vijayetar.Codefellowship.models.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRepository extends JpaRepository <ApplicationUser, Long> {
    public ApplicationUser findByUsername(String username);
}
