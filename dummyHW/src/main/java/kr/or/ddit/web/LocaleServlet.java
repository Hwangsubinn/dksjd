package kr.or.ddit.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Locale clientLocale = req.getLocale();
		Locale serverLocale = Locale.getDefault();// 이 데이터를 
		
	//	data를 가공하면  -> impomation -> contents 
		
		String clientLocaleText = clientLocale.getDisplayName(clientLocale); // 최종 사용자가 클리이언ㅌ크라 클리아이언ㅌ크 용어로 사용되어야해서 
		String serverLocaleText = clientLocale.getDisplayName(clientLocale); // 임포메이션 해주는거야 
	StringBuilder content = new StringBuilder();
	
	// 그리고 여기가 컨텐츠가 된다. 
	content.append("<html>");
	content.append("<body>");
	content.append(MessageFormat.format("<h4>client side licale : {0}</h4>", serverLocaleText));
	content.append(MessageFormat.format("<h4>client side licale : {0}</h4>", clientLocaleText));//{} 이거를 아규먼트 라고 불러 여러개 부르고 싶으면 {0},{2} 이런식으로 인덱스를 넣어줘 
	
	content.append("</body>");
	content.append("</html>");
	
	String mime = "text/html;charset=UTF-8";
	
	
	resp.setContentType(mime);
	
	PrintWriter out = resp.getWriter();
	out.print(content);
	out.close();

	}
}
