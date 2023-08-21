package org.blogApp.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private int categoryId;

	@NotBlank(message = "Title must not be empty")
	@Size(max = 100, message = "Title must not be more than 100 chars")
	private String categoryTitle;

	@NotBlank(message = "Description must not be empty")
	@Size(max = 100, message = "Description must not be more than 100 chars")
	private String categoryDescription;
}
