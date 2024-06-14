package com.sds.cafeadmin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sds.cafeadmin.domain.Admin;
import com.sds.cafeadmin.exception.AdminException;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class AdminController {


	// 로그인 폼 요청 처리
	@GetMapping("/admin/loginform")
	public String getLoginForm() {

		return "admin/login";
	}

	// 로그아웃 요청 처리
	@GetMapping("/admin/logout")
	public String logout(HttpSession session) {
		// 세션을 더이상 사용하지 못하게 하면 됨
		session.invalidate();

		return "redirect:/";
	}

	// 회원가입 폼 요청 처리
	@GetMapping("/admin/registform")
	public String getRegistForm() {

		return "admin/regist";
	}

//	// 홈페이지 회원가입요청
//	@PostMapping("/member/regist")
//	public String Join(Admin admin) {
//
//		log.debug("member uid " + admin.getUid());
//
//		memberService.regist(member);// 3단계
//
//		return "redirect:/member/loginform";
//	}

	@PostMapping("/admin/login")
	public String login(Admin admin) {

		return "redirect:/";
	}
	
	@ExceptionHandler(AdminException.class)
	public ModelAndView handle(AdminException e) {

		ModelAndView mav = new ModelAndView("error/result");
		mav.addObject("e", e);

		return mav;
	}
}
