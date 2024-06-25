package com.sds.cafeadmin.domain;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

//회원의 상세정보를 가진 객체임..단 스프링이 지원하는 기술을 구현해야함
@Data
@Slf4j
public class CustomUserDetails implements UserDetails{
	
	//우리가 이미 정의해놓은 Member DTO 정보를 참고하여, 아래의 메서드들에서 정보들을 처리 
	private Admin admin;
	
	public CustomUserDetails(Admin admin) {
		this.admin = admin;
		log.debug("비밀번호 가져오기 테스트"+admin.getPwd());
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> authList = new ArrayList();
		authList.add(new GrantedAuthority() {
			public String getAuthority() {
				String role_name = admin.getRole().getRole_name(); //관리자페이지에서 ADMIN으로 넣어줌
				log.debug(role_name);
				return role_name;
			}
		});
		return authList;
	}

	@Override
	public String getPassword() {
		log.debug("pass is " +admin.getPwd());
		return admin.getPwd();
	}

	@Override
	public String getUsername() {
//		log.debug("nickname is "+admin.getUid());
		return admin.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}