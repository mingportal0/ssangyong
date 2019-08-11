 /**
 * @Class Name : RetrieveController.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 25.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 25. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member.retrieve;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.google.gson.Gson;
import com.zim.cmn.MessageVO;
import com.zim.cmn.SearchVO;
import com.zim.cmn.StringUtil;
import com.zim.code.CodeDao;
import com.zim.code.CodeVO;
import com.zim.member.MemberVO;


@WebServlet(description = "회원정보조회", urlPatterns = { "/retrieve/retrieve.do" ,"/retrieve/retrieve.json" })
public class RetrieveController extends HttpServlet{
	private final Logger LOG=Logger.getLogger(RetrieveController.class);
	private RetrieveService retrieveService;
	
	public RetrieveController(){
		retrieveService = new RetrieveService();
	}
	
	//do_retrieve
    protected void do_retrieve(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	LOG.debug("03.1 do_retrieve");
    	SearchVO  inVO =new SearchVO();
    	String pageNum    = StringUtil.nvl(req.getParameter("page_num"),"1");
    	String searchDiv  = StringUtil.nvl(req.getParameter("search_div"),"");
    	String searchWord = StringUtil.nvl(req.getParameter("search_word"),"");
    	String pageSize   = StringUtil.nvl(req.getParameter("page_size"),"10");
    	inVO.setPageNum(Integer.parseInt(pageNum));
    	inVO.setSearchDiv(searchDiv);
    	inVO.setSearchWord(searchWord);
    	inVO.setPageSize(Integer.parseInt(pageSize));
    	
    	LOG.debug("03.2 inVO:"+inVO);
    	List<MemberVO> list= retrieveService.do_retrieve(inVO);
    	LOG.debug("------------------------");
    	for(MemberVO vo: list){
    		LOG.debug(vo);
    	}
    	LOG.debug("------------------------");
    	req.setAttribute("list", list);
    	req.setAttribute("paramVO", inVO);
    	///board/board.do?work_div=do_retrieve
    	RequestDispatcher dispatcher =req.getRequestDispatcher("/member/retrieve/retrieve_view.jsp");
    	dispatcher.forward(req, resp);
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		LOG.debug("01.1 retrieveService:"+retrieveService);
		doServiceHandler(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		LOG.debug("01.1 retrieveService:"+retrieveService);
		doServiceHandler(req,resp);
	}

	protected void doServiceHandler(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//기능 : do_retrieve,do_insert,do_update,do_selectone,do_retrieve
    	//work_div
    	LOG.debug("02 doServiceHandler()");
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
	    	case "do_retrieve":
    			do_retrieve(req,resp);
    		break;      		
	    	case "do_move_to_list":
	    		do_move_to_list(req,resp);
	    		break;      		
	    	case "do_selectone":
	    		do_selectone(req,resp);
	    		break;      		
	    	case "do_delete":
	    		do_delete(req,resp);
	    		break;      		
	    	case "do_update":
	    		do_update(req,resp);
	    		break;      		
	    	case "do_insert":
	    		do_retrieve(req,resp);
	    		break;      		
	    	case "do_save_move":
	    		do_retrieve(req,resp);
	    		break;      		
    	}
	}

	      /**
	 * @Method Name  : do_move_to_list
	 * @작성일   : 2019. 7. 25.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param req
	 * @param resp
	 */
	private void do_move_to_list(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		LOG.debug("03.1 do_move_to_list");
		RequestDispatcher dispatcher =req.getRequestDispatcher("/retrieve/retrieve.do?work_div=do_retrieve");
    	dispatcher.forward(req, resp);
		
	}

		/**
	 * @Method Name  : do_selectone
	 * @작성일   : 2019. 7. 25.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param req
	 * @param resp
	 */
	private void do_selectone(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		LOG.debug("03.1 do_selectone");
    	MemberVO inVO=new MemberVO(); //
    	String user_id = StringUtil.nvl(req.getParameter("user_id"), "");
    	inVO.setUserId(user_id);
    	
    	LOG.debug("03.2 inVO:"+inVO);
    	MemberVO outVO =retrieveService.do_selectOne(inVO);
    	LOG.debug("03.3 outVO:"+outVO);
    	req.setAttribute("vo", outVO);
    	//Code
    	CodeVO codeVO = new CodeVO();
    	CodeDao dao = new CodeDao();
    	codeVO.setCodeTypeId("LVL");
    	List<CodeVO> list = (List<CodeVO>) dao.do_retrieve(codeVO);
    	req.setAttribute("lvlList", list);
    	
    	//retrieve_edit_view.jsp
    	RequestDispatcher dispatcher =req.getRequestDispatcher("/member/retrieve/retrieve_edit_view.jsp");
    	dispatcher.forward(req, resp);
		
	}

		/**
	 * @Method Name  : do_delete
	 * @작성일   : 2019. 7. 25.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param req
	 * @param resp
	 */
	private void do_delete(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException  {
		LOG.debug("03.1 do_delete");
		//Service call:삭제
    	MemberVO inVO = new MemberVO();
    	//param:user_id
    	String userId = StringUtil.nvl(req.getParameter("userId"), "");
    	LOG.debug(userId);
    	inVO.setUserId(userId);
    	int flag = retrieveService.do_delete(inVO);
    	LOG.debug("03.2 flag : "+flag);
    	//JSON
    	Gson gson = new Gson();
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	String msg = "";
    	String gsonString = "";    	  	
    	
    	//삭제 성공(msg=flag)
    	if(flag>0){
//    		response.setContentType("text/html;charset=utf-8");
//    		PrintWriter out = response.getWriter();
//    		out.println("<script type='text/javascript'>");
//    		out.println("alert('삭제되었습니다.');");
//    		out.println("location.href='/WEB_EX01/member/member.do?work_div=do_retrieve';");
//    		out.println("</script>");
    		msg = "삭제되었습니다.";
    	}else{
    		msg = "삭제 실패.";
    	}
    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag), msg));
    	LOG.debug("gsonString : "+gsonString);
    	out.println(gsonString);
		
	}
	
	/**
	 * @Method Name  : do_update
	 * @작성일   : 2019. 7. 25.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param req
	 * @param resp
	 */
	private void do_update(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
		LOG.debug("03.1 do_update");
    	MemberVO inVO = new MemberVO();
    	//param
    	String userId = StringUtil.nvl(req.getParameter("user_id"), "");
    	String name   = StringUtil.nvl(req.getParameter("name"), "");
    	String passwd   = StringUtil.nvl(req.getParameter("passwd"), "");
    	String email   = StringUtil.nvl(req.getParameter("email"), "");
    	String residentNo   = StringUtil.nvl(req.getParameter("resident_no"), "");
    	String cellPhone   = StringUtil.nvl(req.getParameter("cell_phone"), "");
    	String point   = StringUtil.nvl(req.getParameter("point"), "0");
    	String lvl   = StringUtil.nvl(req.getParameter("lvl"), "1");
    	String mod_id   = StringUtil.nvl(req.getParameter("mod_id"), "");
    	inVO.setUserId(userId);
    	inVO.setName(name);
    	inVO.setPasswd(passwd);
    	inVO.setEmail(email);
    	inVO.setResidentNo(residentNo);
    	inVO.setCellPhone(cellPhone);
    	inVO.setPoint(point);
    	inVO.setLvl(lvl);
    	inVO.setModId(mod_id);
    	//--param
    	int flag = retrieveService.do_update(inVO);
    	LOG.debug("flag : "+flag);
    	
    	
    	
    	//수정 완료
    	Gson gson = new Gson();
    	resp.setContentType("text/html;charset=utf-8");
    	PrintWriter out = resp.getWriter();
    	String msg = "";
    	String gsonString = "";    
    	if(flag>0){
    		msg = inVO.getUserId()+"이{가} \n수정되었습니다.";
    	}else{
    		msg = "수정 실패.";
    	}
    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag), msg));
    	LOG.debug("03.4 gsonString : "+gsonString);
    	out.println(gsonString);
		
	}

	/**
	 * @Method Name  : do_insert
	 * @작성일   : 2019. 7. 25.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param req
	 * @param resp
	 */
	private void do_insert(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @Method Name  : do_save_move
	 * @작성일   : 2019. 7. 25.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param req
	 * @param resp
	 */
	private void do_save_move(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	} 
    
}
