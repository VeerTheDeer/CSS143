/**
 * The Driver class contains the main method to execute file searching functionalities.
 * Author: Veer Saini
 */
public class Driver {
    private static final int MAX_NUMBER_OF_FILES_TO_FIND = 10;

    /**
     * The main method to initiate file searching and display the results.
     *
     * @param args Command line arguments (not used in this program).
     */
    public static void main(String args[]) {
        String targetFile = "Driver.java";
        String pathToSearch = "C:\\"; // Example directory path

        FindFile finder = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);

        try {
            finder.directorySearch(targetFile, pathToSearch);
        } catch (IllegalArgumentException e) {
            // Handling exception, if any, occurred during the file search.
        }

        System.out.println(finder.toString()); // Printing the results of the file search
    }
}
