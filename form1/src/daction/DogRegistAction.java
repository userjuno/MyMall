package daction;

import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dsvc.DogRegistService;
import dvo.ActionForward;
import dvo.Dog;

public class DogRegistAction implements Action {

	

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
		
		String image = multi.getFilesystemName("image");
		String a=multi.getParameter("item_name");
		System.out.println("아이템 네임 :" +a);
		String b=multi.getParameter("price");
		System.out.println("가격 : "+b);
		String c=multi.getParameter("made");
		System.out.println("원산지 :" + c);
		String d=multi.getParameter("category");
		System.out.println("카테고리 : " +d);
		String e=multi.getParameter("content");
		System.out.println("콘텐츠 : " +e);
		Dog dog = new Dog(
				0, 
				multi.getParameter("item_name"), 
				Integer.parseInt(multi.getParameter("price")), 
				image, 
				multi.getParameter("made"),
				multi.getParameter("category"), 
				0, 
				multi.getParameter("content"), 
				0);
		String a1 = dog.getCategory();
		String b1 = dog.getContent();
		String c1 = dog.getItem_name();
		String d1 = dog.getMade();
		int e1 = dog.getPrice();
		
		System.out.println("카테고리 : "+ a1);
		boolean isRegistSucess = dogRegistService.registDog(dog);
		
		ActionForward forward = null;
		
		if(isRegistSucess) {
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
