package org.blogApp.services;

import java.util.List;

import org.blogApp.payloads.UserDto;

public interface UserServices {
	UserDto registerNewUser(UserDto userDto);
	UserDto registerNewAdmin(UserDto userDto);
//	UserDto createUser(UserDto userDto);
	UserDto updateUser(UserDto userDto, Integer userId);
	UserDto getUserById(Integer userId);
	void deleteUserById(Integer userId);
	List<UserDto> getAllUsers();
}
