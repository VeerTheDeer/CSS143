//TODO: if you use this class because you dont have your
//previous SimpleColor, you must document the code with comments
//and fix the setters so they don't invalidate the [0-255] rule
public class SimpleColor {
	private int r;
	private int g;
	private int b;

	public SimpleColor() {
	}
	public SimpleColor(int r, int g, int b) {
		if(r > 255 || r < 0 || g > 255 || g < 0 || b > 255 || b < 0) {
			throw new ColorArgumentException();
		}
		setR(r);
		setG(g);
		setB(b);
	}
	public SimpleColor(SimpleColor other) {
		if(other.r > 255 || other.r < 0 || other.g > 255 || other.g < 0 || other.b > 255 || other.b < 0) {
			throw new ColorArgumentException();
		}
		setR(other.r);
		setG(other.g);
		setB(other.b);
	}

	public int getR() {
		return r;
	}

	public void setR(int r) {
		this.r = r;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public void setColor(int a, int b, int c) {
		setR(a);
		setG(b);
		setB(c);
	}

	
}
