/** 
 * Filename: House.java
 * Decription: House class extended from Building 
 * Attributes: hasDiningRoom (boolean), an array list containing all residents, and a boolean for whether or not there is an elevator. 
 * Functions: hasDiningRoom(), nResidents(), moveOut(), moveIn(), and isResident().
 * Overriden Methods: showOptions(), and goToFloor()
 * Overloaded Methods: moveIn(), and isResidents()
 */

import java.util.ArrayList;

public class House extends Building {

  private ArrayList<String> residents;
  private ArrayList<String> pets;
  private Boolean hasDiningRoom;
  private Boolean elevator;

  /**
   * Constructor for the House class the extends Building class
   * @param name the name of the house
   * @param address the address of the house
   * @param nFloors the number of floors the house has
   * @param hasDiningRoom true or false if the house has a dining room
   */
  public House(String name, String address, int nFloors, Boolean hasDiningRoom, Boolean elevator) {
    super(name, address, nFloors);
    this.residents = new ArrayList<String>();
    this.pets = new ArrayList <String> ();
    this.hasDiningRoom = hasDiningRoom;
    this.elevator = elevator;
  }

  /**
   * Method that checks if the House has a dining room or not
   * @return true or false - whether the House has a dining room
   */
  public boolean hasDiningRoom() {
    return hasDiningRoom();
  }

   /**
   * Method that checks if the House has a elevator or not
   * @return true or false - whether the House has a elevator
   */
  public boolean Elevator(){
    return this.elevator; 
}

  /**
   * Method that accesses the number of the residents in the array list or House
   * @return the number of residents in the array list - or in the House
   */
  public int nResidents(){
    return this.residents.size();
  }

  /**
   * Method that adds a resident's name to the resident't array list.
   * @param name the resident's name that is being added to the array list or moving in
   */
  public void moveIn(String name) {
    if (this.residents.contains(name)) {
        throw new RuntimeException(name + " is already a resident of this house");
      }
      this.residents.add(name);
      System.out.println(name + " was moved into the house.");
}

/** @Overload
   * Method that adds a resident's pet to the pets' array list.
   * @param pet the resident's pets that is being added to the array list or moving in
   */
  public void moveIn(String name, String pet) {
    if (this.pets.contains(pet)) {
        throw new RuntimeException(pet + " is already a resident of this house");
      }
      this.pets.add(pet);
      System.out.println(pet + " was moved into the house.");
}

  /**
   * Method that removes the name of a resident from the residents array list. 
   * @param name the name of the resident who is moving out 
   * @return the resident's name that was removed from the array list
   */
  public String moveOut(String name) {
    if (this.residents.size() == 0){
        throw new RuntimeException("Sorry, there are no residents in this house");
      }
      if (!this.residents.contains(name)){
        throw new RuntimeException(name+ " is not a resident in this house");
      }
      this.residents.remove(name);
      System.out.println(name + " moved out of the house.");
      return name;
    }   

    @Override
    /*Override building method. 
    * If there's an elevator , the Building class original goToFloor() method is called. 
    * If there's no elevator, you can only go up or down one floor (stairs). 
    * @param floorNum the floor that you want to go to
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
                else if ((floorNum - this.activeFloor) ==1) {
                    this.activeFloor +=1;
                     System.out.println("You are now on floor #" + floorNum + " of " + this.name);
                    }
                    else if ((floorNum-this.activeFloor) ==-1) {
                        this.activeFloor -=1;
                        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
                    }
                }
            }
  /**
   * Boolean Method that checks if a person is in the residents array list 
   * @param person the name of the person that is being considered a resident or not
   * @return true or false - whether if the person is in the resident array list, followed by a message
   */
  public boolean isResident(String person) {
    return residents.contains(person);
  }

  /**
   * Boolean Method that checks if a person's pet is in the pets array list 
   * @param person the name of the person that is being considered a resident or not
   * @param pet the pet of the person that is being considered a resident or not
   * @return true or false - whether if the pet is in the resident array list
   */
  public boolean isResident(String person, String pet) {
    return pets.contains(pet);
  }

  @Override
  /* Overridden building method. 
  Calls building method and adds the House class functions. */
  public void showOptions() {
    super.showOptions();
    System.out.println(" + hasDiningRoom() \n + nResidents() \n + moveIn(name)\n + moveOut(name)\n + isResident(person)"); 
}
    
/* Main for testing! */
  public static void main(String[] args) {
    House gillett = new House("Gillett", "47 Elm Street", 5, false, true );
    System.out.println(gillett);
    gillett.moveIn("Destiny");
    gillett.moveIn("ABC");
    System.out.println(gillett.residents);
    gillett.moveOut("ABC");
    gillett.isResident("XYZ");
    System.out.println(gillett.residents);
    System.out.println(gillett.hasDiningRoom);
    System.out.println(gillett.nFloors);

  }

}