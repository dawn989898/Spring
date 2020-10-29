package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		String title = "TEST3";
		String content = "HAHAHA";
		String files = "";
		String url = "jdbc:oracle:thin:@localhost:1521";
		String sql = "UPDATE notice SET TITLE = ?, CONTENT = ?, FILES = ? WHERE ID = 1";

		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url, "newlec", "dksk7410");
		// Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, content);
		st.setString(3, files);

		int result = st.executeUpdate();
		System.out.println(result);

		st.close();
		con.close();
	}

}
