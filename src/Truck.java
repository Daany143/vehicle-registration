/** This class represent a Truck that goes in a Vehicles.
 *  
 * @author Daanyaal Tahir
 */
public class Truck extends Vehicles{
  
  private int weight;
  private int cargoLength;
  
  /** This is the Truck constructor which takes
	*  aMillage, aColour, aCompany, isElectric, num, aNum.
	* @param aMillage - the millage of the truck
	* @param aColour - the colour of the truck
	* @param aCompany - takes the company of the truck 
	* @param isElectric - takes boolean to see if truck is or is not electric
	* @param num - takes the max weight that the truck can carry
	* @param aNum - takes the length of the cargo
 */
  public Truck(int aMillage, String aColour, String aCompany, boolean isElectric, int num, int aNum){
    super(aMillage, aColour, aCompany, isElectric);
    this.weight = num;
    this.cargoLength = aNum;
  }

  /** Get the max weight that the truck can carry
	 * @return an int of the max weight
 */
  public int getWeight(){
    return this.weight;
  }
  
  /** Get the length of the cargo that the truck can carry
	 * @return an int of the length of the cargo that the truck can carry
 */
  public int getCargoLength(){
    return this.cargoLength;
  }
  
}