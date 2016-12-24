package com.chrental.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.exception.BusinessException;
import com.chrental.Idao.IExample;
import com.chrental.pojo.Pet;
import com.chrental.util.Util;

@Path("/menu")
public class ExampleServiceImp {

	@Autowired
	private IExample exampleDAO;

	@Path("/getmenu")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object exampleService() {
		String taner = "sdsad";
		Pet xx = new Pet(taner, taner);

		return Util.constructJSON("Ok", true, xx);
	}

	@Path("/postmenu")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object exampleService(String name) {
		Pet xx = new Pet(name, name);
		return Util.constructJSON("Ok", true, xx);
	}
	
	
	@Path("/postmenux")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Object exampleService(Pet pet) throws BusinessException {
		
		return Util.constructJSON("Ok", true, exampleDAO.select());
	}
}
