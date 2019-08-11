package com.zim.member.searchid;

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

/**
 * Servlet implementation class SearchIdController
 */
@WebServlet(description = "아이디찾기", urlPatterns = { "/searchid/searchid.json" })
public class SearchIdController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger LOG = Logger.getLogger(SearchIdController.class);
	private SearchIdService searchIdService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdController() {
    	searchIdService = new SearchIdService();
    }
    
    private void do_SearchId(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
    	LOG.debug("03. do_SearchId:");
    	String email = StringUtil.nvl(req.getParameter("email"),"");
    	MemberVO inVO = new MemberVO();
    	MessageVO msgVO = new MessageVO();
    	inVO.setEmail(email);
    	//--param
		LOG.debug("03.1 param-------------------------------");
		LOG.debug(inVO);
		LOG.debug("03.1 ------------------------------------");
    	
		msgVO = searchIdService.do_searchId(inVO);    	
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
    		case "do_SearchId":
    			do_SearchId(request,response);
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
