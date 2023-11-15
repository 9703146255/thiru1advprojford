package in.ashokit.dao;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class ConnectionFactory {

	private static final String DB_URL="jdbc:mysql://localhost:3306/ashokitdb";
	private static final String DB_UNAME="root";
	private static final String DB_PASSWORD="123456";
	private static final String DB_DRIVER="com.mysql.cj.jdbc.Driver";

	public static DataSource ds = null;

	public static DataSource getConn() {

		if (ds == null) {

			
			try {
				HikariConfig config = new HikariConfig();
				config.setJdbcUrl(DB_URL);
				config.setUsername(DB_UNAME);
				config.setPassword(DB_PASSWORD);
				config.setDriverClassName(DB_DRIVER);
				config.setMaximumPoolSize(20);
				config.setMinimumIdle(5);

				ds = new HikariDataSource(config);
				
			return ds;	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return ds;
	}

}
