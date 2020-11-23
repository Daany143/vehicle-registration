import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
/** This class represents the add vehicles screen.
 *  
 * @author Daanyaal Tahir
 */
public class AddVehicle extends JFrame {

	private JPanel contentPane;
	private JFrame current;
	private JFrame MainMenu;
	private JFrame AddCar;
	private JFrame AddTruck;
	private JFrame AddBoat;
	private JFrame originator;

	/**
	 * Create the frame.
	 */
	public AddVehicle() {

		this.current = this;
		this.MainMenu=originator;
		//Set bounds for screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Create title
		JTextPane title = new JTextPane();
		title.setForeground(Color.WHITE);
		title.setText("Select which vehicle to add:");
		title.setFont(new Font("Yu Gothic UI", Font.BOLD, 31));
		title.setOpaque(false);
		title.setBounds(206, 148, 401, 48);
		contentPane.add(title);
		
		
		//Code for Boat option button
		JLabel boat = new JLabel("");
		boat.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Add Boat screen
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				AddBoat newFrame = new AddBoat(current);
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Display "Boat" button
		boat.setIcon(new ImageIcon(AddVehicle.class.getResource("/Pictures/button_boat.png")));
		boat.setBounds(313, 262, 151, 59);
		contentPane.add(boat);
		
		
		//Code for Car option button 
		JLabel car = new JLabel("");
		car.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Add Car screen
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				AddCar newFrame = new AddCar(current);
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Display "Car" button
		car.setIcon(new ImageIcon(AddVehicle.class.getResource("/Pictures/button_car.png")));
		car.setBounds(313, 402, 141, 59);
		contentPane.add(car);
		
		
		//Code for Truck option button
		JLabel truck = new JLabel("");
		truck.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Add Truck screen
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				AddTruck newFrame = new AddTruck(current);
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Display "Truck" button
		truck.setIcon(new ImageIcon(AddVehicle.class.getResource("/Pictures/button_truck.png")));
		truck.setBounds(313, 332, 151, 59);
		contentPane.add(truck);
		
		
		//Code for Home Button
		JLabel homeButton = new JLabel("");
		homeButton.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Main Menu screen
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				MainMenu newFrame = new MainMenu();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Display Home Button icon
		homeButton.setIcon(new ImageIcon(AddVehicle.class.getResource("/Pictures/home3.png")));
		homeButton.setBounds(739, 11, 35, 42);
		contentPane.add(homeButton);
		
		
		//Add wallpaper
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon(AddVehicle.class.getResource("/Pictures/auto-road-bridge-cars-670516.jpg")));
		wallpaper.setBounds(0, 0, 784, 571);
		contentPane.add(wallpaper);
	}
}
