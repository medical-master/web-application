package com.medicalmaster.common.clinicalresearch;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.ClinicalResearch;

/**
 * 临床研究列表查询请求响应
 * 
 * <P> 
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日   <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryClinicalResearchsResponse extends PageResponse {
	private List<ClinicalResearch> researchs;

	/**
	 * @return the researchs
	 */
	public List<ClinicalResearch> getResearchs() {
		return researchs;
	}

	/**
	 * @param researchs the researchs to set
	 */
	public void setResearchs(List<ClinicalResearch> researchs) {
		this.researchs = researchs;
	}
	
	
}
