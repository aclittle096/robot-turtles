package model;

/*
* A model for storing instances of turtles with specific IDs and their logic.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class TurtleModel extends IDModel {

  //--------------------------------------------------------------
  /* Instance Variables */

  private String direction;
  private final DeckModel deck = new DeckModel();
  private boolean finished;
  
  //--------------------------------------------------------------
  /* Constructor */

  public TurtleModel(int id, int r, int c) throws IllegalArgumentException {
    super(id, r, c);
    this.finished = false;

    // Initialize turtles in different directions depending on their IDs
    switch (this.getID()) {
      case 1:
        this.direction = "south";
        break;

      case 2:
        this.direction = "west";
        break;

      case 3:
        this.direction = "east";
        break;

      case 4:
        this.direction = "north";
        break;

      default:
        throw new IllegalArgumentException("Turtle cannot have an ID less than 1 or greater than 4!");
    }
  }

  //--------------------------------------------------------------
  /* Getters */

  public String getDirection() { return direction; }

  public DeckModel getDeck() { return deck; }

  public boolean isFinished() { return finished; }

  public String getItemType() { return "Turtle"; }

  //--------------------------------------------------------------
  /* Setters */

  public void setDirection(String dir) { direction = dir; }

  public void addCard(String move) { deck.add(move); }

  public void setAsFinished() { finished = true; }

}
