package com.kh.portfolio.member.svc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.portfolio.member.dao.MemberDAO;
import com.kh.portfolio.member.vo.MemberVO;

@Service
public class MemberSVCImpl implements MemberSVC {

	private static final Logger logger
		= LoggerFactory.getLogger(MemberSVCImpl.class);
	
	private final MemberDAO memberDAO;
	
	@Autowired
	public MemberSVCImpl(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	//회원등록
	@Override
	public int joinMember(MemberVO memberVO) {
		logger.info("int joinMember(MemberVO memberVO) 호출됨!" + memberVO);
		int result = 0;
		result = memberDAO.joinMember(memberVO);
		return result;
	}

	//회원수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		int result = 0;
		result = memberDAO.modifyMember(memberVO);
		return  result;
	}

	//회원 개별조회
	@Override
	public MemberVO listOneMember(String id) {
		MemberVO memberVO = memberDAO.listOneMember(id);
		return memberVO;
	}

	//회원 탈퇴
	@Override
	public int outMember(String id, String currentpw) {
		int result = 0;
		result = memberDAO.outMember(id, currentpw);
		return result;
	}
	//선생님말: svc는 받아서 dao에 넘겨주는 역할이에요
	//회원 존재
	@Override
	public boolean existMember(String id) {
		boolean result = false;
		result = memberDAO.existMember(id);
		return result;
	}

	//회원 인증
	@Override
	public boolean isMember(String id, String pw) {
		boolean result = false;
		result = memberDAO.isMember(id, pw);
		return result;
	}

	//회원 비밀번호 변경
	@Override
	public int changePw(String id, String currentpw, String nextpw) {
		int result = 0;
		result = memberDAO.changePw(id, currentpw, nextpw);
		return result;
	}


}
