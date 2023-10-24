public class Point2D {
    private int x;
    private int y;

    public static void main(String[] args) {
        Point2D a = new Point2D();
        a.setX(5);
        a.setY(2);
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        a.translate(-1,-1);
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        a.resetToOrigin();
        System.out.println("Point at (" + a.getX() + ", " + a.getY() );
        Point2D b = new Point2D();
        Point2D c = new Point2D();
        System.out.println(b.toString());
        System.out.println(c); //Question: why don’t I need c.toString() here?
        System.out.println("Are b and c equal:" + b.equals(c));
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public void resetToOrigin() {
        this.x = 0;
        this.y = 0;
    }
    public void translate(int dx, int dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    public boolean equals(Point2D that) {
        return (this.x == that.x && this.y == that.y);
    }
}
