import java.util.ArrayList;
/** This class represents the arraylist for the vehicle collection program
 * @author Daanyaal Tahir
 */
public class VehicleCollection extends javax.swing.JFrame {
    private static ArrayList<Vehicles> manyVehicles = new ArrayList<>();

    /** Get a list of all the vehicles added to the program 
	 * @return an arraylist of vehicles
	*/
	public static ArrayList<Vehicles> getList() {
       return manyVehicles;
    }
 }