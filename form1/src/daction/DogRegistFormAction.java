package daction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dvo.ActionForward;

public class DogRegistFormAction implements Action {

	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward("dogRegistForm.jsp",false);
				
		return forward;
	}

}
