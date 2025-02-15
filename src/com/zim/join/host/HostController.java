package com.zim.join.host;

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
import com.zim.product.ProductDao;
import com.google.gson.Gson;
import com.zim.cmn.MessageVO;
import com.zim.cmn.SearchVO;
import com.zim.cmn.StringUtil;
import com.zim.join.JoinVO;
import com.zim.product.ProductVO;

/**
 * Servlet implementation class HostController
 */
@WebServlet(description = "주최" ,urlPatterns = {"/host/host.do","/host/host.json" })
public class HostController extends HttpServlet {
	private final Logger LOG=Logger.getLogger(HostService.class);
	
	private HostService hostService;
	
	public HostController(){
		
		hostService = new HostService();
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
    	List<ProductVO> list= hostService.do_retrieve(inVO);
    	List<ProductVO> list2= hostService.do_retrieve2(inVO);
    	LOG.debug("--------------------");
    	for(ProductVO vo:list){
    		LOG.debug(vo);
    	}
    	LOG.debug("--------------------");
    	LOG.debug("list2--------------------");
    	for(ProductVO vo:list2){
    		LOG.debug(vo);
    	}
    	LOG.debug("list2--------------------");
    	request.setAttribute("list", list);
    	request.setAttribute("list2", list2);
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/host/host_view.jsp");
    	dispatcher.forward(request, response);
    }     
	 protected void do_selectone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LOG.debug("03.1 do_selectone");
		 ProductVO inVO =new ProductVO();
		 String productno=StringUtil.nvl(request.getParameter("productNo"), "");


		 inVO.setProductNo(productno);
		 LOG.debug("03.2 inVO:"+inVO);
		 ProductVO outVO=hostService.do_selectOne(inVO);
		 LOG.debug("03.3 outVO:"+outVO);
		 request.setAttribute("vo", outVO);
		 
		 RequestDispatcher dispatcher=request.getRequestDispatcher("/host/host_mng.jsp");
	    	dispatcher.forward(request, response);
	 }
		public void do_move_to_list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			LOG.debug("03.1 do_move_to_list");
			RequestDispatcher dispatcher =request.getRequestDispatcher("/host/host.do?work_div=do_retrieve");
			dispatcher.forward(request, response);
		}
	    protected void do_update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_update2");
	    	ProductVO inVO=new ProductVO();
	    	//param
	    	String regId=StringUtil.nvl(request.getParameter("RegId"), "");
	    	String productNo=StringUtil.nvl(request.getParameter("ProductNo"),"");
	    	
	    	inVO.setRegId(regId);
	    	inVO.setProductNo(productNo);

	    	LOG.debug("03.2 param:"+inVO);
	    	//--param
	    	int flag = this.hostService.do_update2(inVO);
	    	LOG.debug("03.3 flag:"+flag);
	    	
	    	Gson gson=new Gson();
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter  out = response.getWriter();
	    	
	    	String msg = "";
	    	String gsonString = "";
	    	if(flag>0){
	    		msg ="주최를 \n취소하였습니다.";
	    	}else{
	    		msg ="변경실패.";
	    	}
	    	
	    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
	    	LOG.debug("03.4 gsonString:"+gsonString);
	    	out.print(gsonString);
	    }
	    protected void do_update4(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_update4");
	    	ProductVO inVO=new ProductVO();
	    	//param
	    	String regId=StringUtil.nvl(request.getParameter("RegId"), "");
	    	String productNo=StringUtil.nvl(request.getParameter("ProductNo"),"");
	    	
	    	inVO.setRegId(regId);
	    	inVO.setProductNo(productNo);

	    	LOG.debug("03.2 param:"+inVO);
	    	//--param
	    	int flag = this.hostService.do_update4(inVO);
	    	LOG.debug("03.3 flag:"+flag);
	    	
	    	Gson gson=new Gson();
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter  out = response.getWriter();
	    	
	    	String msg = "";
	    	String gsonString = "";
	    	if(flag>0){
	    		msg ="주최를 \n완료하였습니다.";
	    	}else{
	    		msg ="주최 완료 실패.";
	    	}
	    	
	    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
	    	LOG.debug("03.4 gsonString:"+gsonString);
	    	out.print(gsonString);
	    }
	    protected void do_update3(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_update3");
	    	ProductVO inVO=new ProductVO();
	    	//param
	    	String deliveryStatus=StringUtil.nvl(request.getParameter("DeliveryStatus"),"");
	    	String productNo=StringUtil.nvl(request.getParameter("ProductNo"),"");
	    	String regId=StringUtil.nvl(request.getParameter("RegId"), "");
	    	
	    	inVO.setDeliveryStatus(deliveryStatus);
	    	inVO.setProductNo(productNo);
	    	inVO.setRegId(regId);
	    	
	    	

	    	LOG.debug("03.2 param:"+inVO);
	    	//--param
	    	int flag = this.hostService.do_update3(inVO);
	    	LOG.debug("03.3 flag:"+flag);
	    	
	    	Gson gson=new Gson();
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter  out = response.getWriter();
	    	
	    	String msg = "";
	    	String gsonString = "";
	    	if(flag>0){
	    		msg ="배송상태를 \n변경하였습니다.";
	    	}else{
	    		msg ="배송상태 변경실패.";
	    	}
	    	
	    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
	    	LOG.debug("03.4 gsonString:"+gsonString);
	    	out.print(gsonString);
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
	    		case "do_delete":
	    			do_delete(request,response);
	    		break;     
	    		
	    		case "do_selectOne":
	    			do_selectone(request,response);
	    		break;  
	    		
	    		case "do_retrieve":
	    			do_retrieve(request,response);
	    		break;     	
	    		case "do_move_to_list":
	    			do_move_to_list(request, response);
	    		break;
	    		case "do_update2":
	    			do_update2(request, response);
	    		break;
	    		case "do_update3":
	    			do_update3(request, response);
	    		break;
	    		case "do_update4":
	    			do_update4(request, response);
	    		break;
	    	}
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		LOG.debug("01.1 HostService:"+hostService);
		doServiceHandler(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		LOG.debug("01.1 HostService:"+hostService);
		doServiceHandler(request,response);
	}

}
