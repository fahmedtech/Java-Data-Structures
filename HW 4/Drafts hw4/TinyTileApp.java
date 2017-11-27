// Filename: Tile.java
// Author: Faizan Ahmed
// CSC 300 - Homework #3

public class TinyTileApp {
  // contain main() only
  public static void main(String[] args)
  {
    RandomBag<Tile> rbag = new RandomBag<Tile>();

    //adding the tiles
    rbag.add(new Tile('E',1)); rbag.add(new Tile('E',1));
    rbag.add(new Tile('A',1)); rbag.add(new Tile('A',1));
    rbag.add(new Tile('I',1));
    rbag.add(new Tile('R',1));
    rbag.add(new Tile('C',3));
    rbag.add(new Tile('P',3));   
    rbag.add(new Tile('K',5));
    rbag.add(new Tile('J',3));
    
    //randomly select 3 tiles 
    Tile t1 = rbag.randomRemoveOne();
    Tile t2 = rbag.randomRemoveOne();
    Tile t3 = rbag.randomRemoveOne();
    	
    //creating and printing the string
    String concat = t1.getLetter() + "" + t2.getLetter() + ""+ t3.getLetter();
    int sum = t1.getValue() + t2.getValue() + t3.getValue();
    System.out.println(concat + " -- " + sum);

  }
}
