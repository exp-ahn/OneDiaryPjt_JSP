package com.office.diary.member;

public interface IMemberDao {

	public int memberRegistConfirm(MemberDto memberDto);
	public MemberDto memberLoginConfirm(String id, String pw);
	public int memberModifyConfirm(MemberDto memberDto);
	public MemberDto selectLatestModifyMember(int no);
	public int memberDeleteConfirm(int m_no);
	
}
