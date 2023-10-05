package com.blogsite.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blogsite.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	
}
