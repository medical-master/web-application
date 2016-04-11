package com.medicalmaster.common.clinicalresearch;

import com.medicalmaster.common.Response;
import com.medicalmaster.dal.ClinicalResearch;

/**
 * 临床研究详情查询响应
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryClinicalResearchInfoResponse extends Response {
	private ClinicalResearch research;

	/**
	 * @return the research
	 */
	public ClinicalResearch getResearch() {
		return research;
	}

	/**
	 * @param research
	 *            the research to set
	 */
	public void setResearch(ClinicalResearch research) {
		this.research = research;
	}

}
