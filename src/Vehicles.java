/** The following is the super class, Vehicles
 *  
 * @author Daanyaal Tahir
 */
public abstract class Vehicles implements Comparable<Vehicles>{  

  private int millage;
  private String colour;
  private String company;
  private boolean electric;

  
 /** This is the Vehicles constructor which takes
  *  aMillage, aColour, aCompany, isElectric.
  * @param aMillage - the millage of the vehicle
  * @param aColour - the colour of the vehicle
  * @param aCompany - takes the company of the vehicle 
  * @param isElectric - takes boolean to see if the vehicle is or is not electric
 */
  public Vehicles(int aMillage, String aColour, String aCompany, boolean isElectric){
    this.millage = aMillage;
    this.colour = aColour;
    this.company = aCompany;
    this.electric = isElectric;
  }

  
 /** Get the millage of the vehicle
  * @return an int of the millage
  */
  public int getMillage(){
    return this.millage;
  }

  
  /** Get the colour of the vehicle
  * @return a string of the vehicle
  */
  public String getColour(){
    return this.colour;
  }

  
  /** Get the company of the vehicle
   * @return a string of the company
  */
  public String getCompany(){
    return this.company;
  }
  

  /** Get info on whether the vehicle is electric or not
	* @return a boolean, true for electric, false for not electric
	*/
  public boolean isElectric(){
    return this.electric;
  }
  
  
  /** a toString method
	 * @return a string of all the info on the vehicle collected from the array
 */
  public String toString(){
    return "|Colour: " + this.colour + " |Company: " + this.company + " |Millage: " + this.millage + " |Electric: " + this.electric;
  }

  
  /** Compare a vehicles millage to another
	* @return an int of whether the vehicle has more millage than the other vehicle, -1 (less than), 0 (equal to), 1 (greater than)
 */
  public int compareTo(Vehicles other){
    int diff = getMillage() - other.getMillage();
    return (int)Math.signum(diff);
  }

}
