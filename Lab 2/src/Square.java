public class Square {
    private int x, y;
    private double sideLength;
    private String rep = "[]";

    public Square() {

    }
    public Square(int nx, int ny) {
        this.x = nx;
        this.y = ny;
    }
    public Square(int nx, int ny, int sideLength) {
        this.x = nx;
        this.y = ny;
        this.sideLength = sideLength;
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
    public double getSideLength() {
        return sideLength;
    }
    public double getArea() {
        return getSideLength()*getSideLength();
    }
    public void setY(int y) {
        this.y = y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return this.rep;
    }
    public boolean equals(Square that) {
        return (this.x == that.x && this.y == that.y && this.sideLength == that.sideLength);
    }
}
