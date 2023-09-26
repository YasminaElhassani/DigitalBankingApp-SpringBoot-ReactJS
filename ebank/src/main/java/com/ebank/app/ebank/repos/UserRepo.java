package com.ebank.app.ebank.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ebank.app.ebank.entities.User;



@Repository
public interface UserRepo extends JpaRepository<User,Long> {
    
}
