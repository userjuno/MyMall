package mgraction;

import javax.servlet.http.*;

import mgrvo.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
