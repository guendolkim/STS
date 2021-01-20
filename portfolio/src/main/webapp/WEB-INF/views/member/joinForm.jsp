<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!--common -->
<%@ include file="/WEB-INF/views/include/common.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>

	.container .content{
	display:flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	}
	.container .content #joinForm{
	width: 200px;
	}
	.container .content #joinForm input{
	}
	.container .content #joinForm .title {
	text-align: center;
	}
	
	.errmsg {
	color: red;
	font-size: 0.7rem;
	font-weight: bold;
	}
</style>
<script defer src='${contextPath }/js/joinForm.js'></script>
</head>
<body>
	<div class="container">
		<div class="content">
			<form id="joinForm" action="${contextPath }/member/join"
				method="post">
				<%-- ${contextPath }/portfolio를 가리킴 --%>
				<ul>
					<li><h3 class="title">회원 가입</h3></li>
					<li><label>아이디</label></li>
					<li><input type="text" name="id" id="id"></li>
					<li><span class="errmsg" id="errmsg_id"></span></li>
					<li><label>비밀번호</label></li>
					<li><input type="password" name="pw" id="pw"></li>
					<li><span class="errmsg" id="errmsg_pw"></span></li>
					<li><label>비밀번호 확인</label></li>
					<li><input type="password" id="pwchk"></li>
					<li><span class="errmsg" id="errmsg_pwchk"></span></li>
					<li><label>전화번호</label></li>
					<li><input type="tel" name="tel" id="tel"></li>
					<li><span class="errmsg" id="errmsg_tel"></span></li>
					<li><label>별칭</label></li>
					<li><input type="text" name="nickname" id="nickname"></li>
					<li><span class="errmsg" id="errmsg_nickname"></span></li>
					<li><label>지역</label></li>
					<li><select name="region" id="region">
							<option value="">선택</option>
							<option value="서울">서울</option>
							<option value="부산">부산</option>
							<option value="울산">울산</option>
					</select><li><span class="errmsg" id="errmsg_region"></span></li>


					<li><label>성별</label></li>
      <li><span class="errmsg" id="errmsg_gender"></span></li>
      <li>
        <input type="radio" name="gender" id="man" value="남"><label
						for="man">남</label>
        <input type="radio" name="gender" id="woman" value="여"><label
						for="woman">여</label>
      </li>
      <li><label>생년월일</label></li>
      <li><input type="date" name="birth" id="birth"></li>
      <li><span class="errmsg" id="errmsg_birth"></span></li>
      <li><input type="submit" value="회원가입" id="joinBtn"></li>
    </ul>
  </form>
  </div>
  </div>
</body>
</html>