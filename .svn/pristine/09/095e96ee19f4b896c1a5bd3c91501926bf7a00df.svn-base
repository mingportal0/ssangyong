package com.zim.member.mail;

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

/**
 * Servlet implementation class MailController
 */
@WebServlet(description = "메일 전송", urlPatterns = { "/email/email.json" })
public class MailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final static Logger LOG = Logger.getLogger(MailController.class);
	MailService mailService;
    
    public MailController() {
    	mailService = new MailService();
    }
    
    protected void do_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOG.debug("02 do_update()");
    	MailVO inVO = new MailVO();
    	
    	String title = "비밀번호 변경 메일";
    	String email = StringUtil.nvl(request.getParameter("email"), "");
    	String user_id = StringUtil.nvl(request.getParameter("user_id"), "");
    	String passwd = StringUtil.nvl(request.getParameter("passwd"), "");
    	
    	String message = mailService.make_contents(user_id,passwd);
    	inVO.setTitle(title);
    	inVO.setMailTO(email);
    	inVO.setContents(message);
    	
    	LOG.debug("02.01.-----------------------------");
    	LOG.debug(inVO);
    	LOG.debug("-----------------------------");
    	
    	int flag = mailService.do_send_mail(inVO);
    	
    	//Message json
    	Gson gson = new Gson();
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	String msg = "";
    	String gsonString = "";
    	if(flag>0){
    		msg = inVO.getMailTO()+"에게 성공적으로 메일이 전송되었습니다.";
    	}
    	
    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
    	LOG.debug("03.03.gsonString : "+gsonString);
    	out.print(gsonString);
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		service(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		service(request,response);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("01-2 service()");
		req.setCharacterEncoding("UTF-8");
    	//work_div:read
    	String workDiv = StringUtil.nvl(req.getParameter("work_div"),"");
    	LOG.debug("02.1 workDiv:"+workDiv);
    	
    	/* do_retrieve:목록
    	 * do_insert:등록
    	 * do_update:수정
    	 * do_selectone:단건조회
    	 * do_delete:
    	 */
    	switch(workDiv){    	    
    		case "do_update" : //조회화면으로 이동
    			do_update(req,resp);
    		break;
    	}
	}
	
	
}
