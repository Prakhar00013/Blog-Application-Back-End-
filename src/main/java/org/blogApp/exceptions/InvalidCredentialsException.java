package org.blogApp.exceptions;
import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class InvalidCredentialsException extends RuntimeException{
		String username;
		String password;
		
		public InvalidCredentialsException(String username, String password) {
			super(String.format("username or password is invalid"));
			this.username = username;
			this.password = password;
		}

		public InvalidCredentialsException(String message) {
			super(message);
		}

		public InvalidCredentialsException() {
			super();
		}
}
