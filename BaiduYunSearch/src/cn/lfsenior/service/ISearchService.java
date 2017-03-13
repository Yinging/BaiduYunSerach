package cn.lfsenior.service;

import java.util.List;

/**
 * 
 * @author LFSenior
 *
 *下午3:05:34
 *
 * @param <T>
 */
public interface ISearchService<T> {
	/**
	 * 该方法更具传入的type与keywords进行查询
	 * @param type 查询的数据类型
	 * @param keyWords 查询的关键字
	 * @return 返回结果的List集合
	 */
	public List<T> KeyAndTypeSearch(String type,String keyWords);
}
