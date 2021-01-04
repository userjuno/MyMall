package daction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsvc.DogCartAddService;
import dsvc.DogCartQtyDownService;
import dsvc.DogCartQtyUpService;
import dvo.ActionForward;

public class DogCartQtyDownAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String kind = (String)request.getParameter("kind");
		System.out.println("kind : "+kind);
		DogCartQtyDownService dCQU = new  DogCartQtyDownService();
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("id");
		System.out.println("sId : "+sId);
		boolean isRegistSucess = dCQU.CartDown(kind,sId);
		
		ActionForward forward = null;
		
		if(isRegistSucess) {
			forward = new ActionForward("dogCartList.dog", true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('실패');");
			out.println("</script>");
		}
		return forward;
	}

}
