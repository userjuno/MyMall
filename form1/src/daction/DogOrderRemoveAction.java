package daction;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dsvc.DogCartQtyDownService;
import dsvc.DogCartRemoveService;
import dsvc.DogOrderRemoveService;
import dvo.ActionForward;

public class DogOrderRemoveAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String[] kind = request.getParameterValues("remove");
		if(kind==null || kind.length<=0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('물품을 선택해 주세요');");
			out.println("history.back();");
			out.println("</script>");
		}
		System.out.println(kind.length);
		boolean isRegistSucess = false;
		System.out.println("kind : "+kind);
		HttpSession session = request.getSession();
		
		String sId = (String)session.getAttribute("id");
		System.out.println("sId : "+sId);
		DogOrderRemoveService DIO = new DogOrderRemoveService();
		for(int i=0;i<kind.length;i++) {
			System.out.println("kind : "+kind[i]);
			isRegistSucess = DIO.CartReMoveDog(kind[i],sId);
			
			
		}
		
		
		ActionForward forward = null;
		
		if(isRegistSucess) {
			forward = new ActionForward("dogOrderList.dog", true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('구매 취소기간이 지나 취소 할 수 없습니다.');");
			out.println("</script>");
		}
		return forward;
	}
	
}