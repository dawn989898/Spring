package ex1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String title = "TEST";
		String writed_id = "newlec";
		String content = "test content";
		String files = "";
		
		String url = "jdbc:oracle:thin:@localhost:1521";
		String sql = "INSERT INTO notice (" + 
				"    title," + 
				"    writed_id," + 
				"    content," + 
				"    files" + 
				") VALUES (?,?,?,?)";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection con = DriverManager.getConnection(url,"newlec","dksk7410");
		//Statement st = con.createStatement();
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, title);
		st.setString(2, writed_id);
		st.setString(3, content);
		st.setString(4, files);
		
		int result = st.executeUpdate();
		System.out.println(result);
		
		
		
		st.close();
		con.close();
	}

}
