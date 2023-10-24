public class Driver {
    public static void main(String[] args) {
        Point square = new Point(4, "Square");

        System.out.println(square.getSides());
        //System.out.println(square.setSides());

        /*
         *
         * /Users/veers/IdeaProjects/Access Modifiers/src/Driver.java:6:34
         *  java: method setSides in class Point cannot be applied to given types;
         *  required: int
         *  found:    no arguments
         *  reason: actual and formal argument lists differ in length
         *
         * the java program wasn't able to run because the class that I
         *  was calling was a private method that is exclusive and can only be called from the class that it was instantiated from
         */

        System.out.println(square.name);
        //System.out.println(square.sides);

        /*
         * /Users/veers/IdeaProjects/Access Modifiers/src/Driver.java:20:34
         *  java: sides has private access in Point
         *
         * The java program wasn't able to run because of the variable being private meaning that it could not be accessed
         * however the public variable returned a null, which means that you need to use a getter/setter anyway for this to work successfully
         */
    }
}
