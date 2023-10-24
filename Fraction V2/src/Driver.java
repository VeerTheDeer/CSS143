/**
 * The Driver class calls Fraction, FractionCounter, ObjectList, and Scanner classes
 * First the class scans through Fractions.txt, creating a new fraction object per
 * line scanned and then storing in an ObjectList object. At the same time we check
 * for edge cases
 *
 * Then we iterate through the fraction object and compare with a new ObjectList
 * called fractionCounterObjList to check for duplicates
 * when a duplicate is not found, the fraction is added into
 * fractionCounterObjList
 * in the case a duplicate is found the counter in fractionCounterObjList
 * associated with the FractionCounter object, increases by 1 when we call
 * the compareAndIncrement method. Finally we print each unique fraction
 * stores within fractionCounterObjList and the associated count.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Driver {
    /**
     * This is the main method
     * in here all the computation occur here
     *
     */
    public static void main(String[] args) {
        Scanner fileScanner = null;

        ObjectList fractionObjList = new ObjectList();
        ObjectList fractionCounterObjList = new ObjectList();
        int numLines = 0;

        try {
            fileScanner = new Scanner(new BufferedReader(new FileReader("fractions.txt")));
            while (fileScanner.hasNextLine()) {
                String tempFraction = fileScanner.nextLine();
                String[] parts = tempFraction.split("/");
                double numerator = Double.parseDouble(parts[0]);
                double denominator = Double.parseDouble(parts[1]);
                if(denominator == 0) {
                    System.out.println("You Cannot Divide by Zero!");
                } else if (denominator < 0 && numerator < 0) {
                    fractionObjList.add(new Fraction(numerator, denominator));
                    numLines++;
                } else if(denominator < 0 || numerator < 0) {
                    System.out.println("You cannot have a negative fraction!");

                } else {
                    fractionObjList.add(new Fraction(numerator, denominator));
                    numLines++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }

        for (int i = 0; i < numLines; i++) {
            boolean isDuplicate = false;
            Fraction currentFraction = fractionObjList.getFraction(i);

            for (int x = 0; x < numLines; x++) {
                FractionCounter fractionCounter = fractionCounterObjList.getFractionCounter(x);
                if (fractionCounter != null) {
                    isDuplicate = isDuplicate || fractionCounter.compareAndIncrement(currentFraction);
                }
            }

            if (!isDuplicate) {
                Fraction newFraction = fractionObjList.getFraction(i);
                fractionCounterObjList.add(new FractionCounter(newFraction));
            }
        }

        for (int i = 0; i < fractionCounterObjList.getLength(); i++) {
            System.out.println(fractionCounterObjList.getFractionCounter(i));
        }
    }
}
