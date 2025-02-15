 /**
 * @Class Name : WritingTest.java
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
package com.zim.product.writing;

import java.awt.Image;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.sun.jimi.core.Jimi;
import com.sun.jimi.core.JimiUtils;
import com.zim.cmn.ConnectionMaker;
import com.zim.cmn.JDBCReturnReso;
import com.zim.cmn.StringUtil;
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;
import com.zim.product.image.ImageVO;

/**
 * @author sist
 *
 */
public class WritingTest {

	private final Logger LOG = Logger.getLogger(WritingTest.class);
	
	private ProductDao dao;
	
	public WritingTest() {
		dao = new ProductDao();
	}
	
	public void do_insert(){
		ProductVO productVO = new ProductVO();
		String categoryNum = Integer.toString(((int)(Math.random()*8)+1)*10);
		String ranNum = Integer.toString((int)(Math.random()*12)+1);
		
		productVO.setProductNm("상품명"+ranNum);
		productVO.setPrice("5000");
		productVO.setCategory(categoryNum);
		productVO.setContents("내용"+ranNum);
		productVO.setTargetCnt("100");
		productVO.setDeadline("2019.07.23");
		productVO.setRegId("아이디"+ranNum);
		productVO.setDeliveryPrice("2500");
		
		int flag = dao.do_insert(productVO);
	}
	
	public void do_delete(){
		ProductVO productVO = new ProductVO();
		productVO.setProductNo("8");
		int flag = dao.do_delete(productVO);
		LOG.debug("======================");
		LOG.debug("flag="+flag);
		LOG.debug("======================");
	}
	
	public void do_update(){
		ProductVO productVO = new ProductVO();
		productVO.setProductNm("제목수정555");
		productVO.setPrice("25000");
		productVO.setCategory("30");
		productVO.setContents("내용수정555");
		productVO.setTargetCnt("555");
		productVO.setDeadline("2019-10-10");
		productVO.setProductNo("28");
		productVO.setDeliveryPrice("3000");
		int flag = dao.do_update(productVO);
	}
	
	public void do_select_productNo(){
		ProductVO outVO = new ProductVO();
		outVO = (ProductVO) dao.do_select_productNo(outVO);
		LOG.debug("======================");
		LOG.debug("outVO="+outVO);
		LOG.debug("======================");
	}
	
	public void do_select_imageNo(){
		ImageVO outVO = new ImageVO();
		outVO.setProductNo("149");
		outVO = (ImageVO) dao.do_select_imageNo(outVO);
		LOG.debug("======================");
		LOG.debug("outVO="+outVO);
		LOG.debug("======================");
	}
	
	/**
	 * @Method Name  : main
	 * @작성일   : 2019. 7. 16.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 :
	 * @param args
	 */
	public static void main(String[] args) {
		WritingTest writingTest = new WritingTest();
		//writingTest.do_insert();
		//writingTest.do_delete();
		//writingTest.do_update();
		//writingTest.do_select_productNo();
		//writingTest.do_select_imageNo();
		
//		//String saveFileName  = "/ZIMZALABIM/WebContent/upload/image/2019/07/category20.png"; // 원본 문자열
//		String saveFileName  = "F:\\Java_20190415\\02_ORACLE\\workspace_web\\ZIMZALABIM\\WebContent\\upload\\image\\2019\\07\\category101.png"; // 원본 문자열// 원본 문자열
//		System.out.println(saveFileName);
//		saveFileName=saveFileName.substring(saveFileName.indexOf("\\ZIMZALABIM"),saveFileName.length()).replace("\\", "/").replace("WebContent/", "");
//		
//		String realPath = "F:\\Java_20190415\\02_ORACLE\\workspace_web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ZIMZALABIM\\product";
//		realPath = realPath.substring(0, realPath.indexOf("\\.metadata"))+"\\ZIMZALABIM\\WebContent\\upload\\image";
//	    //saveFileName=saveFileName.replace("\\", "/");
//	    //System.out.println(saveFileName);
//	    //System.out.println(realPath);
//		//realPath = realPath.substring(0, realPath.indexOf("\\.metadata"));
//	    System.out.println(realPath);

//	    String content = "기존 DB에 저장된 내용을 에디터에 적용할 문구<img src=\"/ZIMZALABIM/SE2/multiupload/201080712040919c71e47-ea4c-42a5-a0d0-97317a7d64b3.png&#10;\" title=\"category40.png\"><br style=\"clear:both;\"><img src=\"/ZIMZALABIM/SE2/multiupload/2019080712040909ecd35f-2bdf-406d-a34a-f8095668923a.png&#10;\" title=\"category60.png\"><br style=\"clear:both;\"><img src=\"/ZIMZALABIM/SE2/multiupload/20190807120409c51763a9-4c53-4547-b065-5fa52af9a20c.png&#10;\" title=\"category50.png\"><br style=\"clear:both;\"><img src=\"/ZIMZALABIM/SE2/multiupload/20190807120409a52997fc-0409-4821-8b88-ffe377f8303f.png&#10;\" title=\"category30.png\"><br style=\"clear:both;\"><p><br></p>";
	    String content = "contents=<img src=\"http://localhost:8080/ZIMZALABIM/SE2/multiupload/2019080712303921fc49a4-020b-4fc1-acd7-b48c9ca4372f.png\" title=\"category50.png\"><br style=\"clear:both;\"><img src=\"/ZIMZALABIM/SE2/multiupload/20190807123039af383bc5-0416-4241-992f-922662a5bd4e.png&#10;\" title=\"category40.png\"><br style=\"clear:both;\"><img src=\"/ZIMZALABIM/SE2/multiupload/201908071230392e4eacaa-8a54-4378-ba0d-618a7f9dd335.png&#10;\" title=\"category30.png\"><br style=\"clear:both;\"><img src=\"/ZIMZALABIM/SE2/multiupload/2019080712303982c2bc4e-7f9f-4f75-bd6f-a5c397aeb713.png&#10;\" title=\"category60.png\"><br style=\"clear:both;\"><p>&nbsp;</p>";
	   
	  
//	    String[] contentArray = content.split(" title=\"");
//	    String orgNm = "";
//	    
//	    List<String> orgNameList = new ArrayList<>();
//	    for (int i = 1; i < contentArray.length; i++) {
//	    	orgNm = contentArray[i].substring(0,contentArray[i].indexOf("\""));
//	    	orgNameList.add(orgNm);
//	    	System.out.println(orgNameList);
//	    }
//	    
//	    System.out.println(orgNameList);
	    
//	    String[] contentArray = content.split(" src=\"");
//	    String savePath = "";
//	    
//	    List<String> orgNameList = new ArrayList<>();
//	    for (int i = 1; i < contentArray.length; i++) {
//	    	savePath = contentArray[i].substring(0,contentArray[i].indexOf("\""));
//	    	if(savePath.indexOf("h") == 0){
//	    		savePath= savePath.substring(savePath.indexOf("8080")+4);
//	    	}else{
//	    		savePath = savePath.substring(0, savePath.indexOf("&"));
//	    	}
//	    	savePath = "http://211.238.142.127:8080"+savePath;
//	    	orgNameList.add(savePath);
//	    	System.out.println(savePath);
//	    }

	    
//	    System.out.println(orgNameList);
	    
//	    String[] contentArray = content.split(" title=\"");
//	    String extNm = "";
//	    
//	    List<String> extNameList = new ArrayList<>();
//	    for (int i = 1; i < contentArray.length; i++) {
//	    	extNm = contentArray[i].substring(0,contentArray[i].indexOf("\""));
//	    	extNm = extNm.substring(extNm.indexOf(".")+1);
//	    	extNameList.add(extNm);
//	    	System.out.println(extNm);
//	    }
	    
//	    System.out.println(orgNameList);
	    
	  //파일경로
//	    String fullPath = "F:\\Java_20190415\\02_ORACLE\\workspace_web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ZIMZALABIM\\SE2\\multiupload\\test.jpg";
//	    makeThumb(fullPath);
//	    
//	    
//	    String fileName = fullPath.substring(fullPath.indexOf("multiupload\\")+12);
//	    String filePath = fullPath.substring(0,fullPath.indexOf(fileName));
//	    
//	    String thumbName = fileName.replace(".", "_thumb.");
//	    
//	    
//	    System.out.println(filePath);
//	    System.out.println(fileName);
//	    System.out.println(thumbName);
	    
	    
//	    String want = "F:\\Java_20190415\\02_ORACLE\\workspace_web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ZIMZALABIM\\SE2\\multiupload\\201908071717194ccb1fa9-6beb-412c-867c-066af7be121c.jpg";
//	    String ora = "http://211.238.142.127:8080/ZIMZALABIM/SE2/multiupload/201908071717194ccb1fa9-6beb-412c-867c-066af7be121c.jpg";
//	    String real = "F:\\Java_20190415\\02_ORACLE\\workspace_web\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\ZIMZALABIM\\SE2\\multiupload\\";
//	    System.out.println(want);
//	    
//	    ora = ora.substring(ora.indexOf("/multiupload")+13).replace("/", "\\");
//	    ora = real+ora;
//	    System.out.println(ora);
	    
//	    String path = "http://211.238.142.127:8080/ZIMZALABIM/SE2/multiupload/201908071717194ccb1fa9-6beb-412c-867c-066af7be121c.jpg";
//	    String path = "http://211.238.142.127:8080/ZIMZALABIM/SE2/multiupload/20190807151848f9daedaf-c95d-418b-bb05-b589624627c1.jpg";
//	    StringUtil.makeThumb(path);
//
//	    String real = "http://211.238.142.127:8080";
//	    want = real+want.substring(want.indexOf("\\ZIMZALABIM\\")).replace("\\", "/");
	    
//		InetAddress local;
//		try {
//			local = InetAddress.getLocalHost();
//			String ip = local.getHostAddress();
//			System.out.println("local ip : "+ip);
//		} catch (UnknownHostException e1) {
//			e1.printStackTrace();
//		}
	    
	    String contents = "<p style=\"text-align: center; \" align=\"center\"><b><span style=\"font-size: 10pt;\">** 첫번째 이미지가 썸네일 이미지가 됩니다 **</span></b></p><p style=\"text-align: center; \" align=\"center\"><b><span style=\"font-size: 10pt;\">** 이 문구를 지운후 게시글을 작성해 주세요 **</span></b></p><p>ㅇㅇㅇ</p><p><img src=\"/ZIMZALABIM/SE2/multiupload/201908081432407aae5ffa-9117-4931-a614-94e622a0ba8b.JPG&#10;\" title=\"%EB%8C%95%EB%8C%95%EC%9D%B4.JPG\"><br style=\"clear:both;\">&nbsp;</p>";
	    
	    if(contents.contains("src=\"/ZIMZALABIM")){
	    	contents = contents.replace("src=\"/ZIMZALABIM", "src=\"http://211.238.142.124:8080/ZIMZALABIM");
	    }
	    System.out.println(contents);
	}
	
//	public static void makeThumb (String fullPath){
//		String fileName = fullPath.substring(fullPath.indexOf("multiupload\\")+12);
//	    String filePath = fullPath.substring(0,fullPath.indexOf(fileName));
//	    String thumbName = fileName.replace(".", "_thumb.");
//		
//		// 원본 이미지
//	    String orgFile = filePath+fileName;	 
//	    // 썸네일 이미지
//	    String thumbFile = filePath+thumbName;
//	 
//	    // 썸네일 이미지 가로크기(단위 : px)
//	    int thumbWidth = 160 ;	 
//	    // 썸네일 이미지 세로크기(단위 : px)
//	    int thumbHeight = 160 ;
//	 
//	    try{	 
//	        // 썸네일 설정
//	        Image thumbnail = JimiUtils.getThumbnail(orgFile, thumbWidth, thumbHeight, Jimi.IN_MEMORY);	 
//	        // 썸네일 생성
//	        Jimi.putImage(thumbnail, thumbFile);	 
//	    }catch(Exception e){
//	        e.printStackTrace();
//	    }
//	}

}
