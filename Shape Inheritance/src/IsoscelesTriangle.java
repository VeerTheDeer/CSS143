import java.awt.*;

/**
 * The IsoscelesTriangle class represents an isosceles triangle shape
 * that extends the Shape class. It allows for the creation, manipulation,
 * and representation of an isosceles triangle with specified base, height,
 * and color.
 *
 * By Veer Saini
 */
class IsoscelesTriangle extends Shape {
    private int base; // Length of the base of the triangle
    private int height; // Height of the triangle
    private Color color = Color.BLACK; // Color of the triangle

    /**
     * Constructs an IsoscelesTriangle object with the specified base and height.
     *
     * @param base   The length of the base of the triangle.
     * @param height The height of the triangle.
     */
    public IsoscelesTriangle(int base, int height) {
        super(0, 0);
        setBase(base);
        setHeight(height);
    }

    /**
     * Constructs an IsoscelesTriangle object with the specified base, height,
     * x and y coordinates.
     *
     * @param x      The x-coordinate of the triangle.
     * @param y      The y-coordinate of the triangle.
     * @param base   The length of the base of the triangle.
     * @param height The height of the triangle.
     */
    public IsoscelesTriangle(int x, int y, int base, int height) {
        super(x, y);
        setBase(base);
        setHeight(height);
    }

    /**
     * Constructs an IsoscelesTriangle object with the specified base, height, x and y coordinates,
     * and color.
     *
     * @param x      The x-coordinate of the triangle.
     * @param y      The y-coordinate of the triangle.
     * @param base   The length of the base of the triangle.
     * @param height The height of the triangle.
     * @param color  The color of the triangle.
     */
    public IsoscelesTriangle(int x, int y, int base, int height, Color color) {
        super(x, y);
        setBase(base);
        setHeight(height);
        setColor(color);
    }

    /**
     * Retrieves the area of the IsoscelesTriangle.
     *
     * @return The area of the triangle calculated by (base * height) / 2.
     */
    public double getArea() {
        return 0.5 * base * height;
    }

    /**
     * Retrieves the base of the IsoscelesTriangle.
     *
     * @return The length of the base of the triangle.
     */
    public int getBase() {
        return base;
    }

    /**
     * Retrieves the height of the IsoscelesTriangle.
     *
     * @return The height of the triangle.
     */
    public int getHeight() {
        return height;
    }

    /**
     * Retrieves the color of the IsoscelesTriangle.
     *
     * @return The color of the triangle.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets the base of the IsoscelesTriangle.
     *
     * @param base The length of the base of the triangle.
     */
    public void setBase(int base) {
        this.base = base;
    }

    /**
     * Sets the height of the IsoscelesTriangle.
     *
     * @param height The height of the triangle.
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Sets the color of the IsoscelesTriangle.
     *
     * @param color The color of the triangle.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Draws the IsoscelesTriangle on the specified Graphics object.
     *
     * @param g The Graphics object used to draw the triangle.
     */
    @Override
    public void draw(Graphics g) {
        int[] xPoints = {getX() - base / 2, getX() + base / 2, getX()}; // x coordinates for the triangle
        int[] yPoints = {getY() + height, getY() + height, getY()}; // y coordinates for the triangle

        g.setColor(getColor()); // Set the color for the triangle
        g.drawPolygon(xPoints, yPoints, 3); // Draw the triangle
    }
}
