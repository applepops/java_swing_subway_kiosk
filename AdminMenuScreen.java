import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.PrintWriter;

//Represents the admin menu screen with various options
public class AdminMenuScreen extends JFrame {
	
	private JLabel mainLabel;
    private JButton saleButton, historyButton, backButton, saveButton;
    private int totalSales; //for storing total sale of the day
    private String totalOrderList; //for storing total order list of the day
    
    // Constructor to create the AdminMenuScreen window
    public AdminMenuScreen(int totalSales, String totalOrderList) {
    	this.totalSales = totalSales;
    	this.totalOrderList = totalOrderList;
    	
        setTitle("Admin Menu");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainLabel = new JLabel("");
        mainLabel.setIcon(new ImageIcon(HomeScreen.class.getResource("/image/cha.png")));
        saleButton = new JButton("Check Sales");
        historyButton = new JButton("Order History");
        saveButton = new JButton("Save History");
        backButton = new JButton("Back");
        
        // Set button sizes to 150x40
        Dimension preferredSize = new Dimension(150, 40);
        saleButton.setPreferredSize(preferredSize);
        historyButton.setPreferredSize(preferredSize);
        backButton.setPreferredSize(preferredSize);
        saveButton.setPreferredSize(preferredSize);
        
        // Set button backgrounds
        saleButton.setBackground(new Color(255, 255, 255));
        historyButton.setBackground(new Color(255, 255, 255));
        saveButton.setBackground(new Color(255, 255, 255));
        backButton.setBackground(new Color(186, 186, 186));
        
        saleButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 18));
        historyButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 18));
        saveButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 18));
        backButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 18));
        
        // ActionListener for the "Check Sales" button
        saleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	 // Open the CheckSale window to display total sales
            	CheckSale checkSale = new CheckSale(totalSales);
               
            }
        });

        // ActionListener for the "Order History" button
        historyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	// Open the CheckOrderHistory window to display order history
            	CheckOrderHistory orderHistory = new CheckOrderHistory(totalOrderList);
            	
            }
        });
        
        
        // ActionListener for the "Save History" button
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            	// Save order history to a file and show a confirmation message
            	saveResultToFile(totalOrderList);
            	
            	JOptionPane.showMessageDialog(
        				null, 
        				"Saved successfully!", "SAVE COMPLETION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        
        // ActionListener for the "Back" button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose(); // Close the current frame
            }
        });

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(242, 242, 242));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(mainLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        panel.add(saleButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(historyButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(saveButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(backButton, gbc);

        add(panel);
    }
    
    // Method for saving the result to a text file
    private void saveResultToFile(String content) {
	    try (PrintWriter writer = new PrintWriter(new FileOutputStream("order_history.txt"), false)) {
	        writer.println(content);
	        writer.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}
