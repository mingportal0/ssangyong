package com.zim.cmn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ConnectionMaker {
	private final Logger LOG = Logger.getLogger(ConnectionMaker.class);
	Connection conn = null;	
	public Connection getConnection(){		
		try {
			//1.jdbc 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			LOG.debug("-------------------------");
			LOG.debug("ClassNotFoundException"+e.getMessage());
			LOG.debug("-------------------------");
		}
		LOG.debug("1.jdbc 드라이버 로딩");
		try {
			ConnectionProp prop = new ConnectionProp();
			conn = DriverManager.getConnection(prop.getDbUrl(), prop.getDbUser(), prop.getDbPasswd());
		} catch (SQLException e) {
			LOG.debug("-------------------------");
			LOG.debug("SQLException"+e.getMessage());
			LOG.debug("-------------------------");
		}
		LOG.debug("2.데이터베이스 커넥션 생성:"+conn);
		
		return conn;
	}
}
