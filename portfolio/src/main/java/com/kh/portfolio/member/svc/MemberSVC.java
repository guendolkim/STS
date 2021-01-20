package com.kh.portfolio.member.svc;

import com.kh.portfolio.member.vo.MemberVO;

public interface MemberSVC {
	//회원등록
	int joinMember(MemberVO memberVO);
	//회원 수정
	int modifyMember(MemberVO memberVO);	
	
	//회원 전체 조회
	
	//회원 개별조회
	MemberVO listOneMember(String id);
	
	//회원 탈퇴
	int outMember(String id, String currentpw);	
	
	//회원 존재
	boolean existMember(String id);
	
	//회원 인증
	boolean isMember(String id, String pw);
	
	//회원 비밀번호변경
	int	changePw(String id, String currentpw, String nextpw);	
}
