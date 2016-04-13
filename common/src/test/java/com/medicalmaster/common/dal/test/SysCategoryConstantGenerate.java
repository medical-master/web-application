package com.medicalmaster.common.dal.test;

import java.sql.SQLException;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.medicalmaster.dal.SysPropertyCategory;
import com.medicalmaster.dal.SysPropertyCategoryDao;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016Äê4ÔÂ12ÈÕ <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */

public class SysCategoryConstantGenerate {
	SysPropertyCategoryDao dao;

	@Before
	public void init() {
		try {
			dao = new SysPropertyCategoryDao();
		} catch (SQLException exception) {
		}
	}

	@Test
	public void generate() throws SQLException {
		StringBuilder java = new StringBuilder();
		java.append("package com.medicalmaster.common.bean; \n");
		java.append("public class SysCategoryConstants { \n");

		List<SysPropertyCategory> categories = dao.getAll(null);
		for (SysPropertyCategory sysPropertyCategory : categories) {
			java.append("/**").append(sysPropertyCategory.getDescription()).append("**/\n");
			java.append("public Integer ").append(sysPropertyCategory.getName()).append(" = ")
					.append(sysPropertyCategory.getCategoryId()).append(";\n\n");
		}
		java.append("}\n");
		System.out.println(java.toString());
	}

	@After
	public void close() {
		dao = null;
	}
}
