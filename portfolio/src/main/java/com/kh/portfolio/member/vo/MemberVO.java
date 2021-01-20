package com.kh.portfolio.member.vo;

import java.sql.Date;
import java.sql.Timestamp;

public class MemberVO {

	private String id;				//	ID	VARCHAR2(40 BYTE)	No		1	ex)admin@google.com
	private String pw;				//	PW	VARCHAR2(10 BYTE)	Yes		2	8~10자리,특수문자포함
	private String tel;				//	TEL	VARCHAR2(13 BYTE)	Yes		3	'-'포함
	private String nickname;	//	NICKNAME	VARCHAR2(30 BYTE)	Yes		4	
	private String gender;		//	GENDER	CHAR(3 BYTE)	Yes		5	성별('남','여')
	private String region;		//	REGION	VARCHAR2(30 BYTE)	Yes		6	지역
	private Date	birth;			//	BIRTH	DATE	Yes		7	생년월일('YYYYMMDD')
	private Timestamp cdate;	//	CDATE	TIMESTAMP(6)	Yes	"SYSTIMESTAMP	"	8	생성일시
	private Timestamp udate;	//	UDATE	TIMESTAMP(6)	Yes		9	변경일시
//	PIC	BLOB	Yes		10	회원사진(GIF,JPEG,PNG)
//	FSIZE	VARCHAR2(45 BYTE)	Yes		11	파일크기
//	FTYPE	VARCHAR2(50 BYTE)	Yes		12	파일타입
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Timestamp getCdate() {
		return cdate;
	}
	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}
	public Timestamp getUdate() {
		return udate;
	}
	public void setUdate(Timestamp udate) {
		this.udate = udate;
	}
	
	@Override
	public String toString() {
		return "MemberVO [id=" + id + ", pw=" + pw + ", tel=" + tel + ", nickname=" + nickname + ", gender=" + gender
				+ ", region=" + region + ", birth=" + birth + ", cdate=" + cdate + ", udate=" + udate + "]";
	}

}
