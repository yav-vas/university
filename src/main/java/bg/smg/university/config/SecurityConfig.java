package bg.smg.university.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import bg.smg.university.repository.UserRepository;
import bg.smg.university.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private final UserRepository userRepository;

    @Autowired
    public SecurityConfig(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http
			.authorizeHttpRequests((authorize) -> authorize
					.requestMatchers("/", "/register").permitAll()
					.anyRequest().authenticated()
			)
			.formLogin(form -> form
					.loginPage("/login")
					.permitAll()		
			);
		
		return http.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public CustomUserDetailsService customUserDetailsService() {
		return new CustomUserDetailsService(userRepository);
	}
	
	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new SimpleUrlAuthenticationSuccessHandler("/");
	}
}
