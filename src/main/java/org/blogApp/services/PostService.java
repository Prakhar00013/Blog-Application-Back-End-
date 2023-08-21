package org.blogApp.services;

import java.util.List;

import org.blogApp.payloads.PostDto;
import org.blogApp.payloads.PostResponse;

public interface PostService {

	// Create post
	PostDto createPost(PostDto postDto, Integer userId, Integer categoryId);

	// Update Post
	PostDto updatePost(PostDto post, Integer postId);

	// Delete Post
	void deletePost(Integer postId);

	// Get post by Id
	PostDto getPostById(Integer postId);

	// Get all posts
	PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir);

	// Get posts by category
	List<PostDto> getPostsByCategory(Integer categoryId);

	// Get all posts by user
	List<PostDto> getPostsByUser(Integer userId);

	// Search post
	List<PostDto> searchPost(String keyword);
}
