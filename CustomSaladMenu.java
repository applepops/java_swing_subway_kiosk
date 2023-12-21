import java.awt.EventQueue;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

//Represents the GUI for customizing a salad menu item
public class CustomSaladMenu extends JFrame {
	
	private String menuItemName;
    private int menuItemBasePrice;
    private ImageIcon menuItemImage;
	
    private String selectedCheeseType;
    private boolean selectedDoubleCheese;
    private ArrayList<String> selectedVeggies;
    private String selectedSauce;
    private OrderScreen orderScreen;

    // Setter for the associated OrderScreen
    public void setOrderScreen(OrderScreen orderScreen) {
        this.orderScreen = orderScreen;
    }
    
    

    // Constructor to initialize the CustomSaladMenu
    public CustomSaladMenu(String name, int basePrice, ImageIcon image) {
    	
        this.menuItemName = name;
        this.menuItemBasePrice = basePrice;
        this.menuItemImage = image;
        

        setTitle("Let's customize the menu!");
        initialize();
    }

    // Method to initialize the graphical components of the customization menu
    private void initialize() {

        setSize(800, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new GridLayout(0, 2));


        //---------------------------------------
        

        

        JLabel cheeseTypeLabel = new JLabel("Select Cheese Type:");
        getContentPane().add(cheeseTypeLabel);
        
        JPanel cheeseTypePanel = new JPanel();
        getContentPane().add(cheeseTypePanel);
        
        
        ButtonGroup cheeseTypeGroup = new ButtonGroup();
        
        JRadioButton shredRB = new JRadioButton("Shred Cheese");
        cheeseTypePanel.add(shredRB);
        cheeseTypeGroup.add(shredRB);
        
        JRadioButton mozzaRB = new JRadioButton("Mozzarella Cheese");
        cheeseTypePanel.add(mozzaRB);
        cheeseTypeGroup.add(mozzaRB);
        
        JRadioButton americanRB = new JRadioButton("American Cheese");
        cheeseTypePanel.add(americanRB);
        cheeseTypeGroup.add(americanRB);
        

        JLabel doubleCheeseLabel = new JLabel("Would you like to double the cheese? (+ ₩1400)");
        getContentPane().add(doubleCheeseLabel);
        
        JPanel doubleCheesePanel = new JPanel();
        getContentPane().add(doubleCheesePanel);
        
        ButtonGroup doubleCheeseGroup = new ButtonGroup();
        
        JRadioButton doubleYesRB = new JRadioButton("Yes");
        doubleCheesePanel.add(doubleYesRB);
        doubleCheeseGroup.add(doubleYesRB);
        
        JRadioButton doubleNoRB = new JRadioButton("No");
        doubleCheesePanel.add(doubleNoRB);
        doubleCheeseGroup.add(doubleNoRB);
        

        
        JLabel vegetableLabel = new JLabel("Select Vegetables: (Multiple selections allowed)");
        getContentPane().add(vegetableLabel);
        
        JPanel vegetablePanel = new JPanel();
        getContentPane().add(vegetablePanel);
        
        
        JCheckBox tomatoCB = new JCheckBox("Tomato");
        vegetablePanel.add(tomatoCB);
        
        JCheckBox pickleCB = new JCheckBox("Pickle");
        vegetablePanel.add(pickleCB);
        
        JCheckBox lettuceCB = new JCheckBox("Lettuce");
        vegetablePanel.add(lettuceCB);
        
        JCheckBox bellPepperCB = new JCheckBox("Bell Pepper");
        vegetablePanel.add(bellPepperCB);
        
        
        JLabel sauceLabel = new JLabel("Select Sauce Type:");
        getContentPane().add(sauceLabel);
        
        JPanel saucePanel = new JPanel();
        getContentPane().add(saucePanel);
        
        ButtonGroup sauceGroup = new ButtonGroup();
        
        JRadioButton ranchRB = new JRadioButton("Ranch Sauce");
        saucePanel.add(ranchRB);
        sauceGroup.add(ranchRB);
        
        JRadioButton barbequeRB = new JRadioButton("Barbeque Sauce");
        saucePanel.add(barbequeRB);
        sauceGroup.add(barbequeRB);
        
        JRadioButton chiliRB = new JRadioButton("Chili Sauce");
        saucePanel.add(chiliRB);
        sauceGroup.add(chiliRB);
        

        JPanel panel_ = new JPanel();
        getContentPane().add(panel_);

        JPanel panel = new JPanel();
        getContentPane().add(panel);

        JButton doneButton = new JButton("Done");
        doneButton.addActionListener(e -> {
        	
        	// Check if all options are selected
        	 if (getSelectedRadioButton(cheeseTypePanel) == null || 
                     getSelectedRadioButton(doubleCheesePanel) == null || 
                     getSelectedCheckBoxes(vegetablePanel).isEmpty() || 
                     getSelectedRadioButton(saucePanel) == null) {
                     
                     // Display warning message
                     JOptionPane.showMessageDialog(this, "Please make selections for all options.", "Warning", JOptionPane.WARNING_MESSAGE);
                     return;
            }
        	
        	// Set selected values
            selectedCheeseType = getSelectedRadioButton(cheeseTypePanel);
            selectedDoubleCheese = "Yes".equals(getSelectedRadioButton(doubleCheesePanel));
            selectedVeggies = getSelectedCheckBoxes(vegetablePanel);
            selectedSauce = getSelectedRadioButton(saucePanel);
            

            
            // Create a salad object with the selected options
            Salad salad = 
            		new Salad(
            				menuItemName, 
            				menuItemBasePrice, 
            				menuItemImage, 
            				selectedCheeseType, 
            				selectedDoubleCheese, 
            				selectedVeggies, 
            				selectedSauce);

            // Calculate the payment for the customized salad
            salad.calculatePayment();
            // Add the customized salad to the order screen
            orderScreen.addToOrder(salad.toString());
            // Update the total price on the order screen
            orderScreen.calculateTotalPrice(salad.getTotalPrice());


            dispose();  // Close the customization window  
        });
        doneButton.setVerticalAlignment(SwingConstants.BOTTOM);
        panel.add(doneButton);
        
        setVisible(true);
        
        
        
    }

    
    // Method to get the selected radio button from a button group
    private String getSelectedRadioButton(JPanel panel) {
        for (var comp : panel.getComponents()) {
            if (comp instanceof JRadioButton && ((JRadioButton) comp).isSelected()) {
                return ((JRadioButton) comp).getText();
            }
        }
        return null;
    }

    // Method to get the selected checkboxes from a checkbox group
    private ArrayList<String> getSelectedCheckBoxes(JPanel panel) {
        ArrayList<String> selectedCheckboxes = new ArrayList<>();
        for (var comp : panel.getComponents()) {
            if (comp instanceof JCheckBox && ((JCheckBox) comp).isSelected()) {
                selectedCheckboxes.add(((JCheckBox) comp).getText());
            }
        }
        return selectedCheckboxes;
    }
    
   

   


}