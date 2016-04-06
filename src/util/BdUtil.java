package util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class BdUtil {
	private static Connection dbConnection = null;

	public static Connection getConnection() {
		System.out.print("Conectando...");
		if (dbConnection != null) {
			return dbConnection;
		} else {
			try {
				InputStream inputStream = BdUtil.class.getClassLoader()
						.getResourceAsStream("bd.properties");
				Properties properties = new Properties();
				if (properties != null) {
					properties.load(inputStream);

					String dbDriver = properties.getProperty("dbDriver");
					String connectionUrl = properties
							.getProperty("connectionUrl");
					String userName = properties.getProperty("userName");
					String password = properties.getProperty("password");
					System.out.print(connectionUrl+" "+userName+" "+password);
					Class.forName(dbDriver).newInstance();
					//DriverManager.registerDriver(new com.mysql.jdbc.Driver ());
					dbConnection = DriverManager.getConnection(connectionUrl,
							userName, password);
					
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return dbConnection;
		}
	}
}
