// Filename: Tile.java
// Author: Faizan Ahmed
// CSC 300 - Homework #3

import java.util.Iterator;
import java.util.Random;

import javax.xml.stream.events.Namespace;

/**
 * <i>RandomBag</i>. This class stores a collection of items in an array and,
 * in addition to the standard methods such as add() and size(), it allows the
 * client to pick an  item randomly (and the item is removed from the bag).
 */
@SuppressWarnings("unchecked")
public class RandomBag<E> implements Iterable<E> {

  private int N;    // number of elements in bag
  private E data[]; // data storage of this bag

  private Random rand; // random number generator

  /**
   * Create an empty bag (i.e., N is 0, but data is given an array of size 1.
   */
  public RandomBag() {
    N = 0;                      // no element
    data = (E[]) new Object[1]; // but physical storage of length 1
    rand = new Random(System.currentTimeMillis()); // random number generator
  }

  /**
   * Is the BAG empty?
   */
  public boolean isEmpty() {
    return N == 0;
  }

  /**
   * Return the number of items in the bag.
   */
  public int size() {
    return N;
  }

  /**
   * Add the item to the bag.
   */
  public void add(E item) {
    if (N == data.length) {
      resizing(N * 2);
    }
    data[N++] = item;
  }

  // private support method to resize the data array.. but only to be used to EXTEND the array.
  private void resizing(int max) {
    E temp[] = (E[]) new Object[max];
    
    for (int i = 0; i < N; i++)
      temp[i] = data[i];

    data = temp;
  }

  /**
   * Return an iterator that iterates over the items in the bag.
   */
  @Override
  public String toString() {
    StringBuilder builder = new StringBuilder("Len=" + data.length + ", N=" + N + ": [ ");
    for (E e : this) {
      builder.append(e); builder.append(" ");
    }
    builder.append("]");
    return builder.toString();
  }

  //added methods

  public void shuffle(){
	  
	 for (int i=0; i<data.length-1; i++){
		  int idx = rand.nextInt(N);
	  		E temp = data[idx];
	  		data[idx] = data[i];
	  		data[i] = temp; 
	  }
		
  }
  
  public E randomRemoveOne(){
	  
	  int idx = rand.nextInt(N);
	  E temp = data[idx];
	  //System.out.println(Arrays.toString(data));		
	   for(int i=idx; i < data.length-1; i++){
		  data[i] = data[i+1];
		  //System.out.println(Arrays.toString(data));
	   }
	   N--;
	   return temp;
	  
	 /* int idx = rand.nextInt(N);
	  E temp = data[idx];

	   for(int i=idx; i>0; i--)
		  data[i] = data[i-1];
	  	  data[0] = null; 
	  	return temp; */
	  
	 /* if (isEmpty())
		  return null;
	  int idx = rand.nextInt(N);
	  E temp = data[idx];
	  data[idx] = data[--N];
	  data[N] = null;
	  return temp;
*/  }
  
  public void trimToSize(){
	  
	  if (N < data.length){
		  E newArray[];
		  newArray = (E []) new Object[N];  	
	  for (int i=0; i<N; i++)
		  newArray[i] = data[i];
	  	  data = newArray;
	
	  	
	  	//N = data.length;
	 }
  }


  /**
   * Return an iterator that iterates over the items in the bag.
   */
  @Override
  public Iterator<E> iterator() {
    return new RandomBagIterator();
  }

  /**
   * <i>RandomBagIterator</i>.  A simple iterator which traverses the data array
   *   from the 0th to the last element (where the bag contains N elements).
   */
  private class RandomBagIterator implements Iterator<E> {

   // instance variable
    int index = 0;

    // full defition of the methods in the Iterator interface
    @Override
    public boolean hasNext() {
      return index < N;
    }

    @Override
    public E next() {
      E answer = data[index];
      index++;
      return answer;
    }

    @Override
    public void remove() { /* omitted for now */ }

  } // end RandomBagIterator

  /**
   * main()
   */
  public static void main(String[] args)
  {
    String names[ ] = {"aa", "bb", "cc", "dd", "ee", "ff", "gg"};
    RandomBag<String> rbag = new RandomBag<String>();

    for (String s : names)
      rbag.add(s); // add in the Bag

    // (1) Use an Iterator to iterate/traverse the bag
    System.out.print("Bag contains --  ");
    Iterator<String> it = rbag.iterator();
    while (it.hasNext())
    {
      String n = it.next();
      System.out.printf("%s ", n);
    }
    System.out.printf("%n");

    // (2) Shuffle the bag
    rbag.shuffle();

    // (3) Another way by the for-each syntax
    System.out.print("After shuffle -- ");
    for (String n : rbag)
      System.out.printf("%s ", n);
    System.out.printf("%n%n");

    // (4)
    for (int i = 0; i < 3; ++i) {
      String element = rbag.randomRemoveOne();
      System.out.println("Removed: " + element);
      System.out.println(rbag);
      System.out.println();
    }

    // (5) Call trimToSize(), and print the bag using toString()
    rbag.trimToSize();
    System.out.println("---------------------\nAfter trimToSize()");
    System.out.println(rbag);
    System.out.println();

  } // end main()
} // end class

/* Sample output

Bag contains --  aa bb cc dd ee ff gg
After shuffle -- ee gg cc aa ff bb dd

Removed: cc
Len=8, N=6: [ ee gg aa ff bb dd ]

Removed: gg
Len=8, N=5: [ ee aa ff bb dd ]

Removed: ff
Len=8, N=4: [ ee aa bb dd ]

---------------------
After trimToSize()
Len=4, N=4: [ ee aa bb dd ]

*/