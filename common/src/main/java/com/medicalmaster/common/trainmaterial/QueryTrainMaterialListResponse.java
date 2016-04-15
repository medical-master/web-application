package com.medicalmaster.common.trainmaterial;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.TrainMaterial;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月15日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class QueryTrainMaterialListResponse extends PageResponse {
	private List<TrainMaterial> materials;

	/**
	 * @return the materials
	 */
	public List<TrainMaterial> getMaterials() {
		return materials;
	}

	/**
	 * @param materials
	 *            the materials to set
	 */
	public void setMaterials(List<TrainMaterial> materials) {
		this.materials = materials;
	}

}
