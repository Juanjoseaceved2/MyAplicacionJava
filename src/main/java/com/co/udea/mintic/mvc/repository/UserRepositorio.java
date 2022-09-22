package com.co.udea.mintic.mvc.repository;

import com.co.udea.mintic.mvc.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositorio extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
