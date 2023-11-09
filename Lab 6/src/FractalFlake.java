import java.awt.*;

public class FractalFlake extends Shape {
    private final int limit; // Snowflake's depth limit
    private final int numBranches; // Number of branches for the flake

    // Constructor
    public FractalFlake(int x, int y, int width, int height, Color color, int limit, int numBranches) {
        super(x, y, width, height, color);
        this.limit = Math.max(1, Math.min(50, limit)); // Ensure limit is within the valid range
        this.numBranches = Math.max(5, Math.min(12, numBranches)); // Ensure numBranches is within the valid range
    }

    // Override draw method
    @Override
    public void draw(Graphics g) {
        g.setColor(getColor());
        draw(g, getX(), getY(), limit);
    }

    // Overloaded draw method
    public void draw(Graphics g, int x, int y, int limit) {
        if(limit >= 3) {
            for(int i = 0; i < numBranches; i++) {
                int x2 = x + (int) (limit * Math.cos(2 * Math.PI / numBranches) * i);
                int y2 = x + (int) (limit * Math.sin(2 * Math.PI / numBranches) * i);
                g.drawLine(x, y, x2, y2);
                draw(g, x2, y2, limit / 3);
            }
        }
    }
}
