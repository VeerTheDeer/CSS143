import java.awt.*;

/**
 * The Rectangle class represents a rectangular shape extending the Shape class.
 * It allows the creation, manipulation, and display of a rectangle with specified
 * length, width, color, and position.
 *
 * By Veer Saini
 */
public class Rectangle extends Shape {
    private double length; // Length of the rectangle
    private double width; // Width of the rectangle
    private Color color = Color.BLACK; // Color of the rectangle

    /**
     * Constructs a Rectangle object with specified length and width and default position (0, 0).
     *
     * @param length The length of the rectangle.
     * @param width  The width of the rectangle.
     */
    public Rectangle(double length, double width) {
        super(0 ,0);
        setLength(length);
        setWidth(width);
    }

    /**
     * Constructs a Rectangle object with specified position, length, and width.
     *
     * @param x      The x-coordinate of the rectangle.
     * @param y      The y-coordinate of the rectangle.
     * @param length The length of the rectangle.
     * @param width  The width of the rectangle.
     */
    public Rectangle(int x, int y, double length, double width) {
        super(x, y);
        setLength(length);
        setWidth(width);
    }

    /**
     * Constructs a Rectangle object with specified position, length, width, and color.
     *
     * @param x      The x-coordinate of the rectangle.
     * @param y      The y-coordinate of the rectangle.
     * @param length The length of the rectangle.
     * @param width  The width of the rectangle.
     * @param color  The color of the rectangle.
     */
    public Rectangle(int x, int y, double length, double width, Color color) {
        super(x, y);
        setLength(length);
        setWidth(width);
        setColor(color);
    }

    /**
     * Sets the length of the Rectangle.
     *
     * @param length The length of the rectangle.
     */
    public void setLength(double length) {
        this.length = length;
    }

    /**
     * Sets the width of the Rectangle.
     *
     * @param width The width of the rectangle.
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     * Sets the color of the Rectangle.
     *
     * @param color The color of the rectangle.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Retrieves the length of the Rectangle.
     *
     * @return The length of the rectangle.
     */
    public double getLength() {
        return length;
    }

    /**
     * Retrieves the width of the Rectangle.
     *
     * @return The width of the rectangle.
     */
    public double getWidth() {
        return width;
    }

    /**
     * Retrieves the color of the Rectangle.
     *
     * @return The color of the rectangle.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retrieves the area of the Rectangle.
     *
     * @return The area of the rectangle calculated by length * width.
     */
    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    /**
     * Draws the Rectangle on the specified Graphics object.
     *
     * @param g The Graphics object used to draw the rectangle.
     */
    @Override
    public void draw(Graphics g) {
        g.setColor(this.getColor());
        int p1X = this.getX();
        int p1Y = this.getY();
        int p2X = (int) (this.getX() + this.getWidth());
        int p2Y = this.getY();
        int p3X = (int) (this.getX() + this.getWidth());
        int p3Y = (int) (this.getY() - this.getLength());
        int p4X = this.getX();
        int p4Y = (int) (this.getY() - this.getLength());
        g.drawLine(p1X, p1Y, p2X, p2Y);
        g.drawLine(p2X, p2Y, p3X, p3Y);
        g.drawLine(p3X, p3Y, p4X, p4Y);
        g.drawLine(p4X, p4Y, p1X, p1Y);
    }
}
