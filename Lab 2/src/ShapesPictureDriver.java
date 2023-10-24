/**
 * Driver for CSS 162 Lab
 *
 * uncomment sections to test Square, Circle, and Picture
 *
 * @author Rob Nash
 */


public class ShapesPictureDriver {


	//precondition: assumes {Square, Circle, Picture} all exist in the same working directory
	//postcondition: 2 Squares, 2 Circles, and 1 Picture are constructed and manipulated, then reclaimed once main exits
	public static void main(String[] args) {

		Square firstSquare = new Square();
		Square secondSquare = new Square(10,20);

		firstSquare.setX(3);
		firstSquare.setY(4);

		System.out.println( "Drawing the first square : " + firstSquare.toString());

		firstSquare.draw();

		secondSquare.setX(30);
		secondSquare.setY(30);
		secondSquare.setSideLength(30);

		System.out.println( "Drawing the next square with area : " + secondSquare.getArea());

		secondSquare.draw();






		//now for some circles
		Circle firstCircle = new Circle();
		Circle secondCircle = new Circle(5,5);

		firstCircle.setX(1);
		firstCircle.setY(5);
		firstCircle.setRadius(3);

		System.out.println( "Drawing the first circle : " + firstCircle.toString());

		firstCircle.draw();

		secondCircle.setX(2);
		secondCircle.setY(10);
		secondCircle.setRadius(6);

		System.out.println( "Drawing the second circle with area " + secondCircle.getArea());

		secondCircle.draw();



		//now, lets see the bigger picture
		ObjectList picture = new ObjectList();

		picture.add(firstSquare);
		picture.add(secondSquare);
		picture.add(firstCircle);
		picture.add(secondCircle);

		System.out.println( "Drawing a Picture using ObjectList with Circles and Squares:\n" );

		System.out.println(picture.toString());


	}

}
