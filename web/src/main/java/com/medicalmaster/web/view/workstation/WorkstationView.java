package com.medicalmaster.web.view.workstation;

import java.sql.SQLException;
import java.util.List;

import com.medicalmaster.dal.Workstation;
import com.medicalmaster.dal.WorkstationDao;
import com.medicalmaster.dal.WorkstationFollowerDao;

public class WorkstationView
{
	private WorkstationDao dao;
	private WorkstationFollowerDao followerDao;
	public WorkstationView() throws SQLException 
	{
		dao = new WorkstationDao();
		followerDao = new WorkstationFollowerDao();
	}
	
	public List<Workstation> displayWorkstations() throws SQLException 
	{
		return dao.getAll(null);
	}
	
	public Workstation getWorkstation(int workStationId) 
	{
		System.out.println("ddddddddddddddddffffffffffff");
		return null;
	}
}

/**
 * Revision History
 * -------------------------------------------------------------------------
 * Version       Date             Author          		Note
 * -------------------------------------------------------------------------
 * 1.0         2016-04-01        	js        	  	    工作站信息显示
 */
