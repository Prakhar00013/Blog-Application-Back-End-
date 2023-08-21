package org.blogApp.controllers;

import java.util.List;
import org.blogApp.payloads.ApiResponse;
import org.blogApp.payloads.UserDto;
import org.blogApp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/user")
public class userController {
	
	@Autowired
	private UserServices userService;

/*
//	Create User
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
//		userDto createdUser = this.userService.createUser(userDto);
//		return new ResponseEntity<userDto>(createdUser, HttpStatus.CREATED);//METHOD TYPE: ResponseEntity<userDto>
		return ResponseEntity.ok(this.userService.createUser(userDto));
	}
*/
	
//	Update User
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<ApiResponse> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId){
//		userDto updateUser = this.userService.updateUser(userDto, uId);
//		return ResponseEntity.ok(updateUser);//METHOD TYPE: ResponseEntity<userDto>
		this.userService.updateUser(userDto, uId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Updated Successfully", true), HttpStatus.OK);
	}
	
//	Delete User
	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUserById(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true), HttpStatus.OK);
	}
	
//	Get User By ID
	@GetMapping("/getUser/{userId}")
	public ResponseEntity<UserDto> getUserById(@PathVariable Integer userId){
//		userDto userById = this.userService.getUserById(userId);
//		return new ResponseEntity<userDto>(userById, HttpStatus.OK);
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	
//	Get All Users
	@GetMapping("/getAllUsers")
	public ResponseEntity<List<UserDto>> getAllUsers(){
//		List<userDto> allUsers = this.userService.getAllUsers();
//		return new ResponseEntity<List<userDto>>(allUsers, HttpStatus.OK);
		return ResponseEntity.ok(this.userService.getAllUsers());
	}
}
