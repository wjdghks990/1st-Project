package action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import dao.CommentDao;
import db.vo.BoardVo;
import db.vo.CommentVo;

/**
 * Servlet implementation class TitleReplyListAction
 */
@WebServlet("/boardming/postlist.do")
public class TitlePostListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		int res = BoardDao.getInstance().updateCount(c_idx);
				
		// 게시글 하나 vo에 담기
		BoardVo commu = BoardDao.getInstance().selectcommuOne(c_idx);

		
		// TODO : BoardDao 메소드 만들어서 count = count +1 하는 쿼리문 날리기. 쿼리문 : update commu set c_incount= c_incount + 1 where c_idx+ = ?;
		
		// 가져온 게시글 해당하는 댓글들 리스트에 담기
		List<CommentVo> commentList = CommentDao.getInstance().selectCommentList(c_idx);
		
		//request binding
		request.setAttribute("commu", commu);
		request.setAttribute("commentList", commentList);
		
		// 댓글 리스트  request에 set하기
		
		
		//Dispatcher 형식으로 호출
		String forward_page = "comment.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);
	}

}