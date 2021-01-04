package action.copy;

import javax.servlet.http.*;

import uvo.ActionForward;

public interface Action {
	public ActionForward execute(HttpServletRequest request,HttpServletResponse response) throws Exception;
}
