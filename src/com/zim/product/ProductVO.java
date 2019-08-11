 /**
 * @Class Name : ProductVO.java
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
package com.zim.product;

import com.zim.cmn.DTO;

/**
 * @author SIST
 *
 */
public class ProductVO extends DTO {
	private String restAmount		; //잔여량
	private String imageId  		; //이미지ID
	private String productNo		; //상품번호(PK)
	private String productNm        ; //상품명
	private String price            ; //가격
	private String joinCnt          ; //참여량
	private String category         ; //카테고리
	private String readCnt          ; //조회수
	private String contents         ; //내용
	private String notice           ; //공지사항
	private String targetCnt        ; //목표수량
	private String deadline         ; //모집마감일
	private String hostStatus       ; //주최상태
	private String deliveryStatus   ; //배송상태
	private String regId            ; //등록자ID
	private String regDt            ; //등록일
	private String deliveryPrice    ; //배송비
	private String saveFileNm       ; //저장파일명(저장파일경로)
	
	
	
	public ProductVO(){}



	public ProductVO(String restAmount, String imageId, String productNo, String productNm, String price,
			String joinCnt, String category, String readCnt, String contents, String notice, String targetCnt,
			String deadline, String hostStatus, String deliveryStatus, String regId, String regDt, String deliveryPrice,
			String saveFileNm) {
		super();
		this.restAmount = restAmount;
		this.imageId = imageId;
		this.productNo = productNo;
		this.productNm = productNm;
		this.price = price;
		this.joinCnt = joinCnt;
		this.category = category;
		this.readCnt = readCnt;
		this.contents = contents;
		this.notice = notice;
		this.targetCnt = targetCnt;
		this.deadline = deadline;
		this.hostStatus = hostStatus;
		this.deliveryStatus = deliveryStatus;
		this.regId = regId;
		this.regDt = regDt;
		this.deliveryPrice = deliveryPrice;
		this.saveFileNm = saveFileNm;
	}



	public String getRestAmount() {
		return restAmount;
	}



	public void setRestAmount(String restAmount) {
		this.restAmount = restAmount;
	}



	public String getImageId() {
		return imageId;
	}



	public void setImageId(String imageId) {
		this.imageId = imageId;
	}



	public String getProductNo() {
		return productNo;
	}



	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}



	public String getProductNm() {
		return productNm;
	}



	public void setProductNm(String productNm) {
		this.productNm = productNm;
	}



	public String getPrice() {
		return price;
	}



	public void setPrice(String price) {
		this.price = price;
	}



	public String getJoinCnt() {
		return joinCnt;
	}



	public void setJoinCnt(String joinCnt) {
		this.joinCnt = joinCnt;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	public String getReadCnt() {
		return readCnt;
	}



	public void setReadCnt(String readCnt) {
		this.readCnt = readCnt;
	}



	public String getContents() {
		return contents;
	}



	public void setContents(String contents) {
		this.contents = contents;
	}



	public String getNotice() {
		return notice;
	}



	public void setNotice(String notice) {
		this.notice = notice;
	}



	public String getTargetCnt() {
		return targetCnt;
	}



	public void setTargetCnt(String targetCnt) {
		this.targetCnt = targetCnt;
	}



	public String getDeadline() {
		return deadline;
	}



	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}



	public String getHostStatus() {
		return hostStatus;
	}



	public void setHostStatus(String hostStatus) {
		this.hostStatus = hostStatus;
	}



	public String getDeliveryStatus() {
		return deliveryStatus;
	}



	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
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



	public String getDeliveryPrice() {
		return deliveryPrice;
	}



	public void setDeliveryPrice(String deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}



	public String getSaveFileNm() {
		return saveFileNm;
	}



	public void setSaveFileNm(String saveFileNm) {
		this.saveFileNm = saveFileNm;
	}



	@Override
	public String toString() {
		return "ProductVO [restAmount=" + restAmount + ", imageId=" + imageId + ", productNo=" + productNo
				+ ", productNm=" + productNm + ", price=" + price + ", joinCnt=" + joinCnt + ", category=" + category
				+ ", readCnt=" + readCnt + ", contents=" + contents + ", notice=" + notice + ", targetCnt=" + targetCnt
				+ ", deadline=" + deadline + ", hostStatus=" + hostStatus + ", deliveryStatus=" + deliveryStatus
				+ ", regId=" + regId + ", regDt=" + regDt + ", deliveryPrice=" + deliveryPrice + ", saveFileNm="
				+ saveFileNm + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
		result = prime * result + ((deliveryPrice == null) ? 0 : deliveryPrice.hashCode());
		result = prime * result + ((deliveryStatus == null) ? 0 : deliveryStatus.hashCode());
		result = prime * result + ((hostStatus == null) ? 0 : hostStatus.hashCode());
		result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
		result = prime * result + ((joinCnt == null) ? 0 : joinCnt.hashCode());
		result = prime * result + ((notice == null) ? 0 : notice.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((productNm == null) ? 0 : productNm.hashCode());
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
		result = prime * result + ((readCnt == null) ? 0 : readCnt.hashCode());
		result = prime * result + ((regDt == null) ? 0 : regDt.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((restAmount == null) ? 0 : restAmount.hashCode());
		result = prime * result + ((saveFileNm == null) ? 0 : saveFileNm.hashCode());
		result = prime * result + ((targetCnt == null) ? 0 : targetCnt.hashCode());
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
		ProductVO other = (ProductVO) obj;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (deadline == null) {
			if (other.deadline != null)
				return false;
		} else if (!deadline.equals(other.deadline))
			return false;
		if (deliveryPrice == null) {
			if (other.deliveryPrice != null)
				return false;
		} else if (!deliveryPrice.equals(other.deliveryPrice))
			return false;
		if (deliveryStatus == null) {
			if (other.deliveryStatus != null)
				return false;
		} else if (!deliveryStatus.equals(other.deliveryStatus))
			return false;
		if (hostStatus == null) {
			if (other.hostStatus != null)
				return false;
		} else if (!hostStatus.equals(other.hostStatus))
			return false;
		if (imageId == null) {
			if (other.imageId != null)
				return false;
		} else if (!imageId.equals(other.imageId))
			return false;
		if (joinCnt == null) {
			if (other.joinCnt != null)
				return false;
		} else if (!joinCnt.equals(other.joinCnt))
			return false;
		if (notice == null) {
			if (other.notice != null)
				return false;
		} else if (!notice.equals(other.notice))
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (productNm == null) {
			if (other.productNm != null)
				return false;
		} else if (!productNm.equals(other.productNm))
			return false;
		if (productNo == null) {
			if (other.productNo != null)
				return false;
		} else if (!productNo.equals(other.productNo))
			return false;
		if (readCnt == null) {
			if (other.readCnt != null)
				return false;
		} else if (!readCnt.equals(other.readCnt))
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
		if (restAmount == null) {
			if (other.restAmount != null)
				return false;
		} else if (!restAmount.equals(other.restAmount))
			return false;
		if (saveFileNm == null) {
			if (other.saveFileNm != null)
				return false;
		} else if (!saveFileNm.equals(other.saveFileNm))
			return false;
		if (targetCnt == null) {
			if (other.targetCnt != null)
				return false;
		} else if (!targetCnt.equals(other.targetCnt))
			return false;
		return true;
	}


	
	
	
}
