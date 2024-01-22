package bg.smg.university.model;

import java.util.Collection;
import java.util.LinkedList;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("user")
public class User implements UserDetails {

	private @Id int id;
	
	private String email;
	
	@Column("first_name")
	private String firstName;
	
	@Column("last_name")
	private String lastName;
	
	private String country;
	private String address;
	private String username;
	private String password;
	private Roles authority;
	private boolean enabled; // true if account is enabled
	private boolean expired; // true if account is expired
	private boolean locked; // true if account is locked
	
	public User(StudentRegisterModel student) {
		setEmail(student.getEmail());
		setFirstName(student.getFirstName());
		setLastName(student.getLastName());
		setCountry(student.getCountry());
		setAddress(student.getAddress());
		setUsername(student.getUsername());
		setPassword(student.getEncodedPassword());
		setAuthority(Roles.STUDENT);
		setEnabled(true);
		setExpired(false);
		setLocked(false);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<SimpleGrantedAuthority> authorities = new LinkedList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(authority.toString()));
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
