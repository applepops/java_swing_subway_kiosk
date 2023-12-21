import java.awt.Image;

import javax.swing.ImageIcon;

//Represents a menu item in a restaurant, implementing the Payable interface
public class MenuItem implements Payable {
   
	private String name;           // Name of the menu item
    private int basePrice;         // Base price of the menu item
    private ImageIcon image;       // Image representing the menu item
    private int totalPrice;        // Total price of the menu item, including any additional charges
    
    
    // Constructor to initialize a MenuItem object with a name, base price, and image
    public MenuItem(String name, int basePrice, ImageIcon image) {
        this.name = name;
        this.basePrice = basePrice;
        this.image = image;
        resizeImage(); // Resize the image to a standard size
    }
    
    // Method to resize the image to a standard size for display
    public ImageIcon resizeImage() {
    	Image originalImage = this.image.getImage();
    	Image resizedImage = originalImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
    	ImageIcon resizedIcon = new ImageIcon(resizedImage);
    	this.image = resizedIcon;
    	return resizedIcon;
    }

    // Getter method for the name of the menu item
    public String getName() {
        return name;
    }

    // Getter method for the base price of the menu item
    public int getBasePrice() {
        return basePrice;
    }

    // Getter method for the image representing the menu item
    public ImageIcon getImage() {
        return image;
    }
    
    // Getter method for the total price of the menu item
    public int getTotalPrice() {
		return totalPrice;
	}

    // Setter method for the total price of the menu item
	public void setTotalPrice(int price) {
		this.totalPrice = price;
	}

	// Implementation of the calculatePayment method from the Payable interface
	@Override
	public double calculatePayment() {
		totalPrice = basePrice;  
		return totalPrice;
	}
	
	// toString method to provide a formatted string representation of the menu item
	public String toString() {
		return this.getName() + ":\n" + "Total Price: (" + this.getBasePrice() +")\n";
	}
}
