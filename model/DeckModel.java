package model;

import java.util.ArrayList;

/*
* A model for storing an ArrayList of CardModel instances.
*
* COMP 3721 - Milestone 5
* @author Alexander Little & Logan DiAdams
*/
public class DeckModel {

  //--------------------------------------------------------------
  /* Instance variables */
  
  private ArrayList<CardModel> deck = new ArrayList<>();

  //--------------------------------------------------------------
  /* Getters */
  
  public ArrayList<CardModel> getDeck() { return deck; }

  //--------------------------------------------------------------
  /* Setters */
  
  public void add(String move) { deck.add(new CardModel(move)); }

  public void setDeck(ArrayList<CardModel> deck) { this.deck = deck; }

}