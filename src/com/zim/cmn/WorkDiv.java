/**
 * @Class Name : WorkDiv.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 6. 25.           최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2019. 6. 25. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by H.R. KIM All right reserved.
 */
package com.zim.cmn;

import java.util.List;

//모든 Dao의 아버지
public interface WorkDiv {
	/**
	 * 
	 * @Method Name : do_insert
	 * @작성일 : 2019. 6. 25.
	 * @작성자 : sist
	 * @변경이력 : 최초작성
	 * @Method 설명 : 삽입 메소드
	 * @param vo
	 * @return >0 성공
	 */
	public int do_insert(DTO dto);

	/**
	 * 
	 * @Method Name : do_update
	 * @작성일 : 2019. 6. 25.
	 * @작성자 : sist
	 * @변경이력 : 최초작성
	 * @Method 설명 : 삭제 메소드
	 * @param vo
	 * @return >0 성공
	 */
	public int do_update(DTO dto);

	/**
	 * 
	 * @Method Name : do_delete
	 * @작성일 : 2019. 6. 25.
	 * @작성자 : sist
	 * @변경이력 : 최초작성
	 * @Method 설명 : 수정 메소드
	 * @param vo
	 * @return >0 성공
	 */
	public int do_delete(DTO dto);

	/**
	 * 
	 * @Method Name : do_selectOne
	 * @작성일 : 2019. 6. 25.
	 * @작성자 : sist
	 * @변경이력 : 최초작성
	 * @Method 설명 : 단건조회
	 * @param vo
	 * @return DTO
	 */
	public DTO do_selectOne(DTO dto);

	/**
	 * 
	 * @Method Name : do_select
	 * @작성일 : 2019. 6. 25.
	 * @작성자 : sist
	 * @변경이력 : 최초작성
	 * @Method 설명 : 목록 조회 메소드
	 * @param vo
	 * @return List<?>
	 */
	public List<?> do_retrieve(DTO dto);

}
