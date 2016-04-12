package com.medicalmaster.common.helper;

import java.util.List;

/**
 * 分页帮助类
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class PageHelper<T> {
	public static final Integer DEFAULT_PAGE_SIZE = 10;
	
	private int pageSize = 10;
	private int currentPage = 0;
	private int totalPages = 0;
	private int totalItems = 0;
	private List<T> items = null;

	public PageHelper(List<T> items, int pageSize) {
		this.items = items;

		if (pageSize > 0) {
			this.pageSize = pageSize;
		}

		if (items == null || items.isEmpty()) {
			return;
		}

		totalItems = items.size();
		totalPages = totalItems / this.pageSize;
		if (totalItems % this.pageSize > 0) {
			totalPages += 1;
		}
	}

	public boolean next() {
		if (currentPage >= totalPages) {
			return false;
		}

		currentPage += 1;

		return true;
	}

	public int getCurrentpage() {
		return this.currentPage;
	}

	public List<T> getCurrentList() {
		if (currentPage < totalPages) {
			return items.subList((currentPage - 1) * pageSize, currentPage * pageSize);
		}

		return items.subList((currentPage - 1) * pageSize, totalItems);
	}

	/**
	 * 计算页码总数
	 * 
	 * @param recordCnt
	 * @param pageSize
	 * @return
	 */
	public static Integer calcPageCnt(Integer recordCnt, Integer pageSize) {
		if (recordCnt == null) {
			return 0;
		}

		if (pageSize == null) {
			pageSize = DEFAULT_PAGE_SIZE;
		}

		int pageCnt = recordCnt / pageSize;
		if (recordCnt % pageSize > 0) {
			pageCnt += 1;
		}

		return pageCnt;
	}
}
