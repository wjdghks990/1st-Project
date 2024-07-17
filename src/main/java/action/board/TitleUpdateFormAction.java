package action.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import db.vo.BoardVo;

/**
 * Servlet implementation class TitleUpdateFormAction
 */
@WebServlet("/boardming/update_form.do")
public class TitleUpdateFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int c_idx = Integer.parseInt(request.getParameter("c_idx"));
		BoardVo vo = BoardDao.getInstance().selectOne(c_idx);
		request.setAttribute("vo", vo);
		
		
		//Dispatcher 형식으로 호출
		String forward_page = "title_update_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);

		disp.forward(request, response);
	}

}