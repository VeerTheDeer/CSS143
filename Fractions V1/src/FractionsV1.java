import java.util.*;
import java.io.*;

/**
 * A program that analyzes fractions from a file, counts their unique occurrences, and prints the results.
 * By: Veer Saini
 * Due: October 4, 2023
 */
public class FractionsV1 {

    /**
     * The main entry point of the program.
     */
    public static void main(String[] args) {
        Scanner fileScanner = null;
        int fileLineCount = 0;

        // Step 1: Count the number of lines in the file
        try {
            fileScanner = new Scanner(new FileInputStream("fractions.txt"));
            while (fileScanner.hasNextLine()) {
                fileLineCount++;
                fileScanner.nextLine();
            }
        } catch (IOException e) {
            handleFileNotFoundError();
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }

        int[] numeratorArray = new int[fileLineCount];
        int[] denominatorArray = new int[fileLineCount];
        int[] countArray = new int[fileLineCount];
        int uniqueFractionCount = 0;

        // Step 2: Read fractions from the file and analyze
        try {
            fileScanner = new Scanner(new FileInputStream("fractions.txt"));
            while (fileScanner.hasNextLine()) {
                String tempFraction = fileScanner.nextLine();
                String[] parts = tempFraction.split("/");
                int tempNumerator = Integer.parseInt(parts[0]);
                int tempDenominator = Integer.parseInt(parts[1]);
                boolean fInArray = false;

                // Check if the fraction is already in the arrays
                for (int i = 0; i < uniqueFractionCount; i++) {
                    if (areFractionsEqual(tempNumerator, tempDenominator,
                            numeratorArray[i], denominatorArray[i])) {
                        countArray[i]++;
                        fInArray = true;
                        break;
                    }
                }

                // If not found, add it to the arrays
                if (!fInArray) {
                    numeratorArray[uniqueFractionCount] = tempNumerator;
                    denominatorArray[uniqueFractionCount] = tempDenominator;
                    countArray[uniqueFractionCount] = 1;
                    uniqueFractionCount++;
                }
            }
        } catch (IOException e) {
            handleFileNotFoundError();
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }

        // Step 3: Print the results
        for (int i = 0; i < uniqueFractionCount; i++) {
            if (denominatorArray[i] != 0) {
                System.out.println(
                        numeratorArray[i] + "/" + denominatorArray[i] +
                                " has a count of " + countArray[i]);
            }
        }
    }

    /**
     * Checks if two fractions are equal.
     *
     * @param numerator1   The numerator of the first fraction.
     * @param denominator1 The denominator of the first fraction.
     * @param numerator2   The numerator of the second fraction.
     * @param denominator2 The denominator of the second fraction.
     * @return True if the fractions are equal, false otherwise.
     */
    public static boolean areFractionsEqual(int numerator1, int denominator1,
                                            int numerator2, int denominator2) {
        if (denominator2 == 0 || denominator1 == 0) {
            return false;
        }
        return numerator1 * denominator2 == numerator2 * denominator1;
    }

    /**
     * Handles a file not found error by displaying an error message and exiting.
     */
    public static void handleFileNotFoundError() {
        System.out.println("Error: File not found.");
        System.exit(0);
    }

    /*
     * Questions
     * Answer the following questions using multi-line comments in your code:
     *
     * 1. Can you complete this without using arrays? What is the least
     *    number of variables you can use to solve this problem?
     *
     * 2. Can you use just one array to solve this? What would the data
     *    type be of that array?
     *
     * 3. What does it mean to make a class so another class is inside
     *    (or part of) the first class, so that it is composed of other
     *    data types?  What does "composition" mean in that case?
     *    How is it done?
     *
     * 4. What are some solutions to the reduction problem other
     *    than Euclid's GCD (greatest common divisor) algorithm?
     *    (You may want to look up GCD online.)
     *
     * Answers
     *
     * 1. You can complete this without using arrays. For example a hashmap
     *    would an amazing way to complete this question. I think that you
     *    only need around 1 or 2 variable that are outside any method to
     *    store things like the amount of lines in the file and also the
     *    amount of unique fractions
     *
     * 2. I think that there is a way to this in one array, but that would
     *    be extremely difficult. You would need multiple variables to compare
     *    all the indexes with each other. In this case the data type would
     *    have to be String because it is versatile. You can turn String
     *    into an integer and then into a double
     *
     * 3. A great example of this is the linked list datatype. In high school
     *    we learned to make linked lists with nodes. That Node would be its own
     *    private class inside the linked list class. This means we made a
     *    datatype called Node, inside the class of linked list. The specific
     *    term of this action is a nested class.
     *
     * 4.
     *    1. Modulo Operator (%): Use the modulo operator (%) in most
     *       programming languages. It returns the remainder when dividing
     *       one integer by another.
     *
     *    2. Repeated Subtraction: Repeatedly subtract the divisor from
     *       the dividend until the dividend becomes less than the divisor.
     *       The value of the dividend at that point is the remainder.
     */
}
