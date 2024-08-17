package com.crud.hibernate.repositories;

import com.crud.hibernate.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * User repository.
 */
public interface UserRepository extends JpaRepository<User, Integer> {

}
