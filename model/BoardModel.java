package model;

import java.util.Random;
import java.util.ArrayList;

/*
* A model for storing the contents of the board and its logic.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class BoardModel {

  //--------------------------------------------------------------
  /* Instance Variables */
  
  public static final int GRID_SIZE = 10;

  public int turtleCount;
  public ItemModel[][] grid;
  public TurtleModel[] turtles;
  public JewelModel[] jewels;
  public PortalModel[] portals;

  //--------------------------------------------------------------
  /* Constructor */

  public BoardModel(int turtleCount) throws IllegalArgumentException {
    this.turtleCount = turtleCount;
    this.grid = new ItemModel[GRID_SIZE][GRID_SIZE];
    this.turtles = new TurtleModel[turtleCount];
    this.portals = new PortalModel[2];

    // Depending on the number of players, sets up new turtles with respective jewels
    switch (turtleCount) {
      case 1:
        turtles[0] = new TurtleModel(1, 0, 0);
        this.jewels = new JewelModel[]{ new JewelModel(1, 4, 4) };
        break;

      case 2:
        turtles[0] = new TurtleModel(1, 0, 0);
        turtles[1] = new TurtleModel(2, 0, 9);
        this.jewels = new JewelModel[]{
          new JewelModel(1, 4, 4), 
          new JewelModel(2, 4, 5)
        };
        break;

      case 3:
        turtles[0] = new TurtleModel(1, 0, 0);
        turtles[1] = new TurtleModel(2, 0, 9);
        turtles[2] = new TurtleModel(3, 9, 0);
        this.jewels = new JewelModel[]{
          new JewelModel(1, 4, 4), 
          new JewelModel(2, 4, 5), 
          new JewelModel(3, 5, 4)
        };
        break;

      case 4:
        turtles[0] = new TurtleModel(1, 0, 0);
        turtles[1] = new TurtleModel(2, 0, 9);
        turtles[2] = new TurtleModel(3, 9, 0);
        turtles[3] = new TurtleModel(4, 9, 9);
        this.jewels = new JewelModel[]{
          new JewelModel(1, 4, 4), 
          new JewelModel(2, 4, 5), 
          new JewelModel(3, 5, 4),
          new JewelModel(4, 5, 5)
        };
        break;

      default:
        throw new IllegalArgumentException("Did not choose between 1 and 4 players!");
    }

    // Add created turtles to the board
    for (TurtleModel turtle : turtles)
      grid[turtle.getR()][turtle.getC()] = turtle;

    // Add created jewels to the board
    for (JewelModel jewel : jewels)
      grid[jewel.getR()][jewel.getC()] = jewel;

    ArrayList<int[]> nums = rand();

    // Add stone walls to the board
    for (int i = 0; i < 6; i++) { 
      grid[nums.get(i)[0]][nums.get(i)[1]] = new StoneWallModel(nums.get(i)[0], nums.get(i)[1]); 
    }

    // Add ice walls to the board
    for (int i = 6; i < 12; i++) {
      grid[nums.get(i)[0]][nums.get(i)[1]] = new IceWallModel(nums.get(i)[0], nums.get(i)[1]); 
    }
  
    // Add crates to the board
    for (int i = 12; i < 18; i++) {
      grid[nums.get(i)[0]][nums.get(i)[1]] = new CrateModel(nums.get(i)[0], nums.get(i)[1]); 
    }

    // Add portals to the board
    for (int i = 18; i < 20; i++) {
      PortalModel portal = new PortalModel(nums.get(i)[0], nums.get(i)[1]);

      if (i == 18) { 
        portals[0] = portal; 
      } else { 
        portals[1] = portal; 
      }

      grid[nums.get(i)[0]][nums.get(i)[1]] = portal; 
    }
  }

  //--------------------------------------------------------------
  /* Getters */

  public TurtleModel[] getTurtles() { return turtles; }

  public TurtleModel getTurtle(int n) { return turtles[n - 1]; }

  public JewelModel[] getJewels() { return jewels; }

  public JewelModel getJewel(int n) { return jewels[n - 1]; }

  public ItemModel[][] getGrid() { return grid; }

  public ItemModel getItemAt(int r, int c) { return grid[r][c]; }

  public PortalModel[] getPortals() { return portals; }

  //--------------------------------------------------------------
  /* Setters */

  /* Removes an item at a given spot on the grid, replacing it with null */
  public void removeItem(int r, int c) { grid[r][c] = null; }

  /* Updates a given turtle coordinates to a given space */
  public void setNewTurtleCoords(TurtleModel t, int r, int c) {
    grid[r][c] = t;
    t.setCoords(r, c);
  }

  public void setNewCrateCoords(CrateModel crate, int r, int c) {
    grid[r][c] = crate;
    crate.setCoords(r, c);
  }

  //--------------------------------------------------------------
  /* Functions */

  /* Helper method to create 14 pairs of coordinates which do not include 0, 4, 5 
  or 10 so as to not overlap starting turtles or jewels. */
  public ArrayList<int[]> rand() {
        ArrayList<int[]> nums = new ArrayList<>();
        Random random = new Random();

        while (nums.size() < 20) {
            int a = random.nextInt(7) + 1;
            int b = random.nextInt(7) + 1;
            if (a == 4 || a == 5 || b == 4 || b == 5) { continue; }

            boolean contains = false;
            for (int[] num : nums) {
              if (num[0] == a && num[1] == b) {
                contains = true;
                break;
              }
            }
            if (!contains) { nums.add(new int[] {a, b}); }
        }

        return nums;
  }

  public boolean isNotOutOfBounds(int r, int c) {
    return r >= 0 && r <= 9 && c >= 0 && c <= 9;
  }

  /* Method for moving turtles forward one space, if game rules permit */
  public void makeMove(TurtleModel turtle, int r, int c, int finishedTurtles) {
    int[] coords = turtle.getCoords();

    // Next space is not outside the grid
    if (isNotOutOfBounds(r, c)) {
      // Acquire item stored in next space
      ItemModel item = getItemAt(r, c);

      // Next space is empty, move turtle
      if (item == null) {
        removeItem(coords[0], coords[1]);
        setNewTurtleCoords(turtle, r, c);
      }

      // Next space contains an item
      else {
        String itemType = item.getItemType();

        switch (itemType) {

          case "Jewel":
            JewelModel jewel = (JewelModel) item;

            // Jewel does not belong to player, do nothing
            if (turtle.getID() != jewel.getID()) { return; }

            // Jewel belongs to player, move turtle
            else {
              removeItem(coords[0], coords[1]);
              setNewTurtleCoords(turtle, r, c);
              turtle.setAsFinished();
              finishedTurtles++;
            }

            break;

          case "Portal":
            PortalModel[] portals = getPortals();
            removeItem(turtle.getR(), turtle.getC());

            if (portals[0] != item) {
              removeItem(portals[1].getR(), portals[1].getC());
              setNewTurtleCoords(turtle, portals[0].getR(), portals[0].getC());
            }
            else {
              removeItem(portals[0].getR(), portals[0].getC());
              setNewTurtleCoords(turtle, portals[1].getR(), portals[1].getC());
            }

            break;

          case "Crate":
            CrateModel crate = (CrateModel) item;
            int[] crateCoords = item.getCoords();
            String dir = turtle.getDirection();

            switch (dir) {
              case "north":
                if (makeCrateMove(crate, crateCoords[0] - 1, crateCoords[1])) {
                  makeMove(turtle, coords[0] - 1, coords[1], finishedTurtles);
                }
                break;

              case "east":
                if (makeCrateMove(crate, crateCoords[0], crateCoords[1] + 1)) {
                  makeMove(turtle, coords[0], coords[1] + 1, finishedTurtles);
                }
                break;

              case "south":
                if (makeCrateMove(crate, crateCoords[0] + 1, crateCoords[1])) {
                  makeMove(turtle, coords[0] + 1, coords[1], finishedTurtles);
                }
                break;

              case "west":
                if (makeCrateMove(crate, crateCoords[0], crateCoords[1] - 1)) {
                  makeMove(turtle, coords[0], coords[1] - 1, finishedTurtles);
                }
                break;

              default:
                break;
            }

            break;

          case "Ice":
            IceWallModel ice = (IceWallModel) item;
            if (ice.isMelted()) {
              removeItem(coords[0], coords[1]);
              setNewTurtleCoords(turtle, r, c);
            }
            break;

          default:
            break; //a leg
        }
      }
    }
  }

  /* Method for moving crates forward one space, if game rules permit */
  public boolean makeCrateMove(CrateModel crate, int r, int c) {
    if (isNotOutOfBounds(r, c)) {
      ItemModel item = getItemAt(r, c);
      int[] coords = crate.getCoords();

      if (item == null) {
        removeItem(coords[0], coords[1]);
        setNewCrateCoords(crate, r, c);
        return true;
      }

      // Check for puddle
      else {
        String itemType = item.getItemType();

        if (itemType.equals("Ice")) {
          IceWallModel ice = (IceWallModel) item;

          if (ice.isMelted()) {
            removeItem(coords[0], coords[1]);
            setNewCrateCoords(crate, r, c);
            return true;
          }
        }
      }
    }
    return false;
  }

  /* Method for a turtle to melt a wall in the space in front of it */
  public void makeLaser(int r, int c) {
    if (isNotOutOfBounds(r, c)) {
      // Acquire item stored in next space
      ItemModel item = getItemAt(r, c);

      if (item != null && item.getItemType().equals("Ice")) {
        IceWallModel ice = (IceWallModel) item;
        ice.melt();
      }
    }
  }

}