package com.blogsite.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blogsite.model.Comments;

@Repository
public interface Commentsrepository extends JpaRepository<Comments, Long> {
	
}
