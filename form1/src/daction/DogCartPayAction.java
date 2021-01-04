package daction;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


import dsvc.DogPayService;
import dvo.ActionForward;
import dvo.Cart;
import dvo.OrderBean;

public class DogCartPayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("UTF-8");
		boolean isRegistSucess = false;
		String realFolder = "";
		
		String saveFolder = "/images";
		String encType = "UTF-8";
		int maxSize = 5*1024*1024;
		
		ServletContext context = request.getServletContext();
		realFolder = context.getRealPath(saveFolder);
		
		MultipartRequest multi = new MultipartRequest(request,
				realFolder, maxSize, encType,
				new DefaultFileRenamePolicy());
		String zin = multi.getParameter("gg");
		System.out.println("진진짜라 : " +zin);
		String[] kind = multi.getParameterValues("remove");
		String[] img =multi.getParameterValues("dog_img");
		
		if(kind==null || kind.length<=0) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('물품을 선택해 주세요');");
			out.println("history.back();");
			out.println("</script>");
		}
		else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('구매 목록 페이지로 이동합니다');");
			out.println("</script>");
		}
		System.out.println("꿰뚫어라 사사성광 : " +kind);
		
		
		DogPayService dogPayService = new DogPayService();
		for(int i=0;i<kind.length;i++) {
			System.out.println("kind : "+kind[i]);
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
			String g=kind[i];
			System.out.println("상품 이름 : " +g);
			int h=Integer.parseInt(multi.getParameter("item_price"));
			System.out.println("가격 : " +h);
			int ia=Integer.parseInt(multi.getParameter("pay_count"));
			System.out.println("수량 : "+ia);
			String j=img[i];
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
					ia,
					j,
					id
					);
					
		
			
			
		
			isRegistSucess = dogPayService.registDog(dog);
			request.setAttribute("dog", dog);
			
		}
		
		
		ActionForward forward = null;
	
		
		if(isRegistSucess) {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('구매 완료 상품 리스트로 이동합니다.');");
			out.println("</script>");
			forward = new ActionForward("dogOrderList.dog",true);
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