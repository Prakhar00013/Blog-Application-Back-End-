package org.blogApp.repositories;

import java.util.List;

import org.blogApp.entities.Category;
import org.blogApp.entities.Post;
import org.blogApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Integer>{

	List<Post> findByUser(User user);
	List<Post> findByCategory(Category category);
	List<Post> findByTitleContaining(String keyword);
}
