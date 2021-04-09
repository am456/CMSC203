
public class ManagementCompany {
	
	private final int MAX_PROPERTY = 5;
	private double mgmFee; //percent of rent per property
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH = 10;
	private final int MGMT_DEPTH = 10;
	private Plot plot;
	
	/**
	 * No-Arg Constructor
	 */
	public ManagementCompany()
	{
		//Variables set to default values
		mgmFee = 0;
		name = "";
		taxID = "";
		
		//Object array initialized
		properties = new Property[MAX_PROPERTY];
		
		//Plot object initialized
		this.plot = new Plot();
		
	}
	
	/**
	 * This method creates a ManagementCompany object using the parameter values
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 */
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * This method uses the parameter values to create a ManagementCompany object
	 * @param name
	 * @param taxID
	 * @param mgmFee
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		
		this.plot = new Plot(x, y, width, depth);
		
		this.properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Copy constructor, sets object otherCompany's variables' values 
	 * equal to this class's variables' values of the corresponding name.
	 * @param otherCompany
	 */
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		
		this.properties = new Property[MAX_PROPERTY];
	}
	
	/**
	 * Returns value of variable name
	 * @return name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Set argument name's value as the value of this class's
	 * attribute name
	 * @param name
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Returns value of constant variable MAX_PROPERTY
	 * @return MAX_PROPERTY
	 */
	public int getMAX_PROPERTY()
	{
		return MAX_PROPERTY;
	}
	
	/**
	 * Creates a property object and adds it to the properties array
	 * @param property
	 * @return -2 if property is null, -3 if encompassed returns false, -4 if overlaps returns true, -1 if the array is full
	 */
	public int addProperty(Property property)
	{
		 if(property == null) {
	           return -2;
	       }
	       if(!plot.encompasses(property.getPlot())){
	           return -3;
	       }
	       for (int i = 0;i < properties.length; i++) {
	           if (properties[i] != null) {
	               if(properties[i].getPlot().overlaps(property.getPlot())) {
	                   return -4;
	               }
	           }
	           else {
	               properties[i] = property;
	               return i;
	           }
	       }
	       return -1;
	}
	
	/**
	 * Creates new object with the default plot in the properties array
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner)
	{
		return addProperty(new Property(name, city, rent, owner));
	}
	
	/**
	 * Creates an object and adds it to the properties array
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		 return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
	}
	
	/**
	 * Iterates through the properties array and finds the total of 
	 * all of the rentAmount values.
	 * @return rentSum
	 */
	public double totalRent()
	{
		double rentSum = 0;
		for (int i = 0; i < properties.length; i++)
		{
			Property rentObject = properties[i];
			
			
			if (rentObject == null)
			{
				break;
			}
			else
			{
				rentSum += rentObject.getRentAmount();
			}
		}
		
		return rentSum;
	}
	
	/**
	 * Finds the property with the maximum amount of rent and returns its
	 * toString result 
	 * @return largestRent
	 */
	public double maxRentProp()
	{
		double largestRent = 0;
		
		for(int i = 0; i < properties.length; i++)
		{
			Property rentObject = properties[i];
			
			if (rentObject == null)
			{
				break;
			}
			if(rentObject.getRentAmount() > largestRent)
			{
				largestRent = rentObject.getRentAmount();
			}
		}
		
		return largestRent;
	}
	
	/**
	 * Finds the index of the property with the maximum rent amount
	 * @return rentIndex
	 */
	public double maxRentPropertyIndex()
	{
		double largestRent = 0;
		int rentIndex = 0;
		
		for(int i = 0; i < properties.length; i++)
		{
			Property rentObject = properties[i];
			
			if (rentObject == null)
			{
				break;
			}
			if(rentObject.getRentAmount() > largestRent)
			{
				rentIndex = i;
				largestRent = rentObject.getRentAmount();
			}
		}
		
		return rentIndex;
	}
	
	/**
	 * Displays the information of the property at index i
	 * @param i
	 * @return indexProperties
	 */
	public String displayPropertyAtIndex(int i)
	{
		
		String indexProperties = "";
		indexProperties = properties[i].toString();
		
		return indexProperties;
	}
	
	/**
	 * Finds the value of plot
	 * @return plot
	 */
	public Plot getPlot()
	{
		return plot;
	}
	
	/**
	 * Sets the value of object Plot
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return plot
	 */
	public Plot setPlot(int x, int y, int width, int depth)
	{
		plot = new Plot(x, y, width, depth);
		return plot;
	}
	
	/**
	 * Finds the value of mgmFee
	 * @return mgmFee
	 */
	public double getMgmFee()
	{
		return mgmFee;
	}
	
	public double totalMgmFee()
	{
		double totalFee = 0.0;
		
		
		return totalFee;
	}
	
	/**
	 * Sets the value of mgmFee to the current class attribute mgmFee
	 * @param mgmFee
	 */
	public void setMgmFee(double mgmFee)
	{
		this.mgmFee = mgmFee;
	}
	
	/**
	 * Finds the value of MGMT_WIDTH
	 * @return MGMT_WIDTH
	 */
	public int getMGMT_WIDTH()
	{
		return MGMT_WIDTH;
	}
	
	/**
	 * Sets the value of taxID
	 * @param taxID
	 */
	public void setTaxID(String taxID)
	{
		this.taxID = taxID;
	}
	
	/**
	 * Finds the value of taxID
	 * @return taxID
	 */
	public String getTaxID()
	{
		return taxID;
	}
	
	/**
	 * Overrides the default toString class
	 * Displays the information about the properties in a String format
	 * @return String representation of each property
	 */
	public String toString()
	{
		double totalMgmtFee = 0.0;
		String propertiesString = "";
		propertiesString = "List of the properties for " + getName()
			+ ", taxID: " + getTaxID() + "\n";
		propertiesString += "---------------------------------------------------------------";
		
		for (int i = 0; i < properties.length; i++)
		{
			
			propertiesString += "\n" + displayPropertyAtIndex(i);
			
		}
		
		propertiesString += "\n---------------------------------------------------------------";
		
		totalMgmtFee = mgmFee * properties.length;
		propertiesString += "\nTotal Management Fee: " + totalMgmtFee;
		
		return propertiesString;
	}
	
}
