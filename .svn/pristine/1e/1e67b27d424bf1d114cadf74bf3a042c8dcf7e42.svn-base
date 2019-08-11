 /**
 * @Class Name : imageController.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 15.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 15. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.product.listall;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;

/**
 * @author sist
 *
 */
public class ListAllService {
	private final Logger LOG = Logger.getLogger(ListAllService.class);
	private ProductDao productDao;
	
	public ListAllService(){
		productDao = new ProductDao();
	}
	
	public List<ProductVO> do_totalCategory_select(DTO dto){
		return productDao.do_totalCategory_select(dto);
	}	
	public List<ProductVO> do_totalSearch_select(DTO dto){
		return productDao.do_totalSearch_select(dto);
	}	
	
	public DTO do_detail_select(DTO dto){
		return productDao.do_detail_select(dto);		
	}
}
