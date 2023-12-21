import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeScreen extends JFrame {
	private JLabel mainLabel;
    private JButton orderButton, adminButton, exitButton;
    private OrderScreen order;
    
    //Variables to store total sales and order list
    private int totalSales = 0;
    private String totalOrderList = "";
    
    //Main method to start the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            	HomeScreen frame = new HomeScreen();
                frame.setVisible(true);
            }
        });
    }

    // Constructor to initialize the Home Screen
    public HomeScreen() {
        setTitle("Welcome to Subway");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        mainLabel = new JLabel("");
        mainLabel.setIcon(new ImageIcon(HomeScreen.class.getResource("/image/greenlogo.png")));
        orderButton = new JButton("Order Here");
        adminButton = new JButton("Login as Admin");
        exitButton = new JButton("Exit");
        
        Dimension preferredSize = new Dimension(150, 40);
        orderButton.setPreferredSize(preferredSize);
        adminButton.setPreferredSize(preferredSize);
        exitButton.setPreferredSize(preferredSize);
        
        orderButton.setBackground(new Color(255, 255, 255));
        adminButton.setBackground(new Color(255, 255, 255));
        exitButton.setBackground(new Color(186, 186, 186));
        orderButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 18));
        adminButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 18));
        exitButton.setFont(new Font("Franklin Gothic Medium Cond", Font.BOLD, 18));
        
        
        // Action listeners for orderButton
        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openOrder();
            }
        });

        // Action listeners for adminButton
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openAdminScreen();
            }
        });
        
        // Exit button event to close the program
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	dispose(); 
                System.exit(0); 
            }
        });

        // Create a panel with GridBagLayout
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(0, 98, 41));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(mainLabel, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.insets = new Insets(10, 10, 10, 10); // Padding
        panel.add(orderButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(adminButton, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(exitButton, gbc);

        add(panel);
    }

    
    // Method to open the order screen
    private void openOrder() {
        order = new OrderScreen(HomeScreen.this);
        order.setVisible(true);
        order.setHomeScreenReference(HomeScreen.this);
        
    }


    
    // Method to open the admin screen
    private void openAdminScreen() {
        // Implement admin screen opening logic here
        
    	LoginGUI login = new LoginGUI(totalSales, totalOrderList);
        
    }
    


    // Function to update total sales
	public void updateTotalPrice(int totalPrice) {
		// TODO Auto-generated method stub
		
		this.totalSales += totalPrice;
		
	}
	
	// Function to update total order list
	public void updateOrderList(String orderList) {
		
		this.totalOrderList = this.totalOrderList + orderList;
		
		System.out.println(totalOrderList);
	}

}




