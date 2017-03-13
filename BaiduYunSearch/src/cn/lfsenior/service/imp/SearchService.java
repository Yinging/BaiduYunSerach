package cn.lfsenior.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import cn.lfsenior.entry.SearchInfo;
import cn.lfsenior.service.ISearchService;
import cn.lfsenior.service.util.SearchThread;
import cn.lfsenior.service.util.uri.GetPageUriStr;
import cn.lfsenior.service.util.uri.GetStrURL;

public class SearchService implements ISearchService<SearchInfo> {

	@Override
	public List<SearchInfo> KeyAndTypeSearch(String type, String keyWords) {
		//存放所有查询到的信息
		List<SearchInfo> searchList = new ArrayList<SearchInfo>();
		//连接字符串
		String strURL=GetStrURL.getStrURL(type, keyWords);
		//获取pageList集合
		List<String> pageList=GetPageUriStr.getPageUriStr(strURL);
		pageList.add(strURL);
		//通过多线程获取查找结果项的集合
		CountDownLatch latch = new CountDownLatch(pageList.size());
		for (String string : pageList) {
			Thread t=new Thread(new SearchThread(string, searchList, latch));
			t.start();
		}
		try {
			latch.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return searchList;
	}

}
