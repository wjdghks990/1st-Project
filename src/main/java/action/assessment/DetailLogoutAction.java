package action.assessment;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AssessmentDao;
import db.vo.AssessmentVo;

/**
 * Servlet implementation class MemberLogoutAction
 */
@WebServlet("/member/detaillogout.do")
public class DetailLogoutAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String a_cate = request.getParameter("a_cate");
		
		List<AssessmentVo> list = AssessmentDao.getInstance().selectOne(a_cate);
		
		// Dispatcher형식으로 호출
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		// 로그아웃이 완료되면 parameter를 넘겨준다.
		String forward_page = "../detail/de-"+a_cate+".jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);
	}

}