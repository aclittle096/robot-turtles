package model;

/*
* A model for storing instances of jewels with specific IDs
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class JewelModel extends IDModel {

  //--------------------------------------------------------------
  /* Constructors */

  public JewelModel(int id, int r, int c) { super(id, r, c); }

  //--------------------------------------------------------------
  /* Getters */

  public String getItemType() { return "Jewel"; }

}