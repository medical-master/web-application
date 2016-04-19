package com.medicalmaster.resource.control.hospital;

import java.sql.SQLException;

import com.medicalmaster.domain.hospital.HospitalManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月19日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public abstract class HospitalConverter implements Converter {
	protected static HospitalManager manager;

	static {
		try {
			manager = new HospitalManager();
		} catch (SQLException exception) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.xross.tools.xunit.Converter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public abstract Context convert(Context inputCtx);

}
