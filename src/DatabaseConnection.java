import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	protected static Connection initializeDatabase()
		throws SQLException, ClassNotFoundException {
		String dbURL = "jdbc:mysql://localhost:3306/";
		// Database name to access
		String dbName = "ECommerce";
		String dbUsername = "root";
		String dbPassword = "9810282699";

		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(dbURL + dbName,
													dbUsername,
													dbPassword);
		System.out.println("Connected database successfully...");
		return con;
	}
}
