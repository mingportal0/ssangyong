 /**
 * @Class Name : ProductTest.java
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
package com.zim.product.comment;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;

/**
 * @author SIST
 *
 */
public class CommentTest {

	private final Logger LOG = Logger.getLogger(CommentTest.class);
	
	private CommentVO vo01;
	private CommentVO vo02;
	private CommentVO vo03;
	
	private CommentDao dao;
	
	
	
	public CommentTest(){
		vo01 = new CommentVO("1","6","댓글내용01","","김뀨잉","");
		vo02 = new CommentVO("2","6","댓글내용02","1","김뀨잉02","");
		vo03 = new CommentVO("3","6","댓글내용03","2","김뀨잉03","");
		
		dao = new CommentDao();
	}
	
	
	
	
	public void do_insert() {
		int flag = dao.do_insert(vo01);
		LOG.debug("=================");
		LOG.debug("flag"+flag);
		LOG.debug("=================");
	}
	
	
	
	public void do_update() {
		int flag = dao.do_update(vo02);
		LOG.debug("=================");
		LOG.debug("flag"+flag);
		LOG.debug("=================");
	}
	
	
	public void do_delete(){
		vo02.setProductNo("162");
		vo02.setCommentNo("141");
		vo02.setRegId("아이디031");
		int flag = dao.do_delete(vo02);
		LOG.debug("=================");
		LOG.debug("flag"+flag);
		LOG.debug("=================");
	}
	
	public void do_retrieve() {
		vo01.setProductNo("162");
		List<CommentVO> list = (List<CommentVO>) dao.do_retrieve(vo01);
		LOG.debug("==============");
		for(CommentVO vo:list){
			LOG.debug("vo"+vo);
		}
		LOG.debug("==============");
	}
	
	
	
	/**
	 * @Method Name  : main
	 * @작성일   : 2019. 7. 16.
	 * @작성자   : SIST
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param args
	 */
	public static void main(String[] args) {
		CommentTest productTest = new CommentTest();
		//productTest.do_insert();
		//productTest.do_update();
		productTest.do_delete();
		//productTest.do_retrieve();
		
	}
	
	

}
