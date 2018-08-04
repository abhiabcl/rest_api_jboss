package com.ericsson.jboss.api.rest;
 
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.ericsson.jboss.api.rest.entity.UserData;

 
@Path("/hello")
public class HelloWorldService {
 
	Logger logger = Logger.getLogger(HelloWorldService.class.getSimpleName());
	
	
	//http://127.0.0.5:28080/RESTfulExample/rest/hello/mk
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
		logger.info("this is inside getMsg....");
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
	
	
	@POST
	@Path("/getHellJSON")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getHellJSON(UserData requestData) {
		
		logger.info("this is inside getHellJSON...." + requestData.toString());
		System.out.println(requestData.getName());
	    System.out.println(requestData.getEmail());
	    System.out.println(requestData.getAge());
	    
	    if ( requestData.getName().equalsIgnoreCase("kumar"))
	    	requestData.setName("Kumar Abhishek");
	    
	    return Response.status(200).entity(requestData).build();
		
	}
	
	
	
	//http://127.0.0.5:28080/RESTfulExample/rest/hello/helloJSON
	@POST
	@Path("/helloJSON")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response setHellJSON(UserData requestData) {
		
		logger.info("this is inside setHelloJSON...."+requestData.toString());
		System.out.println(requestData.getName());
	    System.out.println(requestData.getEmail());
	    System.out.println(requestData.getAge());
	    
	    return Response.status(200).entity(requestData).build();
		
	}
	
	
}