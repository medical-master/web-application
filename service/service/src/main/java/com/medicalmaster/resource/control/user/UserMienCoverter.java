package com.medicalmaster.resource.control.user;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.domain.user.UserManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

public abstract class UserMienCoverter implements Converter
{
	protected static Logger log = LoggerFactory.getLogger(UserMienCoverter.class);
	protected static UserManager manager;

	static 
	{
		try 
		{
			manager = new UserManager();
		} 
		catch (SQLException exception)
		{
			log.error("WorkstationCoverter error:"+exception.getMessage());
		}
	}
	
	@Override
	public abstract Context convert(Context inputCtx);
}
