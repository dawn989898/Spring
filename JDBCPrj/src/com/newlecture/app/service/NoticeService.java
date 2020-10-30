package com.newlecture.app.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.newlecture.app.entity.Notice;

public class NoticeService {
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521";
	private String userId = "newlec";
	private String pwd = "dksk7410";

	public List<Notice> getList() throws ClassNotFoundException, SQLException {

		String sql = "SELECT * FROM NOTICE";

		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, userId, pwd);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		List<Notice> list = new ArrayList<Notice>();

		while (rs.next()) {
			// 값 얻어서 변수에 저장
			int id = rs.getInt("ID");
			String title = rs.getString("TITLE");
			String writed_id = rs.getString("WRITED_ID");
			String content = rs.getString("CONTENT");
			Date regdate = rs.getDate("REGDATE");
			int hit = rs.getInt("HIT");
			String files = rs.getString("FILES");

			// 값들을 notice객체로 전달
			Notice notice = new Notice(id, title, writed_id, content, regdate, hit, files);
			// ArrayList생성해서 값 값 추가
			list.add(notice);
		}
		rs.close();
		st.close();
		con.close();
		return list;
	}

	public int insert(Notice notice) throws ClassNotFoundException, SQLException {

		String title = notice.getTitle();
		String writed_id = notice.getWrited_id();
		String content = notice.getContent();
		String files = notice.getFiles();

		String sql = "INSERT INTO notice (title, writed_id, content, files) " + "VALUES (?, ?, ?, ?)";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "newlec", "dksk7410");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writed_id);
		st.setString(3, content);
		st.setString(4, files);
		int result = st.executeUpdate();

		return result;
	}

	public int update(Notice notice) throws ClassNotFoundException, SQLException {

		int id = notice.getId();
		String title = notice.getTitle();
		String content = notice.getContent();
		String files = notice.getFiles();

		String sql = "UPDATE notice SET TITLE = ?, CONTENT = ?, FILES = ? WHERE ID = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "newlec", "dksk7410");
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);
		st.setInt(4, id);
		int result = st.executeUpdate();

		return result;
	}

	public int delete(int id) throws ClassNotFoundException, SQLException {

		String sql = "DELETE FROM notice WHERE id = ?";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "newlec", "dksk7410");
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		int result = st.executeUpdate();

		return result;
	}
}
