import java.awt.*;
/**
 * The Kite class represents a kite shape extending the Shape class.
 * It enables the creation, manipulation, and display of a kite with specified
 * dimensions, color, and position.
 *
 * By Veer Saini
 */
public class Kite extends Shape {
	private int length; // Length of the kite
	private int width; // Width of the kite
	private Color color = Color.BLACK; // Color of the kite

	/**
	 * Constructs a Kite object with specified position, length, and width.
	 *
	 * @param x      The x-coordinate of the kite.
	 * @param y      The y-coordinate of the kite.
	 * @param length The length of the kite.
	 * @param width  The width of the kite.
	 */
	public Kite(int x, int y, int length, int width) {
		super(x, y);
		if (length > width) {
			setLength(length);
			setWidth(width);
		} else {
			setLength(width);
			setWidth(length);
		}
	}

	/**
	 * Constructs a Kite object with specified position, length, width, and color.
	 *
	 * @param x      The x-coordinate of the kite.
	 * @param y      The y-coordinate of the kite.
	 * @param length The length of the kite.
	 * @param width  The width of the kite.
	 * @param color  The color of the kite.
	 */
	public Kite(int x, int y, int length, int width, Color color) {
		super(x, y);
		if (length > width) {
			setLength(length);
			setWidth(width);
		} else {
			setLength(width);
			setWidth(length);
		}
		setColor(color);
	}

	/**
	 * Retrieves the area of the Kite.
	 *
	 * @return The area of the kite calculated by 0.5 * width * length.
	 */
	@Override
	public double getArea() {
		return 0.5 * this.width * this.length;
	}

	/**
	 * Retrieves the length of the Kite.
	 *
	 * @return The length of the kite.
	 */
	public int getLength() {
		return this.length;
	}

	/**
	 * Retrieves the width of the Kite.
	 *
	 * @return The width of the kite.
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Retrieves the color of the Kite.
	 *
	 * @return The color of the kite.
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Sets the length of the Kite.
	 *
	 * @param length The length of the kite.
	 */
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Sets the width of the Kite.
	 *
	 * @param width The width of the kite.
	 */
	public void setWidth(int width) {
		this.width = width;
	}

	/**
	 * Sets the color of the Kite.
	 *
	 * @param color The color of the kite.
	 */
	public void setColor(Color color) {
		this.color = color;
	}

	/**
	 * Compares this Kite to another Kite object for equality.
	 *
	 * @param other The other Kite object to compare.
	 * @return True if both kites have the same position, width, length, and color; otherwise false.
	 */
	public boolean equals(Kite other) {
		return this.getX() == other.getX() &&
				this.getY() == other.getY() &&
				this.getWidth() == other.getWidth() &&
				this.getLength() == other.getLength() &&
				this.getColor().equals(other.getColor());
	}

	/**
	 * Draws the Kite on the specified Graphics object.
	 *
	 * @param g The Graphics object used to draw the kite.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(this.getColor());

		g.drawLine(this.getX(), this.getY() + this.getWidth(), this.getX() + this.getWidth() / 2, this.getY() + this.getWidth() / 2 + this.getWidth());
		g.drawLine(this.getX(), this.getY() + this.getWidth(), this.getX() + this.getWidth() / 2, this.getY() - this.getWidth() / 2 + this.getWidth());
		g.drawLine(this.getX() + this.getWidth() / 2, this.getY() + this.getWidth() / 2 + this.getWidth(), this.getX() + this.getLength(), this.getY() + this.getWidth());
		g.drawLine(this.getX() + this.getWidth() / 2, this.getY() - this.getWidth() / 2 + this.getWidth(), this.getX() + this.getLength(), this.getY() + this.getWidth());
		g.drawLine(this.getX(), this.getY() + this.getWidth(), this.getX() + this.getLength(), this.getY() + this.getWidth());
		g.drawLine(this.getX() + this.getWidth() / 2, this.getY() + this.getWidth() / 2 + this.getWidth(), this.getX() + this.getWidth() / 2, this.getY() - this.getWidth() / 2 + this.getWidth());
	}
}

/*
	@Override
	public String toString(){
		return "X: "+this.getX()+", Y: "+this.getY()+", Width: "+this.getWidth()+", Length: "+this.getLength()+", Area: "+this.getArea()+", Color: "+this.getColor();
	}

		public static void main( String args[] ) {
		Kite kite1 = new Kite(1,1,2,4,Color.BLUE);
		Kite kite2 = new Kite(3,4,8,4);
		Kite kite3 = new Kite(3,4,4,8);
		Kite kite4 = new Kite(3,4,4,8);
		System.out.println("Kite 1: "+kite1.toString());
		System.out.println("Kite 2: "+kite2.toString());
		System.out.println("Kite 3: "+kite3.toString());
		System.out.println("Kite 4: "+kite4.toString());
		System.out.println("Kite1 = Kite2? (Should be false): "+kite1.equals(kite2));
		System.out.println("Kite1 = Kite3? (Should be false): "+kite1.equals(kite3));
		System.out.println("Kite2 = Kite3? (Should be true): "+kite2.equals(kite3));
		System.out.println("Kite3 = Kite4? (Should be true): "+kite3.equals(kite4));
	}
*/
