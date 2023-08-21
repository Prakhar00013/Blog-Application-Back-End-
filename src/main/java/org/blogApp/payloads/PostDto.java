package org.blogApp.payloads;

import java.util.HashSet;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostDto {
	
	private int id;
	
	@NotBlank(message = "Post title can not be blank")
	@Size(max = 100, message = "Title can not be more than 100 chars")
	private String title;
	
	@NotBlank(message = "Content can not be blank")
	@Size(max = 1000, message = "Content can not be more than 1000 chars")
	private String content;
	
	private String imageName;
	
	private String addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private HashSet<CommentDto> comments = new HashSet<>();
}
