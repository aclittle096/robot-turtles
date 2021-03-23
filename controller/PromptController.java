package controller;

import java.util.Scanner;
import java.util.Arrays;
import model.*;
import view.BoardView;

/*
* The main controller for the game, responsible for asking players for actions and updating the board based on those actions.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class PromptController {

  //--------------------------------------------------------------
  /* Instance Variables */

  public static int playerSize, finishedTurtles = 0;
  public static BoardModel board;
  public static Scanner input = new Scanner(System.in);

  //--------------------------------------------------------------

  /* Initializes the game and then runs it */
  public static void setGame(int turtleCount) {
    playerSize = turtleCount;
    board = new BoardModel(playerSize);
    runGame();
  }

  /* Display the end game splash */
  private static void showEndMessage() { EndGameController.doThing(); }

  /* Check if the player entered a valid move for their turtle */
  private static boolean isValidMove(String move) {
    return move.equals("mf")  // Move forward
        || move.equals("rl")  // Rotate left
        || move.equals("rr")  // Rotate right
        || move.equals("lz"); // Laser
  }

  /* Main driver method for the game */
  private static void runGame() {
    // Integer to keep track of current player
    int currTurtle = 1;

    // Main game loop
    while (true) {
      TurtleModel turtle = board.getTurtle(currTurtle);

      // Series of println() calls to update display of the board and the current player's stats
      BoardView.loadBoard(board);
      System.out.println();
      System.out.print("Current Deck: ");
      for (CardModel c : turtle.getDeck().getDeck()) { System.out.print(c.getCard() + "; "); }
      System.out.println();
      System.out.println("Current Coordinates: " + Arrays.toString(turtle.getCoords()));
      System.out.println("Current Direction: " + turtle.getDirection());
      System.out.println();

      // Perform unfinished turtles' turns
      if (!turtle.isFinished()) {

        // Prompt the user to enter a valid move
        System.out.println("Player " + currTurtle + ", please enter your next move (mf, rl, or rr). . .");
        String move = input.nextLine();

        // Re-prompt the user to enter a valid move
        if (!isValidMove(move)) {
          System.out.println("Woah there partner, try again with a valid move!");
          System.out.println();
          continue;
        }

        switch (move) {
          // Move forward
          case "mf":
            int[] coords = turtle.getCoords(); 

            switch (turtle.getDirection()) {
              case "north":
                board.makeMove(turtle, coords[0] - 1, coords[1], finishedTurtles);
                break;

              case "east":
                board.makeMove(turtle, coords[0], coords[1] + 1, finishedTurtles);
                break;

              case "south":
                board.makeMove(turtle, coords[0] + 1, coords[1], finishedTurtles);
                break;

              case "west":
                board.makeMove(turtle, coords[0], coords[1] - 1, finishedTurtles);
                break;

              default:
                break;
            }
            turtle.addCard("MOVE FORWARD");
            break;

          // Rotate left
          case "rl":
            switch (turtle.getDirection()) {
              case "north": 
                turtle.setDirection("west");
                break;

              case "east": 
                turtle.setDirection("north");
                break;

              case "south": 
                turtle.setDirection("east");
                break;

              case "west":
                turtle.setDirection("south");
                break;

              default:
                break;
            }
            turtle.addCard("ROTATE LEFT");
            break;

          // Rotate right
          case "rr":
            switch (turtle.getDirection()) {
              case "north": 
                turtle.setDirection("east");
                break;

              case "east": 
                turtle.setDirection("south");
                break;

              case "south": 
                turtle.setDirection("west");
                break;

              case "west":
                turtle.setDirection("north");
                break;
                
              default:
                break;
            }
            turtle.addCard("ROTATE RIGHT");
            break;

          // Laser
          case "lz":
            coords = turtle.getCoords();

            switch (turtle.getDirection()) {
              case "north":
                board.makeLaser(coords[0] - 1, coords[1]);
                break;

              case "east":
                board.makeLaser(coords[0], coords[1] + 1);
                break;

              case "south":
                board.makeLaser(coords[0] + 1, coords[1]);
                break;

              case "west":
                board.makeLaser(coords[0], coords[1] - 1);
                break;

              default:
                break;
            }

            turtle.addCard("LASER");
            break;

          default:
            break;
        }
      }

      // If all players are finished
      if (finishedTurtles == playerSize){
        showEndMessage();
        return;
      }
      
      // Wrap around to the first unfinished player
      if (currTurtle == playerSize) { currTurtle = 1; }

      // Go to next player
      else { currTurtle++; }
    }
  }

}