package cn.lfsenior.service.util;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import cn.lfsenior.entry.SearchInfo;
import cn.lfsenior.service.util.uri.GetKeyWordInfoURL;

public class SearchThread implements Runnable {
	public SearchThread(String strURL, List<SearchInfo> searchList,CountDownLatch latch) {
		this.strURL = strURL;
		this.searchList = searchList;
		this.latch=latch;
	}

	private String strURL;
	List<SearchInfo> searchList;
	CountDownLatch latch;
	@Override
	public void run() {
		List<SearchInfo> searchArrayList;
		try {
			searchArrayList = new GetKeyWordInfoURL().getKeyWordInfoUrl(strURL);
			synchronized (SearchThread.class) {
				searchList.addAll((ArrayList<SearchInfo>) searchArrayList);
			}
			latch.countDown();
		} catch (Exception e) {
			latch.countDown();
			throw new RuntimeException(e);
		}
	}

}
