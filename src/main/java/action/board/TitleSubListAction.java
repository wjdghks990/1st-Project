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
 * Servlet implementation class VisitListAction
 */
@WebServlet("/boardming/sublist.do")
public class TitleSubListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 방명록 데이터 가져오기

		List<BoardVo> list = BoardDao.getInstance().selectList();

		//request binding
		request.setAttribute("list", list);

		//Dispatcher 형식으로 호출
		String forward_page = "g_commu.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);
	}

}