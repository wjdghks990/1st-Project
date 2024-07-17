package action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import db.vo.MemberVo;

/**
 * Servlet implementation class MemberModifyFormAction
 */
@WebServlet("/member/modify_form.do")
public class MemberModifyFormAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// /member/modify_form?mem_idx=10
		int mem_idx = Integer.parseInt(request.getParameter("mem_idx"));
		MemberVo vo = MemberDao.getInstance().selectOne(mem_idx);
		request.setAttribute("vo", vo);

		// Dispatcher형식으로 호출
		String forward_page = "member_modify_form.jsp";
		RequestDispatcher disp = request.getRequestDispatcher(forward_page);
		disp.forward(request, response);

	}

}