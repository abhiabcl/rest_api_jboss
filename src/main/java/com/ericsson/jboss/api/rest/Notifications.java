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

import com.ericsson.jboss.api.rest.dao.ApiEnablerDao;
import com.ericsson.jboss.api.rest.entity.Action;
import com.ericsson.jboss.api.rest.entity.CallerInfo;
import com.ericsson.jboss.api.rest.entity.RootObjResp;
import com.ericsson.jboss.api.rest.entity.RootObject;

@Path("/Notifications")
public class Notifications {

	Logger logger = Logger.getLogger(HelloWorldService.class.getSimpleName());

	// /Notifications/CallDirectionNotificationURL
	@POST
	@Path("/CallDirectionNotificationURL")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response CallDirection(RootObject pObj) {

		System.out.println("Req. JSON data: " + pObj.toString());

		String calledParty = pObj.getCallEventNotification().getCalledParticipant();
		String callingParty = pObj.getCallEventNotification().getCallingParticipant();

		System.out.println("calledParty : " + calledParty + " callingParty : " + callingParty);

		RootObjResp resp = new RootObjResp();
		Action act = new Action();
		act.setActionToPerform("Route");
		act.setRoutingAddress("sip:+3234343@ad.com");
		resp.setAction(act);
		System.out.println("Resp. JSON data: " + resp.toString());

		return Response.status(200).entity(resp).build();

	}

	@POST
	@Path("/callDirection")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCallDirection(CallerInfo requestData) {

		logger.info("this is inside getCallDirection...." + requestData.toString());
		logger.info("CalledPartyNo: " + requestData.getCalledPartyNo());
		logger.info("CallingPartyNo: " + requestData.getCallingPartyNo());
		logger.info("CallingPartyName: " + requestData.getCallingPartyName());
		logger.info("Action: " + requestData.getAction());

		//requestData.setAction(requestData.getAction());
		//requestData.setAction(requestData.getAction());
		ApiEnablerDao.makeJDBCConnection();
		
		String action = ApiEnablerDao.getDataFromDB();
		
		String objectToReturn = "{\"action\": \""+action+"\"}";

		logger.info("Result: " +objectToReturn);
		
		return Response.status(200).entity(objectToReturn).build();

	}
	
	
	//http://127.0.0.5:28080/APIEnablerDemo/Notifications/setDirection/bye
	@GET
	@Path("/setDirection/{param}")
	public Response setDirection(@PathParam("param") String msg) {
		logger.info("this is inside setDirection....");
		ApiEnablerDao.makeJDBCConnection();
		ApiEnablerDao.addDataToDB(msg);
		String output = "set action is : " + msg;
		return Response.status(200).entity(output).build();
 
	}

}
