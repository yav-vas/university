package bg.smg.university.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

	private String email;
	private String firstName;
	private String lastName;
	private String country;
	private String address;
	private String username;
	private String password;
	private Collection<SimpleGrantedAuthority> authorities;
	private boolean enabled; // true if account is enabled
	private boolean expired; // true if account is expired
	private boolean locked; // true if account is locked
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return !expired;
	}
	
	@Override
	public boolean isAccountNonLocked() {
		return !locked;
	}
	
	@Override
	// credentials never expire
	public boolean isCredentialsNonExpired() {
		return true;
	}
	
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
