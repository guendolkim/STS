package com.kh.portfolio.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kh.portfolio.member.vo.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	
	private static final Logger logger
		= LoggerFactory.getLogger(MemberDAOImpl.class);
	
	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public MemberDAOImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	//회원등록
	@Override
	public int joinMember(MemberVO memberVO) {
		logger.info("int joinMember(MemberVO memberVO) 호출됨!" + memberVO );
		int result = 0;
		
		//sql문 생성
		StringBuilder sql = new StringBuilder();
		sql.append("insert into member (id,pw,tel,nickname,gender,region,birth)");
		sql.append("values (?,?,?,?,?,?,?)");
		
		//sql문 실행
		result = jdbcTemplate.update(sql.toString(),memberVO.getId(),memberVO.getPw(),memberVO.getTel(),
				memberVO.getNickname(),memberVO.getGender(),memberVO.getRegion(),memberVO.getBirth());
		
		return result;
	}

	// 회원 수정
	@Override
	public int modifyMember(MemberVO memberVO) {
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("update member ");
		sql.append("   set tel = ?, ");
		sql.append("       nickname = ?, ");
		sql.append("       gender = ?, ");
		sql.append("       region = ?, ");
		sql.append("       birth = ?, ");
		sql.append("       udate = systimestamp ");
		sql.append("where id = ? ");
		
		result = jdbcTemplate.update(
								sql.toString(),
								memberVO.getTel(),
								memberVO.getNickname(),
								memberVO.getGender(),
								memberVO.getRegion(),
								memberVO.getBirth(),
								memberVO.getId());
		
		return result;
	}

	//회원 개별조회
	@Override
	public MemberVO listOneMember(String id) {
		
//		StringBuilder sql = new StringBuilder();
		String sql = "select * from member where id = ? ";
		
		MemberVO memberVO =	jdbcTemplate.queryForObject(
							sql.toString(), 
							new BeanPropertyRowMapper<MemberVO>(MemberVO.class), 
							id);	
		
		return memberVO;
	}

	//회원 삭제
	@Override
	public int outMember(String id, String currentpw) {
		int result = 0;
		
		StringBuilder sql = new StringBuilder();
		sql.append("delete from member ");
		sql.append(" where id = ? ");
		sql.append("   and pw = ? ");		
		
		result = jdbcTemplate.update(sql.toString(), id, currentpw);	
		return result;
	}

	//회원 존재
	@Override
	public boolean existMember(String id) {
		boolean result = false;
		String sql ="select count(*) cnt from member where id = ? ";
		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class ,id);
		result = (cnt == 1) ? true : false;		
		return result;
	}

	//회원 인증
	@Override
	public boolean isMember(String id, String pw) {
		boolean result = false;
		String sql ="select count(*) cnt from member where id = ? and pw = ?";
		Integer cnt = jdbcTemplate.queryForObject(sql, Integer.class ,id,pw);
		result = (cnt == 1) ? true : false;		
		return result;
	}

	//회원비밀번호 변경
	@Override
	public int changePw(String id, String currentpw, String nextpw) {
		StringBuilder sql = new StringBuilder();
		
		sql.append("update member ");
		sql.append("   set pw = ? ");
		sql.append(" where id = ? ");
		sql.append("   and pw = ? ");		
		
		int result = jdbcTemplate.update(sql.toString(), nextpw,id,currentpw);
		
		return result;
	}
}


















