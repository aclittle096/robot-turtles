package model;

/*
* An abstract class for providing ItemModel implementations with an ID instance variable.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public abstract class IDModel extends ItemModel {
  
  //--------------------------------------------------------------
  /* Instance variables */

  private int id;
  
  //--------------------------------------------------------------
  /* Constructor */

  public IDModel(int id, int r, int c) { 
    super(r, c);
    this.id = id;
  }

  //--------------------------------------------------------------
  /* Getters */

  public int getID() { return id; }

}
