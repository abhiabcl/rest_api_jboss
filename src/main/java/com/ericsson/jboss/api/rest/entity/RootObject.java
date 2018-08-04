package com.ericsson.jboss.api.rest.entity;

public class RootObject
{
  private CallEventNotification callEventNotification;

  public CallEventNotification getCallEventNotification() { return this.callEventNotification; }

  public void setCallEventNotification(CallEventNotification callEventNotification) { this.callEventNotification = callEventNotification; }

  private String callbackData;

  public String getCallbackData() { return this.callbackData; }

  public void setCallbackData(String callbackData) { this.callbackData = callbackData; }

  private String callSessionidentifier;

  public String getCallSessionidentifier() { return this.callSessionidentifier; }

  public void setCallSessionidentifier(String callSessionidentifier) { this.callSessionidentifier = callSessionidentifier; }

  private String addressDirection;

  public String getAddressDirection() { return this.addressDirection; }

  public void setAddressDirection(String addressDirection) { this.addressDirection = addressDirection; }
}

