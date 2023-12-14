import java.awt.*;

/**
 * The {@code Square} class represents a square shape, extending the {@code Shape} class.
 * It provides specific functionality for squares, such as area calculation and drawing.
 *
 * @author Veer Saini
 */
public class Square extends Shape implements Cloneable {

	private int sideLength;
	private Color color = Color.BLACK;

	/**
	 * Constructs a {@code Square} with the specified x and y coordinates, side length, and color.
	 *
	 * @param x          The x-coordinate of the square.
	 * @param y          The y-coordinate of the square.
	 * @param sideLength The side length of the square.
	 * @param color      The color of the square.
	 */
	public Square(int x, int y, int sideLength, Color color) {
		super(x, y);
		this.sideLength = sideLength;
		this.color = color;
	}

	/**
	 * Constructs a {@code Square} with the specified x and y coordinates and side length.
	 *
	 * @param x          The x-coordinate of the square.
	 * @param y          The y-coordinate of the square.
	 * @param sideLength The side length of the square.
	 */
	public Square(int x, int y, int sideLength) {
		super(x, y);
		this.sideLength = sideLength;
	}

	/**
	 * Calculates and returns the area of the square.
	 *
	 * @return The area of the square.
	 */
	@Override
	public double getArea() {
		return this.sideLength * this.sideLength;
	}

	/**
	 * Gets the side length of the square.
	 *
	 * @return The side length of the square.
	 */
	public int getSideLength() {
		return this.sideLength;
	}

	/**
	 * Draws the square using the specified graphics context.
	 *
	 * @param g The graphics context used for drawing.
	 */
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLACK);
		g.drawRect(this.getX(), this.getY(), this.getSideLength(), this.getSideLength());
		g.setColor(this.getColor());
		g.fillRect(this.getX(), this.getY(), this.getSideLength(), this.getSideLength());
	}

	/**
	 * Gets the color of the square.
	 *
	 * @return The color of the square.
	 */
	public Color getColor() {
		return this.color;
	}

	/**
	 * Checks if this square is equal to another square.
	 *
	 * @param other The other square to compare.
	 * @return {@code true} if the squares are equal, {@code false} otherwise.
	 */
	public boolean equals(Square other) {
		return this.getX() == other.getX() &&
				this.getY() == other.getY() &&
				this.getSideLength() == other.getSideLength() &&
				this.getColor().equals(other.getColor());
	}

	/**
	 * Returns a string representation of the square.
	 *
	 * @return A string representation of the square.
	 */
	@Override
	public String toString() {
		return "X: " + this.getX() + ", Y: " + this.getY() + ", Side Length: " + this.getSideLength() +
				", Area: " + this.getArea() + ", Color: " + this.getColor();
	}

	/**
	 * Returns the name of the shape as a string.
	 *
	 * @return The name of the shape.
	 */
	@Override
	public String nameString() {
		return "Square";
	}

	/**
	 * Creates and returns a shallow copy of the square.
	 *
	 * @return A shallow copy of the square.
	 */
	@Override
	public Square clone() {
		return new Square(this.getX(), this.getY(), this.getSideLength());
	}

	/**
	 * The main method for testing the {@code Square} class.
	 *
	 * @param args Command-line arguments (not used).
	 */
	public static void main(String args[]) {
		Square s1 = new Square(1, 1, 2, Color.BLUE);
		Square s2 = new Square(3, 4, 4);
		Square s3 = new Square(3, 4, 4);
		Square s4 = new Square(3, 4, 8);
		System.out.println("Square 1: " + s1.toString());
		System.out.println("Square 2: " + s2.toString());
		System.out.println("Square 3: " + s3.toString());
		System.out.println("Square 4: " + s4.toString());
		System.out.println("Square1 = Square2 " + s1.equals(s2));
		System.out.println("Square1 = Square3 " + s1.equals(s3));
		System.out.println("Square2 = Square3 " + s2.equals(s3));
		System.out.println("Square3 = Square4 " + s3.equals(s4));
	}
}
