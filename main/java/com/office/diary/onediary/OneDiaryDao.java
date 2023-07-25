package com.office.diary.onediary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.office.diary.DBDao;

public class OneDiaryDao extends DBDao {

	public ArrayList<OneDiaryDto> diaryList(String m_id) {
		System.out.println("[OneDiaryDao] diaryList()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		ArrayList<OneDiaryDto> oneDiaryDtos = new ArrayList<>();

		try {

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);

			String sql = "SELECT * FROM tbl_diary " + "WHERE m_id = ? " + "ORDER BY d_reg_date DESC";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m_id);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				OneDiaryDto oneDiaryDto = new OneDiaryDto();

				oneDiaryDto.setD_no(rs.getInt("d_no"));
				oneDiaryDto.setD_word(rs.getString("d_word"));
				oneDiaryDto.setM_id(rs.getString("m_id"));
				oneDiaryDto.setD_reg_date(rs.getString("d_reg_date"));
				oneDiaryDto.setD_mod_date(rs.getString("d_mod_date"));

				oneDiaryDtos.add(oneDiaryDto);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		return oneDiaryDtos;

	}

	public int diaryRegistConfirm(String m_id, String d_word) {
		System.out.println("[OneDiaryDao] diaryRegistConfirm()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);

			String sql = "INSERT INTO tbl_diary(d_word, m_id, d_reg_date, d_mod_date) " + "VALUES(?, ?, NOW(), NOW())";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d_word);
			pstmt.setString(2, m_id);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		return result;

	}

	public OneDiaryDto diaryModifyForm(int d_no) {
		System.out.println("[OneDiaryDao] diaryModifyForm()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		OneDiaryDto oneDiaryDto = new OneDiaryDto();

		try {

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);

			String sql = "SELECT * FROM tbl_diary " + "WHERE d_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d_no);

			rs = pstmt.executeQuery();
			while (rs.next()) {

				oneDiaryDto.setD_no(rs.getInt("d_no"));
				oneDiaryDto.setD_word(rs.getString("d_word"));
				oneDiaryDto.setM_id(rs.getString("m_id"));
				oneDiaryDto.setD_reg_date(rs.getString("d_reg_date"));
				oneDiaryDto.setD_mod_date(rs.getString("d_mod_date"));

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		return oneDiaryDto;

	}

	public int diaryModifyConfirm(int d_no, String d_word) {
		System.out.println("[OneDiaryDao] diaryModifyConfirm()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);

			String sql = "UPDATE tbl_diary SET d_word = ?, d_mod_date = NOW() " + "WHERE d_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d_word);
			pstmt.setInt(2, d_no);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		return result;

	}

	public int diaryDeleteConfirm(int d_no) {
		System.out.println("[OneDiaryDao] diaryDeleteConfirm()");

		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = -1;

		try {

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);

			String sql = "DELETE FROM tbl_diary " + "WHERE d_no = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, d_no);

			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}

		}

		return result;

	}

	public List<OneDiaryDto> diarySearchConfirm(String m_id, String txt) {
		System.out.println("[OneDiaryDao] diarySearchConfirm()");

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		List<OneDiaryDto> oneDiaryDtos = new ArrayList<>();

		try {

			Class.forName(DRIVER);
			conn = DriverManager.getConnection(URL, USERID, USERPW);

			String sql = "SELECT * FROM tbl_diary " + "WHERE m_id = ? AND d_word LIKE ? " + "ORDER BY d_reg_date DESC";

			ps = conn.prepareStatement(sql);
			ps.setString(1, m_id);
			ps.setString(2, "%" + txt + "%");

			rs = ps.executeQuery();

			while (rs.next()) {
				OneDiaryDto oneDiaryDto = new OneDiaryDto();

				oneDiaryDto.setD_no(rs.getInt("d_no"));
				oneDiaryDto.setD_word(rs.getString("d_word"));
				oneDiaryDto.setM_id(rs.getString("m_id"));
				oneDiaryDto.setD_reg_date(rs.getString("d_reg_date"));
				oneDiaryDto.setD_mod_date(rs.getString("d_mod_date"));

				oneDiaryDtos.add(oneDiaryDto);

			}

		} catch (Exception e) {
			e.printStackTrace();

		} finally {

			try {

				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
				if (conn != null)
					conn.close();

			} catch (Exception e) {
				e.printStackTrace();

			}
		}

		return oneDiaryDtos;
	}

}
