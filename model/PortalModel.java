package model;

/*
 * A model for storing a single-use portal instance. To be used in pairs.
 *
 * COMP 3721 - Milestone 5
 * @author Alexander Little & Logan DiAdams
 */
public class PortalModel extends ItemModel {
  
  //--------------------------------------------------------------
  /* Constructor */

  public PortalModel(int r, int c) {
    super(r, c);
  }

  //--------------------------------------------------------------
  /* Getters */

  public String getItemType() { return "Portal"; }

}
