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
 * Servlet implementation class TitleUpdateAction
 */
@WebServlet("/boardming/update.do")
public class TitleUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//로그인 상태 체크
		HttpSession session = request.getSession();
		//로그인 유저 정보 얻어오기
		MemberVo loginUser = (MemberVo) session.getAttribute("user");
		
		if(loginUser==null) {
			
			
			response.sendRedirect("../member/login_form.do?reason=session_timeout");
        }
		
		
		request.setCharacterEncoding("UTF-8");
		int	c_idx 		 = Integer.parseInt(request.getParameter("c_idx"));
		String c_title 	 = request.getParameter("c_title");
		String c_content = request.getParameter("c_content").replaceAll("\n", "<br>");
		String c_category= request.getParameter("c_category");
		// 세션에서 로그인된 유저정보 가져오기
		//int mem_idx 	    = loginUser.getMem_idx();
		//String mem_nickname = loginUser.getMem_nickname();
		BoardVo vo = new BoardVo(c_idx, c_title, c_content, c_category);
		
		int res = BoardDao.getInstance().update(vo);
		
		
		
		response.sendRedirect("sublist.do");
		
	}

}