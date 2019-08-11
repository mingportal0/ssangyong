package com.zim.product.image;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.zim.product.writing.WritingService;

/**
 * Servlet implementation class ImageController
 */
@WebServlet("/image/image.do")
public class ImageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    private ImageService service;

    public ImageController() {    	
    	service = new ImageService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String savePath = request.getServletContext().getRealPath("upload");		 
		String savePath = "F:\\Java_20190415\\02_ORACLE\\workspace_web\\ZIMZALABIM\\WebContent\\upload";		 
		
		int sizeLimit = 1024*1024*15;// 파일 크기 15MB로 제한
		 
		//MultipartRequest를 생성시 파일이 업로드 된다.(파일 자체의 업로드 완료)
		//	       									    	       저장경로         파일최대크기       인코딩유형    중복 파일명 처리
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		

		// MultipartRequest로 전송받은 데이터를 불러온다.
		// enctype을 "multipart/form-data"로 선언하고 submit한 데이터들은 request객체가 아닌 MultipartRequest객체로 불러와야 한다.
		String productNo = multi.getParameter("product_no");
		String imageId = multi.getParameter("image_id");		 
		// 전송받은 데이터가 파일일 경우 getFilesystemName()으로 파일 이름을 받아올 수 있다.
		String fileName = multi.getFilesystemName("org_file_nm");
		 
		// 업로드한 파일의 전체 경로를 DB에 저장하기 위함
		String m_fileFullPath = savePath + "/" + fileName;
		 
		 
		// 데이터들을 담을 그릇인 DTO(혹은 Bean) 객체를 생성 후, 데이터들을 set해준다.
		ImageVO imageVO = new ImageVO();
		 
		imageVO.setProductNo("111");
		imageVO.setImageId("i01");
		imageVO.setOrgFileNm(fileName);
		imageVO.setFileSize("6");
		imageVO.setSaveFileNm(m_fileFullPath);
		imageVO.setThumbnail("1");
		imageVO.setExtNm("jpg");

		int flag = this.service.do_insert(imageVO);

		System.out.println("===flag==="+flag);

	}

}
