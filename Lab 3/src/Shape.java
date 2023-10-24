import java.awt.*;

public class Shape {
    private int x;
    private int y;
    private Color color;

    public Shape() {
        this.x = 0;
        this.y = 0;
        this.color = Color.WHITE;
    }

    public Shape(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public double getArea() {
        return -1;
    }

    public void draw(Graphics g) {
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ") " + this.color;
    }


    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}
