package com.medicalmaster.common.helper;

/**
 * 分页帮助类
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class PageHelper {
	public static final Integer DEFAULT_PAGE_SIZE = 10;

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
