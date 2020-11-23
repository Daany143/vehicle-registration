import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
/** This class represents the add truck screen.
 *  
 * @author Daanyaal Tahir
 */
public class AddTruck extends JFrame {

	private JPanel contentPane;
	private JFrame current;
	private JFrame AddVehicle;
	private JTextField maxCapacity;
	private JTextField cargoLength;

	/**
	 * Create the frame.
	 * @param e - the previous frame
	 */
	public AddTruck(JFrame originator) {
		
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
		title.setEditable(false);
		title.setForeground(Color.WHITE);
		title.setText("Please fill in the following fields:");
		title.setBounds(131, 66, 530, 62);
		title.setFont(new Font("Yu Gothic UI", Font.BOLD, 31));
		title.setOpaque(false);
		contentPane.add(title);
		
		
		
		
		//Code for adding millage of truck
		//Display Millage label
		JTextPane txtpnMillage = new JTextPane();
		txtpnMillage.setForeground(Color.WHITE);
		txtpnMillage.setText("Millage: ");
		txtpnMillage.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		txtpnMillage.setBounds(177, 176, 79, 31);
		txtpnMillage.setOpaque(false);
		contentPane.add(txtpnMillage);
		
		//Create a textfield for the user to enter required information
		JTextField enteredMillage = new JTextField();
		enteredMillage.setBounds(354, 176, 159, 26);
		contentPane.add(enteredMillage);
		enteredMillage.setColumns(10);
		
		
		
		
		//Code for adding colour of truck
		//Display Colour label
		JTextPane txtpnColour = new JTextPane();
		txtpnColour.setText("Colour:");
		txtpnColour.setOpaque(false);
		txtpnColour.setForeground(Color.WHITE);
		txtpnColour.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		txtpnColour.setBounds(177, 229, 79, 31);
		contentPane.add(txtpnColour);
		
		//Create a textfield for the user to enter required information
		JTextField enteredColour = new JTextField();
		enteredColour.setColumns(10);
		enteredColour.setBounds(354, 234, 159, 26);
		contentPane.add(enteredColour);
		
		
		
		
		//Code for entering whether the truck is electric or not
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
		electricYes.setBounds(358, 342, 65, 23);
		electricYes.setOpaque(false);
		contentPane.add(electricYes);
		
		//Add 'no' radio button
		JRadioButton electricNo = new JRadioButton("No");
		electricNo.setOpaque(false);
		electricNo.setForeground(Color.WHITE);
		electricNo.setFont(new Font("Tahoma", Font.BOLD, 14));
		electricNo.setBounds(425, 342, 65, 23);
		contentPane.add(electricNo);
		

		
		
		//Code for entering the company of the truck
		//Display company label
		JTextField Company = new JTextField();
		Company.setColumns(10);
		Company.setBounds(354, 287, 159, 26);
		contentPane.add(Company);
		
		//Create a textfield for the user to enter required information
		JTextPane enteredCompany = new JTextPane();
		enteredCompany.setText("Company:");
		enteredCompany.setOpaque(false);
		enteredCompany.setForeground(Color.WHITE);
		enteredCompany.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		enteredCompany.setBounds(177, 282, 96, 31);
		contentPane.add(enteredCompany);

		
		
		
		//Code for the "Success" text 
		JLabel Result = new JLabel("");
		Result.setFont(new Font("Tahoma", Font.PLAIN, 14));
		Result.setForeground(Color.GREEN);
		Result.setBounds(296, 472, 79, 44);
		contentPane.add(Result);
		
		
		
		
		//Create "Clear" button
		JLabel clearButton = new JLabel("");
		clearButton.setIcon(new ImageIcon(AddTruck.class.getResource("/Pictures/button_clear (4).png")));
		clearButton.setBounds(177, 477, 109, 44);
		clearButton.setVisible(false);
		contentPane.add(clearButton);
		
		
		
		
		//Create warning text label
		JTextPane selectOnlyOne = new JTextPane();
		selectOnlyOne.setFont(new Font("Tahoma", Font.PLAIN, 14));
		selectOnlyOne.setForeground(Color.RED);
		selectOnlyOne.setBounds(354, 358, 308, 20);
		selectOnlyOne.setOpaque(false);
		selectOnlyOne.setVisible(false);
		contentPane.add(selectOnlyOne);
		
		
		
		
		//Code for entering the capacity of the truck
		//Create a textfield for the user to enter required information
		maxCapacity = new JTextField();
		maxCapacity.setColumns(10);
		maxCapacity.setBounds(354, 382, 159, 26);
		contentPane.add(maxCapacity);
		
		//Display capacity label
		JTextPane enteredCapacity = new JTextPane();
		enteredCapacity.setText("Max Capacity (Kg):");
		enteredCapacity.setOpaque(false);
		enteredCapacity.setForeground(Color.WHITE);
		enteredCapacity.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		enteredCapacity.setBounds(177, 382, 169, 31);
		contentPane.add(enteredCapacity);
		
		
		
		
		//Code for entering the cargo length of the truck
		//Create a textfield for the user to enter required information
		cargoLength = new JTextField();
		cargoLength.setColumns(10);
		cargoLength.setBounds(354, 435, 159, 26);
		contentPane.add(cargoLength);
		
		//Display cargo length label
		JTextPane enteredCargoLength = new JTextPane();
		enteredCargoLength.setText("Cargo Length (m):");
		enteredCargoLength.setOpaque(false);
		enteredCargoLength.setForeground(Color.WHITE);
		enteredCargoLength.setFont(new Font("Segoe UI Historic", Font.BOLD, 18));
		enteredCargoLength.setBounds(177, 435, 169, 31);
		contentPane.add(enteredCargoLength);
		
		
		
		
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
				int cargoInput = Integer.parseInt(cargoLength.getText());
				int capacityInput = Integer.parseInt(maxCapacity.getText());
				
				
				//Assign boolean value for whether the truck is electric or not from user input
				boolean isTruckElectric = true;
				if (electricYes.isSelected() == true) {
					if (electricNo.isSelected() == false) {
						isTruckElectric = true;
					}
				}
				if (electricNo.isSelected() == true) {
					if (electricYes.isSelected() == false) {
						isTruckElectric = false;
					}
				}
				
				//If both options are selected or not selected, display warning message. 
				if ((electricNo.isSelected() && electricYes.isSelected()) == true || (electricNo.isSelected() && electricYes.isSelected()) == false) {
					selectOnlyOne.setText("Please select only one of the above options");
					selectOnlyOne.setVisible(true);
				}

				//Adds all entered fields if following is correct
				//Checks to see if radio buttons are not left unchecked
				if ((electricNo.isSelected() && electricYes.isSelected()) == false) {
					//Adds paramters for vehicles into arraylist displaying "Success."
					manyVehicles.add(new Truck(millageInput, colourInput, companyInput, isTruckElectric, cargoInput,capacityInput ));
					Result.setVisible(true);
					Result.setText("Success!");
					selectOnlyOne.setVisible(false);
					//Makes add button invisible and clear button visible
					addButton.setVisible(false);
					clearButton.setVisible(true);
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
						AddTruck newFrame = new AddTruck(current);
						current.setVisible(false);
						newFrame.setVisible(true);
					}
				});

			}
		});
		
		//Insert icon for add button option
		addButton.setIcon(new ImageIcon(AddTruck.class.getResource("/Pictures/button_add (2).png")));
		addButton.setBounds(177, 481, 109, 40);
		contentPane.add(addButton);
		
		
		
		
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
		
		//Add back button icon
		backButton.setIcon(new ImageIcon(AddTruck.class.getResource("/Pictures/back button.png")));
		backButton.setBounds(729, 11, 45, 42);
		contentPane.add(backButton);
		
		
		
		
		//Add wallpaper
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon(AddTruck.class.getResource("/Pictures/AV-Trucks-187479297.jpg")));
		wallpaper.setBounds(0, 0, 784, 607);
		contentPane.add(wallpaper);
	}
}
