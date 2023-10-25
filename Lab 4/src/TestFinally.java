import java.io.*;

public class TestFinally {
    public static void main(String[] args) {
        FileInputStream in1 = null;
        FileInputStream in2 = null;

        // Open an existing file trycatch.txt
        File inputFile1 = new File("trycatch.txt");
        // Open a non-existent file nosuchfile.abc
        File inputFile2 = new File("nosuchfile.abc");

        // 1. Add the try statement here
        try {
            // Get file handlers in Byte Stream format
            in1 = new FileInputStream(inputFile1);
            in2 = new FileInputStream(inputFile2);

            int c1;

            // Try to read 'nosuchfile.abc' till the end of File
            while ((c1 = in2.read()) != -1) {
                System.out.println("Read from nosuchfile.abc");
            }
        } catch (IOException e) {
            // 3. Add a catch block containing meaningful error messages.
            System.out.println("The exception is: " + e);
        } finally {
            try {
                // 2. Close the try block here
                if (in1 != null) {
                    in1.close();
                    System.out.println("Closing file 'trycatch.txt' inside finally block.");
                }
            } catch (IOException e) {
                System.out.println("Error while closing 'trycatch.txt': " + e);
            }

            try {
                // Close the files
                if (in2 != null) {
                    in2.close();
                    System.out.println("Closing file 'nosuchfile.abc' inside finally block.");
                }
            } catch (IOException e) {
                System.out.println("Error while closing 'nosuchfile.abc': " + e);
            }
            // 5. Close the final block here.
        }
    }
}
