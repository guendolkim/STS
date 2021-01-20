package com.kh.portfolio.member.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.portfolio.member.svc.MemberSVC;
import com.kh.portfolio.member.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class MemberController {
	
	private static final Logger logger
		= LoggerFactory.getLogger(MemberController.class);
	
	private final MemberSVC memberSVC;
	
	@Autowired
	public MemberController(MemberSVC memberSVC) {
		this.memberSVC = memberSVC;
	}
	
	//회원가입양식
	@GetMapping("/joinForm")
	public String joinForm() {
		
		return "/member/joinForm";
	}
	
	//회원가입처리
	@PostMapping("/join")
	public String join(MemberVO memberVO) {	
		String viewName = null;
		int result = 0;
		 memberVO = new MemberVO();
		logger.info("memberVO : " + memberVO);
	
		result = memberSVC.joinMember(memberVO);
		
		if(result == 1) {
			logger.info("회원가입성공:" + memberVO);
			viewName = "redirect:/";
		}else {
			logger.info("회원가입실패:" + memberVO);
			viewName = "/member/joinForm";
		}
		
		return viewName;
	}
	
	//내정보
	@GetMapping("/mypage")
	public String mypage() {
		
		return "/member/mypage";
	}
	
	//회원수정양식
	@GetMapping("/modifyForm")
	public String modifyForm(Model model) {
		
		MemberVO member = memberSVC.listOneMember("test@test.com");
		model.addAttribute("memberVO", member);
		
		return "/member/modifyForm";
	}
	
	//회원수정처리
	@PostMapping("/modify")
	public String modify(MemberVO memberVO, Model model) {
		String viewName = null;
		
		int result = memberSVC.modifyMember(memberVO);
		//수정 성공
		if(result == 1 ) {
			viewName = "/member/modifyForm";
		}else {
		//수정 실패				
			viewName = "/member/modifyForm";
		}
		return viewName;
	}
	
	//비밀번호 수정 양식
	@GetMapping("/changePWForm")
	public String changePWForm() {
		
		return "/member/changePWForm";
	}
	
	//비밀번호 변경 처리
	@PostMapping("/changePW")
	public String change(
			@RequestParam("id") String id,
			@RequestParam("currentpw") String currentpw, 
			@RequestParam("nextpw") String nextpw,
			Model model
			) {
		
		logger.info("비밀번호변경:"+ id); 
		logger.info("비밀번호변경:"+ currentpw); 
		logger.info("비밀번호변경:"+ nextpw);
		
		String viewName = null;
		int result = memberSVC.changePw(id, currentpw, nextpw);
		//성공
		if(result == 1) {
			
			viewName = "redirect:/member/mypage";
		}else {
		//실패
			model.addAttribute("svr_msg", "비밀번호를 올바르게 입력하세요!");
			viewName = "/member/changePWForm";
		}
		return viewName;
	}
	
	//회원탈퇴양식	
	@GetMapping("/outMemberForm")
	public String outMemberForm() {
		
		
		return "/member/outMemberForm";
	}
	
	//회원탈퇴	/member/outMember
	@PostMapping("/outMember")
	public String outMember(
			@RequestParam("id") String id,
			@RequestParam("currentpw") String currentpw,
			Model model
			) {
		String viewName = null;
		
		int result = memberSVC.outMember(id, currentpw);
		//1)탈퇴성공
		if(result == 1) {
			
			viewName = "redirect:../logout";
		}else {
		//2)탈퇴실패
			
			model.addAttribute("svr_msg", "비밀번호가 일치하지 않습니다!");
			viewName = "/member/outMemberForm";
		}	
		return viewName;
	}
}












