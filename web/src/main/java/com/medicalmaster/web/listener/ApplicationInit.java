package com.medicalmaster.web.listener;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.HospitalHelper;
import com.medicalmaster.common.helper.SysPropertyHelper;
import com.medicalmaster.dal.SysPropertyCategory;
import com.medicalmaster.dal.SysPropertyCategoryDao;

/**
 * 应用初始化
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月13日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
@WebListener("ApplicationInit")
public class ApplicationInit implements ServletContextListener {
	static Logger log = LoggerFactory.getLogger(ApplicationInit.class);
	SysPropertyCategoryDao dao;

	/**
	 * 
	 */
	public ApplicationInit() throws SQLException {
		dao = new SysPropertyCategoryDao();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * javax.servlet.ServletContextListener#contextInitialized(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		try {
			List<SysPropertyCategory> categories = dao.getAll(null);
			for (SysPropertyCategory category : categories) {
				Integer categoryId = category.getCategoryId();
				if (categoryId != 16 && categoryId != 17 && categoryId != 18) {

					log.info("load sys_property for {} ", categoryId);
					SysPropertyHelper.load(categoryId);
				}
			}
		} catch (SQLException exception) {
			log.error("load sys_property failed!", exception);
		}

		log.info("load sys_hospital");
		HospitalHelper.load();

		log.info("contextInitialized done!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.
	 * ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		SysPropertyHelper.release();
		HospitalHelper.release();
	}
}
