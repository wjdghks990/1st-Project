package action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;

/**
 * Servlet implementation class TitleDeleteAction
 */
@WebServlet("/boardming/delete.do")
public class TitleDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	int c_idx = Integer.parseInt(request.getParameter("c_idx"));
	
	int res = BoardDao.getInstance().delete(c_idx);
	
	response.sendRedirect("sublist.do");
	
		
	}
}
