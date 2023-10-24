public class Car {
    private int odometer;
    private int year;
    private String make;
    private String model;

    public Car(int odometer, int year, String make, String model) {
        this.odometer = odometer;
        this.year = year;
        this.make = make;
        this.model = model;
    }

    public Car(String make) {
        this.make = make;
    }

    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }

    /* 6. Overriding toString() (and equals())
     * this is the toString method for my Car class
     * this method is currently commented out becuase it would interfere with previous questions
     * Example Output: This is a 2020 BMW M4 Competition with 0 miles on it.
     */

    /*
    public String toString() {
        return "This is a " + this.year + " " + this.make + " " + this.model + " with " + this.odometer + " miles on it.";
    }
    */

    public void printMemoryAddress() {
        System.out.println(this.toString());
    }

    /*
     * 2. Variable Scope in Java: Local and Class level
     * This is me trying to attempt accessing a local variable from a method from which it was not instantiated from.
     * this method is later called in the main method at the end in which it explains that these cars are all from the 2000s century
     */
    public int getCentury() {
        int i = 2000;
        return i;
    }

    /*
     * 2. Variable Scope in Java: Local and Class level
     * This is completing the part where in the problem it asks me to prove
     * to myself that I can access a class level variable.
     * this method can be used with any object and will allow the user to find what model that car will be.
     */
    public String getModel() {
        return this.model;
    }

    public static void main(String[] args) {
        Car car1 = new Car(0, 2020, "BMW", "M4 Competition");
        Car car2 = new Car(1500, 2021, "Honda", "Accord");

        System.out.println();
        System.out.println(car1.toString());
        System.out.println(car2.toString());
        car1.printMemoryAddress();
        car2.printMemoryAddress();
        System.out.println("These cars were made in the " + car1.getCentury() + "'s.");

        /*
         * 3. This (the Implicit Parameter)
         * to answer number 3, these two calls above (lines 64-67) are displaying the same address because they are essentially the same thing
         * one of them is a toString that is being called in the main method and the other one is being called in a specifically made method
         * in essence they are the same code just written in two different ways
         */

        Car car3 = new Car("Ferrari");
        Car car4 = new Car("Lamborghini", "Centenario");

        /* 8. Constructors as Methods
         * Here are two constructors with different parameters being used with 2 new objects car3 and car4
         * one of them is able to just declare the make and the other is just able to declare a make and a model
         */

    }
}