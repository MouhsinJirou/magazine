package org.sid.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    
	    http.formLogin();
	    http.authorizeRequests().antMatchers("/login/**","/auteur/articlesreduit","/motcle/articlesreduit").permitAll();
	    http.authorizeRequests().antMatchers("/articles/**","/auteur/articles","/motcle/articles","/rapportjury/**").hasAuthority("AUTEUR");
	    http.authorizeRequests().antMatchers("/etatarticle/**,/rapportjury/**","/articlesnew","/articlesconforme","/evaluations/**","/affectations/**","/articlejury/**","/jury").hasAuthority("COMITE");
	    http.authorizeRequests().antMatchers("/articlejury/**","/evaluationsid/**").hasAuthority("jury");
	    http.authorizeRequests().anyRequest().authenticated();
		
	    
	}
}
