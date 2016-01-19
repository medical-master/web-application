package com.medicalmaster.web.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("user")
public class UserResource {

	@GET
	@Produces("text/plain")
	public String get() {
		return "aaa";
	}
}
