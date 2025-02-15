 /**
 * @Class Name : SearchVO.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 17.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 17. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.cmn;

/**
 * @author sist
 *
 */
public class SearchVO2 extends DTO{
	private int    pageSize   ;//지정할 페이지 사이즈:10
	private int    pageNum    ;//현재 페이지 넘버:1
	private String searchDiv  ;//검색구분:아이디,이름,주민등록번호,이메일 등등
	private String searchWord ;//검색어
	private String Join_Id;
	private String Reg_Id;
	public SearchVO2(){
		
	}
	public SearchVO2(int pageSize, int pageNum, String searchDiv, String searchWord, String join_Id, String reg_Id) {
		super();
		this.pageSize = pageSize;
		this.pageNum = pageNum;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		Join_Id = join_Id;
		Reg_Id = reg_Id;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNum() {
		return pageNum;
	}
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
	public String getSearchDiv() {
		return searchDiv;
	}
	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}
	public String getSearchWord() {
		return searchWord;
	}
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}
	public String getJoin_Id() {
		return Join_Id;
	}
	public void setJoin_Id(String join_Id) {
		Join_Id = join_Id;
	}
	public String getReg_Id() {
		return Reg_Id;
	}
	public void setReg_Id(String reg_Id) {
		Reg_Id = reg_Id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Join_Id == null) ? 0 : Join_Id.hashCode());
		result = prime * result + ((Reg_Id == null) ? 0 : Reg_Id.hashCode());
		result = prime * result + pageNum;
		result = prime * result + pageSize;
		result = prime * result + ((searchDiv == null) ? 0 : searchDiv.hashCode());
		result = prime * result + ((searchWord == null) ? 0 : searchWord.hashCode());
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
		SearchVO2 other = (SearchVO2) obj;
		if (Join_Id == null) {
			if (other.Join_Id != null)
				return false;
		} else if (!Join_Id.equals(other.Join_Id))
			return false;
		if (Reg_Id == null) {
			if (other.Reg_Id != null)
				return false;
		} else if (!Reg_Id.equals(other.Reg_Id))
			return false;
		if (pageNum != other.pageNum)
			return false;
		if (pageSize != other.pageSize)
			return false;
		if (searchDiv == null) {
			if (other.searchDiv != null)
				return false;
		} else if (!searchDiv.equals(other.searchDiv))
			return false;
		if (searchWord == null) {
			if (other.searchWord != null)
				return false;
		} else if (!searchWord.equals(other.searchWord))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "SearchVO2 [pageSize=" + pageSize + ", pageNum=" + pageNum + ", searchDiv=" + searchDiv + ", searchWord="
				+ searchWord + ", Join_Id=" + Join_Id + ", Reg_Id=" + Reg_Id + "]";
	}
	
}