/**
Name: Daanyaal Tahir
Purpose: To create a vehicle collection program that uses polymorphism and inheritance in order to add, remove, display, and sort the listing from an array of vehicles
		in a GUI. A GUI is used in order to make the program more simple and organized. 
**/

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class StartPage extends JFrame {

	private JPanel contentPane;
	private JFrame current;

	/**
	 * Launch the Vehicle Collection Program.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {
					StartPage frame = new StartPage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the start page frame.
	 */
	public StartPage() {
		this.current = this;
		
		//Set bounds for the start screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//Start button
		JLabel lblStartbutton = new JLabel("startButton");
		lblStartbutton.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to main menu screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				MainMenu newFrame = new MainMenu();
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		lblStartbutton.setIcon(new ImageIcon(StartPage.class.getResource("/Pictures/button_start (2).png")));
		lblStartbutton.setBounds(322, 96, 134, 45);
		contentPane.add(lblStartbutton);
		
		
		//Add title
		JTextPane title = new JTextPane();
		title.setForeground(new Color(192, 192, 192));
		title.setFont(new Font("Yu Gothic UI", Font.BOLD, 41));
		title.setText("Welcome to Vehicle Database");
		title.setOpaque(false);
		title.setBounds(117, 22, 559, 54);
		contentPane.add(title);
		
		
		//Add wallpaper
		JLabel wallpaper = new JLabel("");
		wallpaper.setIcon(new ImageIcon(StartPage.class.getResource("/Pictures/metro_-20171016_autonomous-vehicles.jpg")));
		wallpaper.setBounds(0, -109, 938, 742);
		contentPane.add(wallpaper);
		

	}
}
