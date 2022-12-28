function checkForm(form) {
	if (form.id.value === "") {
		alert('생성할 아이디를 입력하세요.')
	} else if (form.password.value === "") {
		alert('생성할 비밀번호를 입력하세요.')
	} else if (form.passwordCheck.value !== form.password.value) {
		alert('비밀번호가 일치하지 않습니다.')
	} else if (form.name.value === "") {
		alert('이름을 입력하세요.')
	} else if (form.phone.value === "") {
		alert('전화번호를 입력하세요.')
	} else if (form.id.value === "") {
		alert('주민번호를 입력하세요.')
	} else {
		form.submit();
	}
}

