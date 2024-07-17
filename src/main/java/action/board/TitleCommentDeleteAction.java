package action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CommentDao;

/**
 * Servlet implementation class TitleCommentDeleteAction
 */
@WebServlet("/boardming/commentdelete.do")
public class TitleCommentDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int cmt_idx = Integer.parseInt(request.getParameter("cmt_idx"));
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		
		
		
		int res = CommentDao.getInstance().delete(cmt_idx);
		
		response.sendRedirect("postlist.do?c_idx="+c_idx);
	}

}
