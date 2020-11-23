/** This class represent a Boat that goes in a Vehicles.
 *  
 * @author Daanyaal Tahir
 */
public class Boat extends Vehicles{
  
  private int maxCapacity;
  private String boatType;

  /** This is the Boat constructor which takes
	 *  aMillage, aColour, aCompany, isElectric, aCapacity, aType.
	 * @param aMillage - the millage of the boat
	 * @param aColour - the colour of the boat
	 * @param aCompany - takes the company of the boat 
	 * @param isElectric - takes boolean to see if boat is or is not electric
	 * @param aCapacity - ask for the max persons the boat can fit 
	 * @param aType - ask for the type of the boat ie yatch, ferry etc
  */
  public Boat(int aMillage, String aColour, String aCompany, boolean isElectric, int aCapacity, String aType){
    super(aMillage, aColour, aCompany, isElectric);
    this.maxCapacity = aCapacity;
    this.boatType = aType;
  }

  /** Get a number of how many people can fit on the boat
	 * @return an int of the number of people that can fit
	*/
  public int getBoatCapacity(){
    return this.maxCapacity;
  }

	/** Get the type of boat
	 * @return a string of the type of the boat
	*/
  public String getBoatType(){
    return this.boatType;
  }
}
