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
import db.vo.BoardVo;

/**
 * Servlet implementation class TitleCommentListAction
 */
@WebServlet("/boardming/commentlist.do")
public class TitleCommentListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		List<BoardVo> list = BoardDao.getInstance().selectList();
		
		
		
		//Dispatcher 형식으로 호출
		String forward_page = "";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);
	}

}