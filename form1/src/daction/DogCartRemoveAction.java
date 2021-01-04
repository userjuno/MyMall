package daction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsvc.DogCartQtyDownService;
import dsvc.DogCartRemoveService;
import dvo.ActionForward;

public class DogCartRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String zin = request.getParameter("gg");
		System.out.println("진진짜라 : " +zin);
		String[] kind = request.getParameterValues("remove");
		String zebal = request.getParameter("item_price");
		System.out.println("젭라: " +zebal);
		if(kind==null || kind.length<=0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('물품을 선택해 주세요');");
			out.println("history.back();");
			out.println("</script>");
		}
		/* System.out.println("꿰뚫어라 사사성광 : " +kind.length); */
		boolean isRegistSucess = false;
		/* System.out.println("kind : "+kind); */
		HttpSession session= request.getSession();
	
		String sId = (String)session.getAttribute("id");
		System.out.println("sId : "+sId);
		
		DogCartRemoveService DCRS = new DogCartRemoveService();
		for(int i=0;i<kind.length;i++) {
			System.out.println("kind : "+kind[i]);
			isRegistSucess = DCRS.CartReMoveDog(kind[i],sId);
			
			
		}
		
		
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