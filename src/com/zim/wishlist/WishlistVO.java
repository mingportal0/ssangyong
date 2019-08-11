/**
* @Class Name : WishlistVO.java
* @Description : 
* @Modification Information
* @
* @  수정일      수정자              수정내용
* @ ---------   ---------   -------------------------------
* @ 2019. 7. 29.           최초생성
*
* @author Zimzalabim
* @since 2019. 7. 29. 
* @version 1.0
* @see
*
*  Copyright (C) by HR. KIM All right reserved.
*/
package com.zim.wishlist;

import java.util.List;

import com.zim.cmn.DTO;
import com.zim.cmn.SearchVO;
import com.zim.product.ProductVO;

/**
 * @author sist
 *
 */
public class WishlistVO extends ProductVO {

	private String user_id;
	private String product_no;
	private String reg_dt;
	
	
	
	public WishlistVO(){}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((product_no == null) ? 0 : product_no.hashCode());
		result = prime * result + ((reg_dt == null) ? 0 : reg_dt.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		WishlistVO other = (WishlistVO) obj;
		if (product_no == null) {
			if (other.product_no != null)
				return false;
		} else if (!product_no.equals(other.product_no))
			return false;
		if (reg_dt == null) {
			if (other.reg_dt != null)
				return false;
		} else if (!reg_dt.equals(other.reg_dt))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}
	

	@Override
	public String toString() {
		return "WishlistVO [user_id=" + user_id + ", product_no=" + product_no + ", reg_dt=" + reg_dt + ", toString()="
				+ super.toString() + "]";
	}

	public WishlistVO(String user_id, String product_no, String reg_dt) {
		super();
		this.user_id = user_id;
		this.product_no = product_no;
		this.reg_dt = reg_dt;
	}
	
	 /**
	 * @Method Name  : do_retrieve
	 * @작성일   : 2019. 8. 8.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param searchVO
	 * @return
	 */

	
	
	
}
