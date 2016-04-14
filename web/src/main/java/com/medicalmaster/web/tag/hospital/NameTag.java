package com.medicalmaster.web.tag.hospital;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.HospitalHelper;

/**
 * 医院名称Tag
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月14日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class NameTag implements Tag {
	static Logger log = LoggerFactory.getLogger(NameTag.class);
	private Integer id;

	PageContext pageContext;

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.jsp.tagext.Tag#doEndTag()
	 */
	@Override
	public int doEndTag() throws JspException {
		try {
			String name = HospitalHelper.getName(id);
			if (StringUtils.isBlank(name)) {
				name = "";
			}

			pageContext.getOut().write(name);
		} catch (IOException e) {
			log.error("id{} NameTag failed!", id, e);
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
		this.pageContext = arg0;
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
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

}
