public class Circle {
    private int x, y;
    private double radius;
    private String rep = "O";

    public Circle() {

    }
    public Circle(int nx, int ny) {
        this.x = nx;
        this.y = ny;
    }
    public Circle(int nx, int ny, int radius) {
        this.x = nx;
        this.y = ny;
        this.radius = radius;
    }
    public void draw() {
        System.out.println(rep);
    }
    public int getY() {
        return y;
    }
    public int getX() {
        return x;
    }
    public double getRadius() {
        return radius;
    }
    public double getArea() {
        return Math.PI*radius*radius;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return this.rep;
    }
    public boolean equals(Circle that) {
        return (this.x == that.x && this.y == that.y && this.radius == that.radius);
    }
}
