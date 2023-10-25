/**
 * The Box class represents a box with dimensions (width, height, depth) and a grade
 * that measures the thickness of the cardboard used to construct the box.
 */
public class Box {
	private int width, depth, height, grade;

	/**
	 * Class constructor to create a Box with specified dimensions and grade.
	 *
	 * @param width  The width of the box.
	 * @param height The height of the box.
	 * @param depth  The depth of the box.
	 * @param grade  The grade of the cardboard used.
	 */
	public Box(int width, int height, int depth, int grade) {
		this.width = width;
		this.height = height;
		this.depth = depth;
		this.grade = grade;
	}

	/**
	 * Two boxes should be considered equivalent if their volume is the same, and they are constructed
	 * out of the same grade of cardboard.
	 *
	 * @param b The Box to compare with this Box.
	 * @return true if they are equivalent, false otherwise.
	 */
	public boolean equals(Box b) {
		return (this.getVolume() == b.getVolume()) && (this.getGrade() == b.getGrade());
	}

	/**
	 * Compares this Box with another Box b. If this Box is larger than the argument Box b,
	 * it returns this Box; otherwise, it returns Box b.
	 *
	 * @param b The Box to compare with this Box.
	 * @return The larger of the two boxes.
	 */
	public Box larger(Box b) {
		if (b.getVolume() > this.getVolume()) {
			return b;
		}
		return this;
	}

	// Simple getter methods

	/**
	 * Get the grade of the cardboard.
	 *
	 * @return The grade of the cardboard.
	 */
	public int getGrade() {
		return grade;
	}

	/**
	 * Calculate and return the volume of the box.
	 *
	 * @return The volume of the box.
	 */
	public int getVolume() {
		return width * height * depth;
	}

	/**
	 * Get the width of the box.
	 *
	 * @return The width of the box.
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * Get the height of the box.
	 *
	 * @return The height of the box.
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * Get the depth of the box.
	 *
	 * @return The depth of the box.
	 */
	public int getDepth() {
		return depth;
	}
}
