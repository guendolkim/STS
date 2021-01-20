<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  <!--common -->
	<%@ include file="/WEB-INF/views/include/common.jsp"%>  
  <title>회원 탈퇴</title>
  <link rel="stylesheet" href="/portfolio/css/layout.css">
  <link rel="stylesheet" href="/portfolio/css/member.css">
 	<style>
 		main .container-m .s1{
 			display:flex;
 			justify-content: center;
 			align-items: center;
 		}
 		main .container-m .s1 form {
 			width:200px;
 		}
 		main .container-m .s1 form ul input,
 		main .container-m .s1 form ul button {
 			width:100%;
 		}
 		/* 확인버튼 */
 		main .container-m .s1 form ul button#confirmBtn {
 			background-color: rgba(0,255,0,1);
 			border: none;
 			outline: none;
 		}
 		/* 취소버튼 */
 		main .container-m .s1 form ul button#cancelBtn {
 			background-color: rgba(255,255,255,1);
 			border: none;
 			outline: none;		
 		}
 		input.errmsg::placeholder {
 			color:red;
 		}
 		/* 오류 메세지 */
 		main .container-m .s1 form .svr_msg{
 			color:red;
 			font-weight:bold;
 			font-size:0.8rem;
 		}
 	</style>
</head>
<body>
  <!--upper most-->
	<%@ include file="/WEB-INF/views/include/uppermost.jsp"%>
  <!--header-->
<%-- 	<%@ include file="/WEB-INF/views/include/header.jsp"%> --%>
  <!--nav-->
	<%@ include file="/WEB-INF/views/member/menu.jsp"%>
  <!--main-->
  <main>
    <div class="container container-m">
      <section class="s1">  
			  <form id="outMemberForm" action="/portfolio/member/outMember" method="post">
			  	<input type="hidden" name="id" value="${sessionScope.member.id }" />
					<ul>	
						<li><h3>회원 탈퇴</h3></li>					
						<li><input type="password" name="currentpw" id="currentpw" placeholder="현재 비밀번호" /></li>					
						<li><span class="svr_msg">${svr_msg }</span></li>
						<li><button id="confirmBtn">탈퇴</button></li>
						<li><button id="cancelBtn">취소</button></li>
					</ul>
			  </form>      
      </section>
    </div>
  </main>
  <!--footer menu-->
<!--   <div class="footermenu">
    <div class="container container-fm">footermenu</div>
  </div> -->
  <!--footer-->
	<%@ include file="/WEB-INF/views/include/footer.jsp"%>
	<script>
		const $confirmBtn = document.getElementById('confirmBtn');
		const $cancelBtn = document.getElementById('cancelBtn');		
		const $currentpw =document.getElementById('currentpw');

		const confirmBtnHandler = evt => {
			evt.preventDefault();
			console.log('탈퇴버튼클릭');
			//1) 모든필드에 값을 채웠는지 여부	
			if($currentpw.value.trim().length == 0) {
				$currentpw.placeholder='비밀번호를 입력하세요!';
				$currentpw.classList.add('errmsg');
				$currentpw.focus();
				return;
			}
			//2) 탈퇴 확인
			if(!confirm("정말로 탈퇴하겠습니까?")) return;
			
			//3) form전송
			document.getElementById('outMemberForm').submit();
		};
		const cancelBtnHandler = evt => {
			evt.preventDefault();
			console.log('취소버튼클릭');
			//모든 필드 clear
			document.getElementById('outMemberForm').reset();
			//현재비밀번호로 focus이동
			document.getElementById('currentpw').focus();
		};
		$confirmBtn.addEventListener("click",confirmBtnHandler);
		$cancelBtn.addEventListener("click",cancelBtnHandler);
	</script>
</body>
</html>






