package daction;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dsvc.DogViewService;
import dvo.ActionForward;
import dvo.Dog;

public class DogPayFormAction implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		DogViewService dogViewService = new DogViewService();
		int id = Integer.parseInt(request.getParameter("id"));
		System.out.println("패이 폼 아이디 : " + id);
		Dog dog = dogViewService.getDogView(id);
		request.setAttribute("dog", dog);
		
		ActionForward forward = new ActionForward("dogPay.jsp", false);
		return forward;
	}

}
