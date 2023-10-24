import java.util.*;
/*
 * InFixCalc, V0.0 (concept borrowed from Carol Zander's Infix Calculator)
 * Exercise author: Rob Nash
 * Complete the calculate() function below to build a simple, infix
 * calculator that evaluates a compound expression from left to right,
 * regardless of operator precedence
 *
 * Example: " 1 * -3 + 6 / 3"
 * Execution: calculate 1 * -3 first, then -3 + 6 next, then 3 / 3
 * last to obtain the value 1
*
* Solution by Veer Saini
*/

public class InFixCalc {
    //example pattern: "3 + 5"
    //general pattern: <lhs='3'> <operation='+'> <rhs='5'> //extended pattern:     ...  
    //special case: 
    //other special cases?

    public static void main(String[] args) { //String input = "4 + 4";
        //String input = "4 + 4 / 2";
        //String input ="1 * -3";
        String input ="1 * -3 + 6 / 3";
        //String input ="5";
        //String input ="-5";
        int answer = calculate(input);
        System.out.println("Answer is " + answer);
    }

    //preconditions: all binary operations are separated via a space
    //postconditions: returns the result of the processed string
    public static int calculate(String input) {
        int lhs = 0; //short for left-hand side
        int rhs = 0; //short for right-hand side
        char operation;

        if(!input.contains(" ")) {
            return Integer.parseInt(input);
        }

        String[] mainArr;
        mainArr = input.split(" ");
        int arrLength = mainArr.length;
        for(int i = 0; i < arrLength + 1; i+=2) {
            if(i+2 > arrLength) {
                return lhs;
            }

            lhs = Integer.parseInt(mainArr[i]);
            rhs = Integer.parseInt(mainArr[i+2]);

            switch (mainArr[i+1]) {
                case "+": lhs += rhs;
                break;
                case "*": lhs *= rhs;
                break;
                case "/": lhs /= rhs;
                break;
                case "-": lhs -= rhs;
                break;
                default: break;
            }

            mainArr[i+2] = "" + lhs;
        }

        /*You need a Scanner(or StringTokenizer) to get tokens
          *Then you need a loop, and switch inside that loop*/
        return lhs;

        /*
         * Unfortunately I tried to use scanner in this way, I've never used scanner to scan through an individual line
         * I've always used scanner to scan whole lines and taking user input. I've found an alternative which
         * would do the same thing.
         */
    }
}
