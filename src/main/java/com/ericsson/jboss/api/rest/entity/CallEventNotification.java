package com.ericsson.jboss.api.rest.entity;

import java.util.ArrayList;

public class CallEventNotification
{
  private String callingParticipant;

  public String getCallingParticipant() { return this.callingParticipant; }

  public void setCallingParticipant(String callingParticipant) { this.callingParticipant = callingParticipant; }

  private EventDescription eventDescription;

  public EventDescription getEventDescription() { return this.eventDescription; }

  public void setEventDescription(EventDescription eventDescription) { this.eventDescription = eventDescription; }

  private String calledParticipant;

  public String getCalledParticipant() { return this.calledParticipant; }

  public void setCalledParticipant(String calledParticipant) { this.calledParticipant = calledParticipant; }

  private String notificationType;

  public String getNotificationType() { return this.notificationType; }

  public void setNotificationType(String notificationType) { this.notificationType = notificationType; }

  private ArrayList<Link> link;

  public ArrayList<Link> getLink() { return this.link; }

  public void setLink(ArrayList<Link> link) { this.link = link; }
}
