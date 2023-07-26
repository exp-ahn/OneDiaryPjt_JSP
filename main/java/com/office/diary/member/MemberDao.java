package com.office.diary.member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.office.diary.DBDao;

public class MemberDao extends DBDao implements IMemberDao {

	@Override
	public int memberRegistConfirm(MemberDto memberDto) {
		System.out.println("[MemberDao] memberRegistConfirm()");
		
		Connection conn		 	= null;
		PreparedStatement pstmt = null;
		int result 				= -1;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "INSERT INTO tbl_member("
												+ "m_id, "
												+ "m_pw, "
												+ "m_mail, "
												+ "m_phone, "
												+ "m_reg_date, "
												+ "m_mod_date) "
												+ "VALUES(?, ?, ?, ?, NOW(), NOW())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getM_id());
			pstmt.setString(2, memberDto.getM_pw());
			pstmt.setString(3, memberDto.getM_mail());
			pstmt.setString(4, memberDto.getM_phone());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
		return result;
		
	}

	@Override
	public MemberDto memberLoginConfirm(String id, String pw) {
		System.out.println("[MemberDao] memberLoginConfirm()");
		
		Connection conn		 	= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		MemberDto memberDto 	= null;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "SELECT * FROM tbl_member "
						+ "WHERE m_id = ? AND m_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int m_no = rs.getInt("m_no");
				String m_id = rs.getString("m_id");
				String m_pw = rs.getString("m_pw");
				String m_mail = rs.getString("m_mail");
				String m_phone = rs.getString("m_phone");
				String m_reg_date = rs.getString("m_reg_date");
				String m_mod_date = rs.getString("m_mod_date");
				
				memberDto = new MemberDto();
				memberDto.setM_no(m_no);
				memberDto.setM_id(m_id);
				memberDto.setM_pw(m_pw);
				memberDto.setM_mail(m_mail);
				memberDto.setM_phone(m_phone);
				memberDto.setM_reg_date(m_reg_date);
				memberDto.setM_mod_date(m_mod_date);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
		return memberDto;
		
	}

	@Override
	public int memberModifyConfirm(MemberDto memberDto) {
		System.out.println("[MemberDao] memberModifyConfirm()");
		
		Connection conn		 	= null;
		PreparedStatement pstmt = null;
		int result 				= -1;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "UPDATE "
						+ "	tbl_member "
						+ "SET "
						+ "	m_pw = ?, "
						+ "	m_mail = ?, "
						+ "	m_phone = ?, "
						+ "	m_mod_date = NOW() "
						+ "WHERE "
						+ "	m_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getM_pw());
			pstmt.setString(2, memberDto.getM_mail());
			pstmt.setString(3, memberDto.getM_phone());
			pstmt.setInt(4, memberDto.getM_no());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
		return result;
	}

	@Override
	public MemberDto selectLatestModifyMember(int no) {
		System.out.println("[MemberDao] selectLatestModifyMember()");
		
		Connection conn		 	= null;
		PreparedStatement pstmt = null;
		ResultSet rs 			= null;
		MemberDto memberDto 	= null;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "SELECT * FROM tbl_member "
						+ "WHERE m_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int m_no = rs.getInt("m_no");
				String m_id = rs.getString("m_id");
				String m_pw = rs.getString("m_pw");
				String m_mail = rs.getString("m_mail");
				String m_phone = rs.getString("m_phone");
				String m_reg_date = rs.getString("m_reg_date");
				String m_mod_date = rs.getString("m_mod_date");
				
				memberDto = new MemberDto();
				memberDto.setM_no(m_no);
				memberDto.setM_id(m_id);
				memberDto.setM_pw(m_pw);
				memberDto.setM_mail(m_mail);
				memberDto.setM_phone(m_phone);
				memberDto.setM_reg_date(m_reg_date);
				memberDto.setM_mod_date(m_mod_date);
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
		return memberDto;
		
	}

	@Override
	public int memberDeleteConfirm(int m_no) {
		System.out.println("[MemberDao] memberDeleteConfirm()");
		
		Connection conn		 	= null;
		PreparedStatement pstmt = null;
		int result 				= -1;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "DELETE FROM tbl_member "
						+ "WHERE m_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_no);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				
			}
			
		}
		
		return result;
		
	}

	public MemberDto selectMemberDtoByNo(int m_no) {
		System.out.println("[MemberDao] selectMemberDtoByNo()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = new MemberDto();
		
		try {
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql = "select * from tbl_member where m_no = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, m_no);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				memberDto.setM_no(rs.getInt("m_no"));
				memberDto.setM_id(rs.getString("m_id"));
				memberDto.setM_pw(rs.getString("m_pw"));
				memberDto.setM_mail(rs.getString("m_mail"));
				memberDto.setM_phone(rs.getString("m_phone"));
				memberDto.setM_reg_date(rs.getString("m_reg_date"));
				memberDto.setM_mod_date(rs.getString("m_mod_date"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return memberDto;
	}
	
	

}
