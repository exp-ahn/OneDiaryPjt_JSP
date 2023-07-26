function userModifyForm() {
	console.log('userModifyForm() CALLED!!');
	
	var form = document.user_modify_form;
	if (form.m_mail.value == '') {
		alert('INPUT MEMBER MAIL.');
		form.m_mail.focus();
		
	} else if (form.m_phone.value == '') {
		alert('INPUT MEMBER PHONE.');
		form.m_phone.focus();
		
	} else {
		form.submit();
		
	}
	
}