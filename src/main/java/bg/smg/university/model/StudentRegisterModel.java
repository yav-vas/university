package bg.smg.university.model;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRegisterModel {
	
	private String email;
	private String firstName;
	private String lastName;
	private String country;
	private String address;
	private String username;
	@Getter(AccessLevel.NONE) private String password;
	private String repeatedPassword;
	
	public String getEncodedPassword() {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(password);
		return encodedPassword;
	}
	
}
