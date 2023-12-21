import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowAdapter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


//Represents the Order Screen where users can select menu items and place orders
public class OrderScreen extends JFrame {

    private JTabbedPane menuTabbedPane;
    private JTextArea orderTextArea;
    private JLabel timeLabel;
    private JLabel topLabel;
    private SwingWorker<Void, Void> timerWorker;
    
    // Total price for the current order
    private int totalPrice = 0;
    private JButton purchaseButton;
    
    // String to store the list of items in the order
    private String orderList = "";
    
    // Reference to the HomeScreen for updating total sales and order list
    private HomeScreen homeScreen;

    
    // Constructor to initialize the Order Screen
    public OrderScreen(JFrame parentFrame) {
        super();
        getContentPane().setBackground(new Color(0, 98, 41));

        setTitle("Order Menu");
        setSize(900, 600);

        orderTextArea = new JTextArea("========<Order List>========\n\n");
        menuTabbedPane = new JTabbedPane();
        menuTabbedPane.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 18));
        menuTabbedPane.setBackground(new Color(242, 183, 1));
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 16));
        timeLabel.setForeground(new Color(255, 255, 255));

        
        // Adding tabs for different menu categories
        menuTabbedPane.addTab("Sandwich", createSandwitchMenuPanel(getSandwichMenu()));
        menuTabbedPane.addTab("Salad", createSaladMenuPanel(getSaladMenu()));
        menuTabbedPane.addTab("Side", createSideMenuPanel(getSideMenu()));

        JPanel textPanel = new JPanel();

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(textPanel, BorderLayout.NORTH);
        textPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

        topLabel = new JLabel("Eat Fresh, Feel Good");
        topLabel.setFont(new Font("Harlow Solid Italic", Font.PLAIN, 28));
        topLabel.setForeground(new Color(255, 255, 255));
        textPanel.add(topLabel);
        textPanel.setBackground(new Color(0, 98, 41));
        

        getContentPane().add(menuTabbedPane, BorderLayout.CENTER);
        getContentPane().add(new JScrollPane(orderTextArea), BorderLayout.WEST);
        getContentPane().add(timeLabel, BorderLayout.SOUTH);
        
        purchaseButton = new JButton("Purchase");
        
        // ActionListener for the purchase button
        purchaseButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		// Display a confirmation message with the total price
        		JOptionPane.showMessageDialog(
        				rootPane, 
        				"You will be charged: ₩" + totalPrice, 
        				"CONFIRM & PAY", JOptionPane.INFORMATION_MESSAGE);
        		
        		// Update total sales and order list in HomeScreen
        		homeScreen.updateTotalPrice(totalPrice);
        		homeScreen.updateOrderList(getOrderList());
        		
        		// Stop the timer and close the OrderScreen
        		stopTimer();
        		dispose();
        	}
        });
        
        
        purchaseButton.setBackground(new Color(192, 192, 192));
        purchaseButton.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 17));
        getContentPane().add(purchaseButton, BorderLayout.EAST);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);

        // Start a timer for 150 seconds
        startTimer(150);
        
        
        // Add a window listener to stop the timer and close the OrderScreen when the user closes the window
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                stopTimer();
                dispose();
            }
        });
        
        
       
        
    }
    
    
    // Method to create a panel for the Sandwich menu category
    private JPanel createSandwitchMenuPanel(ArrayList<MenuItem> menuItems) {
        JPanel menuPanel = new JPanel(new GridLayout(2, 3));
        menuPanel.setBackground(new Color(255, 255, 255));

        for (MenuItem menuItem : menuItems) {
        	
            JButton itemButton = new JButton(menuItem.getName() + " - ₩" + menuItem.getBasePrice());
            itemButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            itemButton.setHorizontalTextPosition(SwingConstants.CENTER);
            itemButton.setIcon(menuItem.getImage());

            // ActionListener to handle the selection of a menu item
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Pass MenuItem parameters to the CustomMenu constructor
                	CustomSandwitchMenu customMenu = new CustomSandwitchMenu(
                            menuItem.getName(),
                            menuItem.getBasePrice(),
                            menuItem.getImage()
                    );
                    
                	// Set the OrderScreen reference for communication
                    customMenu.setOrderScreen(OrderScreen.this);              
                }
            });
            menuPanel.add(itemButton);
        }
        return menuPanel;
    }
    
    
    // Method to create a panel for the Salad menu category
    private JPanel createSaladMenuPanel(ArrayList<MenuItem> menuItems) {
        JPanel menuPanel = new JPanel(new GridLayout(2, 3));
        menuPanel.setBackground(new Color(255, 255, 255));

        for (MenuItem menuItem : menuItems) {
        	
            JButton itemButton = new JButton(menuItem.getName() + " - ₩" + menuItem.getBasePrice());
            itemButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            itemButton.setHorizontalTextPosition(SwingConstants.CENTER);
            itemButton.setIcon(menuItem.getImage());

            // ActionListener to handle the selection of a menu item
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Pass MenuItem parameters to the CustomMenu constructor
                	CustomSaladMenu customMenu = new CustomSaladMenu(
                            menuItem.getName(),
                            menuItem.getBasePrice(),
                            menuItem.getImage()
                    );
                    
                	// Set the OrderScreen reference for communication
                    customMenu.setOrderScreen(OrderScreen.this);
                    
                }
            });
            menuPanel.add(itemButton);
        }
        


        return menuPanel;
    }
    
    
    // Method to create a panel for the Side menu category
    private JPanel createSideMenuPanel(ArrayList<MenuItem> menuItems) {
        JPanel menuPanel = new JPanel(new GridLayout(2, 3));
        menuPanel.setBackground(new Color(255, 255, 255));

        for (MenuItem menuItem : menuItems) {
        	
            JButton itemButton = new JButton(menuItem.getName() + " - ₩" + menuItem.getBasePrice());
            itemButton.setVerticalTextPosition(SwingConstants.BOTTOM);
            itemButton.setHorizontalTextPosition(SwingConstants.CENTER);
            itemButton.setIcon(menuItem.getImage());

            // ActionListener to handle the selection of a menu item
            itemButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Pass MenuItem parameters to the CustomMenu constructor
                	MenuItem customMenu = new MenuItem(
                            menuItem.getName(),
                            menuItem.getBasePrice(),
                            menuItem.getImage()
                    );
                    
                	// Add the selected item to the order and update the total price
                	addToOrder(customMenu.toString());
                	calculateTotalPrice(customMenu.getBasePrice());
                    
                }
            });
            menuPanel.add(itemButton);
        }
        


        return menuPanel;
    }

    

    // Method to add an item to the order and update the display
    public void addToOrder(String item) {
        orderTextArea.append(item + "\n");
    }
    
    
    // Method to update the total price of the order
    public void calculateTotalPrice(int price) {
    	
    	totalPrice += price;
    	
    }

    // Start a timer for the specified number of seconds
    private void startTimer(int seconds) {
        timerWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = seconds; i >= 0; i--) {
                    final int remainingSeconds = i;
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            timeLabel.setText("Time Remaining: " + remainingSeconds + " seconds");
                        }
                    });
                    Thread.sleep(1000);
                }
                return null;
            }

            @Override
            protected void done() {               
            	//stop the timer and perform actions after it ends           	
                stopTimer();
                
                if (!isCancelled()) {  // Display a message only if the timer completes normally
                    JOptionPane.showMessageDialog(rootPane, "Time out.\nWe are going back to home screen.", 
                    		"INFORMATION MESSAGE", JOptionPane.INFORMATION_MESSAGE);
                }           
                dispose(); //close the OrderScreen
            }
        };

        timerWorker.execute();
    }

    
    // Stop the timer if it is running
    private void stopTimer() {
        if (timerWorker != null && !timerWorker.isDone()) {
            timerWorker.cancel(true);
        }
    }
    
    
    
    // Retrieve the menu items for the Sandwich category
    private ArrayList<MenuItem> getSandwichMenu() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        // Add information for each sandwich menu item
        menuItems.add(new MenuItem("Italian B.M.T.", 6700, new ImageIcon(getClass().getResource("/image/sandwitch_bmt.png"))));
        menuItems.add(new MenuItem("Roasted Chicken", 7300, new ImageIcon(getClass().getResource("/image/sandwitch_chicken.png"))));
        menuItems.add(new MenuItem("Egg Mayo", 5500, new ImageIcon(getClass().getResource("/image/sandwitch_eggmayo.png"))));
        menuItems.add(new MenuItem("Veggie Delite", 4900, new ImageIcon(getClass().getResource("/image/sandwitch_vegi.png"))));
        menuItems.add(new MenuItem("Tuna", 5800, new ImageIcon(getClass().getResource("/image/sandwitch_tuna.png"))));
        menuItems.add(new MenuItem("Ham", 5800, new ImageIcon(getClass().getResource("/image/sandwitch_ham.png"))));
        
        return menuItems;
    }

    // Retrieve the menu items for the Salad category
    private ArrayList<MenuItem> getSaladMenu() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        // Add information for each salad menu item
        menuItems.add(new MenuItem("Italian B.M.T.", 8500, new ImageIcon(getClass().getResource("/image/salad_bmt.png"))));
        menuItems.add(new MenuItem("Roasted Chicken", 9100, new ImageIcon(getClass().getResource("/image/salad_chicken.png"))));
        menuItems.add(new MenuItem("Egg Mayo", 7300, new ImageIcon(getClass().getResource("/image/salad_eggmayo.png"))));
        menuItems.add(new MenuItem("Veggie Delite", 6700, new ImageIcon(getClass().getResource("/image/salad_vegi.png"))));
        menuItems.add(new MenuItem("Tuna", 6900, new ImageIcon(getClass().getResource("/image/salad_tuna.png"))));
        menuItems.add(new MenuItem("Ham", 6900, new ImageIcon(getClass().getResource("/image/salad_ham.png"))));
        
        return menuItems;
    }

    // Retrieve the menu items for the Side category
    private ArrayList<MenuItem> getSideMenu() {
        ArrayList<MenuItem> menuItems = new ArrayList<>();
        // Add information for each side menu item
        menuItems.add(new MenuItem("Chocolate Chip", 1300, new ImageIcon(getClass().getResource("/image/chocochip.png"))));
        menuItems.add(new MenuItem("Oatmeal Raisin", 1300, new ImageIcon(getClass().getResource("/image/oatmealchip.png"))));
        menuItems.add(new MenuItem("Soda", 1900, new ImageIcon (getClass().getResource("/image/soda.png"))));
        menuItems.add(new MenuItem("Coffee", 1800, new ImageIcon(getClass().getResource("/image/coffee.png"))));
        menuItems.add(new MenuItem("Hash Brown", 1800, new ImageIcon(getClass().getResource("/image/hashbrown.png"))));
        menuItems.add(new MenuItem("Water", 1000, new ImageIcon (getClass().getResource("/image/icon.png"))));
        
        return menuItems;
    }

    // Getter method for the total price
	public int getTotalPrice() {
		return totalPrice;
	}

	// Setter method for the total price
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	// Method to set the reference to the HomeScreen for communication
    public void setHomeScreenReference(HomeScreen homeScreen) {
        this.homeScreen = homeScreen;
    }

    // Method to retrieve the order list as a string
    public String getOrderList() {
    	
    	this.orderList = this.orderTextArea.getText();
    	return this.orderList;
    }

    

   }




