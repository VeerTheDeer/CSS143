public class Point {
    private int sides;
    public String name;

    public Point (int sides, String name) {
        this.sides = sides;
    }

    public int getSides() {
        return this.sides;
    }

    private void setSides(int sides) {
        this.sides = sides;
    }
}
