import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JTextPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
/** This class represents the display cars screen.
 *  
 * @author Daanyaal Tahir
 */
public class DisplayCars extends JFrame {

	private JPanel contentPane;
	private JFrame orignator;
	private JFrame current;
	private JFrame DisplayVehicles;
	/**
	 * Create the frame.
	 */
	public DisplayCars() {
		
		this.current = this;
		
		//Get the vehicle arraylist
		ArrayList<Vehicles> manyVehicles = VehicleCollection.getList();
		
		
		
		//Set bounds for screen
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		
		
		
		//Create jTable to display all entered values for cars
		String col[] = {"Car #","Frunk","Colour", "Company", "Millage", "Electric"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);
		table.setColumnSelectionAllowed(true);
		table.setBounds(20, 65, 694, 334);
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		contentPane.setLayout(null);
		contentPane.add(table);
		//Go through arraylist and add each instance of car to the jTable
		for(Vehicles vehicle : manyVehicles) {
          if (vehicle instanceof Car){
        	 Car h = (Car)vehicle;
        	 Object[] objs = {manyVehicles.indexOf(vehicle), h.hasFrontTrunk(), vehicle.getColour(), vehicle.getCompany(), vehicle.getMillage(), vehicle.isElectric()};
        	 tableModel.addRow(objs);
          }
	    }
		
		
		 
		//Create back button
		JLabel backButton = new JLabel("");
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Display Vehicles screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				DisplayVehicle newFrame = new DisplayVehicle(current);
				newFrame.setVisible(true);
				current.setVisible(false);
			}
		});
		//Set icon and placement of back button
		backButton.setIcon(new ImageIcon(AddCar.class.getResource("/Pictures/back button.png")));
		backButton.setBounds(729, 11, 45, 42);
		contentPane.add(backButton);
		
		
		
		//Code remove vehicle option
		//Create jTextField so the user can enter the index of the vehicle they would like to remove
		JTextField vehicleToRemove = new JTextField();
		vehicleToRemove.setBounds(513, 404, 64, 28);
		contentPane.add(vehicleToRemove);
		vehicleToRemove.setColumns(10);
		
		//Create label for remove vehicle option
		JTextPane txtpnEnterTheVehicle = new JTextPane();
		txtpnEnterTheVehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnEnterTheVehicle.setText("Enter the vehicle # for the vehicle to remove:");
		txtpnEnterTheVehicle.setBounds(128, 404, 375, 28);
		txtpnEnterTheVehicle.setOpaque(false);
		contentPane.add(txtpnEnterTheVehicle);
		
		
		
		//Create refresh button
		JLabel refreshButton = new JLabel("");
		refreshButton.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Display Vehicles screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				//Reopens the screen by displaying a new screen and making previous screen invisible
				DisplayCars newFrame = new DisplayCars();
				current.setVisible(false);
				newFrame.setVisible(true);
			}
		});
		//Set icon and placement of refresh button
		refreshButton.setIcon(new ImageIcon(DisplayBoats.class.getResource("/Pictures/button_refresh.png")));
		refreshButton.setBounds(338, 442, 115, 42);
		refreshButton.setVisible(false);
		
		
		
		//Code for the "Success" text 
		JTextPane successButton = new JTextPane();
		successButton.setText("Success!");
		successButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		successButton.setForeground(Color.GREEN);
		successButton.setBounds(463, 453, 64, 31);
		successButton.setOpaque(false);
		successButton.setVisible(false);
		contentPane.add(successButton);
		contentPane.add(refreshButton);
		
		
		
		//Create remove button
		JLabel removeButton = new JLabel("");
		removeButton.addMouseListener(new MouseAdapter() {
			@Override
			/** Switch frame to Display Vehicles screen.
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				//Assign inputed text to a variable and remove the entered index
				//Make the remove button invisible and the refresh button visible
				int indexInput = Integer.parseInt(vehicleToRemove.getText());
				manyVehicles.remove(indexInput);
				removeButton.setVisible(false);
				refreshButton.setVisible(true);
				successButton.setVisible(true);
			}
		});
		//Set icon and placement of remove button
		removeButton.setIcon(new ImageIcon(DisplayBoats.class.getResource("/Pictures/button_remove.png")));
		removeButton.setBounds(338, 443, 109, 42);
		contentPane.add(removeButton);
		
		
		
		//The following code is for organizing each column in descending order if the column header is clicked
		//Create frunk header
		JLabel frunkHeader = new JLabel("Frunk");
		frunkHeader.setForeground(Color.WHITE);
		frunkHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		frunkHeader.addMouseListener(new MouseAdapter() {
			@Override
			/** Sort column in descending order
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				
				int columnIndexToSort = 1;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		});
		frunkHeader.setBounds(128, 48, 45, 14);
		contentPane.add(frunkHeader);
		
		
		//Create colour header
		JLabel colourHeader = new JLabel("Colour");
		colourHeader.setForeground(Color.WHITE);
		colourHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		colourHeader.addMouseListener(new MouseAdapter() {
			@Override
			/** Sort column in descending order
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				
				int columnIndexToSort = 2;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		});
		colourHeader.setBounds(242, 48, 53, 14);
		contentPane.add(colourHeader);
		
		
		//Create company header
		JLabel companyHeader = new JLabel("Company");
		companyHeader.setForeground(Color.WHITE);
		companyHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		companyHeader.addMouseListener(new MouseAdapter() {
			@Override
			/** Sort column in descending order
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				
				int columnIndexToSort = 3;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		});
		companyHeader.setBounds(365, 48, 71, 17);
		contentPane.add(companyHeader);
		
		
		//Create millage header
		JLabel lblMillage = new JLabel("Millage");
		lblMillage.setForeground(Color.WHITE);
		lblMillage.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMillage.addMouseListener(new MouseAdapter() {
			@Override
			/** Sort column in descending order
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				
				int columnIndexToSort = 4;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		});
		lblMillage.setBounds(489, 48, 53, 14);
		contentPane.add(lblMillage);
		
		
		//Create electric header 
		JLabel lblElectric = new JLabel("Electric");
		lblElectric.setForeground(Color.WHITE);
		lblElectric.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblElectric.addMouseListener(new MouseAdapter() {
			@Override
			/** Sort column in descending order
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				
				int columnIndexToSort = 5;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		});
		lblElectric.setBounds(596, 48, 53, 14);
		contentPane.add(lblElectric);
		
		
		//Create index of car header
		JLabel carNumHeader = new JLabel("Car #");
		carNumHeader.setForeground(Color.WHITE);
		carNumHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		carNumHeader.addMouseListener(new MouseAdapter() {
			@Override
			/** Sort column in descending order
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent arg0) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				
				int columnIndexToSort = 0;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		});
		carNumHeader.setBounds(41, 48, 45, 14);
		contentPane.add(carNumHeader);
		
		
		//Create title
		JTextPane textPane = new JTextPane();
		textPane.setText("Press each header to sort the respected column in descending order.");
		textPane.setOpaque(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane.setBounds(46, 522, 413, 28);
		contentPane.add(textPane);
		
		
		//Add wallpaper
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DisplayCars.class.getResource("/Pictures/info_icon-removebg.png")));
		label.setBounds(10, 515, 35, 35);
		contentPane.add(label);
	}
}
