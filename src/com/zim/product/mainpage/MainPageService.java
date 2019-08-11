 /**
 * @Class Name : MainPageService.java
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
package com.zim.product.mainpage;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.product.ProductDao;

/**
 * @author SIST
 *
 */
public class MainPageService {

	// View -> Controller -> Service -> Dao

	private final Logger LOG=Logger.getLogger(ProductDao.class);
	
	private ProductDao productDao;
	
	/**
	 * 
	 * <PRE>
	 * 1. MethodName : HrMemberService
	 * 2. ClassName  : HrMemberService
	 * 3. Comment   : 생성자의 기능 = 초기화!!!
	 * 4. 작성자    : SIST
	 * 5. 작성일    : 2019. 7. 19. 오전 9:12:53
	 * </PRE>
	 */
	public MainPageService(){ // 생성자의 기능 = 초기화
		productDao = new ProductDao();
	}
	
	
	
	
	
	//최근등록조회
	public List<?> do_latest_select(){
		return productDao.do_latest_select();
	}
	
	//베스트 상품 조회
	public List<?> do_best_select(DTO dto){
		return productDao.do_best_select(dto);
	}
	
	//마감임박
	public List<?> do_imminent_select(){
		return productDao.do_imminent_select();
	}
	
	
	

}
