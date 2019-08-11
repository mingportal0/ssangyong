 /**
 * @Class Name : EditService.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 19.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 19. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member.checkpw;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.member.MemberDao;
import com.zim.member.MemberVO;

/**
 * @author sist
 *
 */
public class CheckPwService {
	private final Logger LOG = Logger.getLogger(MemberDao.class);
	MemberDao memberDao = new MemberDao();
	
	/**
	 * 
	 * @Method Name  : do_checkPw
	 * @작성일   : 2019. 7. 19.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 : 성공 1
	 * @return
	 */
	public int do_checkPw(DTO dto, String input){
		int flag = 0;
		MemberVO vo = (MemberVO) dto;		
		if(vo.getPasswd().equals(input)){
			LOG.debug("비번 일치");
			flag = 1;
			return flag;
		}else{
			flag = 10;
			return flag;			
		}	
	}
	/**
	 * 
	 * @Method Name  : do_updateData
	 * @작성일   : 2019. 7. 19.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 : 성공 1
	 * @return
	 */
	public int do_updateData(DTO dto){
		return memberDao.do_update(dto);
	}


}
