package com.blogsite.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.blogsite.model.Blog;
@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> {
	@Query("SELECT b FROM Blog b ORDER BY b.blog_id")
	List<Blog> findAllBlogsWithPagination(int limit, int offset);
}
