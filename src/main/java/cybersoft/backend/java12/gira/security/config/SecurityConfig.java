package cybersoft.backend.java12.gira.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import cybersoft.backend.java12.gira.jwt.JwtAuthorizationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    @Qualifier("userDetailsServiceImpl")
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtAuthorizationFilter jwtAuthorizationFilter;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
//	@Bean
//	public JwtAuthorizationFilter jwtAuthorizationFilter() {
//		return new JwtAuthorizationFilter();
//	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// c???u h??nh CORS
		http.cors();
		
		// c???u h??nh session
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		// th??m filter ????? validate jwtoken
		http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
		
		// disable csrf
		http.csrf().disable();
		
		// c???u h??nh x??c th???c cho c??c api
		http.antMatcher("/api/**").authorizeRequests()
			.antMatchers("/api/auth/login").permitAll()
			.anyRequest().authenticated();
			
	}
	
	
}
