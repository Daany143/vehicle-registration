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

/** This class represents the main menu screen.
 *  
 * @author Daanyaal Tahir
 */

public class MainMenu extends JFrame {

	private JPanel contentPane;
	private JFrame StartPage;
	private JFrame current;
	private JFrame DisplayVehicle;
	private JFrame originator;

	/**
	 * Create the main menu frame.
	 */
	public MainMenu() {
		this.current = this;
		this.StartPage=originator;
		//Set bounds of screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Code for the "Add Vehicle" button
		JLabel addVehicle = new JLabel("");
		addVehicle.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Add Vehicles screen
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				AddVehicle newFrame = new AddVehicle();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Display the button
		addVehicle.setIcon(new ImageIcon(MainMenu.class.getResource("/Pictures/button_add-vehicle.png")));
		addVehicle.setBounds(316, 258, 131, 46);
		contentPane.add(addVehicle);
		
		
		//Create title of screen
		JTextPane Title = new JTextPane();
		Title.setForeground(new Color(255, 255, 255));
		Title.setText("Select one of the following options:");
		Title.setFont(new Font("Yu Gothic UI", Font.BOLD, 32));
		Title.setBounds(142, 108, 541, 57);
		Title.setOpaque(false);
		contentPane.add(Title);
		
		
		//Code for "Display Vehicles" button
		JLabel displayVehicles = new JLabel("");
		displayVehicles.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Display Vehicles screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				DisplayVehicle newFrame = new DisplayVehicle(current);
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Make "Display Vehicles" button visible
		displayVehicles.setIcon(new ImageIcon(MainMenu.class.getResource("/Pictures/button_display-vehicle.png")));
		displayVehicles.setBounds(316, 324, 131, 46);
		contentPane.add(displayVehicles);
		
		
		//Add wallpaper
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon(MainMenu.class.getResource("/Pictures/asphalt-clouds-fields-56832.jpg")));
		wallpaper.setBounds(0, 0, 784, 594);
		contentPane.add(wallpaper);
	}

}
