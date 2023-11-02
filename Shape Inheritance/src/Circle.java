import java.awt.*;

/**
 * The Circle class represents a circle shape extending the Shape class.
 * It enables the creation, manipulation, and display of a circle with a specified
 * radius, color, and position.
 *
 * By Veer Saini
 */
public class Circle extends Shape {
    private int radius; // Radius of the circle
    private Color color = Color.BLACK; // Color of the circle

    /**
     * Constructs a Circle object with specified position, radius, and color.
     *
     * @param x      The x-coordinate of the circle.
     * @param y      The y-coordinate of the circle.
     * @param radius The radius of the circle.
     * @param color  The color of the circle.
     */
    public Circle(int x, int y, int radius, Color color) {
        super(x, y);
        setRadius(radius);
        setColor(color);
    }

    /**
     * Constructs a Circle object with specified position and radius.
     *
     * @param x      The x-coordinate of the circle.
     * @param y      The y-coordinate of the circle.
     * @param radius The radius of the circle.
     */
    public Circle(int x, int y, int radius) {
        super(x, y);
        setRadius(radius);
    }

    /**
     * Constructs a Circle object with a radius and default position (0, 0).
     *
     * @param radius The radius of the circle.
     */
    public Circle(int radius) {
        super(0, 0);
        setRadius(radius);
    }

    /**
     * Retrieves the radius of the Circle.
     *
     * @return The radius of the circle.
     */
    public int getRadius() {
        return radius;
    }

    /**
     * Sets the radius of the Circle.
     *
     * @param radius The radius of the circle.
     */
    public void setRadius(int radius) {
        this.radius = radius;
    }

    /**
     * Sets the color of the Circle.
     *
     * @param color The color of the circle.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Retrieves the color of the Circle.
     *
     * @return The color of the circle.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Retrieves the area of the Circle.
     *
     * @return The area of the circle calculated by π * radius * radius.
     */
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    /**
     * Draws the Circle on the specified Graphics object.
     *
     * @param g The Graphics object used to draw the circle.
     */
    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());
        // Draws an oval given the top-left corner, width, and
        // height of the rectangle that bounds this circle.
        g2d.drawOval(getX() - radius, getY() - radius, 2 * radius, 2 * radius);
    }
}
