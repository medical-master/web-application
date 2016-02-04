package com.medicalmaster.web.service;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class MedicalMasterApp extends ResourceConfig {

    public MedicalMasterApp() {
//    	property("jersey.config.server.mvc.templateBasepath.jsp", "");  
//    	register(JspMvcFeature.class); 
    	packages("com.medicalmaster.web.resource");
    }
}
