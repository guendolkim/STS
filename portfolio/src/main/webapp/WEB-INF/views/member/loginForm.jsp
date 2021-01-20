<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Document</title>
  <!--font awesome-->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"/>      
  <!--폰트-->
  <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Nanum+Gothic+Coding:wght@400;700&family=Nanum+Myeongjo:wght@400;700&family=Noto+Sans+KR:wght@100;400;900&display=swap"/>  
  <link rel="stylesheet" href="/portfolio/css/login.css">
  <script defer src="/portfolio/js/login.js"></script>
</head>
<body>
  <div class="container">
    <div class="content">
      <form id="loginForm" action="/portfolio/login" method="post">
        <div class="item">
          <a href="/portfolio">
            <img src="https://cdn.pixabay.com/photo/2015/07/12/14/26/coffee-842020_960_720.jpg" alt="" />
          </a>
        </div>
        <div class="item">
          <input type="text" name="id" id="id" placeholder="아이디" /> <i class="far fa-envelope"></i>
        </div>
        <div class="item">
          <span class="errmsg" id="errmsg_id"></span>
        </div>
        <div class="item">
          <input type="password" name="pw" id="pw" placeholder="비밀번호" /> <i class="fas fa-key"></i>
        </div>
        <div class="item">
          <span class="errmsg" id="errmsg_pw"></span>
        </div>
        <div class="item">
          <span class="svr_msg" id="svr_smg">${svr_msg }</span>
        </div>        
        <div class="item">
          <button id="loginBtn">로그인</button>
        </div>
        <div class="item">
          <input type="checkbox" name="login_chk" id="login_chk" /> 
          <label for="login_chk" id="login_chk">로그인상태유지</label>
        </div>
        <div class="item find_info">
          <a href="#" id="findID">아이디 찾기</a> <span>|</span>
          <a href="#" id="findPW">비밀번호 찾기</a> <span>|</span>
          <a href="#">회원 가입</a>
        </div>
      </form>
    </div>
  </div>
</body>
</html>