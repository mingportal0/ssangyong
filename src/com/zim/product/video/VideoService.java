 /**
 * @Class Name : imageController.java
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

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;



/**
 * @author sist
 *
 */
public class VideoService {
	private final Logger LOG = Logger.getLogger(VideoService.class);
	private VideoDao videoDao;
	
	public VideoService(){
		videoDao = new VideoDao();
	}
	
	public List<VideoVO> do_retrieve(DTO dto){
		return videoDao.do_retrieve(dto);
	}	
	
	public VideoVO do_selectOne(DTO dto){
		return videoDao.do_selectOne(dto);
	}
	
	public int do_delete(DTO dto){
		return videoDao.do_delete(dto);
	}

	public int do_update(DTO dto){
		return videoDao.do_update(dto);
	}
	
	public int do_insert(DTO dto){
		return videoDao.do_insert(dto);
	}
}
