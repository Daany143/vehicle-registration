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
import javax.swing.JTextPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
/** This class represents the display trucks screen.
 *  
 * @author Daanyaal Tahir
 */
public class DisplayTrucks extends JFrame {

	private JPanel contentPane;
	private JFrame originator;
	private JFrame current;
	private JFrame DisplayVehicles;

	/**
	 * Create the frame.
	 */
	public DisplayTrucks() {
		
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
		contentPane.setLayout(null);
		
	
		
		
		//Create jTable to display all entered values for trucks
		String col[] = {"Truck #","Max Capacity","Colour", "Company", "Millage", "Electric", "Cargo Length"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
		JTable table = new JTable(tableModel);
		table.setColumnSelectionAllowed(true);
		table.setBounds(10, 98, 733, 290);
		table.setOpaque(false);
		((DefaultTableCellRenderer)table.getDefaultRenderer(Object.class)).setOpaque(false);
		contentPane.setLayout(null);
		contentPane.add(table);
		
		//Go through arraylist and add each instance of truck to the jTable
		for(Vehicles vehicle : manyVehicles) {
          if (vehicle instanceof Truck){
        	 Truck h = (Truck)vehicle;
        	 Object[] objs = {manyVehicles.indexOf(vehicle), h.getWeight(), vehicle.getColour(), vehicle.getCompany(), vehicle.getMillage(), vehicle.isElectric(), h.getCargoLength()};
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
		vehicleToRemove.setBounds(505, 405, 64, 28);
		contentPane.add(vehicleToRemove);
		vehicleToRemove.setColumns(10);
		
		//Create label for remove vehicle option
		JTextPane txtpnEnterTheVehicle = new JTextPane();
		txtpnEnterTheVehicle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtpnEnterTheVehicle.setText("Enter the vehicle # for the vehicle to remove:");
		txtpnEnterTheVehicle.setBounds(120, 405, 375, 28);
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
				DisplayTrucks newFrame = new DisplayTrucks();
				current.setVisible(false);
				newFrame.setVisible(true);
			}
		});
		//Set icon and placement of refresh button
		refreshButton.setIcon(new ImageIcon(DisplayBoats.class.getResource("/Pictures/button_refresh.png")));
		refreshButton.setBounds(330, 443, 115, 42);
		refreshButton.setVisible(false);
		
		
		
		//Code for the "Success" text
		JTextPane successButton = new JTextPane();
		successButton.setText("Success!");
		successButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		successButton.setForeground(Color.GREEN);
		successButton.setBounds(455, 454, 64, 31);
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
		removeButton.setBounds(330, 444, 109, 42);
		contentPane.add(removeButton);
		
		
		
		//The following code is for organizing each column in descending order if the column header is clicked
		//Create truck number header
		JLabel truckNumHeader = new JLabel("Truck#");
		truckNumHeader.addMouseListener(new MouseAdapter() {
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
		truckNumHeader.setForeground(Color.WHITE);
		truckNumHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		truckNumHeader.setBounds(22, 73, 56, 14);
		contentPane.add(truckNumHeader);
		
		
		//Create max capacity header
		JLabel maxCapacityHeader = new JLabel("Max Capacity");
		maxCapacityHeader.addMouseListener(new MouseAdapter() {
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
		maxCapacityHeader.setForeground(Color.WHITE);
		maxCapacityHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		maxCapacityHeader.setBounds(115, 70, 97, 17);
		contentPane.add(maxCapacityHeader);
		
		
		//Create coulour header
		JLabel colourHeader = new JLabel("Colour");
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
		colourHeader.setForeground(Color.WHITE);
		colourHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		colourHeader.setBounds(241, 73, 56, 14);
		contentPane.add(colourHeader);
		
		
		//Create company header
		JLabel companyHeader = new JLabel("Comapny");
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
		companyHeader.setForeground(Color.WHITE);
		companyHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		companyHeader.setBounds(346, 70, 72, 17);
		contentPane.add(companyHeader);
		
		//Create millage header
		JLabel millageHeader = new JLabel("Millage");
		millageHeader.addMouseListener(new MouseAdapter() {
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
		millageHeader.setForeground(Color.WHITE);
		millageHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		millageHeader.setBounds(454, 70, 56, 17);
		contentPane.add(millageHeader);
		
		
		//Create electric header
		JLabel electricHeader = new JLabel("Electric");
		electricHeader.addMouseListener(new MouseAdapter() {
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
		electricHeader.setForeground(Color.WHITE);
		electricHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		electricHeader.setBounds(538, 73, 56, 14);
		contentPane.add(electricHeader);
		
		
		//Create cargo length header
		JLabel cargoLengthHeader = new JLabel("Cargo Length");
		cargoLengthHeader.addMouseListener(new MouseAdapter() {
			@Override
			/** Sort column in descending order
			 * 
			 * @param e - whether the mouse has been pressed
			 */
			public void mousePressed(MouseEvent e) {
				TableRowSorter<TableModel> sorter = new TableRowSorter<>(table.getModel());
				table.setRowSorter(sorter);
				List<RowSorter.SortKey> sortKeys = new ArrayList<>();
				
				int columnIndexToSort = 6;
				sortKeys.add(new RowSorter.SortKey(columnIndexToSort, SortOrder.DESCENDING));
				 
				sorter.setSortKeys(sortKeys);
				sorter.sort();
			}
		});
		cargoLengthHeader.setForeground(Color.WHITE);
		cargoLengthHeader.setFont(new Font("Tahoma", Font.BOLD, 14));
		cargoLengthHeader.setBounds(636, 64, 97, 23);
		contentPane.add(cargoLengthHeader);
		
		
		
		//Add wallpaper
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DisplayTrucks.class.getResource("/Pictures/info_icon-removebg.png")));
		label.setBounds(10, 515, 35, 35);
		contentPane.add(label);
		
		
		
		//Add title
		JTextPane textPane = new JTextPane();
		textPane.setText("Press each header to sort the respected column in descending order.");
		textPane.setOpaque(false);
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textPane.setBounds(46, 522, 413, 28);
		contentPane.add(textPane);
	}
}
