package com.ericsson.jboss.api.rest.entity;

public class CallerInfo{
	
	
	public String calledPartyNo;
    public String callingPartyNo;
    public String callingPartyName;
    
    public String action;

	public String getCalledPartyNo() {
		return calledPartyNo;
	}

	public void setCalledPartyNo(String calledPartyNo) {
		this.calledPartyNo = calledPartyNo;
	}

	public String getCallingPartyNo() {
		return callingPartyNo;
	}

	public void setCallingPartyNo(String callingPartyNo) {
		this.callingPartyNo = callingPartyNo;
	}

	public String getCallingPartyName() {
		return callingPartyName;
	}

	public void setCallingPartyName(String callingPartyName) {
		this.callingPartyName = callingPartyName;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}
    
    
        
}