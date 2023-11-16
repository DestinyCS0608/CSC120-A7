/** 
 * Filename: Library.java
 * Decription: Library class extended from Building 
 * Attribute: a hashtable attribute containing all the titles in the library's collection. 
 * Functions: addTitle, removeTitle, checkOut, returnBook, containsTitle, isAvailable, and printCollection.
 * Overridden Methods: toString(), showOptions(), and goToFloor()
 * Overloaded Methods: checkOut(), and returnBook()
 */

import java.util.Hashtable;

public class Library extends Building {
  private Hashtable<String, Boolean> collection;
  private Boolean elevator;

    /**
     * Constructor for the library attrributes, includes the name, address, and amount of floors
     * @param name the name of the library
     * @param address the adress of the library
     * @param nFloors the amount of floors of the library
     */
    public Library(String name, String address, int nFloors, Boolean elevator) {
      super(name, address, nFloors);
      this.collection = new Hashtable<String, Boolean> ();
      this.elevator = elevator;
    }
  
    /**
     * Adds a book into the library's collection
     * @param title of the book wanted to be added in to the collection
     */
    public void addTitle(String title){
        if (this.collection.containsKey(title)){
            throw new RuntimeException(title+" is aleady a part of " + name + "'s collection");
      }
      this.collection.put(title, true);
      System.out.println(title + " was added to " + name + "'s collection");
    }
    
    /** 
     * Removes the book from the library's collection
     * @param title of the book wanted to remove from library's collection
     */
    public String removeTitle(String title){
        if (this.collection.size() == 0){
            throw new RuntimeException("Sorry, there are no books in " + name + "'s collection");
        }
        if (!this.collection.containsKey(title)){
            throw new RuntimeException("Sorry, "+title+" is not in " + name + "'s collection");
        }
        this.collection.remove(title);
        System.out.println(title+" was removed from " + name + "'s collection");
        return title;    
    }

    /**
     * Check out book from library
     * @param title of the book to check out
     */
    public void checkOut(String title){
      collection.replace(title, true, false);
    }

    /** 
     * Overloaded checkBook() to check out two books instead of one
     * @param title1 first title of the book to check out
     * @param title2 second title of the book to check out
     */
     public void checkOut(String title1, String title2){
      collection.replace(title1, true, false);
      collection.replace(title2, true, false);
    }

    /**
     * Returns two books
     * @param title of the book to return
     */
    public void returnBook(String title){
      collection.replace(title, false, true);
    }
    
    /** 
     * Overloaded returnBook() to returns two books instead of one
     * @param title1 first title of the book to return
     * @param title2 second title of the book to return
     */
    public void returnBook(String title1, String title2){
      collection.replace(title1, false, true);
      collection.replace(title2, false, true);
    }

    /** 
     * Returns true or false if the book is the library's collection
     * @param title of the book that may or may not be in the collection
     */
    public boolean containsTitle(String title){
        return collection.containsKey(title);
    }
    
    /**
     * Returns true or false if the book is available in the library's collection
     * @param title of the books wonder
     * @return
     */
    public boolean isAvailable(String title){
        return this.collection.get(title);
    }

    /**
     * Method that prints the library collection in an easy-to-read manner
     * Help from Geeks for Geeks: https://www.geeksforgeeks.org/how-to-iterate-through-hashtable-in-java/
     */
    public void printCollection(){
      System.out.println(name + "'s Collection:");
      collection.forEach( (key,value) ->
        System.out.println("Title: " + key + "\t\t Checkout Status: " + value
      ));
      
    }
    
    /* Overridden building method. 
    Calls building method using super and then adds the Library class functions. */
    public void showOptions() {
        super.showOptions();
        System.out.println(" + addTitle(title) \n + removeTitle(title) \n + checkOut(title)\n + returnBook(title)\n + containsTitle(title)\n + isAvailable(title)\n + printcollection()");
  }

  /**Override building method. 
   * If there's an elevator , the buildings original goToFloor() method is called. 
   * If there's no elevator, you can only go up or down one floor at a time (stairs). 
   * @param floorNum the floor that you want to travel to
   */
  public void goToFloor(int floorNum) {
    if (this.elevator == true) {
      System.out.println("...Ridng Elevator...");
      super.goToFloor(floorNum);
    }
    if (this.elevator == false) {
      if (this.activeFloor == -1) {
        throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
      }
      else if (floorNum < 1 || floorNum > this.nFloors) {
        throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
      }
      }
      else if ((floorNum - this.activeFloor) == 1) {
        this.activeFloor += 1;
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      }
      else if ((floorNum - this.activeFloor) ==-1) {
        this.activeFloor -=1;
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
      }
    }

/* Main for testing!*/
    public static void main(String[] args) {
     Library neilson = new Library("Neilson", "Smith campus", 4, true);
     neilson.addTitle("The Cat in the Hat");
     neilson.addTitle("Really Hard Textbook!");
     neilson.addTitle("Rabbit and the Hare");
     neilson.isAvailable("Rabbit and the Hare");

     neilson.checkOut("Rabbit and the Hare");
     neilson.isAvailable("Rabbit and the Hare");
     neilson.printCollection();
    }
  
  }