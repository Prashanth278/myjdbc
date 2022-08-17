package myjdbc;

// 1. Import package java.sql.*
// 2a. Load driver (mysql connector for eclipse)
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.PreparedQuery;



public class Demo {
	
	public static void main(String[] args) throws Exception {
		
		String url="jdbc:mysql://localhost:3306/prash";
		String username="root";
		String password="1234";
		
		
		
		// 2b. register driver
		Class.forName("com.mysql.jdbc.Driver");
		
		// 3. Establish the connection
		Connection con = DriverManager.getConnection(url, username, password);
		
		int newRollNo=14;
		String newName = "Shikamaru";
		String query1 = "INSERT INTO STUDENTS VALUES (?, ?)";
		
		
		// 4. Create statement
		PreparedStatement st = con.prepareStatement(query1);
		//1, 2 implies question mark position in query1
		st.setInt(1, newRollNo);
		st.setString(2, newName);
		
		
		// 5. Execute query
		int  count = st.executeUpdate();
		System.out.println(count);

		// 7. Close connection & statement
		st.close();
		con.close();
	}

}