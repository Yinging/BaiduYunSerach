package cn.lfsenior.service.util.uri;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class GetStrURL {
	/**
	 * 更具type与keywords创建连接字符串
	 * 
	 * @param type
	 *            连接类型
	 * @param keyWords
	 *            连接关键字
	 * @return
	 */
	public static String getStrURL(String type, String keyWords) {
		try {
			keyWords=URLEncoder.encode(keyWords,"gb2312");
			String strURL = "http://www.panyiso.com/search.php?kw=" + keyWords + "&searchType=" + type;
			return strURL;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
		
	}
}
