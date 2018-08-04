package com.ericsson.jboss.api.rest.entity;


public class Action
{
  private String actionToPerform;

  public String getActionToPerform() { return this.actionToPerform; }

  public void setActionToPerform(String actionToPerform) { this.actionToPerform = actionToPerform; }

  private String routingAddress;

  public String getRoutingAddress() { return this.routingAddress; }

  public void setRoutingAddress(String routingAddress) { this.routingAddress = routingAddress; }
}
