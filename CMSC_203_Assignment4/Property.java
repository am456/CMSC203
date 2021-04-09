
public class Property {
	
	private String propertyName;
	private String city;
	private String owner;
	private double rentAmount;
	private Plot plot;
	
	/**
	 * Constructor Method for Property class.
	 * No-arg constructor.
	 * Creates a new object with default values of empty strings.
	 */
	public Property() 
	{
		this.propertyName = "";
		this.city = "";
		this.owner = "";
		this.rentAmount = 0.0;
		this.plot = new Plot(); 
	}
	
	/**
	 * Copy constructor method
	 * Creates a new object using the information of the object that
	 * is passed to it.
	 * @param property
	 */
	public Property(Property p)
	{
		this.propertyName = p.propertyName;
		this.city = p.city;
		this.owner = p.owner;
		this.rentAmount = p.rentAmount;
		this.plot = new Plot(p.plot);
	}
	
	/**
	 * Parameterized constructor method for Property class.
	 * No plot information included.
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 */
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
	}
	
	/**
	 * Parameterized constructor method for Property Class.
	 * Plot information included.
	 * @param propertyName
	 * @param city
	 * @param rentAmount
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) 
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		
		this.plot = new Plot(x, y, width, depth);
		
		
	}

	/**
	 * Assigns parameter rentAmount's value to variable rentAmount
	 * @param rentAmount
	 */
	public void setRentAmount(double rentAmount)
	{
		this.rentAmount = rentAmount;
	}
	
	/**
	 * Assigns parameter propertyName's value to variable propertyName
	 * @param property
	 */
	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}
	
	/**
	 * Assigns parameter owner's value to variable owner
	 * @param ownerName
	 */
	public void setOwner(String owner)
	{
		this.owner = owner;
	}
	
	/**
	 * Assigns parameter city's value to variable city
	 * @param cityName
	 */
	public void setCity(String city)
	{
		this.city = city;
	}
	
	/**
	 * Takes input for plot information and sets it in the
	 * private variable plot.
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return plot set to updated values passed into the parameters
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{
		plot = new Plot(x, y, width, depth);
		return plot;
	}
	
	/**
	 * Can be accessed to retrieve the Object plot
	 * @return plot
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * Called to get the value of rentAmount
	 * @return the value of variable rentAmount
	 */
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	/**
	 * Called to get the value of propertyName
	 * @return the value of variable propertyName
	 */
	public String getPropertyName()
	{
		return propertyName;
	}
	
	/**
	 * Called to get the value of owner
	 * @return the value of variable owner
	 */
	public String getOwner()
	{
		return owner;
	}
	
	/**
	 * Called to get the value of city
	 * @return the value of variable city
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * Returns the class attributes as a String
	 * @return the value of String output.
	 */
	public String toString()
	{
		String output = "Property Name: " + propertyName;
		output += "\nLocated in " + city;
		output += "\nBelonging To: " + owner;
		output += "\nRent Amount: " + rentAmount;
		return output;
	}
	
}
