package action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CommentDao;
import db.vo.CommentVo;
import db.vo.MemberVo;

/**
 * Servlet implementation class TitleCommentUpdateAction
 */
@WebServlet("/boardming/commentupdate.do")
public class TitleCommentUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 로그인 상태 체크
		HttpSession session = request.getSession();
		// 로그인 유저 정보 얻어오기
		MemberVo loginUser = (MemberVo) session.getAttribute("user");

		if (loginUser == null) {

			response.sendRedirect("../member/login_form.do?reason=session_timeout");

		} else {

			request.setCharacterEncoding("UTF-8");
			int c_idx = Integer.parseInt(request.getParameter("c_idx"));
			int cmt_idx = Integer.parseInt(request.getParameter("cmt_idx"));
			String cmt_content = request.getParameter("cmt_content");

			CommentVo vo = new CommentVo(cmt_idx, cmt_content);

			int res = CommentDao.getInstance().update(vo);
			if (res > 0) {
				response.sendRedirect("postlist.do?c_idx=" + c_idx);

			}
		}
	}

}