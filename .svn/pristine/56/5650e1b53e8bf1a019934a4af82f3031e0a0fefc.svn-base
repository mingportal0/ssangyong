 /**
 * @Class Name : DetailService.java
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
package com.zim.product.detail;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.product.ProductDao;

/**
 * @author SIST
 *
 */
public class DetailService {
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
	public DetailService(){ // 생성자의 기능 = 초기화
		productDao = new ProductDao();
	}
	
	
	//공지 수정용 선택
	public DTO do_selectOne(DTO dto){
		return productDao.do_selectOne(dto);
	}

	
	//공지조회
	public DTO do_notice_select(DTO dto){
		return productDao.do_notice_select(dto);
	}
	
	
	//공지수정
	public int do_notice_update(DTO dto){
		return productDao.do_notice_update(dto);
	}
	
	
	//상품상세조회
	public DTO do_detail_select(DTO dto){
		return productDao.do_detail_select(dto);
	}
	
	//상품게시글 삽입
	public int do_insert(DTO dto){
		return productDao.do_insert(dto);
	}
	
	
	//상품게시글 수정
	public int do_update(DTO dto) {
		return productDao.do_update(dto);
	}
	
	
	//상품게시글 삭제
	public int do_delete(DTO dto) {
		return productDao.do_delete(dto);
	}
	
	

}
