package com.zim.member.charge;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
import com.zim.member.MemberDao;
import com.zim.member.MemberVO;
import com.zim.member.login.LoginService;
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;
import com.zim.product.listall.ListAllService;

/**
 * Servlet implementation class ChargeController
 */
@WebServlet(description = "포인트 충전", urlPatterns = { "/charge/charge.do", "/charge/charge.json" })
public class ChargeController extends HttpServlet {
	private final Logger LOG=Logger.getLogger(ChargeController.class);
	private ChargeService service;
	private static final long serialVersionUID = 1L;
	        
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChargeController() {
    	service = new ChargeService();
    }
    
    public void do_point_charge(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03 do_charge()");
    	
    	String chargePoint = StringUtil.nvl(request.getParameter("charge_point"),"");
    	String userId = StringUtil.nvl(request.getParameter("user_id"),"");
    	
    	MemberVO inVO = new MemberVO();
    	inVO.setPoint(chargePoint);
    	inVO.setUserId(userId);
    	LOG.debug("03. param:"+inVO);
    	
    	int flag =  service.do_point_charge(inVO);
    	LOG.debug("03.3 flag:"+flag);
    	    	
    	Gson gson = new Gson();
    	response.setContentType("text/html;charset=utf-8");
    	PrintWriter out = response.getWriter();
    	
    	
    	
    	String msg = "";
    	String gsonString = "";
    	if(flag>0){
    		msg = inVO.getPoint()+"포인트가\n충전되었습니다.";
    		
    		LoginService loginService = new LoginService();
    		MemberVO sessionVO = loginService.do_selectOne(inVO);
    		HttpSession session = request.getSession();
    		session.setAttribute("user", sessionVO);
    	}else{
    		msg = "충전실패.";
    	}
    	
    	//messageVO 값 전달
    	gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
    	LOG.debug("gsonString : "+gsonString);
    	out.println(gsonString);
    	
//    	response.sendRedirect("http://localhost:8080/ZIMZALABIM/detail/detail.do?work_div=do_detail_select&productNo="+productNo);
    }
    
    public void do_point_payment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03 do_point_payment()");
    }
    
    public void do_point_refund(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03 do_point_refund()");
    }
    
    public void doServiceHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("02 doServiceHandler()");
    	request.setCharacterEncoding("UTF-8"); 	//리퀘스트 설정하기    	
    	
    	//work_div : read
    	String workDiv = StringUtil.nvl(request.getParameter("work_div"), "");
    	LOG.debug("02.1 workDiv:"+workDiv);    	
    	
    	//Switch문으로 분기처리
    	switch(workDiv){
    		case "do_point_charge":
    			do_point_charge(request,response);
    		break;
    		case "do_point_payment":
    			do_point_payment(request,response);
    		break;
    		case "do_point_refund":
    			do_point_refund(request,response);
    		break;
    	}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doServiceHandler(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doServiceHandler(request, response);
	}

}
