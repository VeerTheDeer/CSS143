import java.util.*;
import javax.swing.*;
import java.awt.*;

/**
 * Class PolyDemo (is a JFrame) and PolyDemoPanel (is a JPanel)
 *
 * Author: Rob Nash
 */
class PolyDemo extends JFrame {

	/**
	 * Constructor for the PolyDemo class.
	 */
	public PolyDemo() {
		getContentPane().add( new PolyDemoPanel() );
		//just some windowing stuff that must happen for all Frames
		setSize( 300,300 );
		setVisible( true );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	}

	/**
	 * The main method to execute the PolyDemo application.
	 * @param args The command line arguments
	 */
	public static void main( String args[] ) {
		PolyDemo myApp = new PolyDemo();
	}

	/**
	 * The inner class PolyDemoPanel which extends JPanel.
	 * Purpose of this class is to support the JFrame class.
	 */
	public class PolyDemoPanel extends JPanel {
		Shape[] myShapes= new Shape[20];

		/**
		 * Constructor for PolyDemoPanel. Populates myShapes array.
		 */
		public PolyDemoPanel() {
			//Code for populating our myShapes changes minimally when new classes are introduced (only in getRandShape())
			for( int i = 0; i < 20; i++ ) {
				myShapes[i] =  getRandShape();
			}
		}

		/**
		 * Paint method to draw shapes on the panel.
		 * @param g The Graphics object
		 */
		public void paint( Graphics g ) {
			super.paint(g);  //required for GUI widgets to draw correctly

			//Late Binding Demo
			for(int i = 0; i < myShapes.length; i++ ){
				//which draw method is invoked here? There are many forms of the method (polymorphic), so which is chosen?
				//Java has RTTI about every object, and it uses this info to choose the correct method to invoke!
				myShapes[i].draw(g);
			}
		}

		/**
		 * Generate a random integer.
		 * @return A random integer value
		 */
		public int getRandInt() {
			return ( (int) ( Math.random() * 200 ) );
		}

		/**
		 * Get a random shape.
		 * @return A Shape object
		 */
		public Shape getRandShape() {
			Shape retVal = null;
			final int x = getRandInt();
			final int y = getRandInt();

			//Polymorphic extensibility demo
			switch( (int)(Math.random() * 4) ) {
				case 0:     retVal = new Circle(getRandInt(), getRandInt(), getRandInt());
					break;
				case 1:     retVal = new Rectangle(10, 50, 25, 15);
					break;
				case 2:     retVal = new Kite(getRandInt(), getRandInt(), getRandInt(), getRandInt(), Color.pink);
					break;
				case 3:     retVal = new IsoscelesTriangle(getRandInt(), getRandInt(), getRandInt(), getRandInt(), Color.green);
					break;
			}

			return retVal;
		}
	}

}
