import java.awt.*;

import static java.awt.Color.getColor;

public class Circle extends Shape {
    private int radius;

    public Circle(int x, int y, Color color, int radius) {
        super(x, y, color);
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());
        // Draws an oval given the top-left corner, width, and
        // height of the rectangle that bounds this circle.
        g2d.fillOval(getX() - radius, getY() - radius, 2 * radius, 2 * radius);
    }
}
