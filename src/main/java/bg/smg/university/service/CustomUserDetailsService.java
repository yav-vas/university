package bg.smg.university.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import bg.smg.university.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails user = userRepository.findByUsername(username);
		
		if (user == null) {
			throw new UsernameNotFoundException("No user with the specified username was found in the database");
		}
		
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String encodedPassword = encoder.encode("password");
//		System.out.println(encodedPassword);
//		UserDetails user = new User(0,
//				"yav.vasilev@gmail.com",
//				"Iavor",
//				"Vassilev",
//				"Bulgaria",
//				"Han Omurtag 14",
//				"username",
//				encodedPassword,
//				Roles.STUDENT,
//				true,
//				false,
//				false);
		return user;
	}

}
