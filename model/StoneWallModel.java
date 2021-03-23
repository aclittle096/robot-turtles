package model;

/*
* A model for storing an immovable wall which cannot be modified.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class StoneWallModel extends ItemModel {
  
  //--------------------------------------------------------------
  /* Constructor */
  
  public StoneWallModel(int r, int c) {
    super(r, c);
  }
  
  //--------------------------------------------------------------
  /* Getters */

  public String getItemType() { return "Stone"; }

}
