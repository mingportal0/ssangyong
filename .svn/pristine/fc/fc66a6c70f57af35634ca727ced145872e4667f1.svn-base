 /**
 * @Class Name : MemberVO.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 16.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 16. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member;

import com.zim.cmn.DTO;

/**
 * @author sist
 *
 */
public class MemberVO extends DTO{
	private String userId		;//*회원ID(PK)
	private String passwd		;//*비밀번호	
	private String name		    ;//*이름		
	private String email		;//*이메일	
	private String residentNo	;//*주민번호	
	private String CellPhone	;// 핸드폰	
	private String point		;// 포인트	
	private String lvl			;// 등급		
	private String regId		;// 등록자ID	
	private String regDt		;// 등록일	
	private String modId		;// 수정자ID	
	private String modDt		;// 수정일
	
	public MemberVO(){
		
	}	
	
	public MemberVO(String userId, String passwd, String name, String email, String residentNo, String cellPhone,
			String point, String lvl, String regId, String regDt, String modId, String modDt) {
		super();
		this.userId = userId;
		this.passwd = passwd;
		this.name = name;
		this.email = email;
		this.residentNo = residentNo;
		this.CellPhone = cellPhone;
		this.point = point;
		this.lvl = lvl;
		this.regId = regId;
		this.regDt = regDt;
		this.modId = modId;
		this.modDt = modDt;
	}

	
	
	@Override
	public String toString() {
		return "MemberVO [userId=" + userId + ", passwd=" + passwd + ", name=" + name + ", email=" + email
				+ ", residentNo=" + residentNo + ", CellPhone=" + CellPhone + ", point=" + point + ", lvl=" + lvl
				+ ", regId=" + regId + ", regDt=" + regDt + ", modId=" + modId + ", modDt=" + modDt + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CellPhone == null) ? 0 : CellPhone.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((lvl == null) ? 0 : lvl.hashCode());
		result = prime * result + ((modDt == null) ? 0 : modDt.hashCode());
		result = prime * result + ((modId == null) ? 0 : modId.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + ((point == null) ? 0 : point.hashCode());
		result = prime * result + ((regDt == null) ? 0 : regDt.hashCode());
		result = prime * result + ((regId == null) ? 0 : regId.hashCode());
		result = prime * result + ((residentNo == null) ? 0 : residentNo.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
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
		MemberVO other = (MemberVO) obj;
		if (CellPhone == null) {
			if (other.CellPhone != null)
				return false;
		} else if (!CellPhone.equals(other.CellPhone))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (lvl == null) {
			if (other.lvl != null)
				return false;
		} else if (!lvl.equals(other.lvl))
			return false;
		if (modDt == null) {
			if (other.modDt != null)
				return false;
		} else if (!modDt.equals(other.modDt))
			return false;
		if (modId == null) {
			if (other.modId != null)
				return false;
		} else if (!modId.equals(other.modId))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (point == null) {
			if (other.point != null)
				return false;
		} else if (!point.equals(other.point))
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
		if (residentNo == null) {
			if (other.residentNo != null)
				return false;
		} else if (!residentNo.equals(other.residentNo))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getResidentNo() {
		return residentNo;
	}

	public void setResidentNo(String residentNo) {
		this.residentNo = residentNo;
	}

	public String getCellPhone() {
		return CellPhone;
	}

	public void setCellPhone(String cellPhone) {
		CellPhone = cellPhone;
	}

	public String getPoint() {
		return point;
	}

	public void setPoint(String point) {
		this.point = point;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
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

	public String getModId() {
		return modId;
	}

	public void setModId(String modId) {
		this.modId = modId;
	}

	public String getModDt() {
		return modDt;
	}

	public void setModDt(String modDt) {
		this.modDt = modDt;
	}	
}
