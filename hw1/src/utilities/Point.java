package utilities;

//imports

//javadoc
/**
 * @author
 * orel hen 316179423
 * guy aloosh 316471465
 */
public class Point {

	private static final int MAX_X = 1000000;
	private static final int MIN_X = 0;
	private static final int MAX_Y = 70*20;
	private static final int MIN_Y= 0;
	private double x;
	private double y;

	//constructers

	public Point() {
		this.x = 0;
		this.y= 0;
	}

	/**
	 * @param nx
	 * @param ny
	 */
	public Point(double nx, double ny) {
		//input y and x
		//if input is inviald, dafaut x,y =0  ------ maybe Raiseexception.

		if  (nx >= this.MIN_X && nx <= this.MAX_X) {
			this.x = nx;
		} else
			this.x=0;
		if  (ny >= this.MIN_Y && ny <= this.MAX_Y) {
			this.y = ny;
		} else
			this.y=0;
	}

	/**
	 * @param obj
	 */
	public Point(Point obj) {
		this.x= obj.GetX();
		this.y= obj.GetY();
	}

	//getters
	public double GetX() { return this.x;}

	public double GetY() { return this.y;}

	/**
	 * @param nx
	 * @return
	 */
	//setters
	public boolean SetX(double nx) {
		if  (nx >= this.MIN_X && nx <= this.MAX_X) {
			this.x = nx;
			return true;
		} else
			return false;
	}

	/**
	 * @param ny
	 * @return
	 */
	public boolean SetY(double ny) {
		if  (ny >= this.MIN_Y && ny <= this.MAX_Y) {
			this.y = ny;
			return true;
		} else
			return false;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	/**
	 * @return
	 */
	//ToString
	public String toString() {
		return "x cords: " + this.x +"\n y cords: "+ this.y +"\n";
	}

}
