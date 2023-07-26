function adminRegistForm() {
	console.log('adminRegistForm() CALLED!!');
	
	var form = document.admin_regist_form;
	if (form.a_id.value == '') {
		alert('INPUT ADMIN ID.');
		form.a_id.focus();
		
	} else if (form.a_pw.value == '') {
		alert('INPUT ADMIN PW.');
		form.a_pw.focus();
		
	} else if (form.a_mail.value == '') {
		alert('INPUT ADMIN MAIL.');
		form.a_mail.focus();
		
	} else if (form.a_phone.value == '') {
		alert('INPUT ADMIN PHONE.');
		form.a_phone.focus();
		
	} else {
		form.submit();
		
	}
	
}