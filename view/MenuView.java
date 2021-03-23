package view;

/*
* A view responsible for welcoming the player and printing their game options.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class MenuView {

  /* Display game art splash */
  public static void welcome() {
    System.out.println(" _____       _           _  \n" +     
                       "|  __ \\     | |         | | \n"  +   
                       "| |__) |___ | |__   ___ | |_   \n"  +
                       "|  _  // _ \\| '_ \\ / _ \\| __| \n"   +
                       "| | \\ \\ (_) | |_) | (_) | |_  \n"   + 
                       "|_|__\\_\\___/|_.__/ \\___/ \\__| \n"   +
                       "|__   __|       | | | |         \n" +
                       "   | |_   _ _ __| |_| | ___  ___ \n" +
                       "   | | | | | '__| __| |/ _ \\/ __| \n" +
                       "   | | |_| | |  | |_| |  __/\\__ \\\n" +
                       "   |_|\\__,_|_|   \\__|_|\\___||___/\n");
    printRules();
    printOptions();
  }
 
 /* Explain the rules to the player */
  private static void printRules() {
    System.out.println("Welcome to Robot Turtles! Your objective as a numbered turtle is to reach your lettered jewel.");
    System.out.println();
    System.out.println("For example, turtle '1' should go for jewel 'a', turtle '2' for 'b', and so on.");
    System.out.println();
    System.out.println("Each player will be presented four different actions: 'move forward', 'rotate left', 'rotate right', and 'laser'.");
    System.out.println();
    System.out.println("Crates are represented by ■: these can be moved forward one space with a player.");
    System.out.println();
    System.out.println("Portals are represented by P: these can be used to teleport to their counterpart portal and are single-use only.");
    System.out.println();
    System.out.println("Stone walls are represented by S: these are immovable objects");
    System.out.println();
    System.out.println("Ice walls are represented by I: these objects cannot be moved, but rather melted by using the laser (lz) action to become puddles (◍) which can be passed over.");
    System.out.println();
    System.out.println("Once all players have reached the jewels which correspond to their turtles, the game will end and everyone wins.");
    System.out.println();
    System.out.println("Good luck!");
    System.out.println();
  }

  /* Ask the user for how many players will be participating */
  private static void printOptions() {
    System.out.println("Please enter how many players would like to play Robot Turtles: ");
  }
}