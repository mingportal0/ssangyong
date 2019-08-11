 /**
 * @Class Name : CommentDao.java
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
package com.zim.product.comment;

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
import com.zim.product.ProductDao;
import com.zim.product.ProductVO;

/**
 * @author SIST
 *
 */
public class CommentDao implements WorkDiv {

	private final Logger LOG = Logger.getLogger(ProductDao.class);
	private ConnectionMaker connectionMaker;
	
	
	public CommentDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	
	
	
	
	//댓글삽입
	@Override
	public int do_insert(DTO dto) {
		CommentVO vo = (CommentVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("  INSERT INTO comments (				\n");
			sb.append("      comment_no,                    \n");
			sb.append("      product_no,                    \n");
			sb.append("      contents,                      \n");
			sb.append("      hcomment_no,                   \n");
			sb.append("      reg_id,                        \n");
			sb.append("      reg_dt                         \n");
			sb.append("  ) VALUES (                         \n");
			sb.append("       SEQ_COMMENT_NO.nextval,       \n");
			sb.append("      ?,                             \n");
			sb.append("      ?,                             \n");
			sb.append("      ?,                             \n");
			sb.append("      ?,                             \n");
			sb.append("      SYSDATE                        \n");
			sb.append("  )                                  \n");
			
			
			
			LOG.debug("1.======================");
			LOG.debug("1.query\n"+sb.toString());
			LOG.debug("1.======================");
			
			conn = connectionMaker.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getProductNo());
			pstmt.setString(2, vo.getContents());
			pstmt.setString(3, vo.getHcommentNo());
			pstmt.setString(4, vo.getRegId());
			
			
			LOG.debug("2.======================");
			LOG.debug("2.param\n"+vo.toString());
			LOG.debug("2.======================");
			
			flag = pstmt.executeUpdate();
			
			LOG.debug("3.======================");
			LOG.debug("3.flag"+flag);
			LOG.debug("3.======================");
			
			
		}catch(SQLException e){
			LOG.debug("==========================");
			LOG.debug("SQLException:\n"+e.toString());
			LOG.debug("==========================");
		}finally{
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		
		return flag;
		
		
	}

	
	
	
	//댓글수정
	@Override
	public int do_update(DTO dto) {
		CommentVO vo = (CommentVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("  UPDATE comments		\n");
			sb.append("  SET                    \n");
			sb.append("      contents = ?       \n");
			sb.append("  WHERE                  \n");
			sb.append("      comment_no = ?     \n");
			sb.append("      AND reg_id = ?     \n");
			sb.append("      AND product_no = ? \n");
			
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.===================");
			LOG.debug("1.query: \n"+sb.toString());
			LOG.debug("1.===================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getContents());
			pstmt.setString(2, vo.getCommentNo());
			pstmt.setString(3, vo.getRegId());
			pstmt.setString(4, vo.getProductNo());

			
			LOG.debug("2.===================");
			LOG.debug("2.param: \n"+vo);
			LOG.debug("2.===================");
			
			flag = pstmt.executeUpdate();
			
			
		}catch(SQLException e){
			LOG.debug("============");
			LOG.debug("SQLException="+e.toString());
			LOG.debug("============");
		}finally{
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
				
		return flag;
		
	}

	
	
	
	//댓글삭제
	@Override
	public int do_delete(DTO dto) {
		CommentVO vo = (CommentVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append("  DELETE FROM comments        \n");
		sb.append("  WHERE                       \n");
		sb.append("      product_no = ?          \n");
		sb.append("      AND comment_no = ?      \n");
		sb.append("      AND reg_id = ?          \n");
		
		
		try{
			conn = connectionMaker.getConnection();
			conn.setAutoCommit(false); //트랜잭션을 개발자가 관리하겠다는 의미
			LOG.debug("1==========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1==========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			//쿼리파람 셋팅
			pstmt.setString(1, vo.getProductNo());
			pstmt.setString(2, vo.getCommentNo());
			pstmt.setString(3, vo.getRegId());
			LOG.debug("2==========================");
			LOG.debug("query:\n"+vo.toString());
			LOG.debug("2==========================");
			
			flag = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
				JDBCReturnReso.close(pstmt);
				JDBCReturnReso.close(conn);
		}
		
		LOG.debug("2==========================");
		LOG.debug("flag:"+flag);
		LOG.debug("2==========================");
				
		return flag;
		
	}

	
	
	
	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_selectOne(com.zim.cmn.DTO)
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	//댓글 조회
	public List<?> do_retrieve(DTO dto) {
		List<CommentVO> list = new ArrayList<>();
		CommentVO vo = (CommentVO) dto;
		CommentVO outVO = null;
		Connection conn = null; //db연결
		PreparedStatement pstmt = null; //쿼리수행
		ResultSet rs = null; //결과처리
		
		try{
			StringBuilder sb = new StringBuilder();
			sb.append("  SELECT												\n");
			sb.append("      c.comment_no,                                  \n");
			sb.append("      c.product_no,                                  \n");
			sb.append("      c.contents,    								\n");
			sb.append("      c.hcomment_no,                                 \n");
			sb.append("      c.reg_id,                                      \n");
			sb.append("      c.reg_dt                                       \n");
			sb.append("  FROM                                               \n");
			sb.append("      comments c JOIN product p                      \n");
			sb.append("  ON c.product_no = p.product_no                     \n");
			sb.append("  AND p.product_no = ?                               \n");
			sb.append("  CONNECT BY PRIOR c.comment_no = c.hcomment_no      \n");
			sb.append("  START WITH c.hcomment_no IS NULL                   \n");
			sb.append("  ORDER SIBLINGS BY c.reg_dt 	                    \n");
			
			
			
			conn = connectionMaker.getConnection();
			LOG.debug("1.===================");
			LOG.debug("1.query:\n"+sb.toString());
			LOG.debug("1.===================");
			
			
			pstmt = conn.prepareStatement(sb.toString());
			//쿼리 파람 셋팅
			pstmt.setString(1, vo.getProductNo());
			LOG.debug("2.===================");
			LOG.debug("2.param :\n"+sb.toString());
			LOG.debug("2.===================");
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				outVO = new CommentVO();
				outVO.setCommentNo(rs.getString("comment_no"));
				outVO.setProductNo(rs.getString("product_no"));
				outVO.setContents(rs.getString("contents"));
				outVO.setHcommentNo(rs.getString("hcomment_no"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
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





}
