 /**
 * @Class Name : MemberDao.java
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
package com.zim.member;

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
import com.zim.cmn.MessageVO;
import com.zim.cmn.SearchVO;
import com.zim.cmn.WorkDiv;


public class MemberDao implements WorkDiv{
	private final Logger LOG = Logger.getLogger(MemberDao.class);
	
	public int do_point_update(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb=new StringBuilder();
		try{
			sb.append(" UPDATE member	   \n");
			sb.append(" SET point = ?      \n");
			sb.append(" WHERE user_id = ?  \n");
			
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.======================");
			LOG.debug("1.query \n"+sb.toString());
			LOG.debug("1.======================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, Integer.parseInt(vo.getPoint()));
			pstmt.setString(2, vo.getUserId());
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
	
	public MessageVO do_passCheck(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		MessageVO outVO = new MessageVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT COUNT(*) cnt \n");
			sb.append(" FROM member      \n");
			sb.append(" WHERE user_id = ?   \n");
			sb.append(" AND passwd = ?      \n");
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1=========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1=========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getPasswd());
			LOG.debug("2=========================");
			LOG.debug("2.param:"+vo);
			LOG.debug("2=========================");
			LOG.debug(rs);
			rs = pstmt.executeQuery();
			LOG.debug(rs);
			if(rs.next()){
				if(rs.getInt("cnt")==0){//비밀번호를 확인하세요.
					outVO.setMsgId("20");					
					outVO.setMsgContents("비밀번호를 확인하세요.");					
				}else{
					outVO.setMsgId("1");
					outVO.setMsgContents("로그인이 성공하였습니다.");		
				}
			}
			LOG.debug("MessageVO : "+outVO );
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return outVO;
	}
	
	public MessageVO do_idCheck(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		MessageVO outVO = new MessageVO();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT COUNT(*) cnt \n");
			sb.append(" FROM member      \n");
			sb.append(" WHERE user_id = ?   \n");
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1=========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1=========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getUserId());
			LOG.debug("2=========================");
			LOG.debug("2.param:"+vo);
			LOG.debug("2=========================");
			LOG.debug(rs);
			rs = pstmt.executeQuery();
			LOG.debug(rs);
			if(rs.next()){
				if(rs.getInt("cnt")==0){//id를 확인하세요.
					outVO.setMsgId("10");					
					outVO.setMsgContents("id를 확인하세요.");					
				}else{
					outVO.setMsgId("1");
					outVO.setMsgContents("id가 있습니다.");		
				}
			}
			LOG.debug("MessageVO : "+outVO );
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return outVO;
	}
	
	/**
	 * 
	 * @Method Name  : do_selectOne_ckPw
	 * @작성일   : 2019. 7. 22.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 : 비번찾기 위한 정보확인
	 * @param dto
	 * @return
	 */
	public DTO do_selectOne_ckPw(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		MemberVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT            \n");
			sb.append("     user_id,      \n");
			sb.append("     passwd,       \n");
			sb.append("     name,         \n");
			sb.append("     email,        \n");
			sb.append("     resident_no,  \n");
			sb.append("     cell_phone,   \n");
			sb.append("     point,        \n");
			sb.append("     lvl,          \n");
			sb.append("     reg_id,       \n");
			sb.append("     reg_dt,       \n");
			sb.append("     mod_id,       \n");
			sb.append("     mod_dt        \n");
			sb.append(" FROM              \n");
			sb.append("     member        \n");
			sb.append(" WHERE user_id = ?   \n");
			sb.append(" AND email = ?   \n");
			sb.append(" AND resident_no = ?   \n");
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1=========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1=========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getResidentNo());
			LOG.debug("2=========================");
			LOG.debug("2.param:"+vo);
			LOG.debug("2=========================");
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				outVO = new MemberVO();				
				outVO.setUserId(rs.getString("user_id"));
				outVO.setPasswd(rs.getString("passwd"));
				outVO.setName(rs.getString("name"));
				outVO.setEmail(rs.getString("email"));
				outVO.setResidentNo(rs.getString("resident_no"));
				outVO.setCellPhone(rs.getString("cell_phone"));
				outVO.setPoint(rs.getString("point"));
				outVO.setLvl(rs.getString("lvl"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setModId(rs.getString("mod_id"));
				outVO.setModDt(rs.getString("mod_dt"));				
			}
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		
		
		
		return outVO;
	}
	
	
	/**
	 * 
	 * @Method Name  : do_selectOne_ckId
	 * @작성일   : 2019. 7. 22.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 : 아이디 찾기 위한 이메일체크
	 * @param dto
	 * @return
	 */
	public DTO do_selectOne_ckId(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		MemberVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT              \n");
			sb.append("     user_id,        \n");
			sb.append("     passwd,         \n");
			sb.append("     name,           \n");
			sb.append("     email,          \n");
			sb.append("     resident_no,    \n");
			sb.append("     cell_phone,     \n");
			sb.append("     point,          \n");
			sb.append("     lvl,            \n");
			sb.append("     reg_id,         \n");
			sb.append("     reg_dt,         \n");
			sb.append("     mod_id,         \n");
			sb.append("     mod_dt          \n");
			sb.append(" FROM                \n");
			sb.append("     member          \n");
			sb.append(" WHERE email = ?   \n");
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1=========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1=========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getEmail());
			LOG.debug("2=========================");
			LOG.debug("2.param:"+vo);
			LOG.debug("2=========================");
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				outVO = new MemberVO();				
				outVO.setUserId(rs.getString("user_id"));
				outVO.setPasswd(rs.getString("passwd"));
				outVO.setName(rs.getString("name"));
				outVO.setEmail(rs.getString("email"));
				outVO.setResidentNo(rs.getString("resident_no"));
				outVO.setCellPhone(rs.getString("cell_phone"));
				outVO.setPoint(rs.getString("point"));
				outVO.setLvl(rs.getString("lvl"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setModId(rs.getString("mod_id"));
				outVO.setModDt(rs.getString("mod_dt"));				
			}
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}		
		return outVO;
	}
	
	
	
	/**
	 * 
	 * @Method Name  : do_login
	 * @작성일   : 2019. 7. 18.
	 * @작성자   : sist
	 * @변경이력  : 최초작성
	 * @Method 설명 : 로그인 성공 : 1
	 * @param dto
	 * @return
	 */
	public DTO do_login(DTO dto){
		MemberVO vo = (MemberVO) dto;
		MemberDao dao = new MemberDao();
		MemberVO outVO =  (MemberVO)dao.do_selectOne(vo);
		if(outVO != null){
			if(outVO.getPasswd().equals(vo.getPasswd())){
				LOG.debug("로그인 성공!");
				return outVO;
			}else{		
				LOG.debug("비번이 틀립니다.");
				return null;
			}
		}else{
			LOG.debug("아이디가 존재하지 않습니다.");
			return null;
		}
		
	}
	
	@Override
	public int do_insert(DTO dto) {
		MemberVO vo = (MemberVO) dto;               
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try{
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1.conn:"+conn);
			StringBuilder sb = new StringBuilder();
			sb.append(" INSERT INTO member(  \n");
			sb.append(" 	user_id,         \n");
			sb.append(" 	passwd,          \n");
			sb.append(" 	name,            \n");
			sb.append(" 	email,           \n");
			sb.append(" 	resident_no,     \n");
			sb.append(" 	cell_phone,      \n");
			sb.append(" 	point,           \n");
			sb.append(" 	lvl,		     \n");
			sb.append(" 	reg_id,          \n");
			sb.append(" 	reg_dt,          \n");
			sb.append(" 	mod_id,          \n");
			sb.append(" 	mod_dt           \n");
			sb.append(" ) VALUES(?,          \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 0,          \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 SYSDATE,    \n");
			sb.append(" 		 ?,          \n");
			sb.append(" 		 SYSDATE     \n");
			sb.append(" 		 )           \n");
			LOG.debug("2.sql:\n"+sb.toString());
			LOG.debug("3.param:"+vo.toString());
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getUserId());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getEmail());
			pstmt.setString(5, vo.getResidentNo());
			pstmt.setString(6, vo.getCellPhone());
			pstmt.setString(7, vo.getLvl());
			pstmt.setString(8, vo.getRegId());
			pstmt.setString(9, vo.getModId());
			flag = pstmt.executeUpdate();
			LOG.debug("4.flag:"+flag);
		}catch(SQLException e){
			LOG.debug("===============================");
			LOG.debug(e.toString());
			LOG.debug("===============================");
		}finally{
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return flag;
	}

	
	@Override
	public int do_update(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		StringBuilder sb = new StringBuilder();
		sb.append(" UPDATE member        \n");
		sb.append(" SET name 		= ?,  \n");
		sb.append("     lvl 		= ?,  \n");
		sb.append(" 	email 		= ?,  \n");
		sb.append(" 	cell_phone  = ?,  \n");
		sb.append(" 	mod_id 		= ?, \n");
		sb.append(" 	passwd 		= ?	 \n");
		sb.append(" WHERE                \n");
		sb.append("     user_id = ?      \n");
		
		try{
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1=========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1=========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			//query param Set
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getLvl());
			pstmt.setString(3, vo.getEmail());
			pstmt.setString(4, vo.getCellPhone());
			pstmt.setString(5, vo.getModId());
			pstmt.setString(6, vo.getPasswd());
			pstmt.setString(7, vo.getUserId());
			LOG.debug("2=========================");
			LOG.debug("param:"+vo);
			LOG.debug("2=========================");
			flag = pstmt.executeUpdate();
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}		
		return flag;
	}

	
	@Override
	public int do_delete(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		int flag = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(" DELETE FROM member  \n");
		sb.append(" WHERE user_id = ?   \n");
		
		try{
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1=========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1=========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			//query param Set
			pstmt.setString(1, vo.getUserId());
			LOG.debug("2=========================");
			LOG.debug("param:"+vo);
			LOG.debug("2=========================");
			flag = pstmt.executeUpdate();
		}catch(SQLException e){
			flag = 20;
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return flag;
	}

	/**
	 * 제어용 검색
	 */
	@Override
	public MemberVO do_selectOne(DTO dto) {
		MemberVO vo = (MemberVO) dto;
		MemberVO outVO = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try{
			StringBuilder sb = new StringBuilder();
			sb.append(" SELECT             \n");
			sb.append("     user_id,       \n");
			sb.append("     passwd,        \n");
			sb.append("     name,          \n");
			sb.append("     email,         \n");
			sb.append("     resident_no,   \n");
			sb.append("     cell_phone,    \n");
			sb.append("     point,         \n");
			sb.append("     lvl,           \n");
			sb.append("     reg_id,        \n");
			sb.append("     reg_dt,        \n");
			sb.append("     mod_id,        \n");
			sb.append("     mod_dt         \n");
			sb.append(" FROM               \n");
			sb.append("     member         \n");
			sb.append(" WHERE user_id = ?  \n");
			conn = new ConnectionMaker().getConnection();
			LOG.debug("1=========================");
			LOG.debug("query:\n"+sb.toString());
			LOG.debug("1=========================");
			
			pstmt = conn.prepareStatement(sb.toString());
			pstmt.setString(1, vo.getUserId());
			LOG.debug("2=========================");
			LOG.debug("2.param:"+vo);
			LOG.debug("2=========================");
			LOG.debug(rs);
			rs = pstmt.executeQuery();
			LOG.debug(rs);
			if(rs.next()){
				outVO = new MemberVO();				
				outVO.setUserId(rs.getString("user_id"));
				outVO.setPasswd(rs.getString("passwd"));
				outVO.setName(rs.getString("name"));
				outVO.setEmail(rs.getString("email"));
				outVO.setResidentNo(rs.getString("resident_no"));
				outVO.setCellPhone(rs.getString("cell_phone"));
				outVO.setPoint(rs.getString("point"));
				outVO.setLvl(rs.getString("lvl"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setModId(rs.getString("mod_id"));
				outVO.setModDt(rs.getString("mod_dt"));					
			}
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}
		return outVO;
	}

	
	@Override
	public List<MemberVO> do_retrieve(DTO dto) {
		SearchVO vo = (SearchVO) dto;
		List<MemberVO> list = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//검색 query
		StringBuilder sbWhere = new StringBuilder();
		//전체=기본,이름=10,이메일=20,아이디=30
		if(null != vo.getSearchDiv()){
			if("10".equals(vo.getSearchDiv())){
				sbWhere.append("WHERE name like ?||'%' \n");				
			}else if("20".equals(vo.getSearchDiv())){
				sbWhere.append("WHERE email like ?||'%' \n");				
			}else if("30".equals(vo.getSearchDiv())){
				sbWhere.append("WHERE user_id like ?||'%' \n");				
			}else if("".equals(vo.getSearchDiv())){
				sbWhere.append("WHERE name like ?||'%' \n");
				sbWhere.append("OR email like ?||'%' \n");	
				sbWhere.append("OR user_id like ?||'%' \n");
			}			
		}
		LOG.debug("1=========================");
		LOG.debug("1.Search:"+vo);
		LOG.debug("1=========================");
		
		//main query
		StringBuilder sb = new StringBuilder();
		sb.append(" SELECT T1.*,T2.*                             \n");
		sb.append(" FROM                                         \n");
		sb.append(" (                                            \n");
		sb.append(" 	SELECT B.rnum as num,                    \n");
		sb.append("            B.user_id,                        \n");
		sb.append("            B.passwd,                         \n");
		sb.append("            B.name,                           \n");
		sb.append("            B.email,                          \n");
		sb.append("            B.resident_no,                    \n");
		sb.append("            B.cell_phone,                     \n");
		sb.append("            B.point,                          \n");
		sb.append("            B.lvl,                            \n");
		sb.append("            B.reg_id,                         \n");
		sb.append("            B.reg_dt,                         \n");
		sb.append("            B.mod_id,                         \n");
		sb.append("            B.mod_dt                          \n");
		sb.append(" 	FROM(                                    \n");
		sb.append(" 			SELECT ROWNUM AS rnum            \n");
		sb.append(" 				  ,A.*                       \n");
		sb.append(" 			FROM(                            \n");
		sb.append(" 				SELECT *                     \n");
		sb.append(" 				FROM member a                \n");		
		//검색어------------------------------------------------------------------------------------------
		sb.append(sbWhere.toString());
		//정렬조건-----------------------------------------------------------------------------------------
		//인덱스
		//----------------------------------------------------------------------------------------------
		sb.append(" 				)A                           \n");
		sb.append("             WHERE ROWNUM <=(?*(?-1)+?)	)B   \n");
		sb.append(" 	WHERE rnum >=(?*(?-1)+1)                 \n");
		sb.append(" )T1	CROSS JOIN                               \n");
		sb.append(" (                                            \n");
		sb.append(" 	SELECT COUNT(*) total_cnt                \n");
		sb.append(" 	FROM member a                            \n");
		//검색어------------------------------------------------------------------------------------------		
		sb.append(sbWhere.toString());
		//----------------------------------------------------------------------------------------------
		sb.append(" )T2                                          \n");
		LOG.debug("2=========================");
		LOG.debug("query:\n"+sb.toString());
		LOG.debug("2=========================");
		
		try{
			conn = new ConnectionMaker().getConnection();
			pstmt = conn.prepareStatement(sb.toString());
			if(null != vo.getSearchDiv()){
				if("".equals(vo.getSearchDiv())){
					LOG.debug("검색조건이 전체일 때");
					pstmt.setString(1,vo.getSearchWord());
					pstmt.setString(2,vo.getSearchWord());
					pstmt.setString(3,vo.getSearchWord());
					pstmt.setInt(4, vo.getPageSize());
					pstmt.setInt(5, vo.getPageNum());
					pstmt.setInt(6, vo.getPageSize());
					pstmt.setInt(7, vo.getPageSize());
					pstmt.setInt(8, vo.getPageNum());
					pstmt.setString(9,vo.getSearchWord());
					pstmt.setString(10,vo.getSearchWord());
					pstmt.setString(11,vo.getSearchWord());
				}else{
					LOG.debug("검색조건이 그 외");
					pstmt.setString(1,vo.getSearchWord());
					pstmt.setInt(2, vo.getPageSize());
					pstmt.setInt(3, vo.getPageNum());
					pstmt.setInt(4, vo.getPageSize());
					pstmt.setInt(5, vo.getPageSize());
					pstmt.setInt(6, vo.getPageNum());
					pstmt.setString(7,vo.getSearchWord());
				}				
			}
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				MemberVO outVO = new MemberVO();
				outVO.setNum(rs.getInt("num"));
				outVO.setUserId(rs.getString("user_id"));
				outVO.setPasswd(rs.getString("passwd"));
				outVO.setName(rs.getString("name"));
				outVO.setEmail(rs.getString("email"));
				outVO.setResidentNo(rs.getString("resident_no"));
				outVO.setCellPhone(rs.getString("cell_phone"));
				outVO.setPoint(rs.getString("point"));
				outVO.setLvl(rs.getString("lvl"));
				outVO.setRegId(rs.getString("reg_id"));
				outVO.setRegDt(rs.getString("reg_dt"));
				outVO.setModId(rs.getString("mod_id"));
				outVO.setModDt(rs.getString("mod_dt"));
				outVO.setTotal(rs.getInt("total_cnt"));
				list.add(outVO);
				LOG.debug(list);
			}
		}catch(SQLException e){
			LOG.debug("=========================");
			LOG.debug("SQLException:"+e.toString());
			LOG.debug("=========================");
		}finally{
			JDBCReturnReso.close(rs);			
			JDBCReturnReso.close(pstmt);
			JDBCReturnReso.close(conn);
		}	
		
		return list;
	}

}
