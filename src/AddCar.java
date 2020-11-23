import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
/** This class represents the add car screen.
 *  
 * @author Daanyaal Tahir
 */
public class AddCar extends JFrame {

	private JPanel contentPane;
	private JTextField enteredMillage;
	private JTextField enteredColour;
	private JTextField Company;
	private JFrame AddVehicle;
	private JFrame current;


	/**
	 * Create the Add Car frame.
	 * @param e - the previous frame
	 */
	public AddCar(JFrame originator) {
		
		this.current = this;
		this.AddVehicle=originator;
		
		
		//Get the vehicle arraylist
		ArrayList<Vehicles> manyVehicles = VehicleCollection.getList();
		
		
		
		
		//Set bounds for screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		//Create title of screen
		JTextPane title = new JTextPane();
		title.setForeground(Color.WHITE);
		title.setText("Please fill in the following fields:");
		title.setBounds(131, 66, 530, 62);
		title.setFont(new Font("Yu Gothic UI", Font.BOLD, 31));
		title.setOpaque(false);
		contentPane.add(title);
		
		
		
		
		//Code for adding millage of car
		//Display Millage label
		JTextPane txtpnMillage = new JTextPane();
		txtpnMillage.setForeground(Color.WHITE);
		txtpnMillage.setText("Millage: ");
		txtpnMillage.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		txtpnMillage.setBounds(177, 176, 79, 31);
		txtpnMillage.setOpaque(false);
		contentPane.add(txtpnMillage);
		
		//Create a textfield for the user to enter required information
		enteredMillage = new JTextField();
		enteredMillage.setBounds(291, 176, 159, 26);
		contentPane.add(enteredMillage);
		enteredMillage.setColumns(10);
		
		
		
		
		//Code for adding colour of car
		//Display Colour label
		JTextPane txtpnColour = new JTextPane();
		txtpnColour.setText("Colour:");
		txtpnColour.setOpaque(false);
		txtpnColour.setForeground(Color.WHITE);
		txtpnColour.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		txtpnColour.setBounds(177, 229, 79, 31);
		contentPane.add(txtpnColour);
		
		//Create a textfield for the user to enter required information
		enteredColour = new JTextField();
		enteredColour.setColumns(10);
		enteredColour.setBounds(291, 234, 159, 26);
		contentPane.add(enteredColour);
		
		
		
		
		//Code for entering whether the car is electric or not
		//Display Electric label
		JTextPane txtpnElectric = new JTextPane();
		txtpnElectric.setText("Electric:");
		txtpnElectric.setOpaque(false);
		txtpnElectric.setForeground(Color.WHITE);
		txtpnElectric.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		txtpnElectric.setBounds(177, 334, 79, 31);
		contentPane.add(txtpnElectric);
		
		//Add 'yes' radio button
		JRadioButton electricYes = new JRadioButton("Yes");
		electricYes.setFont(new Font("Tahoma", Font.BOLD, 14));
		electricYes.setForeground(Color.WHITE);
		electricYes.setBounds(295, 342, 65, 23);
		electricYes.setOpaque(false);
		contentPane.add(electricYes);
		
		//Add 'no' radio button
		JRadioButton electricNo = new JRadioButton("No");
		electricNo.setOpaque(false);
		electricNo.setForeground(Color.WHITE);
		electricNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		electricNo.setBounds(362, 342, 65, 23);
		contentPane.add(electricNo);
		
		
		
		
		//Code for entering whether the car has a frunk or not
		//Display frunk label
		JTextPane txtpnHasFrunk = new JTextPane();
		txtpnHasFrunk.setText("Has frunk:");
		txtpnHasFrunk.setOpaque(false);
		txtpnHasFrunk.setForeground(Color.WHITE);
		txtpnHasFrunk.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		txtpnHasFrunk.setBounds(177, 388, 96, 31);
		contentPane.add(txtpnHasFrunk);
		
		//Add 'yes' option
		JRadioButton frunkYes = new JRadioButton("Yes");
		frunkYes.setOpaque(false);
		frunkYes.setForeground(Color.WHITE);
		frunkYes.setFont(new Font("Tahoma", Font.BOLD, 14));
		frunkYes.setBounds(295, 396, 65, 23);
		contentPane.add(frunkYes);
		
		//Add 'yes' option
		JRadioButton frunkNo = new JRadioButton("No");
		frunkNo.setOpaque(false);
		frunkNo.setForeground(Color.WHITE);
		frunkNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		frunkNo.setBounds(362, 396, 65, 23);
		contentPane.add(frunkNo);
		

		
		
		//Code for entering the company of the car
		//Display company label
		JTextPane enteredCompany = new JTextPane();
		enteredCompany.setText("Company:");
		enteredCompany.setOpaque(false);
		enteredCompany.setForeground(Color.WHITE);
		enteredCompany.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		enteredCompany.setBounds(177, 282, 96, 31);
		contentPane.add(enteredCompany);
		
		//Create a textfield for the user to enter required information
		Company = new JTextField();
		Company.setColumns(10);
		Company.setBounds(291, 287, 159, 26);
		contentPane.add(Company);

		
		
		
		//Code for the "Success" text 
		JLabel Result = new JLabel("");
		Result.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Result.setForeground(Color.GREEN);
		Result.setBounds(177, 495, 79, 26);
		contentPane.add(Result);
		
		
		
		
		//Create "Clear" button
		JLabel clearButton = new JLabel("");
		clearButton.setIcon(new ImageIcon(AddCar.class.getResource("/Pictures/button_clear (4).png")));
		clearButton.setBounds(177, 450, 109, 44);
		clearButton.setVisible(false);
		contentPane.add(clearButton);
		
		
		
		
		//Create warning text label
		JTextPane selectOnlyOne = new JTextPane();
		selectOnlyOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectOnlyOne.setForeground(Color.RED);
		selectOnlyOne.setBounds(292, 359, 308, 20);
		selectOnlyOne.setOpaque(false);
		selectOnlyOne.setVisible(false);
		contentPane.add(selectOnlyOne);
		
		JTextPane selectOnlyOne2 = new JTextPane();
		selectOnlyOne2.setOpaque(false);
		selectOnlyOne2.setForeground(Color.RED);
		selectOnlyOne2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectOnlyOne2.setBounds(291, 419, 308, 20);
		selectOnlyOne2.setVisible(false);
		contentPane.add(selectOnlyOne2);
		
		
		
		//Create Back button
		JLabel backButton = new JLabel("");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Add Vehicles screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				AddVehicle newFrame = new AddVehicle();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		
		
		
		//Create Add button
		JLabel addButton = new JLabel("");
		addButton.setForeground(Color.WHITE);
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			/** Adds all the given fields into the arraylist
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				
				//Make the result hidden 
				Result.setVisible(false);
				
				//Accept the entered fields and assign values to new variables
				int millageInput = Integer.parseInt(enteredMillage.getText());
				String colourInput = enteredColour.getText();
				String companyInput = Company.getText();
				
				//Assign boolean value for whether the car is electric or not from user input
				boolean isCarElectric = true;
				if (electricYes.isSelected() == true) {
					if (electricNo.isSelected() == false) {
						isCarElectric = true;
					}
				}
				if (electricNo.isSelected() == true) {
					if (electricYes.isSelected() == false) {
						isCarElectric = false;
					}
				}
				
				//If both options are selected or not selected, display warning message. 
				if ((electricNo.isSelected() && electricYes.isSelected()) == true || (electricNo.isSelected() && electricYes.isSelected()) == false) {
					selectOnlyOne.setText("Please select only one of the above options");
					selectOnlyOne.setVisible(true);
				}

				//Assign boolean value for whether the car has a frunk or not from user input
				boolean carHasFrunk = false;
				if (frunkYes.isSelected() == true) {
					carHasFrunk = true;
				}
				if (frunkNo.isSelected() == true) {
					carHasFrunk = false;
				}
				//If both options are selected or not selected, display warning message. 
				if ((frunkYes.isSelected() && frunkNo.isSelected()) == true || (frunkYes.isSelected() && frunkNo.isSelected()) == false) {
					selectOnlyOne2.setText("Please select one of the above options");
					selectOnlyOne2.setVisible(true);
				}
				//Adds all entered fields if following is correct
				//Checks to see if radio buttons are not left unchecked
				if ((frunkYes.isSelected() && frunkNo.isSelected()) == false) {
					if ((electricNo.isSelected() && electricYes.isSelected()) == false) {
						//Check to see if the user selects one option for frunk and electric option
						if (((frunkYes.isSelected() || frunkNo.isSelected()) && (electricNo.isSelected() || electricYes.isSelected())) == true) {
							//Adds paramters for vehicles into arraylist printing "Success."
							manyVehicles.add(new Car(millageInput, colourInput, companyInput, isCarElectric, carHasFrunk));
							Result.setVisible(true);
							Result.setText("Success!");
							//Makes add button invisible and clear button visible
							selectOnlyOne.setVisible(false);
							selectOnlyOne2.setVisible(false);
							addButton.setVisible(false);
							clearButton.setVisible(true);
						}
						
					}
				}
				
				//Add event listener for clear button
				clearButton.addMouseListener(new MouseAdapter() {
					@Override
					/** Clear the frame
					 * 
					 * @param e - whether the mouse has been pressed
					 */
					public void mousePressed(MouseEvent arg0) {
						//Makes new frame visible and previous frame invisible
						AddCar newFrame = new AddCar(current);
						current.setVisible(false);
						newFrame.setVisible(true);
					}
				});
			}
		});
		//Insert icon for add button option
		addButton.setIcon(new ImageIcon(AddCar.class.getResource("/Pictures/button_add (2).png")));
		addButton.setBounds(177, 454, 109, 40);
		contentPane.add(addButton);
		
		//Add icon for back button option
		backButton.setIcon(new ImageIcon(AddCar.class.getResource("/Pictures/back button.png")));
		backButton.setBounds(729, 11, 45, 42);
		contentPane.add(backButton);
		

	
		//Add wallpaper
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon(AddCar.class.getResource("/Pictures/tesla-model-s-p100d-2-1500x1000.jpg")));
		wallpaper.setBounds(0, 0, 784, 577);
		contentPane.add(wallpaper);
	}
}
