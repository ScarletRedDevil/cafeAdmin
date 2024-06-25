package com.sds.cafeadmin;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

//스프링 3.0 부터 스프링빈 xml 파일을 대신하여 어노테이션 기반으로 설정할 수 있도록 지원..
@Configuration
public class SecurityConfig {
	
	//스프링이 지원하는 단방향 암호화(해시) 객체 등록
	@Bean 
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//우리가 spring mvc 에서 AOP를 이용하여 uri를 걸러낸 작업을 스프링 부트 시큐리티에서는 보다 쉽고 체계적으로 지원
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
		
		//필터링 할 uri 명시..
		httpSecurity
			.authorizeHttpRequests(
					(auth) -> auth
					.requestMatchers("/admin/**").permitAll() 
					.requestMatchers("/product_img/**").permitAll() 
//					.requestMatchers("/**").permitAll() 
					.requestMatchers("/admin/loginform", "/admin/login","/admin/registform","/admin/regist").permitAll() 
					//롤은 권한의 집합을 의미하며, hasRole()  메서드는 롤을 사용하게 되고, 내부적으로 ROLE_  접두어가 붙음
					.anyRequest().authenticated()
			);
	
		httpSecurity
			.formLogin((auth)->
				auth.loginPage("/admin/loginform")
				.successHandler(loginEventHandler()) //개발자가 정의한 핸들러 등록...
				.failureHandler(loginFailHandler())
				.loginProcessingUrl("/admin/login")
				.usernameParameter("uid")
				.passwordParameter("pwd")
			);
		
		//로그아웃 설정
		httpSecurity
		.logout(logout -> logout
				.logoutUrl("/admin/logout")//로그아웃 요청 페이지 경로 
				.logoutSuccessUrl("/")//로그아웃 처리후 보내버릴 링크
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.deleteCookies("JSESSIONID")
				);
		
		//토큰 비활성화 
		httpSecurity.csrf((auth)->auth.disable());
		
		return httpSecurity.build();
	}

	/*-----------------------------------------------------------
	  OAuth 유져와  시큐리티를 이용한 홈페이지 로그인 유저가 session에 공통의 member DTO를
	  갖고 있게 하면, header 뿐 아니라, 회원 정보를 세션에서 꺼내올때 member로 통일 할 수 있다.. 
	  이를 위해, 시큐리티한테 모든걸 맡기지 말고, 로그인 하는 시점을 낚아 채서, 억지로 session 에 
	  member DTO를 심어버리자..
	-----------------------------------------------------------*/
	@Bean 
	public AuthenticationSuccessHandler loginEventHandler() {
		return new LoginEventHandler();
	}
	
	@Bean
	public AuthenticationFailureHandler loginFailHandler() {
		
		return new LoginFailHandler();
	}
	
}










