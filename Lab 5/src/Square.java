import java.awt.*;

public class Square extends Shape{
    private int sideLength;

    public Square() {
        super();
    }

    public Square(int sideLength) {
        super(0, 0);
        setSideLength(sideLength);
    }

    public Square(int x, int y, int sideLength) {
        super(x,y);
        setSideLength(sideLength);
    }

    public int getSideLength() {
        return this.sideLength;
    }

    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }

    public double getArea() {
        return getSideLength() * getSideLength();
    }

    @Override
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(getColor());
        g2d.fillRect(getX() - getSideLength() / 2, getY() - getSideLength() / 2, getSideLength(), getSideLength());
    }
}