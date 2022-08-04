package util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBHelper {
	public static Connection connection() throws IOException {
		Connection con = null;
		FileReader f = new FileReader("config.properties");
		Properties p = new Properties();
		p.load(f);
		try {
			Class.forName(p.getProperty("driverManager"));
			con = DriverManager.getConnection(p.getProperty("dbUrl"), p.getProperty("username"),
					p.getProperty("password"));
//			if(con!=null)
//				System.out.println("ok");
//			else
//				System.out.println("not ok");
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}
		return con;
	}
}
