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

//Represents the GUI for customizing a sandwich menu item
public class CustomSandwitchMenu extends JFrame {
	
	private String menuItemName;
    private int menuItemBasePrice;
    private ImageIcon menuItemImage;
	
	private int selectedBreadLength;
    private String selectedBreadType;
    private boolean selectedToasting;
    private String selectedCheeseType;
    private boolean selectedDoubleCheese;
    private ArrayList<String> selectedVeggies;
    private String selectedSauce;
    private OrderScreen orderScreen;

    // Setter for the associated OrderScreen
    public void setOrderScreen(OrderScreen orderScreen) {
        this.orderScreen = orderScreen;
    }
    
    // Constructor to initialize the CustomSandwichMenu
    public CustomSandwitchMenu(String name, int basePrice, ImageIcon image) {
        this.menuItemName = name;
        this.menuItemBasePrice = basePrice;
        this.menuItemImage = image;
        

        setTitle("Let's customize the menu!");
        initialize();
    }

    // Method to initialize the graphical components of the customization menu
    private void initialize() {

        setSize(800, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        getContentPane().setLayout(new GridLayout(0, 2));

        JLabel breadLabel = new JLabel("Select Bread Length: (30cm: base price X 2)");
        getContentPane().add(breadLabel);
        
        JPanel breadLengthPanel = new JPanel();
        getContentPane().add(breadLengthPanel);
        
        ButtonGroup breadLengthGroup = new ButtonGroup();
        
        JRadioButton breadLength15RB = new JRadioButton("15cm");
        breadLengthPanel.add(breadLength15RB);
        breadLengthGroup.add(breadLength15RB);
        
        JRadioButton breadLength30RB = new JRadioButton("30cm");
        breadLengthPanel.add(breadLength30RB);
        breadLengthGroup.add(breadLength30RB);

        //---------------------------------------
        
        JLabel breadTypeLabel = new JLabel("Select Bread Type:");
        getContentPane().add(breadTypeLabel);
        
        
        JPanel breadTypePanel = new JPanel();
        getContentPane().add(breadTypePanel);
        
        ButtonGroup breadTypeGroup = new ButtonGroup();
        
        JRadioButton whiteBreadRB = new JRadioButton("White Bread");
        breadTypePanel.add(whiteBreadRB);
        breadTypeGroup.add(whiteBreadRB);
        
        JRadioButton wheatBreadRB = new JRadioButton("Wheat Bread");
        breadTypePanel.add(wheatBreadRB);
        breadTypeGroup.add(wheatBreadRB);
        
        JRadioButton honeyOatBreadRB = new JRadioButton("Honey Oat Bread");
        breadTypePanel.add(honeyOatBreadRB);
        breadTypeGroup.add(honeyOatBreadRB);
        
        JLabel toastingLabel = new JLabel("Do you want toasting? (+ ₩500)");
        getContentPane().add(toastingLabel);
        
        JPanel toastingPanel = new JPanel();
        getContentPane().add(toastingPanel);
        
        
        
        ButtonGroup toastingGroup = new ButtonGroup();
        
        JRadioButton toastingYesRB = new JRadioButton("Yes");
        toastingPanel.add(toastingYesRB);
        toastingGroup.add(toastingYesRB);
        
        JRadioButton toastingNoRB = new JRadioButton("No");
        toastingPanel.add(toastingNoRB);
        toastingGroup.add(toastingNoRB);
        

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
            if (getSelectedRadioButton(breadLengthPanel) == null || 
                getSelectedRadioButton(breadTypePanel) == null || 
                getSelectedRadioButton(toastingPanel) == null || 
                getSelectedRadioButton(cheeseTypePanel) == null || 
                getSelectedRadioButton(doubleCheesePanel) == null || 
                getSelectedCheckBoxes(vegetablePanel).isEmpty() || 
                getSelectedRadioButton(saucePanel) == null) {
                
            	// Display warning message
                JOptionPane.showMessageDialog(this, "Please make selections for all options.", "Warning", JOptionPane.WARNING_MESSAGE);
                
                return;
            }
        	
            // Set selected values
        	String removeChar = getSelectedRadioButton(breadLengthPanel).replaceAll("[^0-9]", "");
        	selectedBreadLength = Integer.parseInt(removeChar);
            selectedBreadType = getSelectedRadioButton(breadTypePanel);
            selectedToasting = "Yes".equals(getSelectedRadioButton(toastingPanel));
            selectedCheeseType = getSelectedRadioButton(cheeseTypePanel);
            selectedDoubleCheese = "Yes".equals(getSelectedRadioButton(doubleCheesePanel));
            selectedVeggies = getSelectedCheckBoxes(vegetablePanel);
            selectedSauce = getSelectedRadioButton(saucePanel);
            
           
            
            // Create a sandwich object with the selected options
            Sandwitch sandwitch = 
            		new Sandwitch(
            				menuItemName, 
            				menuItemBasePrice, 
            				menuItemImage, 
            				selectedBreadLength, 
            				selectedBreadType, 
            				selectedToasting, 
            				selectedCheeseType, 
            				selectedDoubleCheese, 
            				selectedVeggies, 
            				selectedSauce);

            // Calculate the payment for the customized sandwich
            sandwitch.calculatePayment();
            // Add the customized sandwich to the order screen
            orderScreen.addToOrder(sandwitch.toString());
            // Update the total price on the order screen
            orderScreen.calculateTotalPrice(sandwitch.getTotalPrice());
             
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

