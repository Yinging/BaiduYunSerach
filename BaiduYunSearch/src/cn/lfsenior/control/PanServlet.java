package cn.lfsenior.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.service.util.uri.GetPageUriStr;
import cn.lfsenior.service.util.uri.GetPanUri;

public class PanServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//最后传递的连接
		String uri="http://www.baidu.com";
		String strURL=request.getParameter("searchURL");
		uri=GetPanUri.getPanUri(strURL);
		response.sendRedirect(uri);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
