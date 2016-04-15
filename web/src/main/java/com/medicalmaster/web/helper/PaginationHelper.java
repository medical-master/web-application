package com.medicalmaster.web.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.medicalmaster.common.PageResponse;

/**
 * 分页帮助类
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月13日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class PaginationHelper {
	static final Integer SHOW_PAGE_NUM = 10;

	public static String getPaginationHtml(PageResponse response, String formAction,String pagination) {
		if (response == null) {
			return "";
		}

		Map<String, Object> map = new HashMap<>();
		map.put("action", formAction);
		map.put("pageNo", response.getPageNo());
		map.put("pageSize", response.getPageSize());
		map.put("pageCnt", response.getPageCnt());
		map.put("recordCnt", response.getRecordCnt());
		map.put("cacheTime", response.getCacheTime());

		map.put("pages", calcPages(response.getPageNo(), response.getPageCnt()));

		return FreeMarkerHelper.process(pagination, map);
	}

	static List<Integer> calcPages(Integer pageNo, Integer pageCnt) {
		List<Integer> pages = new ArrayList<>();
		if (pageCnt <= SHOW_PAGE_NUM) {
			for (int idx = 1; idx <= pageCnt; idx++) {
				pages.add(idx);
			}

			return pages;
		}

		int preCnt = SHOW_PAGE_NUM / 2;
		int nextCnt = SHOW_PAGE_NUM - preCnt;

		int pre = pageNo - preCnt;
		int next = pageNo + nextCnt - 1;

		if (pre < 1) {
			pre = 1;
			next = next + (preCnt - pageNo + 1);
		} else if (next > pageCnt) {
			next = pageCnt;
			pre = pre - (nextCnt - pageCnt + pageNo);
		}

		for (int idx = pre; idx <= next; idx++) {
			pages.add(idx);
		}

		return pages;
	}
}
