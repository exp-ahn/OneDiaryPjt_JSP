package com.office.diary.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.office.diary.DBDao;
import com.office.diary.member.MemberDto;

public class AdminDao extends DBDao{
	
	public boolean isAdmin(String a_id) {
		System.out.println("[AdminDao] isAdmin()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = -1;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "SELECT COUNT(*) AS cnt FROM tbl_admin WHERE a_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, a_id);

			for(
				rs = pstmt.executeQuery(); 
				rs.next(); 
				result = rs.getInt("cnt")) {
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}
		return result > 0;
	}

	public int adminRegistConfirm(AdminDto adminDto) {
		System.out.println("[AdminDao] adminRegistConfirm()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "insert into tbl_admin (a_id, a_grade, a_pw, a_mail, a_phone, a_reg_date, a_mod_date) "
						+ "values(?, 0, ?, ?, ?, now(), now())";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, adminDto.getA_id());
			pstmt.setString(2, adminDto.getA_pw());
			pstmt.setString(3, adminDto.getA_mail());
			pstmt.setString(4, adminDto.getA_phone());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		}
		
		return result;
	}

	public AdminDto adminLoginConfirm(String id, String pw) {
		System.out.println("[AdminDao] adminLoginConfirm()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AdminDto adminDto = null;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "SELECT * FROM tbl_admin "
						+ "WHERE a_id = ? AND a_pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int a_no = rs.getInt("a_no");
				int a_grade = rs.getInt("a_grade");
				String a_id = rs.getString("a_id");
				String a_pw = rs.getString("a_pw");
				String a_mail = rs.getString("a_mail");
				String a_phone = rs.getString("a_phone");
				String a_reg_date = rs.getString("a_reg_date");
				String a_mod_date = rs.getString("a_mod_date");
				
				adminDto = new AdminDto();
				adminDto.setA_no(a_no);
				adminDto.setA_grade(a_grade);
				adminDto.setA_id(a_id);
				adminDto.setA_pw(a_pw);
				adminDto.setA_mail(a_mail);
				adminDto.setA_phone(a_phone);
				adminDto.setA_reg_date(a_reg_date);
				adminDto.setA_mod_date(a_mod_date);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (rs != null) {rs.close();}
				if (pstmt != null) {pstmt.close();}
				if (conn != null) {conn.close();}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return adminDto;
	}

	public ArrayList<AdminDto> adminList(String a_id) {
		System.out.println("[AdminDao] adminList()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<AdminDto> adminDtos = new ArrayList<>();
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql = "SELECT * FROM tbl_admin ORDER BY a_grade DESC, "
					+ " a_reg_date ASC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				AdminDto adminDto = new AdminDto();
				
				adminDto.setA_no(rs.getInt("a_no"));
				adminDto.setA_grade(rs.getInt("a_grade"));
				adminDto.setA_id(rs.getString("a_id"));
				adminDto.setA_pw(rs.getString("a_pw"));
				adminDto.setA_mail(rs.getString("a_mail"));
				adminDto.setA_phone(rs.getString("a_phone"));
				adminDto.setA_reg_date(rs.getString("a_reg_date"));
				adminDto.setA_mod_date(rs.getString("a_mod_date"));
				
				adminDtos.add(adminDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return adminDtos;
	}

	public ArrayList<MemberDto> userList() {
		System.out.println("[AdminDao] userList()");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberDto> userDtos = new ArrayList<>();
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql = "SELECT * FROM tbl_member ORDER BY m_reg_date ASC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				MemberDto userDto = new MemberDto();
				
				userDto.setM_no(rs.getInt("m_no"));
				userDto.setM_id(rs.getString("m_id"));
				userDto.setM_pw(rs.getString("m_pw"));
				userDto.setM_mail(rs.getString("m_mail"));
				userDto.setM_phone(rs.getString("m_phone"));
				userDto.setM_reg_date(rs.getString("m_reg_date"));
				userDto.setM_mod_date(rs.getString("m_mod_date"));
				
				userDtos.add(userDto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {rs.close();}
				if(pstmt != null) {pstmt.close();}
				if(conn != null) {conn.close();}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userDtos;
	}

	public int userModifyConfirm(MemberDto memberDto) {
		System.out.println("[AdminDao] userModifyConfirm()");
		
		Connection conn		 	= null;
		PreparedStatement pstmt = null;
		int result 				= -1;
		
		try {
			
			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);
			
			String sql =  "UPDATE "
						+ "	tbl_member "
						+ "SET "
						+ "	m_mail = ?, "
						+ "	m_phone = ?, "
						+ "	m_mod_date = NOW() "
						+ "WHERE "
						+ "	m_no = ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memberDto.getM_mail());
			pstmt.setString(2, memberDto.getM_phone());
			pstmt.setInt(3, memberDto.getM_no());
			
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

}
