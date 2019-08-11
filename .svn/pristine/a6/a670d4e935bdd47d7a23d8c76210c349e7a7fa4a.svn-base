package com.zim.member.edit;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.zim.cmn.MessageVO;
import com.zim.cmn.StringUtil;
import com.zim.member.MemberVO;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/edit/edit.do")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Logger LOG=Logger.getLogger(EditController.class);
	private EditService editService;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditController() {
    	editService = new EditService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		LOG.debug("01.1 editService:"+editService);
		service(req,resp);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		LOG.debug("01.1 editService:"+editService);
		service(req,resp);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("02 service()");
		req.setCharacterEncoding("UTF-8");
		//work_div:read
    	String workDiv = StringUtil.nvl(req.getParameter("work_div"),"");
    	LOG.debug("02.1 workDiv:"+workDiv);
    	
    	switch(workDiv){
    		case "do_update":
    			do_update(req,resp);
    		break;    	
    	};
	}

	 /**
	 * @Method Name  : do_update
	 * @작성일   : 2019. 8. 2.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param req
	 * @param resp
	 */
	private void do_update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		LOG.debug("03 do_update()");
		MemberVO inVO = new MemberVO();
		String userId = StringUtil.nvl(req.getParameter("user_id"),"");
		String passwd = StringUtil.nvl(req.getParameter("passwd"),"");
		String  name= StringUtil.nvl(req.getParameter("name"),"");
		String email = StringUtil.nvl(req.getParameter("email"),"");
		String residentNo = StringUtil.nvl(req.getParameter("resident_no"),"");
		String cellPhone = StringUtil.nvl(req.getParameter("cell_phone"),"");
		String lvl = StringUtil.nvl(req.getParameter("lvl"),"1");
		inVO.setUserId(userId);
		inVO.setPasswd(passwd);
		inVO.setName(name);
		inVO.setEmail(email);
		inVO.setResidentNo(residentNo);
		inVO.setCellPhone(cellPhone);
		inVO.setRegId(userId);
		inVO.setModId(userId);
		inVO.setLvl(lvl);
		
		//--param
		LOG.debug("03.1 param-------------------------------");
		LOG.debug(inVO);
		LOG.debug("03.1 ------------------------------------");
		
		int flag = editService.do_update(inVO);
		LOG.debug("03.2 do_resister----------------------------");
    	LOG.debug("flag : "+flag);
    	LOG.debug("03.2----------------------------------------");
    	
    	Gson gson = new Gson();
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	String msg = "";
    	String gsonString = "";    
    	if(flag>0){
    		msg = "회원정보가 수정 되었습니다.";
    	}else{
    		msg = "회원정보 수정 실패.";
    	}
    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag), msg));
    	LOG.debug("03.4 gsonString : "+gsonString);
    	out.println(gsonString);
    	
    	//로그인 성공 시 MemberVO 세션 설정 : user
    	//기존 세션 삭제
    	HttpSession session = req.getSession();
    	if(null != session){
    		session.removeAttribute("user");
    		session.invalidate();
    	}
    	//새로 세션 추가
    	if(flag==1){
    		//session
    		HttpSession session_new = req.getSession();
    		session_new.setAttribute("user", inVO);
    	}
	}
	
}
