 /**
 * @Class Name : JoinTest.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 16.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 16. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.join;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.SearchVO;
import com.zim.cmn.SearchVO2;
import com.zim.cmn.DTO;
import com.zim.cmn.WorkDiv;


/**
 * @author sist
 *
 */
public class JoinTest {
	
	private final Logger LOG=Logger.getLogger(JoinTest.class);
	JoinVO vo01;
	JoinVO vo02;
	JoinVO vo03;
	JoinDao dao;
	

	public JoinTest(){
		vo01=new JoinVO("아이디001","23","","4","10");
		vo02=new JoinVO("soso","5","","30","10");
		vo03=new JoinVO("soso","1","","30","10");
		dao=new JoinDao();
	}
	
	public void do_update(){
		vo01.setJoin_status("20");
		int flag = dao.do_update(vo01);
	}
	public void do_insert(){
		int flag = dao.do_insert(vo02);
	}
	public void do_delete(){
		vo01.setProduct_no("4");
		int delFlag = dao.do_delete(vo01);
		
		LOG.debug("----------");
		LOG.debug("delFlag:"+delFlag);
		LOG.debug("----------");	
	}	
	public void do_do_selectOne(){
		vo01.setProduct_no("60");
		JoinVO outVO =(JoinVO) dao.do_selectOne(vo01);
		LOG.debug("----------");
		LOG.debug("outVO:"+outVO);
		LOG.debug("----------");
	}
	public void do_retrieve(){

	
		SearchVO searchVO =new SearchVO();
		searchVO.setPageSize(10);
		searchVO.setPageNum(1);
		searchVO.setSearchWord("아이디012");
		//searchVO.setSearchDiv("");
		//searchVO.setSearchWord("이상무001");

		
		List<JoinVO> list=dao.do_retrieve(searchVO);
		LOG.debug("=================");
		LOG.debug("list"+list);
		LOG.debug("=================");		
	}
	public void do_retrieve2(){


		SearchVO searchVO =new SearchVO();
		searchVO.setPageSize(10);
		searchVO.setPageNum(1);
		searchVO.setSearchWord("아이디008");

		
		List<JoinVO> list=dao.do_retrieve2(searchVO);
		LOG.debug("=================");
		LOG.debug("list"+list);
		LOG.debug("=================");		
	}
	public static void main(String[] args) {
		JoinTest joinTest=new JoinTest();
		//joinTest.do_insert();
		//joinTest.do_delete();
		//joinTest.do_do_selectOne();
		joinTest.do_retrieve();
		//joinTest.do_retrieve2();
		//joinTest.do_update();
	}

	
}