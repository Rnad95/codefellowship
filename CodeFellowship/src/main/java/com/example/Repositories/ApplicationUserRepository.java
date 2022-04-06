package com.example.Repositories;

import com.example.domain.ApplicationUser;
import org.springframework.data.repository.CrudRepository;

public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Integer> {
    ApplicationUser findByUsername(String username);
    ApplicationUser findById(int Id);
}





