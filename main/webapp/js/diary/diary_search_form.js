function diarySearchForm() {
	console.log('diarySearchForm() CALLED!!');
	
	var form = document.diary_search_form;
	if (form.search_txt.value == '') {
		alert('INPUT SEARCH TXT');
		form.d_word.focus();
		
	} else {
		form.submit();
		
	}
	
}