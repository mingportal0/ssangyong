 /**
 * @Class Name : JoinStatusService.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 22.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 22. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.join.joinstatus;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.join.JoinDao;
import com.zim.join.JoinVO;

/**
 * @author sist
 *
 */
public class JoinStatusService {
	private final Logger LOG=Logger.getLogger(JoinDao.class);
	
	private JoinDao joinDao;
	public JoinStatusService(){
		joinDao=new JoinDao();
	}
	
	public int do_insert(DTO dto){
		
		return joinDao.do_insert(dto);
	}
	public int do_update(DTO dto){
		
		return joinDao.do_update(dto);
	}
	public int do_delete(DTO dto){
		
		return joinDao.do_delete(dto);
	}
	public JoinVO do_selectOne(DTO dto){
		
		return joinDao.do_selectOne(dto);
	}
	public List<JoinVO>do_retrieve(DTO dto){
		
		return joinDao.do_retrieve(dto);
	}
	
}