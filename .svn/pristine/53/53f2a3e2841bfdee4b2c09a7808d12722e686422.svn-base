package com.zim.member.quit;

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
 * Servlet implementation class QuitController
 */
@WebServlet(description = "회원탈퇴", urlPatterns = { "/quit/quit.do","/quit/quit.json" })
public class QuitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    final Logger LOG = Logger.getLogger(this.getClass());
    private QuitService quitService;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuitController() {
    	quitService = new QuitService();
    }
    
    protected void do_delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	LOG.debug("03.1 do_delete");
    	
		String passWd = StringUtil.nvl(req.getParameter("passWd"),"");
    	LOG.debug("03.01.passWd:"+passWd);
    	
    	//세션 값 불러오기
    	HttpSession session = req.getSession();
    	MemberVO memberVO = (MemberVO) session.getAttribute("user");
    	
    	MessageVO msgVO = quitService.do_quit(memberVO,passWd);
    	String flag = msgVO.getMsgId();
    	
    	//JSON
    	Gson gson = new Gson();
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	String msg = "";
    	String gsonString = "";
    	
    	if(flag.equals("1")){
    		//탈퇴 성공 후 세션 삭제
			session.removeAttribute("user");
			session.invalidate();
    	}else{
    		msg = "회원탈퇴 실패.";
    	}
    	gsonString = gson.toJson(msgVO);
    	LOG.debug("gsonString : "+gsonString);
    	out.println(gsonString);     	
    }
    
	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("--------------------------");
		LOG.debug("02.service");
		LOG.debug("--------------------------");
		
		req.setCharacterEncoding("UTF-8");
    	//work_div:read
    	String workDiv = StringUtil.nvl(req.getParameter("work_div"),"");
    	LOG.debug("02.1 workDiv:"+workDiv);
    	
		switch(workDiv){
		case "do_delete":
			do_delete(req,resp);
		break;
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("--------------------------");
		LOG.debug("doGet");
		LOG.debug("--------------------------");
		service(req, resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("--------------------------");
		LOG.debug("doPost");
		LOG.debug("--------------------------");
		service(req, resp);
	}

}
