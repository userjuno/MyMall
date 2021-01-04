package daction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsvc.DogCartAddService;
import dvo.ActionForward;
import dvo.Dog;

public class DogCartAddAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DogCartAddService dogCartAddService = new DogCartAddService();
		String kind = (String)request.getParameter("id");
		System.out.println("kind : "+kind);
		String sId = (String)request.getParameter("b");
		System.out.println("sId : "+sId);
		boolean isRegistSucess = dogCartAddService.CartAddDog(kind,sId);
		
		ActionForward forward = null;
		
		if(isRegistSucess) {
			forward = new ActionForward("dogCartList.dog?"+sId, true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('실패')");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}
		


}
