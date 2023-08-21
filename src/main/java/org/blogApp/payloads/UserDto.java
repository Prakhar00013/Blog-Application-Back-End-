package org.blogApp.payloads;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min = 4, message = "Name must be atleast 4 characters")
	private String name;
	@Email(message = "Email is not valid")
	private String email;
	@NotEmpty
	@Size(min = 4, max = 10, message = "Password must be min of 3 chars and max of 10 chars")
	private String password;
	@NotEmpty
	@Size(max = 100, message = "About can not be more than 100 chars")
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();
}
