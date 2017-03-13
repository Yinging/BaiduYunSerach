package cn.lfsenior.service.util.uri;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class GetHttpURLConnection {
	/**
	 *获取连接字符串的HttpURLConnection连接对象
	 * @param strURL 连接字符串
	 * @return HttpURLConnection对象
	 * @throws IOException
	 */
	public static  HttpURLConnection getHtml(String strURL) throws IOException {
		// 生成一个URL对象
		URL url = new URL(strURL);
		// 打开URL
		HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
		return urlConnection;
	}
}
