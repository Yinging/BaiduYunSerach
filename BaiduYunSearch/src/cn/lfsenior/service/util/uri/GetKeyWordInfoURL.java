package cn.lfsenior.service.util.uri;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import cn.lfsenior.entry.SearchInfo;

public class GetKeyWordInfoURL {

	public List<SearchInfo> getKeyWordInfoUrl(String strURL) throws Exception {
		// 得到输入流，即获得了网页的内容
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				GetHttpURLConnection.getHtml(strURL).getInputStream(), "gb2312"));
		String line = "";
		List<SearchInfo> searchList = new ArrayList<SearchInfo>();
		SearchInfo si = null;
		boolean flag = false;
		while ((line = reader.readLine()) != null) {
			// 包含主要内容链接
			if (line.contains("href=")) {
				if (line.contains("title")) {
					String strHtml = line.substring(line.indexOf("=") + 2,
							line.indexOf("target") - 2);
					String title = line.substring(line.indexOf("title=") + 7,
							line.indexOf(">") - 1);
					si = new SearchInfo();
					si.setSearchURL(strHtml);
					si.setSearchStr(title);
					flag = true;
				}
			}
			if (flag) {
				if (line.contains("<i>")) {
					String strTime = line.substring(line.indexOf("i") + 2,
							line.indexOf("</"));
					si.setSearchTime(strTime);
					searchList.add(si);
					si = null;
					flag = false;
				}
			}
		}

		reader.close();
		return searchList;
	}
}
