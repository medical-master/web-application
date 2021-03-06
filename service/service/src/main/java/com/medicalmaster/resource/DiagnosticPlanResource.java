package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfoResponse;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlanInfosResponse;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlansRequest;
import com.medicalmaster.common.diagnosticplan.QueryDiagPlansResponse;
import com.medicalmaster.common.request.get.IdRequest;
import com.medicalmaster.common.request.get.PageRequest;

/**
 * 诊疗方案
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月6日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@Resource
@Path(ResourceConstants.PATH_DIAGNOSTIC_PLAN)
public class DiagnosticPlanResource extends Resources {
	/**
	 * 
	 */
	public DiagnosticPlanResource() {
		super("diagnosticPlan.xunit", "diagnosticPlan branch");
	}

	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public QueryDiagPlansResponse queryDiagPlans(@BeanParam QueryDiagPlansRequest request) {
		request.setAction("queryList");

		return handle(request, request.getAction());
	}

	@GET
	@Path("/infos")
	public QueryDiagPlanInfosResponse queryDiagPlanInfos(@BeanParam PageRequest request) {
		request.setAction("queryInfos");

		return handle(request, request.getAction());
	}

	@GET
	@Path("{id}")
	public QueryDiagPlanInfoResponse queryDiagPlanInfo(@PathParam("id") Integer id) {
		IdRequest request = new IdRequest();
		request.setId(id);
		request.setAction("queryInfo");

		return handle(request, request.getAction());
	}

}
