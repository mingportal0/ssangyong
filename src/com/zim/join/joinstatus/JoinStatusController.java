package com.zim.join.joinstatus;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zim.cmn.SearchVO;
import com.zim.cmn.StringUtil;
import com.zim.join.JoinVO;

/**
 * Servlet implementation class JoinStatusController
 */
@WebServlet(description = "참여" ,urlPatterns = {"/joinstatus/joinstatus.do"})
public class JoinStatusController extends HttpServlet {
    
	private final Logger LOG=Logger.getLogger(JoinStatusService.class);
	
	private JoinStatusService joinStatusService;
	
	public JoinStatusController(){
		
		joinStatusService=new JoinStatusService();
	}
	protected void do_retrieve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 	LOG.debug("03.1 do_retrieve");
 	SearchVO inVO =new SearchVO();
 	String pageNum   =StringUtil.nvl(request.getParameter("page_num"),"1");
 	String searchDiv =StringUtil.nvl(request.getParameter("search_div"),"");
 	String searchWord=StringUtil.nvl(request.getParameter("search_word"),"");
 	String pageSize  =StringUtil.nvl(request.getParameter("page_size"),"10");
 	inVO.setPageNum(Integer.parseInt(pageNum));
 	inVO.setSearchDiv(searchDiv);
 	inVO.setSearchWord(searchWord);
 	inVO.setPageSize(Integer.parseInt(pageSize));
 	
 	LOG.debug("03.2 inVO:"+inVO);
 	List<JoinVO> list= joinStatusService.do_retrieve(inVO);
 	LOG.debug("--------------------");
 	for(JoinVO vo:list){
 		LOG.debug(vo);
 	}
 	LOG.debug("--------------------");
 	request.setAttribute("list", list);
 	RequestDispatcher dispatcher=request.getRequestDispatcher("/join/join_view.jsp");
 	dispatcher.forward(request, response);
 }     
	 protected void do_selectone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LOG.debug("03.1 do_selectone");
		 JoinVO inVO =new JoinVO();
		 String productno=StringUtil.nvl(request.getParameter("product_no"), "");
		 
		 inVO.setProductNo(productno);
		 LOG.debug("03.2 inVO:"+inVO);
		 JoinVO outVO=joinStatusService.do_selectOne(inVO);
		 LOG.debug("03.3 outVO:"+outVO);
		 request.setAttribute("vo", outVO);
	    	
	    	//--code
			//user_id 화면 제어:readonly

		 RequestDispatcher dispatcher=request.getRequestDispatcher("join_status_view.jsp");
		 dispatcher.forward(request, response);
	 }
	    protected void do_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_update");
	    }
	    
	    protected void do_insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_insert");
	    }
	    protected void do_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_delete");
	    }

	    protected void doServiceHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	//기능 : do_retrieve,do_insert,do_update,do_selectone,do_retrieve
	    	//work_div
	    	LOG.debug("02 doServiceHandler()");
	    	request.setCharacterEncoding("UTF-8");
	    	//work_div:read
	    	String workDiv = StringUtil.nvl(request.getParameter("work_div"),"");
	    	LOG.debug("02.1 workDiv:"+workDiv);
	    	
	    	/* do_retrieve:목록
	    	 * do_insert:등록
	    	 * do_update:수정
	    	 * do_selectone:단건조회
	    	 * do_delete:
	    	 */
	    	switch(workDiv){
	    	
	    		case "do_insert":
	    			do_insert(request,response);
	    		break;
	    		
	    		case "do_update":
	    			do_update(request,response);
	    		break;  
	    		
	    		case "do_delete":
	    			do_delete(request,response);
	    		break;     
	    		
	    		case "do_selectone":
	    			do_selectone(request,response);
	    		break;  
	    		
	    		case "do_retrieve":
	    			do_retrieve(request,response);
	    		break;     		
	    	}
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		LOG.debug("01.1 joinStatusService:"+joinStatusService);
		doServiceHandler(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		LOG.debug("01.1 joinStatusService:"+joinStatusService);
		doServiceHandler(request,response);
	}

}