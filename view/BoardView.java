package view;

import model.*;

/*
* A view responsible for printing the board to the terminal.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class BoardView {

  public static void loadBoard(BoardModel board) {
    char[][] charGrid = new char[10][10];
    
    // Initialize the array with empty squares
    for (int i = 0; i < charGrid.length; i++) {
      for (int j = 0; j < charGrid.length; j++) { charGrid[i][j] = '▢'; }
    }

    for (int i = 0; i < charGrid.length; i++) {
      for (int j = 0; j < charGrid.length; j++) {

        ItemModel item = board.getItemAt(i, j);
        if (item == null) { continue; }

        int[] coords = item.getCoords();   
        String itemType = item.getItemType();

        switch (itemType) {
          case "Turtle":
            TurtleModel turtle = (TurtleModel) item;
            int id = turtle.getID();
            switch (id) {
              case 1:
                charGrid[coords[0]][coords[1]] = '1';
                break;
              case 2:
                charGrid[coords[0]][coords[1]] = '2';
                break;
              case 3:
                charGrid[coords[0]][coords[1]] = '3';
                break;
              case 4:
                charGrid[coords[0]][coords[1]] = '4';
                break;
              default:
                break;
            }
            break;

          case "Jewel":
            JewelModel jewel = (JewelModel) item;
            id = jewel.getID();
            switch (id) {
              case 1:
                charGrid[coords[0]][coords[1]] = 'a';
                break;
              case 2:
                charGrid[coords[0]][coords[1]] = 'b';
                break;
              case 3:
                charGrid[coords[0]][coords[1]] = 'c';
                break;
              case 4:
                charGrid[coords[0]][coords[1]] = 'd';
                break;
              default:
                break;
            }
            break;

          case "Stone":
            charGrid[coords[0]][coords[1]] = 'S';
            break;

          case "Crate":
            charGrid[coords[0]][coords[1]] = '■';
            break;

          case "Ice":
            IceWallModel ice = (IceWallModel) item;
            if (ice.isMelted()) {
              charGrid[coords[0]][coords[1]] = '◍';
            }
            else {
              charGrid[coords[0]][coords[1]] = 'I';
            }
            break;

          case "Portal":
            charGrid[coords[0]][coords[1]] = 'P';
            break;
        }
      }
    }

    // Print out each row of the grid
    for (char[] chars : charGrid) {
      for (int j = 0; j < charGrid.length; j++) {
        System.out.print(chars[j] + "  ");
      }
      System.out.println();
    }
  }

}