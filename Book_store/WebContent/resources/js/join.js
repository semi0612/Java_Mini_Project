/**
 * 회원 가입시 데이터 유효성 검사 
 */





function joinTest() {

	 


	var id = document.getElementById("cus_id"); // 아이디
	
	var password = document.getElementById("cus_pw"); // 비밀번호 입력
	var password2 = document.getElementById("cus_pw2");// 비밀번호 확인
	
	var name = document.getElementById("cus_name"); // 이름
	
	var address = document.getElementById("cus_add"); // 주소
	var address2 = document.getElementById("cus_add3"); //상세주소
	
	var phone = document.getElementById("cus_phone"); // 휴대폰 번호
	
	var email = document.getElementById("cus_email"); // 이메일
	


	//아이디 영문+숫자조합 (6~12자리입력) 정규식
	var idCheck = /^(?=.*[a-zA-Z])(?=.*[0-9]).{6,12}$/;
	
	//비밀번호 영문자+숫자+특수조합(8~15자리 입력) 정규식
	var pwCheck = /^(?=.*[a-zA-Z])(?=.*[!@#$%^*+=-])(?=.*[0-9]).{8,15}$/;
	
	//이름 한글 (2~10자리 입력) 정규식
	var nameCheck = /^[가-힣]{2,10}$/;
	
	//전화번호 숫자만 입력하는 정규식
	var telCheck = /^\d{3}-\d{3,4}-\d{4}$/; 
	
	//이메일 정규식
	var emailCheck = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		   
	

	
	
	//해당 입력값이 없을 경우 같은말
	//focus(): 커서가 깜빡이는 현상, blur(): 커서가 사라지는 현상
	//return: 반환하다 return false:  아무것도 반환하지 말아라 아래 코드부터 아무것도 진행하지 말것
	if(id.value == "") { 
		alert("아이디를 입력하세요.");
		id.focus(); 
		return false; 
	} 
	
	
	if(!idCheck.test(id.value)) {
		alert("아이디는 영문자+숫자 조합으로 6~12자리를 입력하세요.");
		id.focus();
		return false;
	}
	
	
	if (password.value == "") {
		alert("비밀번호를 입력하세요.");
		password.focus();
		return false;
	}

	

	if (!pwCheck.test(password.value)) {
		alert("비밀번호는 영문자+숫자+특수문자 조합으로 8~15자리를 입력하세요.");
		password.focus();
		return false;
	}
	
	if (password2.value == "") {
		alert("비밀번호를 다시 입력해주세요.");
		password2.focus();
		return false;
	}
	
	//비밀번호와 비밀번호 확인 값이 같지않을때
	if (password.value != password2.value) { 
		alert("입력하신 두 비밀번호가 일치하지 않습니다.");
		password2.focus();
		return false;
	}



	if (name.value == "") {
		alert("이름을 입력하세요.");
		name.focus();
		return false;
	}
	
	
	if (!nameCheck.test(name.value)) {
		alert("이름은 한글로 2~10자리를 입력하세요.");
		name.focus();
		return false;
	}
	
	if (address.value ==""){
		alert("주소를 입력하세요.");
		return false;
		
	}
	
	if (address2.value ==""){
		alert("상세주소를 입력하세요.");
		address2.focus();
		return false;
		
	}
	
	
	if (phone.value ==""){
		alert("휴대폰번호를 입력하세요.");
		phone.focus();
		return false;
		
	}
	
	
	if (!telCheck.test(phone.value)) {
	    alert("휴대폰번호의 형식이 잘못되었습니다.");
	    phone.focus();
	    return false;
	}
	
	if( (email.value != "") && (!emailCheck.test(email.value)) ){
		alert("이메일 형식이 잘못되었습니다.");
	    email.focus();
	    return false;
	} 
	
	
	return true;
	
	
	




}//end function






/**
 * 지번검색
 */



function findAddr(){
	new daum.Postcode({
        oncomplete: function(data) {
        	
        	console.log(data);
        	
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
            // 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var roadAddr = data.roadAddress; // 도로명 주소 변수
            var jibunAddr = data.jibunAddress; // 지번 주소 변수
            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            document.getElementById('cus_add').value = data.zonecode;
            if(roadAddr !== ''){
                document.getElementById("cus_add2").value = roadAddr;
            } 
            else if(jibunAddr !== ''){
                document.getElementById("cus_add2").value = jibunAddr;
            }
        }
    }).open();
}



