 /**
 * @Class Name : SearchPwService.java
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
package com.zim.member.searchpw;

import com.zim.cmn.MessageVO;
import com.zim.member.MemberDao;
import com.zim.member.MemberVO;

/**
 * @author sist
 *
 */
public class SearchPwService {
	MemberDao memberDao = new MemberDao();
	
	public MessageVO do_searchPw(MemberVO inVO){
		//db==아이디,이메일,주민등록번호 체크
		MessageVO outVO = new MessageVO();
		MemberVO tmpVO = (MemberVO) memberDao.do_selectOne_ckPw(inVO);
		if(tmpVO==null){
			outVO.setMsgId(String.valueOf("10"));
			outVO.setMsgContents("일치하는 회원이 없습니다.");
			return outVO;
		}else{
			outVO.setMsgId(String.valueOf("1"));
			outVO.setMsgContents("회원님의 비밀번호는 "+tmpVO.getPasswd()+"입니다.");
			return outVO;
		}
	}
}
