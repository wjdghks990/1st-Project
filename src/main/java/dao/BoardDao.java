package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.vo.BoardVo;
import service.DBService;

public class BoardDao {
	
	static BoardDao Single = null;

	public static BoardDao getInstance() {

		if (Single == null) {

			Single = new BoardDao();
		}

		return Single;
	}

	private BoardDao() {

	}

	public List<BoardVo> selectList() {

		List<BoardVo> list = new ArrayList<BoardVo>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM commu_view";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement 얻어오기 (미리 sql문을 준비)
			pstmt = conn.prepareStatement(sql);

			// 3. ResultSet 얻어오기 (조회하는 과정)
			rs = pstmt.executeQuery();

			while (rs.next()) {

				//저장객체 생성 -> 레코드 에서 읽은 값을 넣는다.
				BoardVo vo = new BoardVo();

				//rs가 가리키는 레코드 값을 vo에 넣는다.	
				vo.setC_idx(rs.getInt("c_idx"));
				vo.setC_no(rs.getInt("c_no"));
				vo.setC_title(rs.getString("c_title"));
				vo.setC_content(rs.getString("c_content"));
				vo.setC_regdate(rs.getString("c_regdate"));
				vo.setC_category(rs.getString("c_category"));
				vo.setC_inCount(rs.getInt("c_inCount"));
				vo.setC_reply(rs.getString("c_reply"));
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_nickname(rs.getString("mem_nickname"));
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

	public BoardVo selectOne(int c_no) { // 데이터를 한개만 조회하기 떄문에 Arraylist를 사용하지 않는다.

		BoardVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM commu_view WHERE c_idx=?";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement 얻어오기 (미리 sql문을 준비)
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter index 채우기
			pstmt.setInt(1, c_no); // 1번째 파라메터를 채운다

			// 4. ResultSet 얻어오기 (조회하는 과정)
			rs = pstmt.executeQuery();

			if (rs.next()) { // 어짜피 1번만 조회를 하기 때문에 굳이 while문을 사용 할 필요가 없다.

				//저장객체 생성 -> 레코드 에서 읽은 값을 넣는다.
				vo = new BoardVo();

				//rs가 가리키는 레코드 값을 vo에 넣는다.	
				vo.setC_idx(rs.getInt("c_idx"));
				vo.setC_no(rs.getInt("c_no"));
				vo.setC_title(rs.getString("c_title"));
				vo.setC_content(rs.getString("c_content"));
				vo.setC_regdate(rs.getString("c_regdate"));
				vo.setC_category(rs.getString("c_category"));
				vo.setC_inCount(rs.getInt("c_inCount"));
				vo.setC_reply(rs.getString("c_reply"));
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_nickname(rs.getString("mem_nickname"));
				

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
	
	public BoardVo selectcommuOne(int c_idx) { // 데이터를 한개만 조회하기 떄문에 Arraylist를 사용하지 않는다.

		BoardVo vo = null;

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "SELECT * FROM commu_view WHERE c_idx=?";

		try {
			// 1. Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			// 2. PreparedStatement 얻어오기 (미리 sql문을 준비)
			pstmt = conn.prepareStatement(sql);

			// 3.pstmt parameter index 채우기
			pstmt.setInt(1, c_idx); // 1번째 파라메터를 채운다

			// 4. ResultSet 얻어오기 (조회하는 과정)
			rs = pstmt.executeQuery();

			if (rs.next()) { // 어짜피 1번만 조회를 하기 때문에 굳이 while문을 사용 할 필요가 없다.

				//저장객체 생성 -> 레코드 에서 읽은 값을 넣는다.
				vo = new BoardVo();

				//rs가 가리키는 레코드 값을 vo에 넣는다.	
				vo.setC_idx(rs.getInt("c_idx"));
				vo.setC_no(rs.getInt("c_no"));
				vo.setC_title(rs.getString("c_title"));
				vo.setC_content(rs.getString("c_content"));
				vo.setC_regdate(rs.getString("c_regdate"));
				vo.setC_category(rs.getString("c_category"));
				vo.setC_inCount(rs.getInt("c_inCount"));
				vo.setC_reply(rs.getString("c_reply"));
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_nickname(rs.getString("mem_nickname"));
				
				

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
	
	
	
	public int insert(BoardVo vo) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//			   	       	  parameter index -> 1  2  3  4
		String sql = "INSERT INTO commu VALUES(seq_commu_idx.nextVal,?,?,DEFAULT,?,DEFAULT,DEFAULT,?,?)";

		try {
			// 1. Connect 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// 3. pstmt parameter index 채우기
			pstmt.setString(1,vo.getC_title());
			pstmt.setString(2,vo.getC_content());
			pstmt.setString(3,vo.getC_category());
			pstmt.setInt(4,vo.getMem_idx());
			pstmt.setString(5,vo.getMem_nickname());
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

	public int delete(int c_idx) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//			   	       	  parameter index -> 1  2  3  4
		String sql = "DELETE FROM commu WHERE c_idx=?";

		try {
			// 1. Connect 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// 3. pstmt parameter index 채우기
			pstmt.setInt(1,c_idx);
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

	public int update(BoardVo vo) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//			   	       	  parameter index -> 1  2  3  4
		String sql = "UPDATE commu SET c_title = ?, c_content = ?,c_category =? WHERE c_idx=?";

		try {
			// 1. Connect 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// 3. pstmt parameter index 채우기
			pstmt.setString(1,vo.getC_title());
			pstmt.setString(2,vo.getC_content());
			pstmt.setString(3,vo.getC_category());
			pstmt.setInt(4, vo.getC_idx());
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

	
	public int updateCount(int c_idx) {

		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		//			   	       	  parameter index -> 1  2  3  4
		String sql = "UPDATE commu SET c_inCount = c_inCount + 1 WHERE c_idx=?";

		try {
			// 1. Connect 얻어오기
			conn = DBService.getInstance().getConnection();
			// 2. PreparedStatement
			pstmt = conn.prepareStatement(sql);
			// 3. pstmt parameter index 채우기
			pstmt.setInt(1,c_idx);
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
	

}
