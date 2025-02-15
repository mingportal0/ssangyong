 /**
 * @Class Name : imageDao.java
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.ConnectionMaker;
import com.zim.cmn.DTO;
import com.zim.cmn.JDBCReturnReso;
import com.zim.cmn.WorkDiv;
import com.zim.product.ProductVO;
import com.zim.product.video.VideoVO;

/**
 * @author sist
 *
 */
public class ImageDao implements WorkDiv {

	private final Logger LOG = Logger.getLogger(ImageDao.class);
	
	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_insert(com.zim.cmn.DTO)
	 */
	@Override
	public int do_insert(DTO dto){
		ImageVO vo = (ImageVO) dto;
		
		int flag = 0;
		Connection conn = null;	
		PreparedStatement pstmt = null;
		try{
			//conn = connectionMaker.getConnection();
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1. conn:"+conn);
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO image (\n");
			sb.append("    image_id,      \n");
			sb.append("    product_no,    \n");
			sb.append("    org_file_nm,   \n");
			sb.append("    save_file_nm,  \n");
			sb.append("    file_size,     \n");
			sb.append("    ext_nm,        \n");
			sb.append("    thumbnail      \n");
			sb.append(") VALUES (         \n");
			sb.append("    ?,             \n");
			sb.append("    ?,             \n");
			sb.append("    ?,             \n");
			sb.append("    ?,             \n");
			sb.append("    ?,             \n");
			sb.append("    ?,             \n");
			sb.append("    ?              \n");
			sb.append(")                  \n");
			
			LOG.debug("2. sql:\n"+sb.toString()); //위의 SQL이 담겨있다
			LOG.debug("3. param:\n"+vo.toString());//SQL문으로 조회해온 정보들이 담겨있다.
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getImageId());
			pstmt.setString(2, vo.getProductNo());
			pstmt.setString(3, vo.getOrgFileNm());
			pstmt.setString(4, vo.getSaveFileNm());
			pstmt.setString(5, vo.getFileSize());
			pstmt.setString(6, vo.getExtNm());
			pstmt.setString(7, vo.getThumbnail());
			
			flag = pstmt.executeUpdate();
			//executeUpdate : 수행결과로 Int 타입의 값을 반환
			//SELECT 구문을 제외한 다른 구문을 수행할 때 사용되는 함수
			
			LOG.debug("5.flag:\n"+flag);
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_update(com.zim.cmn.DTO)
	 */
	@Override
	public int do_update(DTO dto) {
		ImageVO vo = (ImageVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append("UPDATE image         \n");
			sb.append("SET  org_file_nm = ? \n");
			sb.append("    ,save_file_nm = ?\n");
			sb.append("    ,file_size = ?   \n");
			sb.append("    ,ext_nm = ?      \n");
			sb.append("    ,thumbnail = ?      \n");
			sb.append("WHERE image_id = ?   \n");
			sb.append("AND   product_no = ? \n");
			
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.======================");
			LOG.debug("1.query \n"+sb.toString());
			LOG.debug("1.======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getOrgFileNm());
			pstmt.setString(2, vo.getSaveFileNm());
			pstmt.setString(3, vo.getFileSize());
			pstmt.setString(4, vo.getExtNm());
			pstmt.setString(5, vo.getThumbnail());
			pstmt.setString(6, vo.getImageId());
			pstmt.setString(7, vo.getProductNo());
			
			LOG.debug("2.===================");
			LOG.debug("2.param :"+vo);
			LOG.debug("2.===================");
			
			flag = pstmt.executeUpdate();
			LOG.debug("3.===================");
			LOG.debug("3.flag="+flag);
			LOG.debug("3.===================");
		}catch(SQLException s){
			LOG.debug("===================");
			LOG.debug("SQLException="+s.toString());
			LOG.debug("===================");			
		}finally{
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_delete(com.zim.cmn.DTO)
	 */
	@Override
	public int do_delete(DTO dto) {
		ProductVO vo = (ProductVO) dto;
		int flag = 0;
		Connection conn = null;		
		PreparedStatement pstmt = null;		
		
		StringBuilder sb=new StringBuilder();
		sb.append("DELETE FROM image  \n");
		sb.append("WHERE product_no = ? \n");
		
		try {
			
			conn = new ConnectionMaker().getConnection();;

			LOG.debug("1======================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			//query param
			pstmt.setString(1, vo.getProductNo());
			LOG.debug("2======================");
			LOG.debug("query, seq"+vo.getProductNo());
			LOG.debug("2======================");

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//사용한 자원 반납하기
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		LOG.debug("3=====================");
		LOG.debug("flag:"+flag);
		LOG.debug("3=====================");
		
		return 0;
	}
	
	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_delete(com.zim.cmn.DTO)
	 */
	public int do_Image_delete(DTO dto) {
		ImageVO vo = (ImageVO) dto;
		int flag = 0;
		Connection conn = null;		
		PreparedStatement pstmt = null;		
		
		StringBuilder sb=new StringBuilder();
		sb.append("DELETE FROM image  \n");
		sb.append("WHERE image_id = ? \n");
		sb.append("AND   product_no = ? \n");
		
		try {
			
			conn = new ConnectionMaker().getConnection();;

			LOG.debug("1======================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			//query param
			pstmt.setString(1, vo.getImageId());
			pstmt.setString(2, vo.getProductNo());
			LOG.debug("2======================");
			LOG.debug("query, seq"+vo.getProductNo());
			LOG.debug("2======================");

			flag = pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{//사용한 자원 반납하기
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		LOG.debug("3=====================");
		LOG.debug("flag:"+flag);
		LOG.debug("3=====================");
		
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_selectOne(com.zim.cmn.DTO)
	 */
	@Override
	public ImageVO do_selectOne(DTO dto) {
		ImageVO vo = (ImageVO) dto;
		 
		ImageVO outVO = null;
		Connection conn = null; //db연결
		PreparedStatement pstmt = null; //query수행
		ResultSet rs = null; //결과처리

		try{
			//stringBuilder사용 이유 : String 보다 빠르고 콘솔에 찍혀나오므로 디버깅이 쉽다
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT product_no   \n");
			sb.append("      ,image_id     \n");
			sb.append("      ,org_file_nm  \n");
			sb.append("      ,save_file_nm \n");
			sb.append("      ,file_size    \n");
			sb.append("      ,ext_nm       \n");
			sb.append("FROM  image         \n");
			sb.append("WHERE image_id = ?  \n");
			sb.append("AND   product_no = ?\n");
			
			conn= new ConnectionMaker().getConnection();
			LOG.debug("1. conn:"+conn);
			LOG.debug("2. sql:\n"+sb.toString());
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getImageId());
			pstmt.setString(2, vo.getProductNo());
			LOG.debug("3. param-getImageId:\n"+vo.getImageId());
			LOG.debug("3. param-getProductNo:\n"+vo.getProductNo());
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				outVO = new ImageVO();
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setImageId(rs.getString("image_id"));
				outVO.setOrgFileNm(rs.getString("org_file_nm"));
				outVO.setSaveFileNm(rs.getString("save_file_nm"));
				outVO.setFileSize(rs.getString("file_size"));
				outVO.setExtNm(rs.getString("ext_nm"));
			}
			
			}catch(SQLException e){
				e.printStackTrace(); 
			}finally{//close시에는 역순으로 끊는다.
				JDBCReturnReso.close(rs);
				JDBCReturnReso.close(pstmt);
				JDBCReturnReso.close(conn);
			}
		 
		return outVO;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_retrieve(com.zim.cmn.DTO)
	 */
	@Override
	public List<ImageVO> do_retrieve(DTO dto) {
		ImageVO vo = (ImageVO) dto;

		List<ImageVO> list = new ArrayList<>();
		 Connection conn = null; //db연결
		 PreparedStatement pstmt = null; //query수행
		 ResultSet rs = null; //결과처리

		 StringBuilder sb = new StringBuilder();
		 sb.append("SELECT  image_id      \n");
		 sb.append("        ,product_no    \n");
		 sb.append("        ,org_file_nm  \n");
		 sb.append("        ,save_file_nm \n");
		 sb.append("        ,file_size    \n");
		 sb.append("        ,ext_nm       \n");
		 sb.append("        ,thumbnail    \n");
		 sb.append("FROM    image         \n");
		 sb.append("WHERE   product_no = ?\n");
		 
		 LOG.debug("2 sql \n :"+sb.toString());
		 try{
			 conn = new ConnectionMaker().getConnection();
			 pstmt = conn.prepareStatement(sb.toString());

			 pstmt.setString(1, vo.getProductNo());
			 LOG.debug("3. param:\n"+vo.getProductNo());
			 rs = pstmt.executeQuery();
			 while(rs.next()){
				 ImageVO outVO = new ImageVO();
				 outVO = new ImageVO();
				 outVO.setImageId(rs.getString("image_id"));
				 outVO.setProductNo(rs.getString("product_no"));
				 outVO.setOrgFileNm(rs.getString("org_file_nm"));
				 outVO.setSaveFileNm(rs.getString("save_file_nm"));
				 outVO.setFileSize(rs.getString("file_size"));
				 outVO.setExtNm(rs.getString("ext_nm"));
				 outVO.setThumbnail(rs.getString("thumbnail"));
				 
				 list.add(outVO);
			 }			 
			 
			 
		 }catch(SQLException e){
			 e.printStackTrace();
		 }finally{//사용한 자원 반납하기
			 JDBCReturnReso.close(rs);
			 JDBCReturnReso.close(pstmt);
			 JDBCReturnReso.close(conn);
		 }
		 
		 return list;
	}

}
