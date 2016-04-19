package com.medicalmaster.common.syshospital;

import javax.ws.rs.QueryParam;

import com.medicalmaster.common.request.Request;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月19日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QuerySysHospitalsRequest extends Request {
	/** 等级 */
	@QueryParam("level")
	private Integer level;

	/** 省 */
	@QueryParam("proviceId")
	private Integer proviceId;

	/** 市 */
	@QueryParam("cityId")
	private Integer cityId;

	/** 区 */
	@QueryParam("districtId")
	private Integer districtId;

	/** 地址 */
	@QueryParam("address")
	private String address;

	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}

	/**
	 * @param level
	 *            the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}

	/**
	 * @return the proviceId
	 */
	public Integer getProviceId() {
		return proviceId;
	}

	/**
	 * @param proviceId
	 *            the proviceId to set
	 */
	public void setProviceId(Integer proviceId) {
		this.proviceId = proviceId;
	}

	/**
	 * @return the cityId
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @param cityId
	 *            the cityId to set
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @return the districtId
	 */
	public Integer getDistrictId() {
		return districtId;
	}

	/**
	 * @param districtId
	 *            the districtId to set
	 */
	public void setDistrictId(Integer districtId) {
		this.districtId = districtId;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
}
