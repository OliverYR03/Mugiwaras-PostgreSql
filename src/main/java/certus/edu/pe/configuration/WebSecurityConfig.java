package certus.edu.pe.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled= true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/static/js/adminlte.js","/css/**", "/images/**", "/js/**","/video/", "/", "/principal", "/home", "/inicio", "/logeo", "/login","/rest/**")
		.permitAll()
		.antMatchers("/platos/listarPlato").hasAnyRole("ADMIN","LECTOR","CREADOR","EDITOR","DEPURADOR")
		.antMatchers("/platos/nuevo").hasAnyRole("ADMIN","CREADOR")
		.antMatchers("/platos/guardar").hasAnyRole("ADMIN","CREADOR","EDITOR")
		.antMatchers("/platos/actualizar/**").hasAnyRole("ADMIN","EDITOR")
		.antMatchers("/platos/eliminar/**").hasAnyRole("ADMIN","DEPURADOR")
		
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").defaultSuccessUrl("/platos/listarPlato", true).permitAll()
		.and().logout()
		.permitAll();
	}
    
		@Autowired
		public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
			PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
			auth.inMemoryAuthentication().withUser("admin").password(encoder.encode("admin")).roles("ADMIN").and()
			.withUser("oliver").password(encoder.encode("oliver")).roles("ADMIN").and()
			.withUser("jhan").password(encoder.encode("jhan")).roles("CREADOR").and()
			.withUser("yair").password(encoder.encode("yair")).roles("DEPURADOR").and()
			.withUser("nicole").password(encoder.encode("nicole")).roles("EDITOR","LECTOR").and()
			.withUser("lucero").password(encoder.encode("lucero")).roles("LECTOR").and();
	
		}
}
