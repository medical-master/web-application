package com.medicalmaster.service;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("resources")
public class MedicalMasterApp extends ResourceConfig {

    public MedicalMasterApp() {
    	packages("com.medicalmaster.web.resource");
    }
}
