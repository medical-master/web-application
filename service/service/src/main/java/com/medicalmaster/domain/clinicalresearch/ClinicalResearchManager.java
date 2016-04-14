package com.medicalmaster.domain.clinicalresearch;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsRequest;
import com.medicalmaster.dal.ClinicalResearch;
import com.medicalmaster.dal.ClinicalResearchDao;
import com.medicalmaster.dal.ClinicalResearchExtDao;

/**
 * 临床研究
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月7日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class ClinicalResearchManager {
	ClinicalResearchDao dao;
	ClinicalResearchExtDao extDao;

	/**
	 * @throws SQLException
	 * 
	 */
	public ClinicalResearchManager() throws SQLException {
		dao = new ClinicalResearchDao();
		extDao = new ClinicalResearchExtDao();
	}

	public ClinicalResearch queryInfo(Integer id) throws SQLException {
		return dao.queryByPk(id, null);
	}

	public List<ClinicalResearch> queryClinicalResearchs(QueryClinicalResearchsRequest request) throws SQLException {
		return dao.findByWorkstationId(request.getWorkstationId(), request.getPageNo(), request.getPageSize(), null);
	}

	public Integer queryClinicalResearchsCnt(QueryClinicalResearchsRequest request) throws SQLException {
		if (request.getWorkstationId() == null) {
			return extDao.findAllCnt(null).intValue();
		} else {
			return extDao.findByWorkstationIdCnt(request.getWorkstationId(), null).intValue();
		}
	}
}
