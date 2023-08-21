package org.blogApp.services.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.blogApp.entities.Category;
import org.blogApp.entities.Post;
import org.blogApp.entities.User;
import org.blogApp.exceptions.ResourceNotFoundException;
import org.blogApp.payloads.PostDto;
import org.blogApp.payloads.PostResponse;
import org.blogApp.repositories.CategoryRepo;
import org.blogApp.repositories.PostRepo;
import org.blogApp.repositories.UserRepository;
import org.blogApp.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private PostRepo postRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PostDto createPost(PostDto postDto, Integer userId, Integer categoryId) {

		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));

		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		Post post = this.modelMapper.map(postDto, Post.class);

		post.setCategory(category);
		post.setUser(user);
		post.setImageName("default.png");
		post.setAddedDate(new Date());

		Post newPost = this.postRepo.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));

		post.setTitle(postDto.getTitle());
		post.setContent(postDto.getContent());
		post.setImageName(postDto.getImageName());
		Post updatedPost = this.postRepo.save(post);
		return this.modelMapper.map(updatedPost, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
		this.postRepo.delete(post);
	}

	@Override
	public PostDto getPostById(Integer postId) {
		Post post = this.postRepo.findById(postId)
				.orElseThrow(() -> new ResourceNotFoundException("Post", "Id", postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public PostResponse getAllPosts(Integer pageNumber, Integer pageSize, String sortBy, String sortDir) {
		
		Sort sort = (sortDir.equals("asc"))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

	    Pageable page = PageRequest.of(pageNumber, pageSize, sort);

		Page<Post> pagePost = this.postRepo.findAll(page);
		
		List<Post> allPosts = pagePost.getContent();

		List<PostDto> postDtos = allPosts.stream().map((pst) -> this.modelMapper.map(pst, PostDto.class))
				.collect(Collectors.toList());
		
		PostResponse postResponse = new PostResponse();
		
		postResponse.setPostContent(postDtos);
		postResponse.setPageNumber(pagePost.getNumber());
		postResponse.setPageSize(pagePost.getSize());
		postResponse.setTotalElements(pagePost.getTotalElements());
		postResponse.setTotalPages(pagePost.getTotalPages());
		postResponse.setLastPage(pagePost.isLast());
		
		return postResponse;
	}

	@Override
	public List<PostDto> getPostsByCategory(Integer categoryId) {
		Category category = this.categoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Id", categoryId));

		List<Post> posts = this.postRepo.findByCategory(category);

		List<PostDto> postDtos = posts.stream().map((pst) -> this.modelMapper.map(pst, PostDto.class))
				.collect(Collectors.toList());

		return postDtos;

	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "Id", userId));
		List<Post> posts = this.postRepo.findByUser(user);
		List<PostDto> postDtos = posts.stream().map((pst) -> this.modelMapper.map(pst, PostDto.class))
				.collect(Collectors.toList());
		return postDtos;
	}

	@Override
	public List<PostDto> searchPost(String keyword) {
		List<Post> titleContaining = this.postRepo.findByTitleContaining(keyword);
		List<PostDto> postDtos = titleContaining.stream().map((pst)-> this.modelMapper.map(pst, PostDto.class)).collect(Collectors.toList());
		return postDtos;
	}

}
