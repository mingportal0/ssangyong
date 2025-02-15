 /**
 * @Class Name : MainController.java
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

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.zim.cmn.MessageVO;
import com.zim.cmn.StringUtil;
import com.zim.member.MemberVO;

/**
 * @author sist
 *
 */
@WebServlet(description = "회원관리", urlPatterns = { "/member/member.do","/member/member.json" })
public class LoginController extends HttpServlet {
	private final Logger LOG=Logger.getLogger(LoginController.class);
	LoginService loginService;
	
	public LoginController(){
		loginService = new LoginService();
	}
	//로그아웃
	protected void do_logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("03.1 do_logout");
    	//1.session삭제
    	HttpSession session = req.getSession();
    	if(null != session){
    		LOG.debug("03.1 bf session remove"+session);
    		session.removeAttribute("user");
    		session.invalidate();
    		LOG.debug("03.1 af session remove"+session);
    	}
    	//2.mainpage_view.jsp로 이동
       	req.setAttribute("mode","insert");
    	RequestDispatcher dispatcher =req.getRequestDispatcher("/mainpage/mainpage_view.jsp");
    	dispatcher.forward(req, resp);
	}
	//로그인
	//login : http://localhost:8080/ZIMZALABIM/member/member.do?login_div=do_login
	protected void do_login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("03.1 do_login");
    	MemberVO inVO=new MemberVO();
    	MessageVO msgVO = new MessageVO();
    	
    	String user_id = StringUtil.nvl(req.getParameter("user_id"), "");
    	String passwd = StringUtil.nvl(req.getParameter("passwd"), "");
    	inVO.setUserId(user_id);
    	inVO.setPasswd(passwd);    	
    	//--param
		LOG.debug("03.1 param-------------------------------");
		LOG.debug(inVO);
		LOG.debug("03.1 ------------------------------------");
    	
    	msgVO = loginService.loginCheck(inVO);
    	MemberVO outVO = new MemberVO();   
    	
    	LOG.debug("03.2 loginCheck----------------------------");
    	LOG.debug(msgVO);
    	LOG.debug("03.2----------------------------------------");
    	
    	//JSON
    	Gson gson = new Gson();
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	String msg = "";
    	String gsonString = "";
    	
    	//messageVO 값 전달
    	gsonString = gson.toJson(msgVO);
    	LOG.debug("gsonString : "+gsonString);
    	out.println(gsonString);
    	
    	//로그인 성공 시 MemberVO 세션 설정 : user
    	if(msgVO.getMsgId().equals("1")){
    		outVO = loginService.do_selectOne(inVO);
    		//session
    		HttpSession session = req.getSession();
    		session.setAttribute("user", outVO);
    	}
	}
	    
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		LOG.debug("01.1 loginService:"+loginService);
		service(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		LOG.debug("01.1 loginService:"+loginService);
		service(req,resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("02 service()");
		req.setCharacterEncoding("UTF-8");
    	//work_div:read
    	String loginDiv = StringUtil.nvl(req.getParameter("login_div"),"");
    	LOG.debug("02.1 loginDiv:"+loginDiv);
    	
    	/* do_retrieve:목록
    	 * do_insert:등록
    	 * do_update:수정
    	 * do_selectone:단건조회
    	 * do_delete:
    	 */
    	switch(loginDiv){
	    	case "do_logout":
				do_logout(req,resp);
			break;
	    	case "do_login":
				do_login(req,resp);
			break;
    	}
	}
	
}
