 /**
 * @Class Name : EditService.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 29.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 29. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member.edit;

import com.zim.cmn.DTO;
import com.zim.member.MemberDao;

/**
 * @author sist
 *
 */
public class EditService {
	MemberDao memberDao;
	
	public EditService(){
		memberDao = new MemberDao();
	}
	
	public int do_update(DTO dto) {
		int flag = memberDao.do_update(dto);
		
		return flag;
	}
}
