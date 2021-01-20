package com.kh.portfolio.member.dao;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.kh.portfolio.member.vo.MemberVO;
import org.junit.jupiter.api.Assertions;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/*.xml"})
public class MemberDAOImplTest {

	private final static Logger logger
		= LoggerFactory.getLogger(MemberDAOImplTest.class);
	
	@Autowired
	MemberDAO memberDAO;
	
	@Test
	@Disabled
	void joinMember() {
		MemberVO memberVO = new MemberVO();
		
//    values ('test@test.com','1234','010-1234-5678','테스터1','남','울산','20010101');		
		memberVO.setId("test2@test.com");
		memberVO.setPw("1234");
		memberVO.setTel("010-1234-5678");
		memberVO.setNickname("테스터1");
		memberVO.setGender("남");
		memberVO.setRegion("울산");
		memberVO.setBirth(java.sql.Date.valueOf("2000-01-01"));
		
		int result = memberDAO.joinMember(memberVO);
		
		logger.info("cnt:"+result);
		
	}
	@Test
	@DisplayName("회원개별조회")
	@Disabled
	void listOneMember() {
		String id = "test@test.com";
		MemberVO memberVO = memberDAO.listOneMember(id);
		logger.info(memberVO.toString());
	}
	@Test
	@DisplayName("회원존재유무")
	@Disabled
	void existMember() {
		String id = "test@test.com";
		logger.info("회원존재유무:"+memberDAO.existMember(id));
	}
	@Test
	@DisplayName("회원인증")
	@Disabled
	void isMember() {
		String id = "test@test.com";
		String pw = "1234";
		logger.info("회원인증:"+memberDAO.isMember(id,pw));
	}
	@Test
	@DisplayName("회원수정")
	@Disabled
	void modifyMember() {
		MemberVO memberVO = new MemberVO();
		
		memberVO.setTel("010-1111-1111");
		memberVO.setNickname("관리자2");
		memberVO.setGender("남");
		memberVO.setRegion("울산");
		memberVO.setBirth(java.sql.Date.valueOf("2000-01-01"));
		memberVO.setId("test@test.com");
		
		int result = memberDAO.modifyMember(memberVO);
		logger.info("회원수정:" + result);
	}
	@Test
	@DisplayName("회원비밀번호 변경")
	@Disabled
	void changePw() {
		String id = "test@test.com";
		String currentpw = "5678";
		String nextpw = "1234";
		int result = memberDAO.changePw(id, currentpw, nextpw);
		Assertions.assertEquals(1, result);
	}
	
	@Test
	@DisplayName("회원탈퇴")
	void outMember() {
		String id = "test4@test.com";
		String currentpw = "1234";
		int result = memberDAO.outMember(id, currentpw);
		Assertions.assertEquals(1, result);
	}
	
}








