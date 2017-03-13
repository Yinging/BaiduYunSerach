package cn.lfsenior.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lfsenior.entry.*;
import cn.lfsenior.service.imp.SearchService;

public class SearchServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 传入的属性type
		 * 值：全部：all、视屏：sp、图片：tp、音乐：yy、文档：wd、种子：zz、apk:apk、ios:iso、压缩包：rar、文件夹：fd
		 * 属性keywords，为查询的关键字
		 */
		String uri = "";// 最后传递的连接
		List<SearchInfo> searchList = new ArrayList<SearchInfo>();
		// 查询类型
		String type = request.getParameter("type");
		// 查询关键字
		String keyWords = request.getParameter("keywords");
		if (keyWords != null) {
			keyWords = new String(keyWords.getBytes("ISO-8859-1"), "utf-8");
		}
		searchList = new SearchService().KeyAndTypeSearch(type, keyWords);
		request.setAttribute("searchList", searchList);
		// System.out.println(request.getLocalAddr());
		uri = "index.jsp";
		request.setAttribute("keyWords", keyWords);
		request.setAttribute("type", type);
		request.getRequestDispatcher(uri).forward(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doGet(request, response);
	}

}
