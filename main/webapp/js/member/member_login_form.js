function memberLoginForm() {
	console.log('memberLoginForm() CALLED!!');
	
	var form = document.member_login_form;
	if (form.m_id.value == '') {
		alert('INPUT MEMBER ID.');
		form.m_id.focus();
		
	} else if (form.m_pw.value == '') {
		alert('INPUT MEMBER PW.');
		form.m_pw.focus();
		
	} else {
		form.submit();
		
	}
	
}