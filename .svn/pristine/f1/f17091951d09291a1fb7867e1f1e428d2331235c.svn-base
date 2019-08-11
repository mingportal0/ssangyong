 /**
 * @Class Name : ImgDao.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 23.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 23. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.product.image;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author sist
 *
 */
public class ImgDao {
	private List<ImgVO> list = new ArrayList<>();
	private final String IMG_FILE_NM = "C:\\TEMP\\thumbname.csv";
	private final Logger LOG = Logger.getLogger(ImgDao.class);
	
	public ImgDao(){
		try{
			String url = "http://corners.auction.co.kr/corner/categorybest.aspx";
			Document doc = Jsoup.connect(url).get();
			Elements imgUrl = doc.select("div.img a img");
			
			for(int i=0; i<15; i++){
				Element posterElement = imgUrl.get(i);
				String img = posterElement.attr("src");	
				//str.length()-3, str.length()
				String exc = img.substring(img.length()-3, img.length());
				ImgVO vo = new ImgVO();
				vo.setORG_FILE_NM(img);
				vo.setEXT_NM(exc);
				list.add(vo);
				LOG.debug(img);
			}	
		}catch(IOException io){
			LOG.debug("-----------------------------");
			LOG.debug("IOException-"+io.getMessage());
			LOG.debug("-----------------------------");
		}
	}
	public int saveFile(){
		int writeCnt = 0; //저장 Line Count
		FileWriter writer = null;
		try{
			writer = new FileWriter(IMG_FILE_NM);
			for(int i=0; i<list.size(); i++){
				ImgVO outVO = list.get(i);
				String outStr = outVO.getORG_FILE_NM()+","
						       +outVO.getEXT_NM()+"\n";
				writer.write(outStr);
				writeCnt++;
			}//--for i
			
		}catch(IOException e){
			LOG.debug("-----------------");
			LOG.debug("IOException"+e.getMessage());
			LOG.debug("-----------------");
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				LOG.debug("-----------------");
				LOG.debug("IOException"+e.getMessage());
				LOG.debug("-----------------");
			}
		}
		return writeCnt;
	}
}
