package com.zim.member.searchpw;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.zim.cmn.MessageVO;
import com.zim.cmn.StringUtil;
import com.zim.member.MemberVO;
import com.zim.member.searchid.SearchIdController;

/**
 * Servlet implementation class SearchPwController
 */
@WebServlet("/searchpw/searchpw.json")
public class SearchPwController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger LOG = Logger.getLogger(SearchPwController.class);
	private SearchPwService searchPwService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchPwController() {
    	searchPwService = new SearchPwService();
    }
    
    private void do_SearchPw(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	LOG.debug("03. do_SearchId:");
    	String user_Id = StringUtil.nvl(req.getParameter("user_Id"),"");
    	String email = StringUtil.nvl(req.getParameter("email"),"");
    	String resident_No = StringUtil.nvl(req.getParameter("resident_No"),"");
    	
    	MemberVO inVO = new MemberVO();
    	MessageVO msgVO = new MessageVO();
    	inVO.setUserId(user_Id);
    	inVO.setEmail(email);
    	inVO.setResidentNo(resident_No);
    	//--param
		LOG.debug("03.1 param-------------------------------");
		LOG.debug(inVO);
		LOG.debug("03.1 ------------------------------------");
    	
		msgVO = searchPwService.do_searchPw(inVO);    	
    	LOG.debug("03.2 do_searchPw----------------------------");
    	LOG.debug(msgVO);
    	LOG.debug("03.2----------------------------------------");
    	
    	//JSON
    	Gson gson = new Gson();
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	String msg = "";
    	String gsonString = "";
    	
    	gsonString = gson.toJson(msgVO);
    	LOG.debug("gsonString : "+gsonString);
    	out.println(gsonString); 	
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01.02.service");
		request.setCharacterEncoding("UTF-8");
		//work_div:read
    	String workDiv = StringUtil.nvl(request.getParameter("work_div"),"");
    	LOG.debug("02.1 workDiv:"+workDiv);
    	
    	switch(workDiv){
    		case "do_SearchPw":
    			do_SearchPw(request,response);
    		break;    	
    	}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01.01.doGet");
		service(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01.01.doPost");
		service(request, response);
	}

}
