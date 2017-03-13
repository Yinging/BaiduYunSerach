package cn.lfsenior.entry;

public class SearchInfo {
	/**
	 * searchStr表示搜索结果字符串
	 */
	private String searchStr;
	
	/**
	 * searchTime表示搜索时间字符串
	 */
	private String searchTime;

	
	private String searchURL;
	/**
	 *对searchStr与searchTime设置访问器 
	 * 
	 */
	
	
	public String getSearchStr() {
		return searchStr;
	}

	public void setSearchStr(String searchStr) {
		this.searchStr = searchStr;
	}

	public String getSearchTime() {
		return searchTime;
	}

	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}

	public String getSearchURL() {
		return searchURL;
	}

	public void setSearchURL(String searchURL) {
		this.searchURL = searchURL;
	}

	
	
}
