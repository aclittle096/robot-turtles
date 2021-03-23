package model;

/*
* A model for storing instances of movable crates.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class CrateModel extends ItemModel {
  
  //--------------------------------------------------------------
  /* Constructor */
  
  public CrateModel(int r, int c) {
    super(r, c);
  }

  //--------------------------------------------------------------
  /* Getters */

  public String getItemType() { return "Crate"; }

}
