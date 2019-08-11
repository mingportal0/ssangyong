 /**
 * @Class Name : ChartService.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 8. 7.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 8. 7. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.chart;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;



public class ChartService {

	private final Logger LOG=Logger.getLogger(ChartService.class);
	
	private ChartDao chartDao;
	
	public ChartService(){
		chartDao = new ChartDao();
	}
	
	public List<?> do_pro_chart(DTO dto) {
		return chartDao.do_pro_chart(dto);
	}
}
