<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
  <!--common -->
	<%@ include file="/WEB-INF/views/include/common.jsp"%>  
  <title>비밀번호 변경</title>
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
			  <form id="changePWForm" action="/portfolio/member/changePW" method="post">
			  	<input type="hidden" name="id" value="${sessionScope.member.id }" />
					<ul>	
						<li><h3>비밀번호 변경</h3></li>					
						<li><input type="password" name="currentpw" id="currentpw" placeholder="현재 비밀번호" /></li>
						<li><input type="password" name="nextpw" id="nextpw" placeholder="새 비밀번호"/></li>						
						<li><input type="password" id="nextpwchk" placeholder="새 비밀번호 확인"/></li>
						<li><span class="svr_msg">${svr_msg }</span></li>
						<li><button id="confirmBtn">확인</button></li>
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
		const $nextpw =document.getElementById('nextpw');
		const $nextpwchk =document.getElementById('nextpwchk');
		
		const $$input = [$currentpw,$nextpw,$nextpwchk];
		const confirmBtnHandler = evt => {
			evt.preventDefault();
			console.log('확인버튼클릭');
			//1) 모든필드에 값을 채웠는지 여부

			
			if($currentpw.value.trim().length == 0) {
				$currentpw.placeholder='비밀번호를 입력하세요!';
				$currentpw.classList.add('errmsg');
				$currentpw.focus();
				return;
			}
			if($nextpw.value.trim().length == 0) {
				$nextpw.placeholder='새 비밀번호를 입력하세요!';
				$nextpw.classList.add('errmsg');
				$nextpw.focus();
				return;
			}
			if($nextpwchk.value.trim().length == 0) {
				$nextpwchk.placeholder='새 비밀번호확인을 입력하세요!';
				$nextpwchk.classList.add('errmsg');
				$nextpwchk.focus();
				return;
			}
			//2) 새비밀번호값과 새비밀번호확인값이 같은지
			if($nextpw.value !== $nextpwchk.value){
				$nextpw.placeholder='비밀번호가 일치하지 않습니다.';
				$nextpw.value=''; $nextpwchk.value='';
				$nextpw.focus();
				return;
			}
			//3) form전송
			document.getElementById('changePWForm').submit();
		};
		const cancelBtnHandler = evt => {
			evt.preventDefault();
			console.log('취소버튼클릭');
			//모든 필드 clear
			document.getElementById('changePWForm').reset();
			//placeholder 
			$$input.forEach(ele=>{
				if(ele.classList.contains('errmsg')){
					ele.classList.remove('errmsg');
				}
			});
			//현재비밀번호로 focus이동
			document.getElementById('currentpw').focus();
		};
		$confirmBtn.addEventListener("click",confirmBtnHandler);
		$cancelBtn.addEventListener("click",cancelBtnHandler);
	</script>
	
</body>
</html>






