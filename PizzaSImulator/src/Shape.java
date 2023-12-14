import java.awt.*;

/**
 * The {@code Shape} class is an abstract base class representing geometric shapes.
 * It provides basic functionality for shapes, such as position and color.
 *
 * @author Veer Saini
 */
abstract class Shape extends Object implements Cloneable {

	private int x = 0;
	private int y = 0;
	private Color color = Color.BLACK;

	/**
	 * Constructs a {@code Shape} with the specified x and y coordinates.
	 *
	 * @param x The x-coordinate of the shape.
	 * @param y The y-coordinate of the shape.
	 */
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/**
	 * Constructs a {@code Shape} with the specified x and y coordinates and color.
	 *
	 * @param x     The x-coordinate of the shape.
	 * @param y     The y-coordinate of the shape.
	 * @param color The color of the shape.
	 */
	public Shape(int x, int y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	/**
	 * Gets the area of the shape. This method is abstract and should be overridden
	 * by subclasses to provide the specific implementation for each shape type.
	 *
	 * @return The area of the shape.
	 */
	public abstract double getArea();

	/**
	 * Draws the shape using the specified graphics context.
	 *
	 * @param g The graphics context used for drawing.
	 */
	public void draw(Graphics g) {
		// Implementation specific to each shape.
	}

	/**
	 * Gets the x-coordinate of the shape.
	 *
	 * @return The x-coordinate of the shape.
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Gets the y-coordinate of the shape.
	 *
	 * @return The y-coordinate of the shape.
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Creates and returns a shallow copy of the shape.
	 *
	 * @return A shallow copy of the shape.
	 */
	public Shape clone() {
		try {
			return (Shape) super.clone();
		} catch (CloneNotSupportedException e) {
			// This should never happen since Shape extends Cloneable.
			throw new InternalError(e.getMessage());
		}
	}

	/**
	 * Returns a string representation of the shape's name.
	 * This method should be overridden by subclasses to provide
	 * the specific name for each shape type.
	 *
	 * @return A string representation of the shape's name.
	 */
	public String nameString() {
		return "";
	}
}
