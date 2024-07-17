package action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.BoardDao;
import db.vo.BoardVo;
import db.vo.MemberVo;

/**
 * Servlet implementation class TitleInsertAction
 */
@WebServlet("/boardming/insert.do")
public class TitleInsertAction extends HttpServlet {
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
			return;
		}
		
		// 유저정보 얻어오기
		String c_title 	 = request.getParameter("c_title");
		String c_content = request.getParameter("c_content").replaceAll("\n", "<br>");
		String c_category= request.getParameter("c_category");
		int mem_idx 	 = Integer.parseInt(request.getParameter("mem_idx"));
		String mem_nickname  = request.getParameter("mem_nickname");
		
		
	//	String c_ip = request.getRemoteAddr();
		
		BoardVo vo = new BoardVo(c_title, c_content, c_category ,mem_idx, mem_nickname);
		
		int res = BoardDao.getInstance().insert(vo);
		
		response.sendRedirect("../boardming/sublist.do");
		
		
		
	}
}