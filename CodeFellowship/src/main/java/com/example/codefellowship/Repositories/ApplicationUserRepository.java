package com.example.codefellowship.Repositories;

import com.example.codefellowship.domain.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
}





