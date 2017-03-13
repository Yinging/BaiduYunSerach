package cn.lfsenior.service.util.uri;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class GetPanUri {
	public static String getPanUri(String strURL) {
		strURL="http://www.panyiso.com"+strURL;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					GetHttpURLConnection.getHtml(strURL).getInputStream(),
					"gb2312"));
			String line = "";
			String str2 = "";
			boolean flag = false;
			while ((line = reader.readLine()) != null) {
				if (line.contains("href")) {
					if (line.contains("pan.baidu")) {
						String str = line.substring(
								line.indexOf("pan.baidu") - 7, line.length());
						str2 = str.substring(0, str.indexOf("rel") - 2);
					}
				}
			}
			reader.close();
			return str2;
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
