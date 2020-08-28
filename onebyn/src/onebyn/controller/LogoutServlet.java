package onebyn.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;

import onebyn.common.listener.MemberListener;
import onebyn.common.listener.Ml;
import onebyn.model.vo.Member;

@WebServlet("/logout.do")
public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = -4361645753791708636L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = req.getSession();
		Member m = (Member)session.getAttribute("m");
		
//		session.invalidate();//현재 세션 삭제
		MemberListener ml = new MemberListener();
//		Ml ml = new Ml();
		ml.removeSession(m.getId());
		
		resp.sendRedirect(req.getContextPath()+"/board.do");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
}
