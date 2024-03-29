package br.univille.cellphone2019;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import br.univille.cellphone2019.service.MyUserDetailService;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled=true)


public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private MyUserDetailService userDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*auth.inMemoryAuthentication()
		.withUser("user").password("user").roles("USER")
		.and()
		.withUser("admin").password("admin").roles("ADMIN");*/
		auth.authenticationProvider(authenticationProvider());
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
	DaoAuthenticationProvider authProvider
	= new DaoAuthenticationProvider();
	authProvider.setUserDetailsService(userDetailsService);
	authProvider.setPasswordEncoder(passwordEncoder());
	return authProvider;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		String[] resources = new String[]{
		"/", "/home","/pictureCheckCode","/include/**",
		"/css/**","/icons/**","/images/**","/js/**","/layer/**"
		};

		http
			.csrf().disable()
		        .authorizeRequests()
		            .anyRequest().authenticated()
		            .antMatchers(resources).permitAll()
		        .and()
		            .formLogin().loginPage("/login")
		            .successForwardUrl("/")
		        .permitAll();
		}
	@Bean
	public PasswordEncoder passwordEncoder() {	
		return NoOpPasswordEncoder.getInstance();
		
	}

}
