package action.member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDao;
import db.vo.MemberVo;

/**
 * Servlet implementation class MemberCheckIdAction
 */
@WebServlet("/member/check_id.do")
public class MemberCheckIdAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		String mem_id = request.getParameter("mem_id");
		
		MemberVo vo = MemberDao.getInstance().selectOne(mem_id);
		// vo에 null 값은 중복된 id가 없다는 것이기 때문에 true를 반환하면 된다.
		Boolean bResult = (vo==null);
		
		response.setContentType("application/json; charset=utf-8;");
		
		PrintWriter out = response.getWriter();
		
		String json = String.format("{\"result\": %b}", bResult);
		out.print(json);
	}

}