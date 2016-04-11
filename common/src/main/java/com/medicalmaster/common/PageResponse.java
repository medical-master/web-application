package com.medicalmaster.common;

import com.medicalmaster.common.request.get.PageRequest;

/**
 * 分页响应
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class PageResponse extends Response {
	/** 每页条目 */
	private Integer pageSize;
	/** 当前页码 */
	private Integer pageNo;
	/** 记录总数 */
	private Integer recordCnt;
	/** 页码总数 */
	private Integer pageCnt;

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize
	 *            the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the pageNo
	 */
	public Integer getPageNo() {
		return pageNo;
	}

	/**
	 * @param pageNo
	 *            the pageNo to set
	 */
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}

	/**
	 * @return the recordCnt
	 */
	public Integer getRecordCnt() {
		return recordCnt;
	}

	/**
	 * @param recordCnt
	 *            the recordCnt to set
	 */
	public void setRecordCnt(Integer recordCnt) {
		this.recordCnt = recordCnt;
	}

	/**
	 * @return the pageCnt
	 */
	public Integer getPageCnt() {
		return pageCnt;
	}

	/**
	 * @param pageCnt
	 *            the pageCnt to set
	 */
	public void setPageCnt(Integer pageCnt) {
		this.pageCnt = pageCnt;
	}

	/**
	 * 从PageRequest中获取分页信息
	 * 
	 * @param request
	 */
	public void covert(PageRequest request) {
		this.pageSize = request.getPageSize();
		this.pageNo = request.getPageNo();
	}
}
