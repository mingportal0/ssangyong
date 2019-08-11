 /**
 * @Class Name : MailTestMain.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 8. 9.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 8. 9. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member.mail;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/**
 * @author sist
 *
 */
public class MailTestMain {

	final static Logger LOG = Logger.getLogger(MailTestMain.class);
	MailService service = new MailService();
	
	public static void main(String[] args) {
		MailVO vo = new MailVO("nmjgo7321@gmail.com", "테스트", "내용");
		MailTestMain main = new MailTestMain();
		main.service.do_send_mail(vo);
	}

}
