package com.medicalmaster.web.tag.hospital;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import com.medicalmaster.common.bean.KeyValue;
import com.medicalmaster.dal.SysHospital;
import com.medicalmaster.dal.SysHospitalDao;
import com.medicalmaster.web.helper.FreeMarkerHelper;

/**
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月18日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class SelectTag implements Tag {
	/** 当前被选中的ID */
	private Integer selectedId;
	/** 元素的id */
	private String id;
	/** 元素的name */
	private String name;

	private PageContext context;

	static SysHospitalDao dao;

	static {
		try {
			dao = new SysHospitalDao();
		} catch (SQLException exception) {
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			Map<String, Object> params = new HashMap<>();
			params.put("elementId", id);
			params.put("elementName", name);
			params.put("selectKey", selectedId);

			List<SysHospital> hospitals = dao.getAll(null);
			List<KeyValue> items = new ArrayList<>();
			for (SysHospital hospital : hospitals) {
				KeyValue item = new KeyValue(hospital.getHospitalId(), hospital.getName());
				items.add(item);
			}
			params.put("items", items);
			String html = FreeMarkerHelper.process("/select/single.html", params);
			context.getOut().print(html);
		} catch (SQLException exception) {
			throw new JspException("数据查询失败");
		} catch (IOException e) {
			throw new JspException("标签输出失败");
		}
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doStartTag()
	 */
	@Override
	public int doStartTag() throws JspException {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#getParent()
	 */
	@Override
	public Tag getParent() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#release()
	 */
	@Override
	public void release() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#setPageContext(javax.servlet.jsp.
	 * PageContext)
	 */
	@Override
	public void setPageContext(PageContext arg0) {
		context = arg0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#setParent(javax.servlet.jsp.tagext.Tag)
	 */
	@Override
	public void setParent(Tag arg0) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the selectedId
	 */
	public Integer getSelectedId() {
		return selectedId;
	}

	/**
	 * @param selectedId
	 *            the selectedId to set
	 */
	public void setSelectedId(Integer selectedId) {
		this.selectedId = selectedId;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
