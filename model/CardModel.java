package model;

/*
* A model for storing types of cards, i.e possible player actions.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class CardModel {
  
  //--------------------------------------------------------------
  /* Instance Variables */

  public String actionType;

  //--------------------------------------------------------------
  /* Constructor */

  public CardModel(String actionType) throws IllegalArgumentException {
    if (actionType != "MOVE FORWARD" 
     && actionType != "ROTATE LEFT"
     && actionType != "ROTATE RIGHT"
     && actionType != "LASER") {
       throw new IllegalArgumentException("Illegal card created!");
    }
    
    this.actionType = actionType; 
  }

  //--------------------------------------------------------------
  /* Getters */
  
  public String getCard() { return actionType; }

}