package com.robson.webservices_spring.model.repositories;

import com.robson.webservices_spring.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
