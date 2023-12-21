import java.util.ArrayList;

import javax.swing.ImageIcon;

//Represents a Salad menu item, extending the MenuItem class
public class Salad extends MenuItem {
	
	private String cheeseType;           // Type of cheese in the salad
    private boolean doubleCheese;        // Indicates whether double cheese is selected
    private ArrayList<String> veggies;   // List of vegetables in the salad
    private String sauce;                // Type of sauce for the salad

    // Constructor to initialize a Salad object with specific attributes
	public Salad(String name, int basePrice, ImageIcon image, 
			String cheeseType, boolean doubleCheese, ArrayList<String> veggies, String sauce){
		super(name, basePrice, image);

        this.cheeseType = cheeseType;
        this.doubleCheese = doubleCheese;
        this.veggies = veggies;
        this.sauce = sauce;
	}

	
	// Getter method for the cheese type in the salad
	public String getCheeseType() {
		return cheeseType;
	}

	// Setter method for the cheese type in the salad
	public void setCheeseType(String cheeseType) {
		this.cheeseType = cheeseType;
	}

	 // Getter method to check if double cheese is selected
	public boolean isDoubleCheese() {
		return doubleCheese;
	}

	// Setter method to set whether double cheese is selected
	public void setDoubleCheese(boolean doubleCheese) {
		this.doubleCheese = doubleCheese;
	}

	 // Getter method for the list of vegetables in the salad
	public ArrayList<String> getVeggies() {
		return veggies;
	}

	// Setter method for the list of vegetables in the salad
	public void setVeggies(ArrayList<String> veggies) {
		this.veggies = veggies;
	}

	// Getter method for the sauce type in the salad
	public String getSauce() {
		return sauce;
	}

	// Setter method for the sauce type in the salad
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	
	// Override the calculatePayment method to include additional charges for double cheese
	@Override
	public double calculatePayment() {
		int additionalPrice = 0;
		if (doubleCheese == true) additionalPrice += 1400; // Additional charge for double cheese
		
		// Set the total price by adding the base price and any additional charges
		super.setTotalPrice(additionalPrice + getBasePrice());
		return super.getTotalPrice();
	}
	

	// Override the toString method to provide a formatted string representation of the salad
	public String toString() {
		int additionalPrice = super.getTotalPrice() - super.getBasePrice();
		return super.getName() + ":\n" 
				+ "[Cheese Type: " + this.cheeseType +"]\n"
				+ "[Double Cheese: " + this.doubleCheese +"]\n"
				+ "[Vegetables: " + this.veggies +"]\n"
				+ "[Sauce Type: " + this.sauce +"]\n"
				+ "Base Price: (" + super.getBasePrice() + "),\nExtra Price: (" + additionalPrice + "),\nTotal Price: (" + super.getTotalPrice() +")\n";
	}

}