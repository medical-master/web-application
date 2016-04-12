package com.medicalmaster.resource.control.diagnostic;

import java.sql.SQLException;

import com.medicalmaster.domain.diagnosticplan.DiagnosticPlanManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月11日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public abstract class DiagPlanConverter implements Converter {
	static DiagnosticPlanManager manager;

	static {
		try {
			manager = new DiagnosticPlanManager();
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
