

package com.zim.join;

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
import com.zim.code.CodeVO;
import com.zim.member.MemberVO;
import com.zim.member.charge.ChargeService;
import com.zim.product.comment.CommentVO;
import com.zim.code.CodeDao;
import com.zim.cmn.MessageVO;
import com.zim.cmn.SearchVO;
import com.zim.cmn.SearchVO2;
import com.zim.cmn.StringUtil;

/**
 * Servlet implementation class JoinController
 */
@WebServlet(description = "참여" ,urlPatterns = { "/join/join.do","/join/join.json" })
public class JoinController extends HttpServlet {
       
	private final Logger LOG=Logger.getLogger(JoinService.class);
	
	private JoinService joinService;
	
	public JoinController(){
		
		joinService=new JoinService();
	}
	
	public void do_move_to_list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LOG.debug("03.1 do_move_to_list");
		RequestDispatcher dispatcher =request.getRequestDispatcher("/join/join.do?work_div=do_retrieve");
		dispatcher.forward(request, response);
	}
	protected void do_retrieve(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	LOG.debug("03.1 do_retrieve");
    	SearchVO  inVO =new SearchVO();
    	String pageNum   =StringUtil.nvl(request.getParameter("page_num"),"1");
    	String searchDiv =StringUtil.nvl(request.getParameter("search_div"),"");
    	String searchWord=StringUtil.nvl(request.getParameter("search_word"),"");
    	String pageSize  =StringUtil.nvl(request.getParameter("page_size"),"10");
    	inVO.setPageNum(Integer.parseInt(pageNum));
    	inVO.setSearchDiv(searchDiv);
    	inVO.setSearchWord(searchWord);
    	inVO.setPageSize(Integer.parseInt(pageSize));
    	
    	LOG.debug("03.2 inVO:"+inVO);
    	List<JoinVO> list= joinService.do_retrieve(inVO);
    	List<JoinVO> list2= joinService.do_retrieve2(inVO);
    	LOG.debug("list1--------------------");
    	for(JoinVO vo:list){
    		LOG.debug(vo);
    	}
    	LOG.debug("list1--------------------");
    	LOG.debug("list2--------------------");
    	for(JoinVO vo:list2){
    		LOG.debug(vo);
    	}
    	LOG.debug("list2--------------------");
    	request.setAttribute("list", list);
    	request.setAttribute("list2", list2);
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/join/join_view.jsp");
    	dispatcher.forward(request, response);
    }        
	       
	 protected void do_selectone(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 LOG.debug("03.1 do_selectone");
		 JoinVO inVO =new JoinVO();
		
		 String productno=StringUtil.nvl(request.getParameter("product_no"), "");
		 
		 inVO.setProductNo(productno);
		
		 
		 LOG.debug("03.2 inVO:"+inVO);
		 JoinVO outVO=joinService.do_selectOne(inVO);
		 LOG.debug("03.3 outVO:"+outVO);
		 request.setAttribute("vo", outVO);
	    	
	    	//--code
			//user_id 화면 제어:readonly

		 RequestDispatcher dispatcher=request.getRequestDispatcher("/join/join_mng.jsp");
		 dispatcher.forward(request, response);
	 }
	    protected void do_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_update");
	    	JoinVO inVO=new JoinVO();
	    	//param
	    	String joinId = StringUtil.nvl(request.getParameter("Join_id"),"");
	    	String Product_no = StringUtil.nvl(request.getParameter("Product_no"), "");
	    	
	    	inVO.setJoin_id(joinId);
	    	inVO.setProduct_no(Product_no);
	    	LOG.debug("03.2 param: "+ inVO);
	    	
	    	//--param
	    	int flag = joinService.do_update(inVO);
	    	LOG.debug("03.3 flag:"+flag);
	    	
	    	Gson gson=new Gson();
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter  out = response.getWriter();
	    	
	    	String msg = "";
	    	String gsonString = "";
	    	if(flag >0){
	    		msg ="참여를 \n취소하였습니다.";
	    	}else{
	    		msg ="취소실패.";
	    	}
	    	
	    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
	    	LOG.debug("03.4 gsonString:"+gsonString);
	    	out.print(gsonString);
	    }
	    protected void do_update2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_update2");
	    	JoinVO inVO=new JoinVO();
	    	//param
	    	String joinId = StringUtil.nvl(request.getParameter("Join_id"),"");
	    	String Product_no = StringUtil.nvl(request.getParameter("Product_no"), "");
	    	
	    	inVO.setJoin_id(joinId);
	    	inVO.setProduct_no(Product_no);
	    	LOG.debug("03.2 param: "+ inVO);
	    	
	    	//--param
	    	int flag = joinService.do_update2(inVO);
	    	LOG.debug("03.3 flag:"+flag);
	    	
	    	Gson gson=new Gson();
	    	response.setContentType("text/html;charset=utf-8");
	    	PrintWriter  out = response.getWriter();
	    	
	    	String msg = "";
	    	String gsonString = "";
	    	if(flag >0){
	    		msg ="참여를 \n완료 하였습니다.";
	    	}else{
	    		msg ="취소실패.";
	    	}
	    	
	    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
	    	LOG.debug("03.4 gsonString:"+gsonString);
	    	out.print(gsonString);
	    }
	    
	    
	    protected void do_insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    	LOG.debug("03.1 do_insert");
	    	JoinVO inVO = new JoinVO();
			//param to VO
			String join_id = StringUtil.nvl(request.getParameter("join_id"), "");
			String product_no = StringUtil.nvl(request.getParameter("product_no"), "");
			String join_dt = StringUtil.nvl(request.getParameter("join_dt"), "");
			String join_cnt = StringUtil.nvl(request.getParameter("join_cnt"), "");
			String join_status = StringUtil.nvl(request.getParameter("join_status"), "10");
			String price = StringUtil.nvl(request.getParameter("price"), "10");
			
			inVO.setJoin_id(join_id);
			inVO.setProduct_no(product_no);
			inVO.setJoin_dt(join_dt);
			inVO.setJoin_cnt(join_cnt);
			inVO.setJoin_status(join_status);			
			LOG.debug("03.2 param:"+inVO);
			
			int flag=0;
			
			//--구매자 포인트 차감
			MemberVO memberVO = new MemberVO();			
			memberVO.setUserId(join_id);
			memberVO.setPoint(price);
			
			ChargeService chargeService = new ChargeService();
			int chargeFlag = chargeService.do_point_payment(memberVO, join_cnt); //상품의 총 금액이 소지 포인트보다 클 경우 0을 리턴
			LOG.debug("03.3 chargeFlag:"+chargeFlag);
			//--구매자 포인트 차감
			
			if(chargeFlag > 0){//상품포인트가 소지 포인트보다 작거나 같으면
				flag = this.joinService.do_insert(inVO);
			}
			LOG.debug("03.3 flag:"+flag);
			
			
			Gson gson = new Gson();
			response.setContentType("text/html;charset=utf-8");
			PrintWriter out = response.getWriter();			
			
			String msg = "";
			String gsonString = "";
			if(flag>0 || chargeFlag>0){
				msg = "결제가 완료되었습니다.";
			}else if(chargeFlag == 0){
				msg = "소지 포인트가 부족합니다.";
			}else{
				msg = "결제가 실패했습니다.";
			}
			
			gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
			LOG.debug("03.4 gsonString"+gsonString);
			out.print(gsonString);
	    	
	    	
	    }
	    protected void do_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      	LOG.debug("03.1 do_delete");
	    	//Service call:삭제
	    	JoinVO inVO=new JoinVO();
	    	//param:user_id
	    	String Join_id = StringUtil.nvl(request.getParameter("Join_id"),"");
	    	
	    	inVO.setJoin_id("soso");
	    	
	    	int flag =  joinService.do_delete(inVO);
	    	LOG.debug("03.2 flag:"+flag);
	    	
	    	if(flag>0){
	    		//alert:삭제 성공	
	    		response.setContentType("text/html;charset=utf-8");
	    		PrintWriter out = response.getWriter();
	    		out.println("<script>");
	    		out.println("alert('삭제되었습니다.');");
	    		out.println("location.href='/join/join.do?work_div=do_retrieve';");
	    		out.println("</script>");
	    		//조회 서블릿콜: /join/join.do?work_div=do_retrieve
	        	//RequestDispatcher dispatcher = request.getRequestDispatcher("/member/member.do?work_div=do_retrieve");
	        	//dispatcher.forward(request, response);
	    	}
	    	
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
	    		case "do_update2":
	    			do_update2(request,response);
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
	    	}
	    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		LOG.debug("01.1 joinService:"+joinService);
		doServiceHandler(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		LOG.debug("01.1 joinService:"+joinService);
		doServiceHandler(request,response);
	}

}
