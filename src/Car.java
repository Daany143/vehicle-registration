/** This class represent a Car that goes in a Vehicles.
 *  
 * @author Daanyaal Tahir
 */
public class Car extends Vehicles{
  
  private boolean frontTrunk;

  /** This is the Car constructor which takes
   *  aMillage, aColour, aCompany, isElectric, trunk.
   * @param aMillage - the millage of the boat
   * @param aColour - the colour of the boat
   * @param aCompany - takes the company of the boat 
   * @param isElectric - takes boolean to see if boat is or is not electric
   * @param trunk - takes boolean to see if the car has a front trunk
  */
  public Car(int aMillage, String aColour, String aCompany, boolean isElectric, boolean trunk){
    super(aMillage, aColour, aCompany, isElectric);
    this.frontTrunk = trunk;
  }

  /** Get a boolean to let the user know if the car has a front trunk or not, true for yes false for no
	 * @return a boolean if the car has a front trunk
 */
  public boolean hasFrontTrunk(){
    return this.frontTrunk;
  }

}