package bg.smg.university.service;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import bg.smg.university.model.User;

public class CustomUserDetailsService implements UserDetailsService {

	// TODO: make it so that it does not load always the same username
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Collection<SimpleGrantedAuthority> grantedAuthorities = new LinkedList<SimpleGrantedAuthority>();
		grantedAuthorities.add(new SimpleGrantedAuthority("STUDENT"));
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode("password");
		UserDetails user = new User("yav.vasilev@gmail.com",
				"Iavor",
				"Vassilev",
				"Bulgaria",
				"Han Omurtag 14",
				"username",
				encodedPassword,
				grantedAuthorities,
				true,
				false,
				false);
		return user;
	}

}
