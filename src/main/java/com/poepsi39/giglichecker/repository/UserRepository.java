package com.poepsi39.giglichecker.repository;

import com.poepsi39.giglichecker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByNameContainingIgnoreCase(String name);
}
