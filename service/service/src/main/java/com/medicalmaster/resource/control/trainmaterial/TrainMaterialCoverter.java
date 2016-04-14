package com.medicalmaster.resource.control.trainmaterial;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.domain.trainmaterial.TrainmaterialManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public abstract class TrainMaterialCoverter implements Converter
{
	protected static Logger log = LoggerFactory.getLogger(TrainMaterialCoverter.class);
	protected static TrainmaterialManager manager;
	
	static 
	{
		try 
		{
			manager = new TrainmaterialManager();
		} 
		catch (SQLException exception)
		{
			log.error("WorkstationCoverter error:"+exception.getMessage());
		}
	}
	
	@Override
	public abstract Context convert(Context inputCtx);
}
