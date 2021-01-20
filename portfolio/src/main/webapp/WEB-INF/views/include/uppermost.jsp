<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <div class="uppermost">
    <div class="container container-um">
      <ul class="logo">
        <li><a href="/portfolio"><i class="fas fa-coffee"></i></a></li>
        <li id="logo-txt">아리에떼[[Ariete]]</li>
      </ul>     
      <!-- 로그인전 -->
      <c:if test="${empty sessionScope.member}">
      <ul class="menu">
        <li><a href="/portfolio/loginForm">로그인</a></li>
        <li>|</li>
        <li><a href="/portfolio/member/joinForm">회원가입</a></li>
      </ul>
      </c:if>
      <!-- 로그인후 -->
      <c:if test="${!empty sessionScope.member}">
      <ul class="menu">
        <li><a href="/portfolio/member/mypage">내정보</a></li>
        <li>|</li>
        <li><a href="/portfolio/logout">로그아웃</a></li>
      </ul>      
      </c:if>
    </div>
  </div>