package model;

/*
* An abstraction for creating any and all items needed to be placed on the board.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public abstract class ItemModel {
  
  //--------------------------------------------------------------
  /* Instance Variables */

  private int[] coords = new int[2];

  //--------------------------------------------------------------
  /* Getters */

  public ItemModel(int r, int c) {
    this.coords[0] = r;
    this.coords[1] = c;
  }

  //--------------------------------------------------------------
  /* Getters */

  public int getR() { return coords[0]; }

  public int getC() { return coords[1]; }

  public int[] getCoords() { return coords; }

  public abstract String getItemType();

  //--------------------------------------------------------------
  /* Setters */

  public void setCoords(int r, int c) {
    this.coords[0] = r;
    this.coords[1] = c;
  }
}
