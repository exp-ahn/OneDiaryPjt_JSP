function diaryRegistForm() {
	console.log('diaryRegistForm() CALLED!!');
	
	var form = document.diary_regist_form;
	if (form.d_word.value == '') {
		alert('INPUT DIARY');
		form.d_word.focus();
		
	} else {
		form.submit();
		
	}
	
}