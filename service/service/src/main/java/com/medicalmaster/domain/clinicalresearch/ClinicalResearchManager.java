package com.medicalmaster.domain.clinicalresearch;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.common.clinicalresearch.QueryClinicalResearchsRequest;
import com.medicalmaster.dal.ClinicalResearch;
import com.medicalmaster.dal.ClinicalResearchDao;

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

	/**
	 * @throws SQLException
	 * 
	 */
	public ClinicalResearchManager() throws SQLException {
		dao = new ClinicalResearchDao();
	}

	public ClinicalResearch queryInfo(Integer id) throws SQLException {
		return dao.queryByPk(id, null);
	}

	public List<ClinicalResearch> queryClinicalResearchs(QueryClinicalResearchsRequest request) throws SQLException {
		return dao.findByWorkstationId(request.getWorkstationId(), request.getPageNo(), request.getPageSize(), null);
	}

	public Integer queryClinicalResearchsCnt(QueryClinicalResearchsRequest request) throws SQLException {
		List<ClinicalResearch> clinicalResearchs = dao.findAllByWorkstationId(request.getWorkstationId(), null);
		if (clinicalResearchs == null) {
			return 0;
		}

		return clinicalResearchs.size();
	}
}
