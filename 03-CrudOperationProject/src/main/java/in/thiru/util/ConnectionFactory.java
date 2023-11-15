package in.thiru.util;


import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static final String DB_URL = "jdbc:mysql://localhost:3306/ashokitdb";
	private static final String DB_UNAME = "root";
	private static final String DB_PASSWORD = "123456";
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static Connection connection = null;

	private ConnectionFactory() {
	}

	public static Connection getConn() {

		try {

			if (connection == null) {
				HikariConfig config = new HikariConfig();
				config.setJdbcUrl(DB_URL);
				config.setUsername(DB_UNAME);
				config.setPassword(DB_PASSWORD);
				config.setDriverClassName(DB_DRIVER);

				HikariDataSource hikariDataSource = new HikariDataSource(config);

				Connection connection = hikariDataSource.getConnection();

				return connection;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;

	}

}
