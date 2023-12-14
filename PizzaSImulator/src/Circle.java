import java.awt.*;

/**
 * This class represents a Circle shape and extends the Shape class. It implements the
 * Cloneable interface to support object cloning.
 *
 * @author Veer Saini
 */
public class Circle extends Shape implements Cloneable {

	private int radius;
	private Color myColor = Color.BLACK;

	/**
	 * Constructor for creating a Circle object with specified coordinates and radius.
	 *
	 * @param x      The x-coordinate of the center of the circle.
	 * @param y      The y-coordinate of the center of the circle.
	 * @param radius The radius of the circle.
	 */
	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	/**
	 * Constructor for creating a Circle object with specified coordinates, radius, and color.
	 *
	 * @param x      The x-coordinate of the center of the circle.
	 * @param y      The y-coordinate of the center of the circle.
	 * @param r      The radius of the circle.
	 * @param color  The color of the circle.
	 */
	public Circle(int x, int y, int r, Color color) {
		super(x, y);
		this.radius = r;
		this.myColor = color;
	}

	/**
	 * Calculates and returns the area of the circle.
	 *
	 * @return The area of the circle.
	 */
	@Override
	public double getArea() {
		return Math.PI * this.radius * this.radius;
	}

	/**
	 * Gets the radius of the circle.
	 *
	 * @return The radius of the circle.
	 */
	public int getRadius() {
		return this.radius;
	}

	/**
	 * Gets the color of the circle.
	 *
	 * @return The color of the circle.
	 */
	public Color getColor() {
		return this.myColor;
	}

	/**
	 * Checks if this circle is equal to another circle.
	 *
	 * @param other The circle to compare with.
	 * @return true if the circles are equal, false otherwise.
	 */
	public boolean equals(Circle other) {
		return (this.getX() == other.getX() &&
				this.getY() == other.getY() &&
				this.getRadius() == other.getRadius() &&
				this.getColor() == other.getColor());
	}

	/**
	 * Draws the circle on a Graphics object.
	 *
	 * @param g The Graphics object to draw on.
	 */
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawOval(this.getX(), this.getY(), this.getRadius() * 2, this.getRadius() * 2);
		g.setColor(this.getColor());
		g.fillOval(this.getX(), this.getY(), this.getRadius() * 2, this.getRadius() * 2);
	}

	/**
	 * Returns a string representation of the Circle object.
	 *
	 * @return A string containing information about the circle.
	 */
	@Override
	public String toString() {
		return "X: " + this.getX() + ", Y: " + this.getY() + ", Radius: " + this.getRadius() +
				", Area: " + this.getArea() + ", Color: " + this.getColor();
	}

	/**
	 * Creates and returns a deep copy (clone) of the Circle object.
	 *
	 * @return A new Circle object with the same properties as the original.
	 */
	@Override
	public Circle clone() {
		return new Circle(this.getX(), this.getY(), this.getRadius());
	}

	/**
	 * Gets the name of the shape as a string.
	 *
	 * @return The string "Circle".
	 */
	public String nameString() {
		return "Circle";
	}

	/**
	 * The main method for testing the Circle class. It creates Circle objects with different
	 * parameters and prints their string representations. It also checks the equality of two
	 * Circle objects using the equals method.
	 *
	 * @param args The command-line arguments (not used in this context).
	 */
	public static void main(String args[]) {
		Circle c1 = new Circle(1, 1, 2, Color.BLUE);
		Circle c2 = new Circle(3, 4, 4);
		Circle c3 = new Circle(3, 4, 4);
		Circle c4 = new Circle(3, 4, 8);

		System.out.println("Circle 1: " + c1.toString());
		System.out.println("Circle 2: " + c2.toString());
		System.out.println("Circle 3: " + c3.toString());
		System.out.println("Circle 4: " + c4.toString());
		System.out.println("Circle1 = Circle2: " + c1.equals(c2));
		System.out.println("Circle1 = Circle3: " + c1.equals(c3));
		System.out.println("Circle2 = Circle3: " + c2.equals(c3));
		System.out.println("Circle3 = Circle4: " + c3.equals(c4));
	}
}
