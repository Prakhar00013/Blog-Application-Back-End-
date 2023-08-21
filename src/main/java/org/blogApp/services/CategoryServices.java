package org.blogApp.services;

import java.util.List;

import org.blogApp.payloads.CategoryDto;

public interface CategoryServices {

	// Create Category
	CategoryDto createCategory(CategoryDto categoryDto);

	// Update Category
	CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

	// Get Category By ID
	CategoryDto getCategory(Integer categoryId);

	// Delete Category
	void deleteCategory(Integer categoryId);

	// Get All Category
	List<CategoryDto> getCategories();
}
