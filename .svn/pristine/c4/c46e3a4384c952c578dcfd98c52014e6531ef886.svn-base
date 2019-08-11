 /**
 * @Class Name : CodeDao.java
 * @Description : 
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2019. 7. 25.           최초생성
 *
 * @author Zimzalabim
 * @since 2019. 7. 25. 
 * @version 1.0
 * @see
 *
 *  Copyright (C) by HR. KIM All right reserved.
 */
package com.zim.code;

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

/**
 * @author sist
 *
 */
public class CodeDao implements WorkDiv{
	private final Logger LOG = Logger.getLogger(CodeDao.class); 
	private ConnectionMaker connectionMaker;
	
	public CodeDao() {
		connectionMaker = new ConnectionMaker();
	}
	
	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_insert(com.zim.cmn.DTO)
	 */
	@Override
	public int do_insert(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_update(com.zim.cmn.DTO)
	 */
	@Override
	public int do_update(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_delete(com.zim.cmn.DTO)
	 */
	@Override
	public int do_delete(DTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_selectOne(com.zim.cmn.DTO)
	 */
	@Override
	public DTO do_selectOne(DTO dto) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.zim.cmn.WorkDiv#do_retrieve(com.zim.cmn.DTO)
	 */
	@Override
	public List<?> do_retrieve(DTO dto) {
		CodeVO vo = (CodeVO) dto;
		Connection conn = null;
		PreparedStatement pstmt = null;;
		ResultSet rs = null;
		List<CodeVO> list = new ArrayList<>();
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT b.code_id,                  \n");
			sb.append("        b.code_nm                   \n");
			sb.append(" FROM code_type a JOIN code b       \n");
			sb.append(" ON a.code_type_id = b.code_type_id \n");
			sb.append(" WHERE b.code_type_id = ?           \n");
			sb.append(" AND b.use_yn = 1                   \n");
			sb.append(" ORDER BY b.num                     \n");
			LOG.debug("1===========================================");
			LOG.debug("query : "+sb.toString());
			LOG.debug("1===========================================");
			
			conn = connectionMaker.getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			//param
			pstmt.setString(1, vo.getCodeTypeId());
			LOG.debug("2===========================================");
			LOG.debug("param : "+vo.toString());
			LOG.debug("2===========================================");			
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				CodeVO outVo = new CodeVO();
				//code_id,code_nm
				outVo.setCodeId(rs.getString("code_id"));
				outVo.setCodeNm(rs.getString("code_nm"));
				list.add(outVo);
			}			
		}catch(SQLException e){
			LOG.debug("===========================================");
			LOG.debug("SQLException : "+e.toString());
			LOG.debug("===========================================");
		}finally{
			JDBCReturnReso.close(rs);
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return list;
	}
	
	
}
