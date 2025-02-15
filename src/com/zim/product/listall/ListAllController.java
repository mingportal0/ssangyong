package com.zim.product.listall;

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
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;

/**
 * Servlet implementation class ListAllController
 */
@WebServlet(description = "전체카테고리", urlPatterns = { "/listall/listall.do", "/listall/listall.json" })
public class ListAllController extends HttpServlet {
	private final Logger LOG=Logger.getLogger(ListAllController.class);
	private ListAllService service;
	private static final long serialVersionUID = 1L;
	  
	public ListAllController() {
		service = new ListAllService();
	}

    public void do_totalCategory_select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_totalCategory_select");
    	
    	//catrgory-------------------------------------------------------------------------
    	String[] checkbox = request.getParameterValues("category");
    	String category="";
		if(null != checkbox){
			for(int i=0;i<checkbox.length;i++){
				if(checkbox.length-1 != i){
					category = category+checkbox[i]+",";
				}else{
					category = category+checkbox[i];
				}			
			}
		}
		//catrgory-------------------------------------------------------------------------
		
		
    	//일반상품--------------------------------------------------------------------------------
    	ListAllSearchVO inVO = new ListAllSearchVO();
    	//검색조건
    	String pageNum = StringUtil.nvl(request.getParameter("page_num"),"1");
    	String searchDiv = StringUtil.nvl(request.getParameter("search_div"),"");
    	String searchWord = StringUtil.nvl(request.getParameter("searchWord"),"");
    	String pageSize = StringUtil.nvl(request.getParameter("page_size"),"12");
    	LOG.debug("===========================================================================");
    	LOG.debug("=pageNum="+pageNum);
    	LOG.debug("=searchDiv="+searchDiv);
    	LOG.debug("=searchWord="+searchWord);
    	LOG.debug("=pageSize="+pageSize);
    	LOG.debug("===========================================================================");
    	    	
    	
    	inVO.setPageNum(Integer.parseInt(pageNum));
    	inVO.setSearchDiv(searchDiv);
    	inVO.setSearchWord(searchWord);
    	inVO.setPageSize(Integer.parseInt(pageSize));
    	inVO.setCategory(category);
    	
    	
    	
    	LOG.debug("03.2 inVO:"+inVO);
    	List<ProductVO> list = (List<ProductVO>) this.service.do_totalSearch_select(inVO);
    	LOG.debug("--------------------");
    	for(ProductVO vo:list){
    		LOG.debug(vo);
    	}
    	LOG.debug("--------------------");
    	int totalCnt = 0;
    	//총 글수
    	if(null != list && list.size()>0){
    		ProductVO totalVO = list.get(0);
    		totalCnt = totalVO.getTotal();
    	}
    	
    	LOG.debug("===========================================================================");
    	LOG.debug("=totalCnt="+totalCnt);
    	LOG.debug("=list="+list);
    	LOG.debug("=paramVO="+inVO);
    	LOG.debug("===========================================================================");
    	
    	request.setAttribute("totalCnt", totalCnt);
    	request.setAttribute("list", list);
    	request.setAttribute("paramVO", inVO);
    	
    	//일반상품--------------------------------------------------------------------------------
//
//    	request.setAttribute("category", category);
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/product/listall_view.jsp");
    	dispatcher.forward(request, response);    	
   	}
    
    public void do_detail_select(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	LOG.debug("03.1 do_detail_select");
		ProductVO inVO = new ProductVO();//jame007_127
    	String productNo = StringUtil.nvl(request.getParameter("productNo"),"");
    	inVO.setProductNo(productNo);
    	
    	LOG.debug("03.2 inVO:"+inVO);
    	ProductVO outVO = (ProductVO) this.service.do_detail_select(inVO);
    	LOG.debug("03.3 outVO:"+outVO);
    	request.setAttribute("vo", outVO);
    	
    	RequestDispatcher dispatcher = request.getRequestDispatcher("/product/detail_view.jsp");
    	dispatcher.forward(request, response);
    
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
    	switch(workDiv){
    		case "do_detail_select":
    			do_detail_select(request,response);
    		break;
    		case "do_totalCategory_select":
    			do_totalCategory_select(request,response);
    			break;
    	}
    }
    	
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doServiceHandler(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doServiceHandler(request, response);
	}

}
