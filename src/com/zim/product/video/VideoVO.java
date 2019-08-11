 /**
 * @Class Name : ImageVO.java
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
package com.zim.product.video;

import com.zim.cmn.DTO;

/**
 * @author sist
 *
 */
public class VideoVO extends DTO {
	private String videoId    ;//비디오ID
	private String productNo  ;//상품번호
	private String orgFileNm ;//원본파일명
	private String saveFileNm;//저장파일명
	private String fileSize   ;//파일크기
	private String extNm      ;//확장자명
	
	public VideoVO(){}

	public VideoVO(String videoId, String productNo, String orgFileNm, String saveFileNm, String fileSize,
			String extNm) {
		super();
		this.videoId = videoId;
		this.productNo = productNo;
		this.orgFileNm = orgFileNm;
		this.saveFileNm = saveFileNm;
		this.fileSize = fileSize;
		this.extNm = extNm;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getOrgFileNm() {
		return orgFileNm;
	}

	public void setOrgFileNm(String orgFileNm) {
		this.orgFileNm = orgFileNm;
	}

	public String getSaveFileNm() {
		return saveFileNm;
	}

	public void setSaveFileNm(String saveFileNm) {
		this.saveFileNm = saveFileNm;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getExtNm() {
		return extNm;
	}

	public void setExtNm(String extNm) {
		this.extNm = extNm;
	}

	@Override
	public String toString() {
		return "VideoVO [videoId=" + videoId + ", productNo=" + productNo + ", orgFileNm=" + orgFileNm + ", saveFileNm="
				+ saveFileNm + ", fileSize=" + fileSize + ", extNm=" + extNm + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((extNm == null) ? 0 : extNm.hashCode());
		result = prime * result + ((fileSize == null) ? 0 : fileSize.hashCode());
		result = prime * result + ((orgFileNm == null) ? 0 : orgFileNm.hashCode());
		result = prime * result + ((productNo == null) ? 0 : productNo.hashCode());
		result = prime * result + ((saveFileNm == null) ? 0 : saveFileNm.hashCode());
		result = prime * result + ((videoId == null) ? 0 : videoId.hashCode());
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
		VideoVO other = (VideoVO) obj;
		if (extNm == null) {
			if (other.extNm != null)
				return false;
		} else if (!extNm.equals(other.extNm))
			return false;
		if (fileSize == null) {
			if (other.fileSize != null)
				return false;
		} else if (!fileSize.equals(other.fileSize))
			return false;
		if (orgFileNm == null) {
			if (other.orgFileNm != null)
				return false;
		} else if (!orgFileNm.equals(other.orgFileNm))
			return false;
		if (productNo == null) {
			if (other.productNo != null)
				return false;
		} else if (!productNo.equals(other.productNo))
			return false;
		if (saveFileNm == null) {
			if (other.saveFileNm != null)
				return false;
		} else if (!saveFileNm.equals(other.saveFileNm))
			return false;
		if (videoId == null) {
			if (other.videoId != null)
				return false;
		} else if (!videoId.equals(other.videoId))
			return false;
		return true;
	};
	
	
	
}
