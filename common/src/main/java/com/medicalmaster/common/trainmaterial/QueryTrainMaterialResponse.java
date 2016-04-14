package com.medicalmaster.common.trainmaterial;

import java.util.List;

import com.medicalmaster.common.PageResponse;
import com.medicalmaster.dal.TrainMaterialViewPojoPojo;

public class QueryTrainMaterialResponse extends PageResponse
{
	private List<TrainMaterialViewPojoPojo> trainMaterial;

	public List<TrainMaterialViewPojoPojo> getTrainMaterial() 
	{
		return trainMaterial;
	}

	public void setTrainMaterial(List<TrainMaterialViewPojoPojo> trainMaterial) 
	{
		this.trainMaterial = trainMaterial;
	}
}
