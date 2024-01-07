package bg.smg.university.model;

import lombok.Data;
import lombok.NoArgsConstructor;
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
	private String password;
	private String repeatedPassword;
	
}
