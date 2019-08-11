/**
* @Class Name : ChartDao.java
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

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.zim.cmn.ConnectionMaker;
import com.zim.cmn.DTO;
import com.zim.cmn.JDBCReturnReso;
import com.zim.cmn.StringUtil;
import com.zim.cmn.WorkDiv;

/**
 * @author sist
 *
 */
public class ChartDao implements WorkDiv {
	private final Logger LOG = Logger.getLogger(ChartDao.class);

	private ConnectionMaker connectionMaker;

	public ChartDao() {
		connectionMaker = new ConnectionMaker();
	}

	public List<?> do_pro_chart(DTO dto) {
		ChartVO vo = (ChartVO) dto;

		List<ChartVO> list = new ArrayList();
		Connection conn = null;// db 연결
		PreparedStatement pstmt = null;// query 수행
		ResultSet rs = null; // 결과처리

		try {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT a.product_nm,                  \n");
			sb.append("       b.join_cnt                     \n");
			sb.append("FROM                                  \n");
			sb.append("(SELECT TO_CHAR(REG_DT,'YYYY') year,  \n");
			sb.append("        TO_CHAR(REG_DT,'MM') month,   \n");
			sb.append("        product_no,                   \n");
			sb.append("        product.product_nm            \n");
			sb.append("FROM product                          \n");
			sb.append("WHERE TO_CHAR(REG_DT,'YYYY')  = '2019'\n");
			sb.append(")A JOIN JOINLIST B                    \n");
			sb.append("ON A.product_no = B.product_no        \n");
			sb.append("WHERE ROWNUM <= 5                     \n");
			sb.append("ORDER BY B.JOIN_CNT  DESC             \n");

			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.conn:" + conn);
			LOG.debug("2.sql:\n" + sb.toString());

			pstmt = conn.prepareStatement(sb.toString());
				
			

			rs = pstmt.executeQuery();
			while (rs.next()) {
				ChartVO outVO = new ChartVO();
				outVO.setLabel(rs.getString("PRODUCT_NM"));
				outVO.setData(rs.getInt("JOIN_CNT"));

				list.add(outVO);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return list;
	}

	@Override
	public int do_insert(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zim.cmn.WorkDiv#do_update(com.zim.cmn.DTO)
	 */
	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zim.cmn.WorkDiv#do_delete(com.zim.cmn.DTO)
	 */
	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zim.cmn.WorkDiv#do_selectOne(com.zim.cmn.DTO)
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.zim.cmn.WorkDiv#do_retrieve(com.zim.cmn.DTO)
	 */
	@Override
	public List<?> do_retrieve(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

}
