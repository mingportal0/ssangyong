 /**
 * @Class Name : MemberTestMain.java
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
package com.zim.member;

import java.util.List;
import org.apache.log4j.Logger;
import com.zim.cmn.SearchVO;
import com.zim.member.resister.ResisterService;
import com.zim.member.searchid.SearchIdService;
import com.zim.member.searchpw.SearchPwService;


/**
 * @author sist
 *
 */
public class MemberTestMain {
	private final Logger LOG = Logger.getLogger(MemberTestMain.class);
	MemberVO vo01;
	MemberVO vo02;
	MemberVO vo03;
	MemberVO vo04;
	MemberDao dao;
	ResisterService rs;
	SearchIdService sid;
	SearchPwService spw;
	public MemberTestMain(){
		vo01 = new MemberVO("아이디12","비번12","이름12","이메일12@naver.com","1234567123456","010-1234-1245","","1","아이디12","","아이디12","");
		vo02 = new MemberVO("아이디13","비번13","이름13","이메일13@naver.com","1234567123456","010-1234-1245","","1","아이디13","","아이디13","");
		vo03 = new MemberVO("아이디14","비번14","이름14","이메일14@naver.com","1234567123456","","","1","아이디14","","아이디14","");
		vo04 = new MemberVO("아이디12","pass12","name12","이메일12@naver.com","1234567123456","010-1234-1245","","1","아이디12","","아이디12","");
		dao = new MemberDao();
		rs = new ResisterService();
		sid = new SearchIdService();
		spw = new SearchPwService();
	}
	public void do_insertTest(){
		int flag = dao.do_insert(vo01);
		LOG.debug("=========================");
		LOG.debug("flag"+flag);
		LOG.debug("=========================");
	}
	public void do_deleteTest(){
		int flag = dao.do_delete(vo01);
		LOG.debug("=========================");
		LOG.debug("flag"+flag);
		LOG.debug("=========================");
	}
	public void do_InsertAndDelete(){
		do_insertTest();
		do_deleteTest();
	}
	public void do_InsertAndSelectOne(){
		do_insertTest();
		MemberVO tmpVO = (MemberVO) dao.do_selectOne(vo01);
		LOG.debug(tmpVO);
	}
	public void do_retrieveTest(){
		SearchVO searchVO = new SearchVO();
		searchVO.setPageNum(1);
		searchVO.setPageSize(10);
		searchVO.setSearchDiv("10");
		searchVO.setSearchWord("아이디");
		List<MemberVO> members = dao.do_retrieve(searchVO);
		LOG.debug("======================================================================");
		for(MemberVO vo : members){
			LOG.debug(vo);
		}
		LOG.debug("======================================================================");
	}
	public void do_login(){
		//로그인 테스트
		vo02.setUserId("아이디13");
		vo02.setPasswd("비번4");
		dao.do_login(vo02);
	}
	public void do_resister(){
		//회원가입 - 모두 기입
		rs.do_resister(vo02);
		//회원가입 - 필수만 기입
		rs.do_resister(vo03);
	}
	public void do_update(){
		int flag = dao.do_update(vo01);
		LOG.debug("=========================");
		LOG.debug("flag"+flag);
		LOG.debug("=========================");
	}
	public static void main(String[] args) {
		MemberTestMain mainTest = new MemberTestMain();
		//mainTest.do_InsertAndDelete();
		//mainTest.do_InsertAndSelectOne();
		//mainTest.do_retrieveTest();
		//mainTest.do_login();
		//mainTest.do_resister();
		//mainTest.do_update();
		//mainTest.do_searchId();
	}

}
