 /**
 * @Class Name : CommentVO.java
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
package com.zim.product.comment;

import com.zim.cmn.DTO;

/**
 * @author SIST
 *
 */
public class CommentVO extends DTO {
	private String commentNo    ; //댓글번호(PK)
	private String productNo    ; //상품번호(FK)
	private String contents     ; //내용
	private String hcommentNo   ; //상위댓글번호
	private String regId        ; //등록자ID
	private String regDt        ; //등록일
	
	
	public CommentVO() {}


	public CommentVO(String commentNo, String productNo, String contents, String hcommentNo, String regId,
			String regDt) {
		super();
		this.commentNo = commentNo;
		this.productNo = productNo;
		this.contents = contents;
		this.hcommentNo = hcommentNo;
		this.regId = regId;
		this.regDt = regDt;
	}


	public String getCommentNo() {
		return commentNo;
	}


	public void setCommentNo(String commentNo) {
		this.commentNo = commentNo;
	}


	public String getProductNo() {
		return productNo;
	}


	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}


	public String getContents() {
		return contents;
	}


	public void setContents(String contents) {
		this.contents = contents;
	}


	public String getHcommentNo() {
		return hcommentNo;
	}


	public void setHcommentNo(String hcommentNo) {
		this.hcommentNo = hcommentNo;
	}


	public String getRegId() {
		return regId;
	}


	public void setRegId(String regId) {
		this.regId = regId;
	}


	public String getRegDt() {
		return regDt;
	}


	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}


	@Override
	public String toString() {
		return "CommentVO [commentNo=" + commentNo + ", productNo=" + productNo + ", contents=" + contents
				+ ", hcommentNo=" + hcommentNo + ", regId=" + regId + ", regDt=" + regDt + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentNo == null) ? 0 : commentNo.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((hcommentNo == null) ? 0 : hcommentNo.hashCode());
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
		result = prime * result + ((regDt == null) ? 0 : regDt.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CommentVO other = (CommentVO) obj;
		if (commentNo == null) {
			if (other.commentNo != null)
				return false;
		} else if (!commentNo.equals(other.commentNo))
			return false;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (hcommentNo == null) {
			if (other.hcommentNo != null)
				return false;
		} else if (!hcommentNo.equals(other.hcommentNo))
			return false;
		if (productNo == null) {
			if (other.productNo != null)
				return false;
		} else if (!productNo.equals(other.productNo))
			return false;
		if (regDt == null) {
			if (other.regDt != null)
				return false;
		} else if (!regDt.equals(other.regDt))
			return false;
		if (regId == null) {
			if (other.regId != null)
				return false;
		} else if (!regId.equals(other.regId))
			return false;
		return true;
	}

	
	
	
}
