package controller;

import java.util.Scanner;
import view.MenuView;

/*
* A controller for handling the beginning of the game, i.e. the main menu.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class MainMenuController {

  //--------------------------------------------------------------
  /* Instance Variables */

  public static Scanner input = new Scanner(System.in);

  //--------------------------------------------------------------

  /* Open the game and its main menu */
  public static void run() {
    MenuView.welcome();
    go();
  }

  /* Begin the game with a given amount of turtles */
  private static void go() {
    int turtleCount = input.nextInt();
    PromptController.setGame(turtleCount);
  }

}