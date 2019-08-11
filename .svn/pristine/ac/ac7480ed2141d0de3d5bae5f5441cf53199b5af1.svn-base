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
package com.zim.product.writing;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;
import com.zim.product.image.ImageVO;

/**
 * @author sist
 *
 */
public class WritingService {
	private final Logger LOG = Logger.getLogger(WritingService.class);
	private ProductDao productDao;
	
	public WritingService(){
		productDao = new ProductDao();
	}
	
	public int do_delete(DTO dto){
		return productDao.do_delete(dto);
	}

	public int do_update(DTO dto){
		return productDao.do_update(dto);
	}
	
	public int do_insert(DTO dto){
		return productDao.do_insert(dto);
	}
	
	public DTO do_selectOne(DTO dto) {
		return productDao.do_selectOne(dto);
	}
	
	
	
	public ProductVO do_select_productNo(DTO dto){
		return productDao.do_select_productNo(dto);
	}
	
	public ImageVO do_select_imageNo(DTO dto){
		return productDao.do_select_imageNo(dto);
	}
	
	public List<ProductVO> do_category_select(DTO dto) {
		return productDao.do_category_select(dto);
	}
	
	
	
	
	
}
