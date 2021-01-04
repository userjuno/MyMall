package daction;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dsvc.DogRegistService;
import dvo.ActionForward;
import dvo.Dog;
import dsvc.DogPayService;
import dsvc.DogViewService;
import dvo.OrderBean;

public class DogPayAction implements Action {

	

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		DogRegistService dogRegistService = new DogRegistService();
		
		String realFolder = "";
		
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request,
				realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		
		HttpSession session = request.getSession();
		String id = (String)session.getAttribute("id");
		String a=multi.getParameter("orderer_name");
		System.out.println("주문자 이름 :" +a);
		String b=multi.getParameter("orderer_call");
		System.out.println("연락처 : "+b);
		String c=multi.getParameter("zipcode");
		System.out.println("우편번호 :" + c);
		String d=multi.getParameter("address");
		System.out.println("주소 : " +d);
		String e=multi.getParameter("addr_more");
		System.out.println("상세주소 : " +e);
		String f=multi.getParameter("memo");
		System.out.println("메모 : " +f);
		String g=multi.getParameter("item_name");
		System.out.println("상품 이름 : " +g);
		int h=Integer.parseInt(multi.getParameter("item_price"));
		System.out.println("가격 : " +h);
		int i=Integer.parseInt(multi.getParameter("pay_count"));
		System.out.println("수량 : "+i);
		String j=multi.getParameter("dog_img");
		System.out.println("이미지 : "+ j);
		OrderBean dog = new OrderBean(
				0,
				g,
				a,
				d,
				e,
				c,
				b,
				f,
				h,
				0,
				i,
				j,
				id
				);
				
	
		
		DogPayService dogPayService = new DogPayService();
	
		ActionForward forward = null;
		boolean isRegistSucess = dogPayService.registDog(dog);
		request.setAttribute("dog", dog);
		if(isRegistSucess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('구매 완료 상품 리스트로 이동합니다.');");
			out.println("history.back();");
			out.println("</script>");
			forward = new ActionForward("dogList.dog",true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('실패');");
			out.println("history.back();");
			out.println("</script>");
		}
		
		return forward;
	}

}
