
public class Plot {
	
	private int x; //Horizontal coordinate of upper left corner
	private int y; //Vertical coordinate of upper left corner
	private int width; //Horizontal size
	private int depth; //vertical size
	
	/** 
	 * No-args constructor
	 */
	public Plot()
	{
		this.x = 0;
		y = 0;
		width = 1;
		depth = 1;
	}
	
	/**
	 * Copy constructor
	 * @param p
	 */
	public Plot(Plot p)
	{
		this.x = p.x;
		this.y = p.y;
		this.width = p.width;
		this.depth = p.depth;
	}
	
	/**
	 * Parameterized constructor for class Plot.
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 */
	public Plot(int x, int y, int width, int depth) 
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	/**
	 * Checks whether or not the plot overlaps with the parameters
	 * @return true if there is overlap, false if not
	 */
	public boolean overlaps(Plot plot)
	{		
		if((this.x < plot.x + plot.width) && (this.y < plot.y + plot.depth)
				&& (plot.x < this.x + this.width) && (plot.y < this.y + this.depth))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Method determines if the plot is within the parameters given
	 * @param plot
	 * @return true if the plot is encompassed by the parameter, if not then false
	 */
	public boolean encompasses(Plot plot)
	{
		double xTwo = x + width; //Right horizontal coordinate from Plot
		double yTwo = x + depth; //Bottom y coordinate from Plot
		
		double plotXTwo = plot.getX() + plot.getWidth(); //Right horizontal coordinate from parameter
		double plotYTwo = plot.getY() + plot.getDepth(); //Bottom y coordinate from parameter
		
		if((this.x <= xTwo) && (plotXTwo <= xTwo) && (this.y <= plotYTwo) 
				&& (plotYTwo <= yTwo) && (this.x <= plot.getX()) 
				&& (plot.getX() <= xTwo) && (this.y <= plot.getY()) 
				&& (plot.getY() <= yTwo))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public void setX(int x) 
	{
		this.x = x;
	}
	
	public int getX()
	{
		return x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public int getY()
	{
		return y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	public String toString()
	{
		Property p = new Property();
		System.out.println(p.toString());
		String output;
		output = "Upper left: ("  + x + "," + y + ");";
		output += " Width: " + width + " Depth: " + depth;
		return output;
	}
	
}
