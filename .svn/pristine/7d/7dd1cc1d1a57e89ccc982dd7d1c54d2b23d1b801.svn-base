 /**
 * @Class Name : QuitService.java
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
package com.zim.member.quit;

import com.zim.cmn.DTO;
import com.zim.cmn.MessageVO;
import com.zim.member.MemberDao;
import com.zim.member.checkpw.CheckPwService;

/**
 * @author sist
 *
 */
public class QuitService {
	MemberDao dao = new MemberDao();
	CheckPwService checkPwService = new CheckPwService();
	
	public MessageVO do_quit(DTO dto, String input){
		MessageVO outVO = new MessageVO();
		//1:성공, 10:비번 잘못 입력, 20: 탈퇴 실패, 30:알 수 없는 오류
		int flag = checkPwService.do_checkPw(dto, input);
		if(flag>1){
			outVO.setMsgId(String.valueOf(flag));
			outVO.setMsgContents("비밀 번호를 잘못 입력하셨습니다.");
			return outVO;
		}
		int delete_Flag = dao.do_delete(dto);
		if(delete_Flag>1){
			outVO.setMsgId(String.valueOf(delete_Flag));
			outVO.setMsgContents("회원탈퇴가 실패하였습니다.");
			return outVO;
		}
		if(flag==1 && delete_Flag==1){
			outVO.setMsgId(String.valueOf("1"));
			outVO.setMsgContents("회원탈퇴가 되었습니다..");
			return outVO;
		}else{
			outVO.setMsgId(String.valueOf("30"));
			outVO.setMsgContents("알 수 없는 오류입니다.");
			return outVO;
		}
	}
}
