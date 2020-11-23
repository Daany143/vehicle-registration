import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JTable;
/** This class represents the display vehicles screen.
 *  
 * @author Daanyaal Tahir
 */
public class DisplayVehicle extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JFrame originator;
	private JFrame current;
	private JFrame MainMenu;

	/**
	 * Create the frame.
	 * @param e - the previous frame
	 */
	public DisplayVehicle(JFrame originator) {
		
		this.MainMenu=originator;
		this.current = this;
		
		
		
		//Set bounds for screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		//Set bounds for screen
		JTextPane title = new JTextPane();
		title.setForeground(Color.WHITE);
		title.setText("Select which vehicle entries to view:");
		title.setFont(new Font("Yu Gothic UI", Font.BOLD, 31));
		title.setOpaque(false);
		title.setBounds(145, 138, 522, 48);
		contentPane.add(title);
		
		
		
		//Create home button
		JLabel homeButton = new JLabel("");
		homeButton.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Main Menu screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				MainMenu newFrame = new MainMenu();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Set icon and placement of home button
		homeButton.setIcon(new ImageIcon(AddVehicle.class.getResource("/Pictures/home3.png")));
		homeButton.setBounds(739, 11, 35, 42);
		contentPane.add(homeButton);
		

		
		//Create display cars button
		JLabel displayCars = new JLabel("");
		displayCars.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Main Menu screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				DisplayCars newFrame = new DisplayCars();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Set icon and placement of display cars button
		displayCars.setIcon(new ImageIcon(DisplayVehicle.class.getResource("/Pictures/button_display-cars (1).png")));
		displayCars.setBounds(310, 264, 136, 56);
		contentPane.add(displayCars);
		
		
		
		//Create display boats button
		JLabel displayBoats = new JLabel("");
		displayBoats.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Main Menu screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				DisplayBoats newFrame = new DisplayBoats();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Set icon and placement of display boats button
		displayBoats.setIcon(new ImageIcon(DisplayVehicle.class.getResource("/Pictures/button_display-boats.png")));
		displayBoats.setBounds(310, 331, 131, 55);
		contentPane.add(displayBoats);
		
		
		
		//Create display trucks button
		JLabel displayTrucks = new JLabel("");
		displayTrucks.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Main Menu screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				DisplayTrucks newFrame = new DisplayTrucks();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Set icon and placement of display trucks button
		displayTrucks.setIcon(new ImageIcon(DisplayVehicle.class.getResource("/Pictures/button_display-trucks.png")));
		displayTrucks.setBounds(310, 397, 131, 50);
		contentPane.add(displayTrucks);
		

		
		//Add wallpaper
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon(DisplayVehicle.class.getResource("/Pictures/Golden-Gate-Bridge-1-1.jpg")));
		wallpaper.setBounds(0, 0, 784, 573);
		contentPane.add(wallpaper);
	}
}
