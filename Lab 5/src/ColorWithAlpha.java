public class ColorWithAlpha extends SimpleColor{
    private int alpha;

    public ColorWithAlpha(int alpha) {
        super(0, 0, 0);
        this.alpha = alpha;
    }

    public ColorWithAlpha(int r, int g, int b, int alpha) {

        super(r,g,b);
        this.alpha = alpha;
    }

    public ColorWithAlpha(ColorWithAlpha other) {
        super(other.getR(), other.getG(), other.getB());
        this.alpha = other.alpha;
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = alpha;
    }

    @Override
    public String toString() {
        return "(" + this.getR() + ", "+this.getG() + ", " + this.getB() + ", " + this.getAlpha() + ")";
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!super.equals(object)) {
            return false;
        }
        if (!(object instanceof ColorWithAlpha)) {
            return false;
        }
        ColorWithAlpha color = (ColorWithAlpha) object;
        // compare the alpha values
        return color.getAlpha() == ((ColorWithAlpha) object).getAlpha();
    }
}
