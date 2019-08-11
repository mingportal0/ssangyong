 /**
 * @Class Name : ProductDAO.java
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
package com.zim.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.zim.cmn.JDBCReturnReso;
import com.zim.cmn.SearchVO;
import com.zim.cmn.ConnectionMaker;
import com.zim.cmn.DTO;
import com.zim.cmn.WorkDiv;
import com.zim.join.JoinVO;
import com.zim.product.image.ImageVO;
import com.zim.product.listall.ListAllSearchVO;

/**
 * @author sist
 *
 */
public class ProductDao implements WorkDiv {

	
	private final static Logger LOG = Logger.getLogger(ProductDao.class);
	private ConnectionMaker connectionMaker;
	
	
	public ProductDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	//카테고리중 전체보기를 조회. 전체 카테고리 조회
	public List<ProductVO> do_totalSearch_select(DTO dto) {
		ListAllSearchVO vo = (ListAllSearchVO) dto;

		List<ProductVO> list = new ArrayList<>();
		Connection conn = null; //db연결
		PreparedStatement pstmt = null; //query수행
		ResultSet rs = null; //결과처리

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT T1.*,T2.*											   \n");
		sb.append("FROM (                                                      \n");    
		sb.append("    SELECT b.rnum num, b.*                                  \n");           
		sb.append("    FROM(                                                   \n");
		sb.append("        SELECT ROWNUM rnum, A.*                             \n");          
		sb.append("        FROM(                                               \n");
		sb.append("            SELECT                                          \n");
		sb.append("             i.image_id,                                    \n");
		sb.append("             i.save_file_nm,                                \n");
		sb.append("				p.product_no,                                  \n");
		sb.append("				p.product_nm,                                  \n");
		sb.append("				p.price,                                       \n");
		sb.append("				p.category,                                    \n");
		sb.append("				TO_CHAR(p.deadline ,'YYYY.MM.DD')	deadline   \n");
		sb.append("            FROM product p JOIN image i                     \n");
		sb.append("            ON p.product_no = i.product_no                  \n");
		sb.append("			AND i.thumbnail = '1'                              \n");
		sb.append("			AND p.deadline >= SYSDATE -1                         \n");
		//-------------------------------카테고리-------------------------------------
		if(vo.getCategory() != null && !vo.getCategory().equals("")){
			//getCategory가 null이나 공백이 아니면 IN절 사용
			sb.append("			WHERE p.category IN(							   \n");
		
			try {
				categorySbAppend(sb, vo); //test에서 set한 Category값을 get하여 sb.append하는 함수
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
			sb.append("						     )     		          			   \n");
			if(vo.getSearchWord() != null && !vo.getSearchWord().equals("")){
				sb.append("			AND p.product_nm like '"+vo.getSearchWord());
				sb.append("%'					   \n");
			}
		}else{
			if(vo.getSearchWord() != null && !vo.getSearchWord().equals("")){
				sb.append("			WHERE p.product_nm like '"+vo.getSearchWord());
				sb.append("%'					   \n");
			}
		}
		//-------------------------------카테고리-------------------------------------
		sb.append("			ORDER BY p.reg_dt DESC                             \n");
		sb.append("        )A                                                  \n");                               
		sb.append("        WHERE ROWNUM <=(?*(?-1)+?)                          \n");                                 
		sb.append("    )B                                                      \n");                     
		sb.append("    WHERE B.rnum>= (?*(?-1)+1)                              \n");                      
		sb.append(")T1 CROSS JOIN(                                              \n");
		sb.append("    SELECT COUNT(*) total_cnt                                \n");
		sb.append("    FROM product p JOIN image i                              \n");
		sb.append("    ON p.product_no = i.product_no                           \n");
		sb.append("	AND i.thumbnail = '1'                                       \n");
		sb.append("    AND p.deadline >= SYSDATE -1                             \n");
		//sb.append("    WHERE p.category = ?                                     \n");
		//-------------------------------카테고리-------------------------------------
		if(vo.getCategory() != null && !vo.getCategory().equals("")){
			//getCategory가 null이나 공백이 아니면 IN절 사용
			sb.append("			WHERE p.category IN(							   \n");
		
			try {
				categorySbAppend(sb, vo); //test에서 set한 Category값을 get하여 sb.append하는 함수
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
		sb.append("						     )     		          			   \n");
		if(vo.getSearchWord() != null && !vo.getSearchWord().equals("")){
			sb.append("			AND p.product_nm like '"+vo.getSearchWord());
			sb.append("%'					   \n");
		}
		}else{
			if(vo.getSearchWord() != null && !vo.getSearchWord().equals("")){
				sb.append("			WHERE p.product_nm like '"+vo.getSearchWord());
				sb.append("%'					   \n");
			}
		}
		//-------------------------------카테고리-------------------------------------
		sb.append(")T2                                                          \n");

		
		LOG.debug("2 sql \n :"+sb.toString());
		try{
			conn = new ConnectionMaker().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, vo.getPageSize());
			pstmt.setInt(2, vo.getPageNum());
			pstmt.setInt(3, vo.getPageSize());
			pstmt.setInt(4, vo.getPageSize());
			pstmt.setInt(5, vo.getPageNum());
			LOG.debug("3. param:getCategory:\n"+vo.getCategory());
			LOG.debug("3. param:getPageSize:\n"+vo.getPageSize());
			LOG.debug("3. param:getPageNum:\n"+vo.getPageNum());
			rs = pstmt.executeQuery();
			 while(rs.next()){
				 ProductVO outVO = new ProductVO();
				 outVO.setProductNo(rs.getString("product_no"));
				 outVO.setImageId(rs.getString("image_id"));			 
				 outVO.setProductNm(rs.getString("product_nm"));
				 outVO.setPrice(rs.getString("price"));
				 outVO.setDeadline(rs.getString("deadline"));
				 outVO.setCategory(rs.getString("category"));
				 outVO.setSaveFileNm(rs.getString("save_file_nm"));
				 outVO.setTotal(rs.getInt("total_cnt"));
				 LOG.debug("-----------------------------------------------------");
				 LOG.debug("3. outVO:\n"+outVO);
				 LOG.debug("-----------------------------------------------------");
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
	
	//공지수정
	public int do_notice_update(DTO dto){
		ProductVO vo = (ProductVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append("  UPDATE product			  \n");
			sb.append("  SET                      \n");
			sb.append("      notice = ?,          \n");
			sb.append("      reg_dt = SYSDATE     \n");
			sb.append("  WHERE                    \n");
			sb.append("      product_no = ?       \n");
			sb.append("      AND reg_id = ?       \n");
			
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.======================");
			LOG.debug("1.query \n"+sb.toString());
			LOG.debug("1.======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getNotice());
			pstmt.setString(2, vo.getProductNo());
			pstmt.setString(3, vo.getRegId());
			
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
	
	
	
	
	
	
	

	//공지조회
	public DTO do_notice_select(DTO dto){
		ProductVO vo = (ProductVO)dto;
		ProductVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("  SELECT             		\n");
			sb.append("      p.product_no,   		\n");
			sb.append("      p.notice       		\n");
			sb.append("  FROM  product p   		    \n");
			sb.append("  WHERE p.product_no = ?     \n");
			
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.===================");
			LOG.debug("1.query:\n"+sb.toString());
			LOG.debug("1.===================");
			
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductNo());
			//쿼리 파람 셋팅
			LOG.debug("2.===================");
			LOG.debug("2.param seq:\n"+sb.toString());
			LOG.debug("2.===================");
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				outVO = new ProductVO();
				outVO.setNotice(rs.getString("product_no"));
				outVO.setNotice(rs.getString("notice"));
				
				return outVO;
				
			}
			
			
		}catch(SQLException e){
			LOG.debug("=================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("=================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		
		return null;
		
	}
	
	
	
	//상품상세조회
	public DTO do_detail_select(DTO dto){
		ProductVO vo = (ProductVO)dto;
		ProductVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT														\n");										
			sb.append("     i.image_id,                                             \n");
			sb.append("     i.save_file_nm,                                         \n");
			sb.append("     p.product_no,                                           \n");
			sb.append("     p.product_nm,                                           \n");
			sb.append(" 	p.join_cnt,									            \n");
			sb.append("  	p.target_cnt,        								    \n");
			sb.append(" 	p.category,         								    \n");
			sb.append(" 	p.read_cnt,          								    \n");
			sb.append(" 	p.host_status,      								    \n");
			sb.append(" 	p.delivery_status,	                                    \n");
			sb.append("     NVL((   SELECT p.target_cnt-sum(j.join_cnt)             \n");
			sb.append("          FROM product p JOIN joinlist j                     \n");
			sb.append("          ON p.product_no = j.product_no                     \n");
			sb.append("          AND j.product_no = ?                               \n");
			sb.append("          GROUP BY p.target_cnt                              \n");
			sb.append("     ),p.target_cnt) AS rest_amount,                         \n");
			sb.append("     TO_CHAR(p.deadline,'YYYY.MM.DD') AS deadline,           \n");
			sb.append("     p.delivery_price,                                       \n");
			sb.append("     p.price,                                                \n");
			sb.append("     p.notice,								       		    \n");
			sb.append("     p.contents,                                             \n");
			sb.append("     p.reg_id,                                               \n");
			sb.append("     TO_CHAR(p.reg_dt,'YYYY.MM.DD') AS reg_dt                \n");
			sb.append(" FROM                                                        \n");
			sb.append("     product p JOIN image i                                  \n");
			sb.append(" ON p.product_no = i.product_no                              \n");
			sb.append(" AND p.product_no = ?	                                    \n");
			sb.append(" AND i.thumbnail = '1'   									\n");
			
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.===================");
			LOG.debug("1.query:\n"+sb.toString());
			LOG.debug("1.===================");
			
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductNo());
			pstmt.setString(2, vo.getProductNo());
			//쿼리 파람 셋팅
			LOG.debug("2.===================");
			LOG.debug("2.param seq:\n"+sb.toString());
			LOG.debug("2.===================");
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				outVO = new ProductVO();
				outVO.setImageId(rs.getString("image_id"));
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setProductNm(rs.getString("product_nm"));
				outVO.setRestAmount(rs.getString("rest_amount"));
				outVO.setDeadline(rs.getString("deadline"));
				outVO.setDeliveryPrice(rs.getString("delivery_price"));
				outVO.setPrice(rs.getString("price"));
				outVO.setNotice(rs.getString("notice"));
				outVO.setContents(rs.getString("contents"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setSaveFileNm(rs.getString("save_file_nm"));
				
				
				return outVO;
				
			}
			
			
		}catch(SQLException e){
			LOG.debug("=================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("=================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		
		return null;
		
	}
	
	
	//최근등록조회
	public List<?> do_latest_select(){
		List<ProductVO> list = new ArrayList<>();
		ProductVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("  SELECT T1.*,T2.*											\n");								
			sb.append("  FROM                                               	    \n");
			sb.append("  (                                                 	        \n");
			sb.append("      SELECT b.rnum num,                           	    	\n");
			sb.append("             b.*                                    		    \n");
			sb.append("      FROM(                                              	\n");
			sb.append("          SELECT ROWNUM rnum                        		    \n");
			sb.append("  				,A.*                                   		\n");
			sb.append("          FROM(                                         		\n");
			sb.append("              SELECT                                   		\n");
			sb.append("  				i.image_id,                    		        \n");
			sb.append("                 i.save_file_nm,                             \n");
			sb.append("  				p.product_no,                 		        \n");
			sb.append("  				p.product_nm,                       	    \n");
			sb.append("  				p.price,                                	\n");
			sb.append("  				TO_CHAR(p.deadline ,'YYYY.MM.DD') deadline	\n");
			sb.append("              FROM product p JOIN image i             	    \n");
			sb.append("              ON p.product_no = i.product_no            		\n");
			sb.append("  			AND p.deadline >= SYSDATE -1             		    \n");
			sb.append("  			AND i.thumbnail = '1'                	        \n");
			sb.append("  			ORDER BY p.reg_dt DESC            	            \n");
			sb.append("          )A                                       	        \n");
			sb.append("          WHERE ROWNUM <= 8                           		\n");
			sb.append("      )B                                              	    \n");
			sb.append("      WHERE B.rnum>= 1                               	    \n");
			sb.append("  )T1 CROSS JOIN                                     	    \n");
			sb.append("  (                                                		    \n");
			sb.append("      SELECT COUNT(*) total_cnt                      	    \n");
			sb.append("      FROM product p JOIN image i                    	    \n");
			sb.append("      ON p.product_no = i.product_no                    		\n");
			sb.append("  	AND i.thumbnail = '1'                             		\n");
			sb.append("  )T2                                                    	\n");
			
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.===================");
			LOG.debug("1.query:\n"+sb.toString());
			LOG.debug("1.===================");
			
			
			pstmt = conn.prepareStatement(sb.toString());
			//쿼리 파람 셋팅
			LOG.debug("2.===================");
			LOG.debug("2.param seq:\n"+sb.toString());
			LOG.debug("2.===================");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				outVO = new ProductVO();
				outVO.setImageId(rs.getString("image_id"));
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setProductNm(rs.getString("product_nm"));
				outVO.setPrice(rs.getString("price"));
				outVO.setDeadline(rs.getString("deadline"));
				outVO.setSaveFileNm(rs.getString("save_file_nm"));
				list.add(outVO);
				
			}
			
			
		}catch(SQLException e){
			LOG.debug("=================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("=================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		
		return list;
		
		
	}
	
	
	
	
	//베스트 상품 조회
	public List<?> do_best_select(DTO dto){
		ListAllSearchVO vo = (ListAllSearchVO) dto;
		
		List<ProductVO> list = new ArrayList<>();
		ProductVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
				
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("  SELECT T1.*,T2.*											\n");
			sb.append("  FROM                                                       \n");
			sb.append("  (                                                          \n");
			sb.append("      SELECT b.rnum num,                                     \n");
			sb.append("             b.*                                             \n");
			sb.append("      FROM(                                                  \n");
			sb.append("          SELECT ROWNUM rnum                                 \n");
			sb.append("  				,A.*                                        \n");
			sb.append("          FROM(                                              \n");
			sb.append("  			SELECT                            			    \n");
			sb.append("  				i.image_id,                   			    \n");
			sb.append("                 i.save_file_nm,                             \n");
			sb.append("  				p.product_no,                 			    \n");
			sb.append("  				p.product_nm,                 			    \n");
			sb.append("  				p.price,                      			    \n");
			sb.append("  				TO_CHAR(p.deadline ,'YYYY.MM.DD') deadline  \n");
			sb.append("  			FROM                              			    \n");
			sb.append("  				product p JOIN image i        			    \n");
			sb.append("  			ON p.product_no = i.product_no    			    \n");
			sb.append("  			AND p.reg_dt+10>=SYSDATE          			    \n");
			sb.append("  			AND p.deadline >= SYSDATE -1                		\n");
			sb.append("  			AND i.thumbnail = '1'             			    \n");
			if(vo.getCategory() != null && !vo.getCategory().equals("")){
			sb.append("             WHERE p.category = ?                            \n");
			}
			sb.append("  			ORDER BY p.read_cnt DESC                        \n");
			sb.append("          )A                                                 \n");
			//sb.append("          WHERE ROWNUM <= 8                                \n");
			sb.append("        WHERE ROWNUM <= ?			                        \n");
			sb.append("      )B                                                     \n");
			sb.append("      WHERE B.rnum>= 1                                       \n");
			sb.append("  )T1 CROSS JOIN                                             \n");
			sb.append("  (                                                          \n");
			sb.append("      SELECT COUNT(*) total_cnt                              \n");
			sb.append("      FROM                              			            \n");
			sb.append("  		product p JOIN image i        			            \n");
			sb.append("  	ON p.product_no = i.product_no    			            \n");
			sb.append("  	AND p.reg_dt+10>=SYSDATE          			            \n");
			sb.append("  	AND i.thumbnail = '1'                                   \n");
			sb.append("  )T2                                                        \n");			
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.===================");
			LOG.debug("1.query:\n"+sb.toString());
			LOG.debug("1.===================");			
			
			pstmt = conn.prepareStatement(sb.toString());
			//쿼리 파람 셋팅
			if(vo.getCategory() != null && !vo.getCategory().equals("")){
				pstmt.setString(1, vo.getCategory());
				pstmt.setInt(2, vo.getPageSize());		
			}else{
				pstmt.setInt(1, vo.getPageSize());			
			}
			
			LOG.debug("2.===================");
			LOG.debug("2.param seq:\n"+sb.toString());
			LOG.debug("2.===================");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				outVO = new ProductVO();
				outVO.setImageId(rs.getString("image_id"));
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setProductNm(rs.getString("product_nm"));
				outVO.setPrice(rs.getString("price"));
				outVO.setDeadline(rs.getString("deadline"));
				outVO.setSaveFileNm(rs.getString("save_file_nm"));
				list.add(outVO);
				
			}
			
			
		}catch(SQLException e){
			LOG.debug("=================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("=================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		
		return list;
		
		
	}
	
	
	
	
	
	
	//마감임박
	public List<ProductVO> do_imminent_select() {
		List<ProductVO> list = new ArrayList<>();
		ProductVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("   SELECT T1.*,T2.*												\n");
			sb.append("   FROM                                                          \n");
			sb.append("   (                                                             \n");
			sb.append("       SELECT b.rnum num,                                        \n");
			sb.append("              b.*                                                \n");
			sb.append("       FROM(                                                     \n");
			sb.append("           SELECT ROWNUM rnum                                    \n");
			sb.append("   				,A.*                                            \n");
			sb.append("           FROM(                                                 \n");
			sb.append("   			SELECT                           					\n");
			sb.append("   				i.image_id,                  					\n");
			sb.append("                 i.save_file_nm,                                 \n");
			sb.append("   				p.product_no,                 					\n");
			sb.append("   				p.product_nm,               					\n");
			sb.append("   				p.price,                     					\n");
			sb.append("   				TO_CHAR(p.deadline ,'YYYY.MM.DD') deadline  	\n");
			sb.append("   			FROM                             					\n");
			sb.append("   				product p JOIN image i      					\n");
			sb.append("   			ON p.product_no = i.product_no   					\n");
			sb.append("  			AND p.deadline >= SYSDATE -1          	      		\n");
			sb.append("   			AND i.thumbnail = '1'           					\n");
			sb.append("   			ORDER BY p.deadline                                 \n");
			sb.append("           )A                                                    \n");
			sb.append("           WHERE ROWNUM <= 8                                     \n");
			sb.append("       )B                                                        \n");
			sb.append("       WHERE B.rnum>= 1                                          \n");
			sb.append("   )T1 CROSS JOIN                                                \n");
			sb.append("   (                                                             \n");
			sb.append("       SELECT COUNT(*) total_cnt                                 \n");
			sb.append("   	FROM                             					        \n");
			sb.append("   		product p JOIN image i      					        \n");
			sb.append("   	ON p.product_no = i.product_no   					        \n");
			sb.append("   	AND i.thumbnail = '1'                                       \n");
			sb.append("   )T2                                                           \n");
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.===================");
			LOG.debug("1.query:\n"+sb.toString());
			LOG.debug("1.===================");
			
			
			pstmt = conn.prepareStatement(sb.toString());
			//쿼리 파람 셋팅
			LOG.debug("2.===================");
			LOG.debug("2.param seq:\n"+sb.toString());
			LOG.debug("2.===================");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				outVO = new ProductVO();
				outVO.setImageId(rs.getString("image_id"));
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setProductNm(rs.getString("product_nm"));
				outVO.setPrice(rs.getString("price"));
				outVO.setDeadline(rs.getString("deadline"));
				outVO.setSaveFileNm(rs.getString("save_file_nm"));
				list.add(outVO);
				
			}
			
			
		}catch(SQLException e){
			LOG.debug("=================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("=================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		
		return list;
	}
	
	
	
	
	
	
	

	@Override
	public int do_insert(DTO dto){
		ProductVO vo = (ProductVO) dto;
		
		int flag = 0;
		Connection conn = null;	
		PreparedStatement pstmt = null;
		try{
			//conn = connectionMaker.getConnection();
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1. conn:"+conn);
			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO product (     \n");
			sb.append("        product_no,       \n");
			sb.append("        product_nm,       \n");
			sb.append("        price,            \n");
			sb.append("        category,         \n");
			sb.append("        contents,         \n");
			sb.append("        target_cnt,       \n");
			sb.append("        deadline,         \n");
			sb.append("        reg_id,           \n");
			sb.append("        reg_dt,           \n");
			sb.append("        delivery_price,   \n");
			sb.append("        remaining         \n");
			sb.append(") VALUES (                \n");
			sb.append("        SEQ_PRODUCT_NO.nextval,\n");
			sb.append("        ?,     			 \n");
			sb.append("        ?,      		     \n");
			sb.append("        ?,      			 \n");
			sb.append("        ?,      			 \n");
			sb.append("        ?,      			 \n");
			sb.append("        ?,        		 \n");
			sb.append("        ?,          		 \n");
			sb.append("        SYSDATE,   		 \n");
			sb.append("        ?,          		 \n");
			sb.append("        ?          		 \n");
			sb.append(")                         \n");
			
			LOG.debug("2. sql:\n"+sb.toString()); //위의 SQL이 담겨있다
			LOG.debug("3. param:\n"+vo.toString());//SQL문으로 조회해온 정보들이 담겨있다.
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductNm());
			pstmt.setString(2, vo.getPrice());
			pstmt.setString(3, vo.getCategory());
			pstmt.setString(4, vo.getContents());
			pstmt.setString(5, vo.getTargetCnt());
			pstmt.setString(6, vo.getDeadline());
			pstmt.setString(7, vo.getRegId());
			pstmt.setString(8, vo.getDeliveryPrice());
			pstmt.setString(9, vo.getTargetCnt());//남은 수량은 게시글 작성시 목표수량과 같음
			
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
		ProductVO vo = (ProductVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append("UPDATE product     		\n");
			sb.append("SET  product_nm = ? 		\n");
			sb.append("    ,price = ?      		\n");
			sb.append("    ,category = ?  		\n");
			sb.append("    ,contents = ?   		\n");
			sb.append("    ,target_cnt = ? 		\n");
			sb.append("    ,deadline = ?  		\n");
			sb.append("    ,delivery_price = ?	\n");
			sb.append("WHERE               		\n");
			sb.append("    product_no = ?  		\n");
			
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.======================");
			LOG.debug("1.query \n"+sb.toString());
			LOG.debug("1.======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductNm());
			pstmt.setString(2, vo.getPrice());
			pstmt.setString(3, vo.getCategory());
			pstmt.setString(4, vo.getContents());
			pstmt.setString(5, vo.getTargetCnt());
			pstmt.setString(6, vo.getDeadline());
			pstmt.setString(7, vo.getDeliveryPrice());
			pstmt.setString(8, vo.getProductNo());
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
	public int do_update2(DTO dto) {
		ProductVO vo = (ProductVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append(" UPDATE product          \n");
			sb.append(" SET host_status='20'    \n");
			sb.append(" WHERE reg_id= ?		    \n");
			sb.append(" AND product_no= ?       \n");
			
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.======================");
			LOG.debug("1.query \n"+sb.toString());
			LOG.debug("1.======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getRegId());
			pstmt.setString(2, vo.getProductNo());

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
	public int do_update3(DTO dto) {
		ProductVO vo = (ProductVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append(" UPDATE product              \n");
			sb.append(" SET  delivery_status=?      \n");
			sb.append(" WHERE product_no=?		    \n");
			sb.append(" AND   reg_id=?              \n");
		
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.======================");
			LOG.debug("1.query \n"+sb.toString());
			LOG.debug("1.======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getDeliveryStatus());
			pstmt.setString(2, vo.getProductNo());
			pstmt.setString(3, vo.getRegId());

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
	public int do_update4(DTO dto) {
		ProductVO vo = (ProductVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append(" UPDATE product          \n");
			sb.append(" SET host_status='30'    \n");
			sb.append(" WHERE reg_id= ?		    \n");
			sb.append(" AND product_no= ?       \n");
			
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.======================");
			LOG.debug("1.query \n"+sb.toString());
			LOG.debug("1.======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getRegId());
			pstmt.setString(2, vo.getProductNo());

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
		sb.append("DELETE FROM product  \n");
		sb.append("WHERE PRODUCT_NO = ? \n");
		
		try {
			
			conn = new ConnectionMaker().getConnection();;

			LOG.debug("1======================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			//query param
			pstmt.setString(1, vo.getProductNo());
			LOG.debug("2======================");
			LOG.debug("product_no:"+vo.getProductNo());
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
		
		return flag;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_selectOne(com.zim.cmn.DTO)
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		ProductVO vo = (ProductVO) dto;
		ProductVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT                       ");
			sb.append("     product_no,              ");
			sb.append("     product_nm,              ");
			sb.append("     price,                   ");
			sb.append("     join_cnt,                ");
			sb.append("     category,                ");
			sb.append("     read_cnt,                ");
			sb.append("     contents,                ");
			sb.append("     notice,                  ");
			sb.append("     target_cnt,              ");
//			sb.append("     deadline,                ");
			sb.append("     TO_CHAR(deadline ,'YYYY.MM.DD') deadline,                ");
			sb.append("     host_status,             ");
			sb.append("     delivery_status,         ");
			sb.append("     reg_id,                  ");
			sb.append("     reg_dt,                  ");
			sb.append("     delivery_price           ");
			sb.append(" FROM                         ");
			sb.append("     product                  ");
			sb.append(" WHERE product_no = ?         ");
			conn = new ConnectionMaker().getConnection();			
			LOG.debug("1.conn:"+conn);
			LOG.debug("2.sql:"+sb.toString());
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductNo());
			LOG.debug("3.param:"+vo);
			rs = pstmt.executeQuery();
			if(rs.next()){
				outVO = new ProductVO();
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setProductNm(rs.getString("product_nm"));
				outVO.setPrice(rs.getString("price"));
				outVO.setJoinCnt(rs.getString("join_cnt"));
				outVO.setCategory(rs.getString("category"));
				outVO.setReadCnt(rs.getString("read_cnt"));
				outVO.setContents(rs.getString("contents"));
				outVO.setNotice(rs.getString("notice"));
				outVO.setTargetCnt(rs.getString("target_cnt"));
				outVO.setDeadline(rs.getString("deadline"));
				outVO.setHostStatus(rs.getString("host_status"));
				outVO.setDeliveryStatus(rs.getString("delivery_status"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setDeliveryPrice(rs.getString("delivery_price"));
			}			
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.getMessage());
			LOG.debug("=========================");
		}finally{			
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return outVO;
	}
	public List<ProductVO> do_retrieve2(DTO dto) {
		SearchVO vo = (SearchVO) dto;
		List<ProductVO> list = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT T1.*,T2.*                        \n");                 
		sb.append(" FROM(                                   \n");                 
		sb.append(" SELECT B.rnum as num                    \n");                 
		sb.append("       ,B.product_no                     \n");                    
		sb.append("       ,B.product_nm                     \n");                     
		sb.append("       ,B.price                          \n");                  
		sb.append("       ,B.join_cnt                       \n");                    
		sb.append("       ,B.category                       \n");
		sb.append(" 	  ,B.read_cnt                       \n");
		sb.append(" 	  ,B.contents                       \n");
		sb.append(" 	  ,B.notice                         \n");
		sb.append(" 	  ,B.target_cnt                     \n");
		sb.append(" 	  ,B.deadline                       \n");
		sb.append(" 	  ,B.host_status 	                \n");
		sb.append(" 	  ,B.delivery_status                \n");
		sb.append(" 	  ,B.reg_id                         \n");
		sb.append(" 	  ,B.reg_dt                         \n");
		sb.append(" 	  ,B.delivery_price                 \n");
		sb.append(" FROM(                                   \n");                 
		sb.append("    SELECT ROWNUM AS rnum,A.*            \n");
		sb.append("    FROM(                                \n");                 
		sb.append("       SELECT *                          \n");                 
		sb.append("       FROM product                      \n");
		sb.append("  WHERE reg_id = ?                       \n"); 
		sb.append("  AND host_status IN('20','30')          \n");
		sb.append("       ORDER BY reg_dt DESC              \n");                 
		sb.append("    )A                                   \n");                 
		sb.append("    WHERE ROWNUM <=(?*(?-1)+?) )B   	    \n");						
		sb.append("    WHERE B.rnum>= (?*(?-1)+1)         	\n");			        
		sb.append(" )T1                                     \n");                 
		sb.append(" CROSS JOIN                              \n");                 
		sb.append(" (                                       \n");                 
		sb.append(" SELECT COUNT(*) total_cnt               \n");                 
		sb.append(" FROM   product                          \n");
		sb.append("  WHERE reg_id = ?                       \n");
		sb.append("  AND host_status IN('20','30')          \n");
		sb.append(" )T2                                     \n");
		
		LOG.debug("do_retrieve2 sql :"+sb.toString());
		try{
			conn = new ConnectionMaker().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1,vo.getSearchWord());
			pstmt.setInt(2, vo.getPageSize());
			pstmt.setInt(3, vo.getPageNum());
			pstmt.setInt(4, vo.getPageSize());
			pstmt.setInt(5, vo.getPageSize());
			pstmt.setInt(6, vo.getPageNum());
			pstmt.setString(7,vo.getSearchWord());
			rs = pstmt.executeQuery();
			LOG.debug("3.do_retrieve2 sql :"+vo);
			while(rs.next()){
				ProductVO outVO = new ProductVO();
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setProductNm(rs.getString("product_nm"));
				outVO.setPrice(rs.getString("price"));
				outVO.setJoinCnt(rs.getString("join_cnt"));
				outVO.setCategory(rs.getString("category"));
				outVO.setReadCnt(rs.getString("read_cnt"));
				outVO.setContents(rs.getString("contents"));
				outVO.setNotice(rs.getString("notice"));
				outVO.setTargetCnt(rs.getString("target_cnt"));
				outVO.setDeadline(rs.getString("deadline"));
				outVO.setHostStatus(rs.getString("host_status"));
				outVO.setDeliveryStatus(rs.getString("delivery_status"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setDeliveryPrice(rs.getString("delivery_price"));
				LOG.debug("--------------------------------");
				LOG.debug("4. outVO :"+outVO);
				LOG.debug("--------------------------------");
				list.add(outVO);
			}
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.getMessage());
			LOG.debug("=========================");
		}finally{			
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}		
		
		return list;
	}
	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_retrieve(com.zim.cmn.DTO)
	 */
	@Override
	public List<ProductVO> do_retrieve(DTO dto) {
		SearchVO vo = (SearchVO) dto;
		List<ProductVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT T1.*,T2.*                        \n");                 
		sb.append(" FROM(                                   \n");                 
		sb.append(" SELECT B.rnum as num                    \n");                 
		sb.append("       ,B.product_no                     \n");                    
		sb.append("       ,B.product_nm                     \n");                     
		sb.append("       ,B.price                          \n");                  
		sb.append("       ,B.join_cnt                       \n");                    
		sb.append("       ,B.category                       \n");
		sb.append(" 	  ,B.read_cnt                       \n");
		sb.append(" 	  ,B.contents                       \n");
		sb.append(" 	  ,B.notice                         \n");
		sb.append(" 	  ,B.target_cnt                     \n");
		sb.append(" 	  ,B.deadline                       \n");
		sb.append(" 	  ,B.host_status 	                \n");
		sb.append(" 	  ,B.delivery_status                \n");
		sb.append(" 	  ,B.reg_id                         \n");
		sb.append(" 	  ,B.reg_dt                         \n");
		sb.append(" 	  ,B.delivery_price                 \n");
		sb.append(" FROM(                                   \n");                 
		sb.append("    SELECT ROWNUM AS rnum,A.*            \n");
		sb.append("    FROM(                                \n");                 
		sb.append("       SELECT *                          \n");                 
		sb.append("       FROM product                      \n");
		sb.append("  WHERE reg_id = ?                       \n"); 
		sb.append("  AND host_status IN('10')               \n");
		sb.append("       ORDER BY reg_dt DESC              \n");                 
		sb.append("    )A                                   \n");                 
		sb.append("    WHERE ROWNUM <=(?*(?-1)+? ) )B   	\n");						
		sb.append("    WHERE B.rnum>= (?*(?-1)+1)         	\n");			        
		sb.append(" )T1                                     \n");                 
		sb.append(" CROSS JOIN                              \n");                 
		sb.append(" (                                       \n");                 
		sb.append(" SELECT COUNT(*) total_cnt               \n");                 
		sb.append(" FROM   product                          \n");
		sb.append("  WHERE reg_id = ?                       \n");
		sb.append("  AND host_status IN('10')               \n");
		sb.append(" )T2                                     \n");
		LOG.debug("do_retrieve sql :"+sb.toString());
		try{
			conn = new ConnectionMaker().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1,vo.getSearchWord());
			pstmt.setInt(2, vo.getPageSize());
			pstmt.setInt(3, vo.getPageNum());
			pstmt.setInt(4, vo.getPageSize());
			pstmt.setInt(5, vo.getPageSize());
			pstmt.setInt(6, vo.getPageNum());
			pstmt.setString(7,vo.getSearchWord());
			rs = pstmt.executeQuery();
			LOG.debug("3.do_retrieve sql :"+vo);
			while(rs.next()){
				ProductVO outVO = new ProductVO();
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setProductNm(rs.getString("product_nm"));
				outVO.setPrice(rs.getString("price"));
				outVO.setJoinCnt(rs.getString("join_cnt"));
				outVO.setCategory(rs.getString("category"));
				outVO.setReadCnt(rs.getString("read_cnt"));
				outVO.setContents(rs.getString("contents"));
				outVO.setNotice(rs.getString("notice"));
				outVO.setTargetCnt(rs.getString("target_cnt"));
				outVO.setDeadline(rs.getString("deadline"));
				outVO.setHostStatus(rs.getString("host_status"));
				outVO.setDeliveryStatus(rs.getString("delivery_status"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setDeliveryPrice(rs.getString("delivery_price"));
				LOG.debug("--------------------------------");
				LOG.debug("4. outVO :"+outVO);
				LOG.debug("--------------------------------");
				
				list.add(outVO);
			}
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.getMessage());
			LOG.debug("=========================");
		}finally{			
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}		
		
		return list;
	}
	//각각의 카테고리(ex-의류, 잡화 등)을 조회
	public List<ProductVO> do_category_select(DTO dto) {
		ListAllSearchVO vo = (ListAllSearchVO) dto;

		List<ProductVO> list = new ArrayList<>();
		Connection conn = null; //db연결
		PreparedStatement pstmt = null; //query수행
		ResultSet rs = null; //결과처리

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT T1.*,T2.*											    \n");
		sb.append("FROM (                                                       \n");
		sb.append("    SELECT b.rnum num, b.*                                   \n");
		sb.append("    FROM(                                                    \n");
		sb.append("        SELECT ROWNUM rnum, A.*                              \n");
		sb.append("        FROM(                                                \n");
		sb.append("            SELECT                                           \n");
		sb.append("             i.image_id,                                     \n");
		sb.append("             i.save_file_nm,                                 \n");
		sb.append("				p.product_no,                                   \n");
		sb.append("				p.product_nm,                                   \n");
		sb.append("				p.price,                                        \n");
		sb.append("				TO_CHAR(p.deadline ,'YYYY.MM.DD') deadline      \n");
		sb.append("            FROM product p JOIN image i                      \n");
		sb.append("            ON p.product_no = i.product_no                   \n");
		sb.append("			AND i.thumbnail = '1'                               \n");
		sb.append("			AND p.deadline >= SYSDATE -1                        \n");
		sb.append("            WHERE p.category = ?                             \n");
		sb.append("			ORDER BY p.reg_dt DESC                              \n");
		sb.append("        )A                                                   \n");
//		sb.append("        WHERE ROWNUM <=(:PAGE_SIZE*(:PAGE_NUM-1)+:PAGE_SIZE) \n");
		sb.append("        WHERE ROWNUM <=(?*(?-1)+?)                           \n");
		sb.append("    )B                                                       \n");
//		sb.append("    WHERE B.rnum>= (:PAGE_SIZE*(:PAGE_NUM-1)+1)              \n");
		sb.append("    WHERE B.rnum>= (?*(?-1)+1)              \n");
		sb.append(")T1 CROSS JOIN(                                              \n");
		sb.append("    SELECT COUNT(*) total_cnt                                \n");
		sb.append("    FROM product p JOIN image i                              \n");
		sb.append("    ON p.product_no = i.product_no                           \n");
		sb.append("	AND i.thumbnail = '1'                                       \n");
		sb.append("    AND p.deadline >= SYSDATE -1                             \n");
		sb.append("    WHERE p.category = ?                                     \n");
		sb.append(")T2                                                          \n");
		
		LOG.debug("2 sql \n :"+sb.toString());
		try{
			conn = new ConnectionMaker().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			
			//카테고리 입력
			pstmt.setString(1, vo.getCategory());
			pstmt.setInt(2, vo.getPageSize());
			pstmt.setInt(3, vo.getPageNum());
			pstmt.setInt(4, vo.getPageSize());
			pstmt.setInt(5, vo.getPageSize());
			pstmt.setInt(6, vo.getPageNum());
			pstmt.setString(7, vo.getCategory());
			LOG.debug("3. param:getCategory:\n"+vo.getCategory());
			LOG.debug("3. param:getPageSize:\n"+vo.getPageSize());
			LOG.debug("3. param:getPageNum:\n"+vo.getPageNum());
			rs = pstmt.executeQuery();
		 while(rs.next()){
			 ProductVO outVO = new ProductVO();
			 outVO.setProductNo(rs.getString("product_no"));
			 outVO.setImageId(rs.getString("image_id"));			 
			 outVO.setProductNm(rs.getString("product_nm"));
			 outVO.setPrice(rs.getString("price"));
			 outVO.setDeadline(rs.getString("deadline"));
			 outVO.setSaveFileNm(rs.getString("save_file_nm"));
			 outVO.setTotal(rs.getInt("total_cnt"));
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
	
	//카테고리중 전체보기를 조회. 전체 카테고리 조회
	public List<ProductVO> do_totalCategory_select(DTO dto) {
		ListAllSearchVO vo = (ListAllSearchVO) dto;

		List<ProductVO> list = new ArrayList<>();
		Connection conn = null; //db연결
		PreparedStatement pstmt = null; //query수행
		ResultSet rs = null; //결과처리

		StringBuilder sb = new StringBuilder();
		sb.append("SELECT T1.*,T2.*											   \n");
		sb.append("FROM (                                                      \n");    
		sb.append("    SELECT b.rnum num, b.*                                  \n");           
		sb.append("    FROM(                                                   \n");
		sb.append("        SELECT ROWNUM rnum, A.*                             \n");          
		sb.append("        FROM(                                               \n");
		sb.append("            SELECT                                          \n");
		sb.append("             i.image_id,                                    \n");
		sb.append("             i.save_file_nm,                                \n");
		sb.append("				p.product_no,                                  \n");
		sb.append("				p.product_nm,                                  \n");
		sb.append("				p.price,                                       \n");
		sb.append("				p.category,                                    \n");
		sb.append("				TO_CHAR(p.deadline ,'YYYY.MM.DD')	deadline   \n");
		sb.append("            FROM product p JOIN image i                     \n");
		sb.append("            ON p.product_no = i.product_no                  \n");
		sb.append("			AND i.thumbnail = '1'                              \n");
		sb.append("			AND p.deadline >= SYSDATE -1                         \n");
		//-------------------------------카테고리-------------------------------------
		if(vo.getCategory() != null && !vo.getCategory().equals("")){
			//getCategory가 null이나 공백이 아니면 IN절 사용
			sb.append("			WHERE p.category IN(							   \n");
		
			try {
				categorySbAppend(sb, vo); //test에서 set한 Category값을 get하여 sb.append하는 함수
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
		sb.append("						     )     		          			   \n");
		}
		//-------------------------------카테고리-------------------------------------
		sb.append("			ORDER BY p.reg_dt DESC                             \n");
		sb.append("        )A                                                  \n");                               
		sb.append("        WHERE ROWNUM <=(?*(?-1)+?)                          \n");                                 
		sb.append("    )B                                                      \n");                     
		sb.append("    WHERE B.rnum>= (?*(?-1)+1)                              \n");                      
		sb.append(")T1 CROSS JOIN(                                              \n");
		sb.append("    SELECT COUNT(*) total_cnt                                \n");
		sb.append("    FROM product p JOIN image i                              \n");
		sb.append("    ON p.product_no = i.product_no                           \n");
		sb.append("	AND i.thumbnail = '1'                                       \n");
		sb.append("    AND p.deadline >= SYSDATE -1                             \n");
		//sb.append("    WHERE p.category = ?                                     \n");
		//-------------------------------카테고리-------------------------------------
		if(vo.getCategory() != null && !vo.getCategory().equals("")){
			//getCategory가 null이나 공백이 아니면 IN절 사용
			sb.append("			WHERE p.category IN(							   \n");
		
			try {
				categorySbAppend(sb, vo); //test에서 set한 Category값을 get하여 sb.append하는 함수
			} catch (SQLException e1) {
				e1.printStackTrace();
			}		
		sb.append("						     )     		          			   \n");
		}
		//-------------------------------카테고리-------------------------------------
		sb.append(")T2                                                          \n");

		
		LOG.debug("2 sql \n :"+sb.toString());
		try{
			conn = new ConnectionMaker().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setInt(1, vo.getPageSize());
			pstmt.setInt(2, vo.getPageNum());
			pstmt.setInt(3, vo.getPageSize());
			pstmt.setInt(4, vo.getPageSize());
			pstmt.setInt(5, vo.getPageNum());
			LOG.debug("3. param:getCategory:\n"+vo.getCategory());
			LOG.debug("3. param:getPageSize:\n"+vo.getPageSize());
			LOG.debug("3. param:getPageNum:\n"+vo.getPageNum());
			rs = pstmt.executeQuery();
		 while(rs.next()){
			 ProductVO outVO = new ProductVO();
			 outVO.setProductNo(rs.getString("product_no"));
			 outVO.setImageId(rs.getString("image_id"));			 
			 outVO.setProductNm(rs.getString("product_nm"));
			 outVO.setPrice(rs.getString("price"));
			 outVO.setDeadline(rs.getString("deadline"));
			 outVO.setCategory(rs.getString("category"));
			 outVO.setSaveFileNm(rs.getString("save_file_nm"));
			 outVO.setTotal(rs.getInt("total_cnt"));
			 
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

	public ProductVO do_select_productNo(DTO dto) {
		ProductVO vo = (ProductVO) dto;
		ProductVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append("select max(product_no) product_no\n");
			sb.append("from product          			\n");
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.=====================");
			LOG.debug("1.query: \n"+sb.toString());
			LOG.debug("1.=====================");
			
			pstmt = conn.prepareStatement(sb.toString());
			//query param

			
			rs = pstmt.executeQuery();
			if(rs.next()){
				outVO = new ProductVO();
				outVO.setProductNo(rs.getString("product_no"));			
			}
		}catch(SQLException e){
			LOG.debug("=====================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("=====================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		return outVO;
	}
	
	public ImageVO do_select_imageNo(DTO dto) {
		ImageVO vo = (ImageVO) dto;
		ImageVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb=new StringBuilder();
			sb.append("select max(image_id) image_id \n");
			sb.append("from image                    \n");
			sb.append("WHERE product_no = ?          \n");
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.=====================");
			LOG.debug("1.query: \n"+sb.toString());
			LOG.debug("1.=====================");
			
			pstmt = conn.prepareStatement(sb.toString());			
			//query param
			pstmt.setString(1, vo.getProductNo());
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				outVO = new ImageVO();
				outVO.setImageId(rs.getString("image_id"));			
			}
		}catch(SQLException e){
			LOG.debug("=====================");
			LOG.debug("SQLException="+e.getMessage());
			LOG.debug("=====================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		return outVO;
	}
	
	//test에서 set한 Category값을 get하여 sb.append하는 함수	
	//IN절 처리
	public static void categorySbAppend(StringBuilder sb, ListAllSearchVO vo) throws SQLException {
		String[] categoryArr = vo.getCategory().split(","); 
		
		for(int i = 0; i<categoryArr.length ; i++){ //categoryArr의 길이만큼 반복문
			sb.append(categoryArr[i]);
			if(i<categoryArr.length-1){//마지막 값 뒤에는 , 를 찍지 않는다
				sb.append(",");
			}
		}
	}

}
