package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:oracle:thin:@localhost:1521";
		String sql = "SELECT * FROM NOTICE WHERE HIT>=10";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"newlec","dksk7410");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
		
		String title = rs.getString("TITLE");
		int hit = rs.getInt("HIT");
		System.out.printf("title:%s, hit:%d", title, hit);
		}
		
		rs.close();
		st.close();
		con.close();
	}

}
