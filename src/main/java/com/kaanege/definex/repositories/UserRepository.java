package com.kaanege.definex.repositories;

import com.kaanege.definex.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByFullName(String name);

    Optional<User> findBySsn(String ssn);
}
