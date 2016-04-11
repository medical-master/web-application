package com.medicalmaster.resource.control.clinicalresearch;

import com.medicalmaster.domain.clinicalresearch.ClinicalResearchManager;
import com.xross.tools.xunit.Context;
import com.xross.tools.xunit.Converter;

/**
 * 临床研究
 * 
 * <P> 
 * Created By guanrong.xie <BR>
 * Created On 2016年4月9日   <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public abstract class ClinicalResearchCoverter implements Converter {
	protected static ClinicalResearchManager manager;
	static{
		try{
			manager = new ClinicalResearchManager();
		}catch(Exception exception){
			
		}
		
	}
	
	/* (non-Javadoc)
	 * @see com.xross.tools.xunit.Converter#convert(com.xross.tools.xunit.Context)
	 */
	@Override
	public abstract Context convert(Context inputCtx) ;

}
