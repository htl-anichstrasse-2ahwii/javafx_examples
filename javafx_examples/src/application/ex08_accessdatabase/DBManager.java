package application.ex08_accessdatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {
	private Connection con;
	public DBManager() throws ClassNotFoundException, SQLException  {		
		Class.forName("com.mysql.jdbc.Driver"); //Optional
		con = DriverManager.getConnection("jdbc:mysql://localhost/employees?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");

	}
	
	public Employee getEmployee(int empId) throws SQLException
	{
		String sql = "SELECT * FROM employees WHERE emp_no = ?";
		PreparedStatement stmt =  con.prepareStatement(sql);
		stmt.setInt(1, empId);
		ResultSet rs =  stmt.executeQuery();
		Employee e = null;
		while (rs.next())
		{
			int empNo = rs.getInt("emp_no");
			String firstName = rs.getString("first_name");
			String lastName = rs.getString("last_name");
			e = new Employee(empNo, firstName, lastName);
		}
		rs.close();
		stmt.close();
		return e;
	}
	
	public void close() throws SQLException
	{
		con.close();
	}
}
