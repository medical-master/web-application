package com.medicalmaster.common.request.get;

import java.util.Calendar;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.Request;

/**
 * 分页请求
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class PageRequest extends Request {
	/**缓存刷新时间 毫秒*/
	static final Long CACHE_REFRESH_TIME = 60000L;
	
	@DefaultValue("1") 
	@QueryParam("pageNo")
	private Integer pageNo;

	@DefaultValue("10")
	@QueryParam("pageSize")
	private Integer pageSize;

	@QueryParam("recordCnt")
	private Integer recordCnt;

	@QueryParam("pageCnt")
	private Integer pageCnt;

	@QueryParam("cacheTime")
	private Long cacheTime;

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
	 * @return the cacheTime
	 */
	public Long getCacheTime() {
		return cacheTime;
	}

	/**
	 * @param cacheTime
	 *            the cacheTime to set
	 */
	public void setCacheTime(Long cacheTime) {
		this.cacheTime = cacheTime;
	}

	/***
	 * 校验记录总数缓存时间是否已经过时
	 */
	public void checkCache() {
		if(cacheTime == null){
			this.pageCnt = null;
			this.recordCnt = null;
		}
		
		Long currTime = Calendar.getInstance().getTimeInMillis();
		if(currTime - this.cacheTime > CACHE_REFRESH_TIME){
			this.pageCnt = null;
			this.recordCnt = null;
		}
	}

}
