package com.blogsite.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.blogsite.model.Blog;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {

}
