package org.blogApp.controllers;

import java.util.List;
import org.blogApp.payloads.ApiResponse;
import org.blogApp.payloads.CategoryDto;
import org.blogApp.services.CategoryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryServices categoryServices;
	
	//Create Category
	@PostMapping("/createCategory")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){		
		return ResponseEntity.ok(this.categoryServices.createCategory(categoryDto));
	}
	//Update Category
	@PutMapping("/updateCategory/{categoryId}")
	public ResponseEntity<ApiResponse> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
		this.categoryServices.updateCategory(categoryDto, categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Updated Successfully", true),HttpStatus.OK);
	}
	//Delete Category
	@DeleteMapping("/deleteCategory/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer categoryId){
		this.categoryServices.deleteCategory(categoryId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category Deleted Successfully", true),HttpStatus.OK);
	}
	//Get Category
	@GetMapping("/getCategory/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer categoryId){
		CategoryDto category = this.categoryServices.getCategory(categoryId);
		return ResponseEntity.ok(category);
	}
	//Get Categories
	@GetMapping("/getAllCategories")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		return ResponseEntity.ok(this.categoryServices.getCategories());
	}
}
