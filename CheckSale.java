import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckSale extends JFrame {

	private JFrame frame;
	private JLabel totalSaleLabel;
	private int totalSales;
	
	// Constructor to create the CheckSale window with the total sales
	public CheckSale(int totalSales) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setTitle("Today's Total Sales");
		this.totalSales = totalSales;
		initialize();
	}

	
	// Method to initialize the contents of the frame
	private void initialize() {
		frame = new JFrame();
		setTitle("Check Total Sales");
		setSize(500, 100);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Today's Total Sales:");
		lblNewLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		//getContentPane().add(lblNewLabel);
		
		totalSaleLabel = new JLabel("-");
		totalSaleLabel.setForeground(new Color(210, 0, 0));
		totalSaleLabel.setFont(new Font("Calibri", Font.PLAIN, 24));
		//getContentPane().add(totalSaleLabel);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel);
		panel.add(lblNewLabel);
		panel.add(totalSaleLabel);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1);
		
		JButton backButton = new JButton("Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		panel_1.add(backButton);
		
		// Update the total sales on the GUI
		updateTotalSales();
		
		setVisible(true);

	}
	
	
	// Method to update the total sales label on the GUI
	public void updateTotalSales() {
        totalSaleLabel.setText("₩" + Integer.toString(this.totalSales));
    }

}
