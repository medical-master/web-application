package com.medicalmaster.resource.control.workstation;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.domain.workstation.WorkstationManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public abstract class WorkstationCoverter implements Converter
{
	protected static Logger log = LoggerFactory.getLogger(WorkstationCoverter.class);
	protected static WorkstationManager manager;

	static 
	{
		try 
		{
			manager = new WorkstationManager();
		} 
		catch (SQLException exception)
		{
			log.error("WorkstationCoverter error:"+exception.getMessage());
		}
	}
	
	@Override
	public abstract Context convert(Context inputCtx);
}
