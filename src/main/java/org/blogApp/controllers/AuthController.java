package org.blogApp.controllers;

import org.blogApp.exceptions.InvalidCredentialsException;
import org.blogApp.payloads.JwtAuthRequest;
import org.blogApp.payloads.JwtAuthResponse;
import org.blogApp.payloads.UserDto;
import org.blogApp.security.JwtTokenHelper;
import org.blogApp.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private JwtTokenHelper jwtTokenHelper;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServices userServices;
	
	@PostMapping("/register")
	public ResponseEntity<UserDto> registerUser(@Valid @RequestBody UserDto userDto){
		UserDto registered = this.userServices.registerNewUser(userDto);
		return new ResponseEntity<UserDto>(registered,HttpStatus.CREATED);
	}
	
	@PostMapping("/register/admin")
	public ResponseEntity<UserDto> registerAdmin(@Valid @RequestBody UserDto userDto){
		UserDto registered = this.userServices.registerNewAdmin(userDto);
		return new ResponseEntity<UserDto>(registered,HttpStatus.CREATED);
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request) throws Exception{
		
		this.authenticate(request.getUsername(),request.getPassword());
		
		UserDetails userDetails = this.userDetailsService.loadUserByUsername(request.getUsername());
		
		String token = this.jwtTokenHelper.generateToken(userDetails);
		
		JwtAuthResponse authResponse = new JwtAuthResponse();
		authResponse.setToken(token);
		
		return new ResponseEntity<JwtAuthResponse>(authResponse,HttpStatus.OK);
	}

	private void authenticate(String username, String password) throws Exception{
		
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
		
		try {
			
			this.authenticationManager.authenticate(authenticationToken);
			
		} catch (BadCredentialsException e) {
			System.out.println("Invalid Credentials!");
			throw new InvalidCredentialsException("Password is incorrect!");
		}
		
	}
}
