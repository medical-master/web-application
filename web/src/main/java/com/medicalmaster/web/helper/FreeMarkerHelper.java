package com.medicalmaster.web.helper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.medicalmaster.common.helper.CloseableHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * 
 * FreeMarker帮助类
 * 
 * <P>
 * Created By guanrong.xie <BR>
 * Created On 2016年4月13日 <BR>
 * CopyRight@IMedMaster <BR>
 * </P>
 */
public class FreeMarkerHelper {
	static Logger log = LoggerFactory.getLogger(FreeMarkerHelper.class);
	static Configuration configuration;

	static {
		configuration = new Configuration(Configuration.VERSION_2_3_23);
		configuration.setDateFormat("yyyy-MM-dd");
		configuration.setClassForTemplateLoading(FreeMarkerHelper.class, "/freemarker");
		configuration.setDefaultEncoding("UTF-8");
	}

	public static String process(String templateName, Map<String, Object> params) {
		String content = null;
		StringWriter writer = null;
		try {
			Template template = configuration.getTemplate(templateName);

			writer = new StringWriter();
			template.process(params, writer);

			content = writer.toString();
		} catch (TemplateException e) {
			log.error("process {} failed!", templateName, e);
		} catch (IOException e) {
			log.error("process {} failed!", templateName, e);

			e.printStackTrace();
		} finally {
			CloseableHelper.close(writer);
		}

		return content;
	}
}
