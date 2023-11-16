/** 
 * Filename: Cafe.java
 * Decription: Cafe class extended from Building class 
 * Attributes: nCoffeeOunces, nSugarPackets, nCreams, and nCups
 * New Attribute: nIce
 * Contains functions sellCoffee, and restock.
 * Overridden Methods: toString(), showOptions(), and goToFloor()
 * Overloaded Methods: restock() and sellCoffee()
 */

public class Cafe extends Building{
    private int nCoffeeOunces; 
    private int nSugarPackets;
    private int nCreams; 
    private int nCups; 
    private int nIce;

    /**
     * Constructor for the cafe attrributes, includes the name, address, and amount of floor of the cafe
     * while setting the initial values for coffee, sugar, cream, and cups
     * new attribute -- ice
     * @param name the name of the cafe
     * @param address the adress of the cafe
     * @param nFloors the amount of floors of the cafe
     */
    public Cafe(String name, String address, int nFloors){
        super(name, address, nFloors);
        this.nCoffeeOunces = 60;
        this.nSugarPackets = 50;
        this.nCreams = 30;
        this.nCups = 40; 
        this.nIce = 20;
    }

    /**
     * Method that sells coffee by decreasing the amount of coffee, sugar, cream, and cups
     * @param size the coffee sizes in ounces
     * @param nSugarPackets the amount of sg
     * @param nCreams
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams){
        if (this.nCoffeeOunces<size || this.nSugarPackets<nSugarPackets || this.nCreams<nCreams || this.nCups == 0) {
            System.out.println("Stock is low, we are restocking!");
            restock(size, nSugarPackets, nCreams, 1);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        System.out.println("Coffee succesfully sold!");
    }

    /**
     * Method that sells ICE coffee by decreasing the amount of coffee, sugar, cream, cups, and ice
     * @param size the coffee sizes in ounces
     * @param nSugarPackets the amount of sg
     * @param nCreams the amount of creams
     * @param nIce the amount of ice
     */
    public void sellCoffee(int size, int nSugarPackets, int nCreams, int nIce){
        if (this.nCoffeeOunces < size || this.nSugarPackets < nSugarPackets || this.nCreams < nCreams || this.nCups == 0 || this.nIce < nIce) {
            System.out.println("Stock is low, we are restocking!");
            restock(size, nSugarPackets, nCreams, 1);
            restock(nIce);
        }
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= nSugarPackets;
        this.nCreams -= nCreams;
        this.nCups -= 1;
        this.nIce -= nIce;
        System.out.println("Coffee succesfully sold!");
    }

    /**
     * Method that restocks the cafe coffee, sugar, creams, and cups
     * @param nCoffeeOunces the amount of coffee
     * @param nSugarPackets the amount of sugar packets
     * @param nCreams the amount of creams
     * @param nCups the amount of cups
     */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
        nCoffeeOunces += nCoffeeOunces;
        nSugarPackets += nSugarPackets;
        nCreams += nCreams;
        nCups += nCups; 
    }

    /** @Overload -- to restock only ice.
     * @param nIce the number of ice to be added to the current stock
     */
    private void restock(int nIce) {
        this.nIce += nIce;
    }

    @Override
    /* Override Building class showOptions() method. 
     * Calls Building class method using super and then adds the Cafe class functions. */
    public void showOptions() {
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown() \n + goToFloor(n) \n + sellCoffee(n, n, n, n) \n + restock(n, n, n, n) \n");
    }
    
    @Override
     /* Overload goToFloor() method
     * @param floorNum the floor that you want to go to 
     * Throws run time exception because cafes only have one floor
     */
    public void goToFloor(int floorNum) {
        throw new RuntimeException("Cafe's only have one floor!"); 
    }

    /* Main used for testin the Cafe class*/
    public static void main(String[] args) {
        Cafe starbucks = new Cafe("Starbucks", "time square", 2);

        starbucks.sellCoffee(12,3,4);
        starbucks.sellCoffee(75,100, 89);
        starbucks.restock(7);
        System.out.println("Coffee ounces in Starbucks Cafe: " + starbucks.nCoffeeOunces);
        System.out.println("Sugar in Starbucks Cafe: " + starbucks.nSugarPackets);

    }
    
}
