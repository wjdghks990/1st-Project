package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.CommentVo;
import service.DBService;

public class CommentDao {
	
	static CommentDao Single = null;

	public static CommentDao getInstance() {

		if (Single == null) {

			Single = new CommentDao();
		}

		return Single;
	}

	private CommentDao() {

	}
	
	
	public List<CommentVo> selectCommentList(int c_idx) {

		List<CommentVo> list = new ArrayList<CommentVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from cmt where c_idx = ? order by cmt_regdate desc";
		
		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement 얻어오기 (미리 sql문을 준비)
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c_idx);
			
			// 3. ResultSet 얻어오기 (조회하는 과정)
			rs = pstmt.executeQuery();

			while (rs.next()) {

				//저장객체 생성 -> 레코드 에서 읽은 값을 넣는다.
				CommentVo vo = new CommentVo();

				//rs가 가리키는 레코드 값을 vo에 넣는다.	
				vo.setCmt_idx(rs.getInt("cmt_idx"));
				vo.setC_idx(rs.getInt("c_idx"));
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_nickname(rs.getString("mem_nickname"));
				vo.setCmt_content(rs.getString("cmt_content"));
				vo.setCmt_regdate(rs.getString("cmt_regdate"));
				list.add(vo);

			} // end:while

		} //end:try
		catch (Exception e) {
			e.printStackTrace();
		} //end:catch 

		finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} //end:try-catch

		} //end:finally

		return list;

	}//end:selectList
	
	public CommentVo selectCommentOne(int cmt_idx) { // 데이터를 한개만 조회하기 떄문에 Arraylist를 사용하지 않는다.

		CommentVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM cmt WHERE cmt_idx=?";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement 얻어오기 (미리 sql문을 준비)
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter index 채우기
			pstmt.setInt(1, cmt_idx); // 1번째 파라메터를 채운다

			// 4. ResultSet 얻어오기 (조회하는 과정)
			rs = pstmt.executeQuery();

			if (rs.next()) { // 어짜피 1번만 조회를 하기 때문에 굳이 while문을 사용 할 필요가 없다.

				//저장객체 생성 -> 레코드 에서 읽은 값을 넣는다.
				vo = new CommentVo();

				//rs가 가리키는 레코드 값을 vo에 넣는다.	
				vo.setCmt_idx(rs.getInt("cmt_idx"));
				vo.setC_idx(rs.getInt("c_idx"));
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_nickname(rs.getString("mem_nickname"));
				vo.setCmt_content(rs.getString("cmt_content"));
				vo.setCmt_regdate(rs.getString("cmt_regdate"));
			} // end:if

		} //end:try
		catch (Exception e) {
			e.printStackTrace();
		} //end:catch 

		finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} //end:try-catch

		} //end:finally

		return vo;

	}//end:selectList
	
	public CommentVo selectCommentCmt(int cmt_idx) { // 데이터를 한개만 조회하기 떄문에 Arraylist를 사용하지 않는다.

		CommentVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM cmt WHERE c_idx=?";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement 얻어오기 (미리 sql문을 준비)
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter index 채우기
			pstmt.setInt(1, cmt_idx); // 1번째 파라메터를 채운다

			// 4. ResultSet 얻어오기 (조회하는 과정)
			rs = pstmt.executeQuery();

			if (rs.next()) { // 어짜피 1번만 조회를 하기 때문에 굳이 while문을 사용 할 필요가 없다.

				//저장객체 생성 -> 레코드 에서 읽은 값을 넣는다.
				vo = new CommentVo();

				//rs가 가리키는 레코드 값을 vo에 넣는다.	
				vo.setCmt_idx(rs.getInt("cmt_idx"));
				vo.setC_idx(rs.getInt("c_idx"));
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_nickname(rs.getString("mem_nickname"));
				vo.setCmt_content(rs.getString("cmt_content"));
				vo.setCmt_regdate(rs.getString("cmt_regdate"));
			} // end:if

		} //end:try
		catch (Exception e) {
			e.printStackTrace();
		} //end:catch 

		finally {

			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} //end:try-catch

		} //end:finally

		return vo;

	}//end:selectList
	
	
	public int insert(CommentVo vo) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//			   	       	  parameter index -> 1  2  3  4
		String sql = "INSERT INTO cmt VALUES(seq_cmt_idx.nextval,?,?,?,?,DEFAULT)";

		try {
			// 1. Connect 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// 3. pstmt parameter index 채우기
			pstmt.setInt(1,vo.getC_idx());
			pstmt.setInt(2,vo.getMem_idx());
			pstmt.setString(3,vo.getMem_nickname());
			pstmt.setString(4,vo.getCmt_content());
			// 4. DB insert
			res = pstmt.executeUpdate();

		} //end:try

		catch (Exception e) {
			e.printStackTrace();
		} //end:catch 

		finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} //end:try-catch

		} //end:finally

		return res;
	}//end:insert
	
	public int update(CommentVo vo) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//			   	       	  parameter index -> 1  2  3  4
		String sql = "UPDATE cmt SET cmt_content = ?, cmt_regdate =sysdate  WHERE cmt_idx=?";

		try {
			// 1. Connect 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// 3. pstmt parameter index 채우기
			pstmt.setString(1,vo.getCmt_content());
			pstmt.setInt(2,vo.getCmt_idx());
			// 4. DB update
			res = pstmt.executeUpdate();

		} //end:try

		catch (Exception e) {
			e.printStackTrace();
		} //end:catch 

		finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} //end:try-catch

		} //end:finally

		return res;
	}//end:update
	
	public int delete(int cmt_idx) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//			   	       	  parameter index -> 1  2  3  4
		String sql = "DELETE FROM cmt WHERE cmt_idx=?";

		try {
			// 1. Connect 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// 3. pstmt parameter index 채우기
			pstmt.setInt(1,cmt_idx);
			// 4. DB delete
			res = pstmt.executeUpdate();

		} //end:try

		catch (Exception e) {
			e.printStackTrace();
		} //end:catch 

		finally {

			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} //end:try-catch

		} //end:finally

		return res;
	}//end:delete
	
}
