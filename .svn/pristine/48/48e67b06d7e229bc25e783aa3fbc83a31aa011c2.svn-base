 /**
 * @Class Name : ChargeTest.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 8. 9.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 8. 9. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.member.charge;

import java.util.List;

import com.zim.member.MemberDao;
import com.zim.member.MemberVO;
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;
import com.zim.product.listall.ListAllSearchVO;
import com.zim.product.listall.ListAllTest;

/**
 * @author sist
 *
 */
public class ChargeTest {

	private MemberDao dao;
	
	public ChargeTest() {
		dao = new MemberDao();
	}			
	
	public void do_charge(){
		MemberVO vo=new MemberVO();
		ChargeService chargeService = new ChargeService();
		vo.setUserId("lhj");
		vo.setPoint("5000");
		int flag = chargeService.do_point_charge(vo);
		System.out.println(flag);		
	}
	
	public static void main(String[] args) {
		ChargeTest chargeTest = new ChargeTest();
		chargeTest.do_charge();
	}

}
