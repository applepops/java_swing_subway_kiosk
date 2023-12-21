import java.util.ArrayList;

import javax.swing.ImageIcon;

//Represents a Sandwich menu item, extending the MenuItem class
public class Sandwitch extends MenuItem {
	
	private int breadLength;          // Length of the sandwich bread
    private String breadType;         // Type of bread used in the sandwich
    private boolean isToasted;        // Indicates whether the sandwich is toasted
    private String cheeseType;         // Type of cheese in the sandwich
    private boolean doubleCheese;      // Indicates whether double cheese is selected
    private ArrayList<String> veggies; // List of vegetables in the sandwich
    private String sauce;              // Type of sauce for the sandwich

    // Constructor to initialize a Sandwich object with specific attributes
	public Sandwitch(String name, int basePrice, ImageIcon image, int breadLength, String breadType, boolean isToasted, 
			String cheeseType, boolean doubleCheese, ArrayList<String> veggies, String sauce){
		super(name, basePrice, image);
		this.breadLength = breadLength;
        this.breadType = breadType;
        this.isToasted = isToasted;
        this.cheeseType = cheeseType;
        this.doubleCheese = doubleCheese;
        this.veggies = veggies;
        this.sauce = sauce;
	}

	// Getter method for the length of the sandwich bread
	public int getBreadLength() {
		return breadLength;
	}

	// Setter method for the length of the sandwich bread
	public void setBreadLength(int breadLength) {
		this.breadLength = breadLength;
	}

	// Getter method for the type of bread used in the sandwich
	public String getBreadType() {
		return breadType;
	}

	// Setter method for the type of bread used in the sandwich
	public void setBreadType(String breadType) {
		this.breadType = breadType;
	}

	// Getter method to check if the sandwich is toasted
	public boolean isToasted() {
		return isToasted;
	}

	// Setter method to set whether the sandwich is toasted
	public void setToasted(boolean isToasted) {
		this.isToasted = isToasted;
	}

	// Getter method for the type of cheese in the sandwich
	public String getCheeseType() {
		return cheeseType;
	}

	// Setter method for the type of cheese in the sandwich
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

	// Getter method for the list of vegetables in the sandwich
	public ArrayList<String> getVeggies() {
		return veggies;
	}

	// Setter method for the list of vegetables in the sandwich
	public void setVeggies(ArrayList<String> veggies) {
		this.veggies = veggies;
	}

	// Getter method for the type of sauce in the sandwich
	public String getSauce() {
		return sauce;
	}

	// Setter method for the type of sauce in the sandwich
	public void setSauce(String sauce) {
		this.sauce = sauce;
	}
	
	// Override the calculatePayment method to include additional charges for specific attributes
	@Override
	public double calculatePayment() {
		int additionalPrice = 0;
		if (breadLength > 15) additionalPrice+= getBasePrice(); // Additional charge for longer bread
		if (doubleCheese == true) additionalPrice += 1400;      // Additional charge for double cheese
		if (isToasted == true) additionalPrice += 500;          // Additional charge for toasted sandwich
		
		// Set the total price by adding the base price and any additional charges
		super.setTotalPrice(additionalPrice + getBasePrice());
		return super.getTotalPrice();
	}
	

	// Override the toString method to provide a formatted string representation of the sandwitch
	public String toString() {
		int additionalPrice = super.getTotalPrice() - super.getBasePrice();
		return super.getName() + ":\n" 
				+ "[Bread Length: " + this.breadLength +"cm]\n"
				+ "[Bread Type: " + this.breadType + "]\n" 
				+ "[Toasting: " + this.isToasted +"]\n"
				+ "[Cheese Type: " + this.cheeseType +"]\n"
				+ "[Double Cheese: " + this.doubleCheese +"]\n"
				+ "[Vegetables: " + this.veggies +"]\n"
				+ "[Sauce Type: " + this.sauce +"]\n"
				+ "Base Price: (" + super.getBasePrice() 
				+ "),\nExtra Price: (" + additionalPrice 
				+ "),\nTotal Price: (" + super.getTotalPrice() 
				+")\n";
	}

}
