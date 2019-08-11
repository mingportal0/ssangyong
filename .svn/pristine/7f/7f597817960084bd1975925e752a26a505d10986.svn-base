/**
 * @Class Name : ConnectionProp.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 6. 25.           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2019. 6. 25. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 */
package com.zim.cmn;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import org.apache.log4j.Logger;

/**
 * @author sist
 *
 */
public class ConnectionProp {
	private final Logger LOG = Logger.getLogger(ConnectionProp.class);
	Properties prop = new Properties();
	
	private String dbUrl;
	private String dbUser;
	private String dbPasswd;
	
	public ConnectionProp(){
		//Properties 로딩
				//String propPath = "/WEB_EX01/src/ConnectionInfo.properties";
				try {
					ClassLoader cl = Thread.currentThread().getContextClassLoader();
					URL url = cl.getResource("ConnectionInfo.properties");
					prop.load(url.openStream());
				}
				catch(FileNotFoundException e){
					LOG.debug("FileNotFoundException:"+e.getMessage());
				}catch (IOException e) {		
					LOG.debug("IOException:"+e.getMessage());
				}
	}

	public String getDbUrl() {
		dbUrl = prop.getProperty("dbUrl");
		return dbUrl;
	}

	public String getDbUser() {
		dbUser = prop.getProperty("dbUser");
		return dbUser;
	}

	public String getDbPasswd() {
		dbPasswd = prop.getProperty("dbPasswd");
		return dbPasswd;
	}
	
}
