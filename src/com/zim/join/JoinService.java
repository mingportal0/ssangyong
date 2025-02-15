package com.zim.join;

import java.util.List;

import org.apache.log4j.Logger;
import com.zim.cmn.DTO;
import com.zim.cmn.SearchVO2;


public class JoinService {
	//private   JoinVO JoinVO = null;

	private final Logger LOG=Logger.getLogger(JoinDao.class);
	
	private JoinDao joinDao;
	
	public JoinService(){
		joinDao=new JoinDao();
	}
	
	public int do_insert(DTO dto){
		
		return joinDao.do_insert(dto);
	}
	public int do_update(DTO dto){
		
		return joinDao.do_update(dto);
	}
	public int do_update2(DTO dto){
		
		return joinDao.do_update2(dto);
	}
	public int do_delete(DTO dto){
		
		return joinDao.do_delete(dto);
	}
	public JoinVO do_selectOne(DTO dto){
		
		return joinDao.do_selectOne(dto);
	}
	public List<JoinVO>do_retrieve(DTO dto){
		
		return joinDao.do_retrieve(dto );
		
	}
	public List<JoinVO>do_retrieve2(DTO dto){
		return joinDao.do_retrieve2(dto );
	}
	
}

