 /**
 * @Class Name : CodeTest.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 25.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 25. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.code;

import java.util.List;
import org.apache.log4j.Logger;
import com.zim.cmn.StringUtil;


/**
 * @author sist
 *
 */
public class CodeTest {
	private CodeVO codeVO;
	private CodeDao dao;
	private final Logger LOG = Logger.getLogger(CodeTest.class);
	public CodeTest(){
		codeVO = new CodeVO();
		dao = new CodeDao();
	}

	public void do_retrieve() {
		codeVO.setCodeTypeId("LVL");
		List<CodeVO> list = (List<CodeVO>) dao.do_retrieve(codeVO);
		for(CodeVO vo : list){
			LOG.debug(vo.toString());
		}
		String selected=StringUtil.makeSelectBox(list, "lvl", "9", false);		
	}
	public static void main(String[] args) {
		CodeTest codeTest = new CodeTest();
		codeTest.do_retrieve();
	}
}
