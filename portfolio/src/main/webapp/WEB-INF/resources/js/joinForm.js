'use strict'
//const $joinBtn = document.getElementById('joinBtn'); document.getElementById 없어도 아이디값을 찾아옴
addEventListener('click',joinHandler);

function joinHandler(evt){
	evt.preventDefault(); //submit 기본 이벤트 취소
	console.log('회원가입클릭');
	
	//유효성 체크
	if(!validationChk(evt)) return;
	
	//유효성 통과시
	joinForm.submit();
	
}
function validationChk(){
	//아이디 체크
	const id =document.getElementById('id');
	if(!isEmail(id.value)){
		//오류메세지
		errmsg_id.textContent='아이디잘못입력'; //document.getElementById 없어도 아이디값을 찾아옴
		//포커스
		id.focus(); id.select();
		return false;
	}else{
		errmsg_id.textContent='';
	}
	//비번유효성체크
	if(!isPasswd(pw.value)){
		errmsg_pw.textContent = '4~10자리 영문자 숫자만가능'
		//포커스
		pw.focus(); pw.select();
		return false;
	}else{
		errmsg_pw.textContent='';  //일치하면 에러메시지 없애줌
	}
	//비밀번호, 비밀번호 확인 (두개일치하는지확인)
	if(pw.value !== pwchk.value){   //!= 이게아니라 !== 사용된이유는 타입까지도 같은지 확인
		errmsg_pwchk.textContent = '비밀번호 일치하지 않음'
		//포커스
		pwchk.focus(); pwchk.select();
		return false;
	}else{
		errmsg_pwchk.textContent='';  //일치하면 에러메시지 없애줌
	}
	//전화번호체크
	if(!isTel(tel.value)){
		errmsg_tel.textContent = '전화번호형식 ex) 010-1234-5678';
		tel.focus(); tel.select();
		return false;
	}else{
		errmsg_tel.textContent='';  //일치하면 에러메시지 없애줌
	}
	//별칭체크
	if(!isNickname(nickname.value)){
		errmsg_nickname.textContent = '4~10자리';
		nickname.focus(); nickname.select();
		return false;
	}else{
		errmsg_nickname.textContent='';  //일치하면 에러메시지 없애줌
	}
	
	//지역체크
	if(region.selectedIndex == 0){
		region.style.outline = '1px solid red';
		regiong.focus();
		return false;
	}else{
		errmsg_region.textContent='';  //일치하면 에러메시지 없애줌
	}
	//성별체크
	const $gender = document.querySelectorAll('input[name=gender]');
	let status = false;
	for(const ele of $gender){
		if(ele.checked){
			status = true;
			break;
		}
	}
	if(!status){
		errmsg_gender.textContent = '성별을 선택해주시오';
		return false;
	}else{
		errmsg_gender.textContent='';  //일치하면 에러메시지 없애줌
	}
	//생년월일
	if(birth.value === ''){
		errmsg_birth.textContent = '생년월일을 입력하시오';
		birth.focus(); birth.select();
		return false
	}else{
		errmsg_birth.textContent='';  //일치하면 에러메시지 없애줌
	}
	return true;
}



//별칭 유효성체크
function isNickname(nickname){
//한글 알파벳 대소문자 또는 숫자로 시작하고 끝나며 4~10 자리인지 검사한다.
const nicknamepattern = /^[가-힣ㄱ-ㅎㅏ-ㅣA-Za-z0-9]{4,10}$/;
return nicknamepattern.test(nickname);
}

//이메일체크
function isEmail(email){
const emailPattern = /^[\w]([-_\.]?[\w])*@[\w]([-_\.]?[\w])*\.[a-zA-Z]{2,3}$/;
 return emailPattern.test(email);
}

//전화번호체크
function isTel(tel){
const telPattern = /^\d{3}-\d{3,4}-\d{4}$/;
return telPattern.test(tel);
}

//숫자로 입력된 문자인지 체크
function isNum(num){
const numPattern = /^[\d]*$/;
return numPattern.test(num);
}

//숫자로 입력된 문자인지 체크 +  갯수제한 4 ~10
function isNum1(num){
const numPattern1 = /^[\d]{4,10}$/; // /^[0-9]{4,10}$/
return numPattern1.test(num);
}

//비밀번호체크
function isPasswd(passwd){
//대소문자 또는 숫자로 시작하고 끝나며 4~10 자리인지 검사
const passwdPattern = /^[\w]{4,10}$/; ///^[A-Za-Z0-9]{4,10}$/
return passwdPattern.test(passwd);
}