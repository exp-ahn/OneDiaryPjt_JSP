function memberRegistForm() {
	console.log('memberRegistForm() CALLED!!');
	
	var form = document.member_regist_form;
	if (form.m_id.value == '') {
		alert('INPUT MEMBER ID.');
		form.m_id.focus();
		
	} else if (form.m_pw.value == '') {
		alert('INPUT MEMBER PW.');
		form.m_pw.focus();
		
	} else if (form.m_mail.value == '') {
		alert('INPUT MEMBER MAIL.');
		form.m_mail.focus();
		
	} else if (form.m_phone.value == '') {
		alert('INPUT MEMBER PHONE.');
		form.m_phone.focus();
		
	} else {
		form.submit();
		
	}
	
}