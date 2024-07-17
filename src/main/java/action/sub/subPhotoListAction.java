package action.sub;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.subPhotoDao;
import db.vo.subPhotoVo;

/**
 * Servlet implementation class subPhotoListAction
 */
@WebServlet("/photo/list.do")
public class subPhotoListAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		List<subPhotoVo> list = subPhotoDao.getInstance().selectList();
		
		request.setAttribute("list", list);

		//Dispatcher형식으로 호출
		String forward_page = "allGame.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}