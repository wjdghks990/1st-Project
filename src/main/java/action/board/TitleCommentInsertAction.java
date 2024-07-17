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
 * Servlet implementation class TitleCommentInsertAction
 */
@WebServlet("/boardming/commentinsert.do")
public class TitleCommentInsertAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		//로그인 상태 체크
		HttpSession session = request.getSession();
		//로그인 유저 정보 얻어오기
		MemberVo user = (MemberVo) session.getAttribute("user");
		
		
		// 세션만료
		if (user == null) {
			response.sendRedirect("../member/login_form.do?reason=session_timeout");
			System.out.println("user is null");
			return;
		}
		
		int c_idx 			= Integer.parseInt(request.getParameter("c_idx"));
		int mem_idx 		= Integer.parseInt(request.getParameter("mem_idx"));
		String mem_nickname = request.getParameter("mem_nickname");
		String cmt_content  = request.getParameter("cmt_content").replaceAll("\n", "<br>");
	
		CommentVo vo = new CommentVo(c_idx, mem_idx, mem_nickname, cmt_content);
		
		int res = CommentDao.getInstance().insert(vo);
		response.sendRedirect("postlist.do?c_idx=" + c_idx);
				
		
		
	}

}