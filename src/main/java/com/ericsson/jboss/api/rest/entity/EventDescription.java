package com.ericsson.jboss.api.rest.entity;

public class EventDescription
{
  private String callEvent;

  public String getCallEvent() { return this.callEvent; }

  public void setCallEvent(String callEvent) { this.callEvent = callEvent; }

  private String terminationParticipant;

  public String getTerminationParticipant() { return this.terminationParticipant; }

  public void setTerminationParticipant(String terminationParticipant) { this.terminationParticipant = terminationParticipant; }
}