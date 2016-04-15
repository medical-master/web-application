package com.medicalmaster.resource;

import javax.annotation.Resource;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medicalmaster.common.bean.ResourceConstants;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialListRequest;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialListResponse;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialRequest;
import com.medicalmaster.common.trainmaterial.QueryTrainMaterialResponse;

/**
 * 培训资料
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月6日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@Resource
@Path(ResourceConstants.PATH_TRAIN_MATERIAL)
public class TrainMaterialResource extends Resources {
	public TrainMaterialResource() {
		super("trainMaterial.xunit", "trainMaterial branch");
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/showTrainMaterial")
	public QueryTrainMaterialResponse showWorkTrainMaterial(@BeanParam QueryTrainMaterialRequest request) {
		request.setAction("showInfo");
		return handle(request, request.getAction());
	}

	/**
	 * 查询培训资源列表
	 * 
	 * @param request
	 * @return
	 */
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public QueryTrainMaterialListResponse queryTrainMaterialList(@BeanParam QueryTrainMaterialListRequest request) {
		request.setAction("queryList");

		return handle(request, request.getAction());
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version Date Author Note
 * ------------------------------------------------------------------------- 1.0
 * 2016-04-14 js 培训资料公共类
 */
