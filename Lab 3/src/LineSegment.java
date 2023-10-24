public class LineSegment {
    private Point2D start;
    private Point2D end;

    public LineSegment() {
        this.start = new Point2D(0, 0);
        this.end = new Point2D(0, 0);
    }

    public LineSegment(LineSegment other) {
        this.start = other.start;
        this.end = other.end;
    }
    public LineSegment(Point2D start, Point2D end) {
        this.start = start;
        this.end = end;
    }

    public class Main {
        public static void main(String[] args) {
            LineSegment line = new LineSegment(new Point2D(50, 75), new Point2D(80, 45));
            Point2D point = line.getStart();
            point.setX(-100); // breaks the class invariant for LineSegment
        }
    }

    public Point2D getStart() {
        return new Point2D(start);
    }

    public Point2D getEnd() {
        return new Point2D(end);
    }

    @Override
    public String toString() {
        return "Line start: (" + this.start.getX() + ", " + this.start.getY() + ") end: (" + this.end.getX() + ", " + this.end.getY() + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || !(other instanceof LineSegment)) {
            return false;
        }
        if (this == other) {
            return true;
        }
        LineSegment that = (LineSegment) other;
        if(this.start.equals(that.start) && this.end.equals(that.end)) {
            return true;
        }
        return false;
    }

    public double getDistance() {
        return Math.abs(Math.sqrt((start.getY() - end.getY()) * (start.getY() - end.getY()) +
                (start.getX() - end.getX()) * (start.getX() - end.getX())));
    }

    /*
     * What is a privacy leak?
     *
     * A privacy leak is when the user get access to private instances that they are not supposed to get access to,
     * usually the interface that they are give are not working in a proper manner, and that is the reason that
     * these leaks are possible in the first place
     *
     * Do your getters or setters have privacy leaks?
     *
     * No I do not think that my getters and setters have any privacy leaks that
     * would allow the user to maliciously change the data setters are there
     * for the users to set their data and for them to utilize this class, so
     * I would not classify that as a privacy leak.
     *
     * Where else could a privacy leak look occur?
     *
     * Some other ways that a data leak can occur is when a access modifier is set incorrectly.
     * in this case something could happen to data that is not supposed to be either set or edited.
     */
}