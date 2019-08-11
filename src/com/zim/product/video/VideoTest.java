 /**
 * @Class Name : VideoTest.java
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
package com.zim.product.video;

import java.util.List;

import org.apache.log4j.Logger;

import com.zim.product.ProductVO;
import com.zim.product.image.ImageVO;


/**
 * @author sist
 *
 */
public class VideoTest {

private final Logger LOG = Logger.getLogger(VideoTest.class);
	
	private VideoDao dao;
	
	public VideoTest() {
		dao = new VideoDao();
	}
	
	public void do_insert(){
		VideoVO videoVO = new VideoVO();
		String videoId = "v01";
		String productNo="28";
		
		videoVO.setVideoId(videoId);
		videoVO.setProductNo(productNo);
		videoVO.setOrgFileNm("basic_video");
		videoVO.setSaveFileNm("p"+productNo+"_"+videoId);
		videoVO.setFileSize("100");
		videoVO.setExtNm("jpg");
		
		int flag = dao.do_insert(videoVO);
	}
	
	public void do_update(){
		VideoVO videoVO = new VideoVO();
		String videoId = "v02";
		String productNo="28";
		
		videoVO.setVideoId(videoId);
		videoVO.setProductNo(productNo);
		videoVO.setOrgFileNm("basic_video"+"_update");
		videoVO.setSaveFileNm("p"+productNo+"_"+videoId+"_update");
		videoVO.setFileSize("100"+"*100");
		videoVO.setExtNm("jpg");
		
		int flag = dao.do_update(videoVO);
	}
		
	public void do_delete(){
		VideoVO videoVO = new VideoVO();
		String videoId = "v02";
		String productNo="28";
		
		videoVO.setVideoId(videoId);
		videoVO.setProductNo(productNo);

		int flag = dao.do_delete(videoVO);
	}
	
	public void do_retrieve(){
		VideoVO videoVO=new VideoVO();
		videoVO.setProductNo("28");

		List<VideoVO> list = (List<VideoVO>) dao.do_retrieve(videoVO);
		LOG.debug("===================");
		for(VideoVO vo:list){
			LOG.debug("vo"+vo);	
		}
		
		LOG.debug("===================");	
	}
	
	public void do_selectOne(){
		VideoVO videoVO=new VideoVO();
		videoVO.setProductNo("28");
		videoVO.setVideoId("v01");
		
		VideoVO outVO = new VideoVO();
		outVO = (VideoVO) dao.do_selectOne(videoVO);
		
		LOG.debug("image one select : "+outVO);	
	}
	
	public static void main(String[] args) {
		VideoTest videoTest = new VideoTest();
		//videoTest.do_insert();
		//videoTest.do_update();
		//videoTest.do_delete();
		//videoTest.do_retrieve();
		videoTest.do_selectOne();

	}

}
