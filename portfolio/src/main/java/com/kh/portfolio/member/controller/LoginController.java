package com.kh.portfolio.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.portfolio.member.svc.MemberSVC;

@Controller
public class LoginController {
	private static final Logger logger
		= LoggerFactory.getLogger(LoginController.class);
	
	private final MemberSVC memberSVC;
	
	@Autowired
	public LoginController(MemberSVC memberSVC) {
		this.memberSVC = memberSVC;
	}
	
	//로그인양식
	@GetMapping("/loginForm")
	public String loginForm() {
		
		return "/member/loginForm";
	}
	
	//로그인처리
	@PostMapping("/login")
	public String login(
			@RequestParam("id") String id,
			@RequestParam("pw") String pw,
			Model model,
			HttpSession	session
			) {
		String viewName = null;
		
		logger.info("id:"+id);
		logger.info("pw:"+pw);
		
		//1. 회원인경우
		if(memberSVC.existMember(id)) {

			//1-1 회원번호일치
			if(memberSVC.isMember(id, pw)) {
				session.setAttribute("member", memberSVC.listOneMember(id));
				
				viewName = "index";
			//1-2 회원번호불일치
			}else {
				model.addAttribute("svr_msg","가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
				viewName = "/member/loginForm";
			}
		//2. 비회원인경우
		}else {
			model.addAttribute("svr_msg","가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.");
			viewName = "/member/loginForm";
		}
		return viewName;
	}
	
	//로그아웃
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		
		//세션에 저장된 정보 제거
		session.invalidate();
		
		return "redirect:/";
	}
}






