 /**
 * @Class Name : MainService.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 31.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 31. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member.login;
import com.zim.cmn.DTO;
import com.zim.cmn.MessageVO;
import com.zim.member.MemberDao;
import com.zim.member.MemberVO;

public class LoginService {
	MemberDao MemberDao;
	
	public LoginService(){
		MemberDao = new MemberDao();
	}
	
	public MessageVO loginCheck(DTO dto){
		MessageVO outVO = new MessageVO();
		//01 : ID Check
		outVO = MemberDao.do_idCheck(dto);
		if(!outVO.getMsgId().equals("1"))return outVO;
		//02 : Pass Check
		outVO = MemberDao.do_passCheck(dto);
		if(!outVO.getMsgId().equals("1"))return outVO;		
		return outVO;
	}
	public MemberVO do_selectOne(DTO dto) {
		return MemberDao.do_selectOne(dto);
	}

}
