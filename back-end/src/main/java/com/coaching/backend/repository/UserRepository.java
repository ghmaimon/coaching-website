package com.coaching.backend.repository;

import com.coaching.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository<T extends User> extends JpaRepository<T, Long> {
    T findByEmail(String email);
    T findById(String email);
    List<T> findByFirstNameAndLastName(String first_name, String last_name);
    List<T> findByFirstName(String first_name);
    List<T> findByLastName(String last_name);
}
