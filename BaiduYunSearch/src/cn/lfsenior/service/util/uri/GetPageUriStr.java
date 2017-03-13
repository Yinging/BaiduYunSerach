package cn.lfsenior.service.util.uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GetPageUriStr {
	/**
	 * 获取多个页面的的URL
	 * @param strURL 连接字符串
	 * @return
	 */
	public static List<String> getPageUriStr(String strURL){
		List<String> pageStrList = new ArrayList<String>();
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(GetHttpURLConnection.getHtml(strURL).getInputStream(), "gb2312"));
			String line = "";
			List<String> list = new ArrayList<String>();
			boolean flag = false;
			while ((line = reader.readLine()) != null) {
				// 获取下一页的连接
				if (line.contains("<span class=\"current\">1</span>")) {
					flag = true;
					continue;
				}
				if (flag) {
					if (line.contains("下一页")) {
						flag = false;
						break;
					}
					if (line.contains("<a href=")) {
						String str = line.substring(line.indexOf("=") + 2, line.indexOf(">") - 1);
						pageStrList.add("http://www.panyiso.com"+str);
					}
				}
			}
			reader.close();
			return pageStrList;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
