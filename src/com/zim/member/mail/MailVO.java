/**
 * @Class Name : MailVO.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 8. 5.           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2019. 8. 5. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 */
package com.zim.member.mail;

import com.zim.cmn.DTO;

/**
 * @author sist
 *
 */
public class MailVO extends DTO {
	String mailTO;
	String title;
	String contents;
	
	public MailVO(){}

	public String getMailTO() {
		return mailTO;
	}

	public void setMailTO(String mailTO) {
		this.mailTO = mailTO;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public MailVO(String mailTO, String title, String contents) {
		super();
		this.mailTO = mailTO;
		this.title = title;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return "MailVO [mailTO=" + mailTO + ", title=" + title + ", contents=" + contents + "]";
	};
	
	
}
