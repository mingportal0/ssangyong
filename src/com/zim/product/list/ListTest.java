 /**
 * @Class Name : ListTest.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 19.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 19. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.product.list;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.SearchVO;
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;
import com.zim.product.listall.ListAllSearchVO;
import com.zim.product.video.VideoVO;



/**
 * @author sist
 *
 */
public class ListTest {
private final Logger LOG = Logger.getLogger(ListTest.class);
	
	private ProductDao dao;
	
	public ListTest() {
		dao = new ProductDao();
	}

	public void do_category_select(){
		ListAllSearchVO listAllSearchVO=new ListAllSearchVO();
		listAllSearchVO.setCategory("10");
		listAllSearchVO.setPageNum(1);
		listAllSearchVO.setPageSize(5);

		List<ProductVO> list = (List<ProductVO>) dao.do_category_select(listAllSearchVO);
		LOG.debug("===================");
		for(ProductVO vo:list){
			LOG.debug("vo"+vo);	
		}
		
		LOG.debug("===================");	
	}
	
	public String[] splitStr(String str){
			return str.split(","); //선택된 카테고리
	}
	
	public static void main(String[] args) {
		ListTest listTest = new ListTest();
		//listTest.do_category_select();

	}

}
