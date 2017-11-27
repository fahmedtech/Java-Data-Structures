// Filename: Tile.java
// Author: Faizan Ahmed
// CSC 300 - Homework #3

public class Tile {
	
	// instance data members
	private char letter;
	private int value;
	
	// constructor
	public Tile(char let, int val) {  
		this.letter = let;
		this.value = val;
	}
	
	//get methods()
	public char getLetter(){return this.letter;}
	public int getValue(){return this.value;}
	
	public String toString(){
		String ret = "";
		ret = getLetter() + ", " + getValue();
		return ret;
	}
	
	// main()
	public static void main(String[] args)
	{
		Tile t1 = new Tile('K', 5);
		Tile t2 = new Tile('X', 8);
		
		System.out.println(t1.toString());
		System.out.println(t2.toString());
	}

}