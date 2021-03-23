package model;

/*
* A model for storing an ice version of a wall obstacle which can be melted.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class IceWallModel extends ItemModel {

  //--------------------------------------------------------------
  /* Instance variables */

  private boolean melted = false;

  //--------------------------------------------------------------
  /* Constructor */
  
  public IceWallModel(int r, int c) {
    super(r, c);
  }

  //--------------------------------------------------------------
  /* Getters */

  public String getItemType() { return "Ice"; }

  public boolean isMelted() { return melted; }

  //--------------------------------------------------------------
  /* Setters */

  public void melt() { melted = true; }

}
