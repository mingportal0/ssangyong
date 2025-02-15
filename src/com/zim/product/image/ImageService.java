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
package com.zim.product.image;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.DTO;
import com.zim.product.video.VideoVO;



/**
 * @author sist
 *
 */
public class ImageService {
	private final Logger LOG = Logger.getLogger(ImageService.class);
	private ImageDao imageDao;
	
	public ImageService(){
		imageDao = new ImageDao();
	}
	
	public List<ImageVO> do_retrieve(DTO dto){
		return imageDao.do_retrieve(dto);
	}	
	
	public ImageVO do_selectOne(DTO dto){
		return imageDao.do_selectOne(dto);
	}
	
	public int do_delete(DTO dto){
		return imageDao.do_delete(dto);
	}

	public int do_update(DTO dto){
		return imageDao.do_update(dto);
	}
	
	public int do_insert(DTO dto){
		return imageDao.do_insert(dto);
	}
}
