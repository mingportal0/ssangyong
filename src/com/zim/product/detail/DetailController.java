package com.zim.product.detail;

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
import com.zim.cmn.StringUtil;
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;
import com.zim.product.comment.CommentService;
import com.zim.product.comment.CommentVO;
import com.zim.product.image.ImageService;


@WebServlet(description = "상품상세", urlPatterns = { "/detail/detail.do","/detail/detail.json" })
public class DetailController extends HttpServlet {
    
	// View -> Controller -> Service -> Dao   
	private final Logger LOG=Logger.getLogger(ProductDao.class);
	
	private DetailService detailService;
	private CommentService commentService;
	private ImageService imageService;
	
	
    public DetailController() {
    	detailService = new DetailService();
    	commentService = new CommentService();
    	imageService = new ImageService();
    }

    
    
    //공지 수정용 선택
    public void do_selectOne(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
    	LOG.debug("03.1 do_selectOne");
    	ProductVO inVO = new ProductVO();
		String productNo = StringUtil.nvl(request.getParameter("product_no"),"");
		String productNm = StringUtil.nvl(request.getParameter("product_nm"),"");
		String regId = StringUtil.nvl(request.getParameter("reg_id"),"");
		String notice = StringUtil.nvl(request.getParameter("notice"),"");
		
		
		inVO.setProductNo(productNo);
		inVO.setProductNm(productNm);
		inVO.setRegId(regId);
		inVO.setNotice(notice);
		
		
		LOG.debug("03.2 inVO:"+inVO);
		ProductVO outVO = (ProductVO) this.detailService.do_selectOne(inVO);
		LOG.debug("03.3 outVO:"+outVO);
		request.setAttribute("vo", outVO);
		
		//code관련
		//--code
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/writing_for_notice_view.jsp");
		dispatcher.forward(request, response);
    
    }
    
    
    
    
    
    //공지 전체조회
    public void do_notice_select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_notice_select");
		ProductVO inVO = new ProductVO();
		String productNo = StringUtil.nvl(request.getParameter("product_no"),"");
		inVO.setProductNo(productNo);
		
		LOG.debug("03.2 inVO:"+inVO);
		ProductVO outVO = (ProductVO) this.detailService.do_notice_select(inVO);
		LOG.debug("03.3 outVO:"+outVO);
		request.setAttribute("vo", outVO);
		
		//code관련
		//--code
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/detail_view.jsp");
		dispatcher.forward(request, response);
  	}
    
    
    //공지수정
    public void do_notice_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_update");
    	ProductVO inVO = new ProductVO();
		//param to VO
		String notice = StringUtil.nvl(request.getParameter("notice"), "");
		String productNo = StringUtil.nvl(request.getParameter("product_no"), "");
		String regId = StringUtil.nvl(request.getParameter("reg_id"), "");

		
		inVO.setNotice(notice);
		inVO.setProductNo(productNo);
		inVO.setRegId(regId);

		
		LOG.debug("03.2 param:"+inVO);
		
		//--param
		
		int flag = this.detailService.do_notice_update(inVO);
		LOG.debug("03.3 flag:"+flag);
		
//		Gson gson = new Gson();
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter out = response.getWriter();
		
		
//		String msg = "";
//		String gsonString = "";
//		if(flag>0){
//			msg = "공지가 수정되었습니다.";
//		}else{
//			msg = "수정실패.";
//		}
		
//		gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
//		LOG.debug("03.4 gsonString"+gsonString);
//		out.print(gsonString);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/detail/detail.do?work_div=do_detail_select&productNo="+productNo);
		dispatcher.forward(request, response);
		
		
  	}
    
    
    //상품상세조회
    public void do_detail_select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_detail_select");
		
    	//상품조회
    	ProductVO inVO = new ProductVO(); 
		String productNo = StringUtil.nvl(request.getParameter("productNo"),"");
		inVO.setProductNo(productNo);
		LOG.debug("03.2 inVO:"+inVO);
		
		ProductVO outVO = (ProductVO) this.detailService.do_detail_select(inVO);
		LOG.debug("03.3 outVO:"+outVO);
		request.setAttribute("vo", outVO);
		
		
		//댓글조회
		CommentVO commentVO = new CommentVO();
		commentVO.setProductNo(productNo);
		
		List<CommentVO> list = (List<CommentVO>)commentService.do_retrieve(commentVO);
		LOG.debug("----------------------");
		for(CommentVO vo:list){
			LOG.debug(vo);
		}
		LOG.debug("----------------------");
		request.setAttribute("coList", list);
		request.setAttribute("paramVO", commentVO);
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product/detail_view.jsp");
		dispatcher.forward(request, response);
  	}
    
    
    //상품게시글 삽입
    public void do_insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_insert");
    	ProductVO inVO = new ProductVO();
		//param to VO
		String productNm = StringUtil.nvl(request.getParameter("product_nm"), "");
		String price = StringUtil.nvl(request.getParameter("price"), "");
		String category = StringUtil.nvl(request.getParameter("category"), "");
		String contents = StringUtil.nvl(request.getParameter("contents"), "");
		String targetCnt = StringUtil.nvl(request.getParameter("target_cnt"), "");
		String deadline = StringUtil.nvl(request.getParameter("deadline"), "");
		String regId = StringUtil.nvl(request.getParameter("reg_id"), "");
		String deliveryPrice = StringUtil.nvl(request.getParameter("delivery_price"), "");
		
		inVO.setProductNm(productNm);
		inVO.setPrice(price);
		inVO.setCategory(category);
		inVO.setContents(contents);
		inVO.setTargetCnt(targetCnt);
		inVO.setDeadline(deadline);
		inVO.setRegId(regId);
		inVO.setRegDt(deliveryPrice);

		
		LOG.debug("03.2 param:"+inVO);
		
		//--param
		
		int flag = this.detailService.do_insert(inVO);
		LOG.debug("03.3 flag:"+flag);
		
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String msg = "";
		String gsonString = "";
		if(flag>0){
			msg = inVO.getProductNm()+"이 \n 등록되었습니다.";
		}else{
			msg = "등록실패.";
		}
		
		gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
		LOG.debug("03.4 gsonString"+gsonString);
		out.print(gsonString);
		
  	}
    
    
    
    //상품게시글 수정
    public void do_update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_update");
    	ProductVO inVO = new ProductVO();
		//param to VO
    	String productNm = StringUtil.nvl(request.getParameter("product_nm"), "");
		String price = StringUtil.nvl(request.getParameter("price"), "");
		String category = StringUtil.nvl(request.getParameter("category"), "");
		String contents = StringUtil.nvl(request.getParameter("contents"), "");
		String targetCnt = StringUtil.nvl(request.getParameter("target_cnt"), "");
		String deadline = StringUtil.nvl(request.getParameter("deadline"), "");
		String deliveryPrice = StringUtil.nvl(request.getParameter("delivery_price"), "");
		String productNo = StringUtil.nvl(request.getParameter("product_no"), "");

		
		inVO.setProductNm(productNm);
		inVO.setPrice(price);
		inVO.setCategory(category);
		inVO.setContents(contents);
		inVO.setTargetCnt(targetCnt);
		inVO.setDeadline(deadline);
		inVO.setDeliveryPrice(deliveryPrice);
		inVO.setProductNo(productNo);

		
		LOG.debug("03.2 param:"+inVO);
		
		//--param
		
		int flag = this.detailService.do_update(inVO);
		LOG.debug("03.3 flag:"+flag);
		
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		
		String msg = "";
		String gsonString = "";
		if(flag>0){
			msg = inVO.getProductNm()+"이 \n 수정되었습니다.";
		}else{
			msg = "수정실패.";
		}
		
		gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
		LOG.debug("03.4 gsonString"+gsonString);
		out.print(gsonString);
  	}
    
    
    
    //상품게시글 삭제
    public void do_delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_delete");
		//service call : 삭제
    	ProductVO inVO = new ProductVO();
    	
		//param: product_no
    	String productNo = StringUtil.nvl(request.getParameter("product_no"),"");
    	inVO.setProductNo(productNo);
		int flag = this.detailService.do_delete(inVO);
		int imageFlag = this.imageService.do_delete(inVO);
		LOG.debug("03.2 flag"+flag);
		LOG.debug("03.2 imageFlag="+imageFlag);
		
		//JSON
		Gson gson = new Gson();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String msg = "";
		String gsonString = "";
		
		//JSON 만들기 위해  VO를 만들어줌
		
		//msg=flag
		//msgContents = '삭제되었습니다.';
		
		if(flag>0){
			msg = "삭제되었습니다.";
		}else{
			msg = "삭제실패.";
		}
		gsonString = gson.toJson(new MessageVO(String.valueOf(flag),msg));
		LOG.debug("03.3 gsonString"+gsonString);
		out.print(gsonString);
  	}
    
    
    
    
    
    public void doServiceHandler(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	//기능 : do_retrieve, do_insert, do_update, do_selectOne, do_delete
    	//work_div
    	LOG.debug("02 doServiceHandler()");
    	request.setCharacterEncoding("UTF-8"); 	//리퀘스트 설정하기
    	
    	
    	//work_div : read
    	String workDiv = StringUtil.nvl(request.getParameter("work_div"), "");
    	LOG.debug("02.1 workDiv:"+workDiv);
    	
    	
    	//Switch문으로 분기처리
    	
    	/*
    	 * do_retrieve : 목록
    	 * do_insert : 등록
    	 * do_update : 수정
    	 * do_selectOne : 단건조회
    	 * do_delete
    	 * 
    	 */
    	
    	switch(workDiv){
    		//등록화면으로 이동
//	    	case "do_save_move":
//	    		do_save_move(request,response);
//			break;
    	
    		case "do_notice_select":
    			do_notice_select(request,response);
    		break;
    	
    		case "do_notice_update":
    			do_notice_update(request,response);
    		break;
    		
    		case "do_detail_select":
    			do_detail_select(request,response);
    		break;
    		
    		case "do_insert":
    			do_insert(request,response);
    		break;
    		
    		case "do_update":
    			do_update(request,response);
    		break;
    		
    		case "do_delete":
    			do_delete(request,response);
    		break;
    		
    		case "do_selectOne":
    			do_selectOne(request,response);
    		break;
    		
    	}
    	
    }
    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doGet()");
		LOG.debug("01.1 detailService:"+detailService);
		doServiceHandler(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOG.debug("01 doPost()");
		LOG.debug("01.1 detailService:"+detailService);
		doServiceHandler(request, response);
	}

}
