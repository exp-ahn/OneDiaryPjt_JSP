function diaryModifyForm() {
	console.log('diaryModifyForm() CALLED!!');
	
	var form = document.diary_modify_form;
	if (form.d_word.value == '') {
		alert('INPUT DIARY');
		form.d_word.focus();
		
	} else {
		form.submit();
		
	}
	
}