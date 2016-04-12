package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchInfoResponse;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsRequest;
import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsResponse;
import com.medicalmaster.common.request.get.IdRequest;
import com.xross.tools.xunit.XunitFactory;

/**
 * 临床研究
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月6日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@Resource
@Path(ResourceConstants.PATH_CLINICAL_RESEARCH)
public class ClinicalResearchResource extends Resources {
	/**
	 * 
	 */
	public ClinicalResearchResource() {
		try {
			factory = XunitFactory.load("clinicalResearch.xunit");
			converterId = "clinicalResearch branch";
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public QueryClinicalResearchsResponse queryClinicalResearchs(@BeanParam QueryClinicalResearchsRequest request) {
		request.setAction("queryClinicalResearchs");
		return handle(request, request.getAction());
	}

	@GET
	@Path("{id}")
	public QueryClinicalResearchInfoResponse queryClinicalResearchInfo(@PathParam("id") Integer id) {
		IdRequest request = new IdRequest();
		request.setAction("queryClinicalResearchInfo");
		request.setId(id);

		return handle(request, request.getAction());
	}
}
