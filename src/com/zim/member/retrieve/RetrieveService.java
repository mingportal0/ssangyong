 /**
 * @Class Name : RetrieveService.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 25.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 25. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member.retrieve;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.member.MemberDao;
import com.zim.member.MemberVO;

/**
 * @author sist
 *
 */
public class RetrieveService {
private final Logger LOG=Logger.getLogger(RetrieveService.class);
	
	private MemberDao memberDao;
	
	public RetrieveService(){
		memberDao = new MemberDao();
	}
	
	public int do_delete(DTO dto) {
		return memberDao.do_delete(dto);
	}
	public int do_update(DTO dto) {
		return memberDao.do_update(dto);
	}
	
	public MemberVO do_selectOne(DTO dto) {
		return memberDao.do_selectOne(dto);
	}
	
	public List<MemberVO> do_retrieve(DTO dto) {
		return memberDao.do_retrieve(dto);
	}	
}
