/**
 * FileSearch is a class that provides functionality to search for a file within a directory and its subdirectories.
 * Author: Veer Saini
 */
import java.io.File;

public class FileSearch {

    /**
     * The main method that initiates the file search operation based on the provided directory and file name.
     *
     * @param args Command-line arguments: directory_path and file_name.
     */
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java FileSearch <directory_path> <file_name>");
            return;
        }

        String directoryPath = args[0];
        String fileName = args[1];

        File directory = new File(directoryPath);
        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        String result = searchFiles(directory, fileName);
        System.out.println(result);
    }

    /**
     * Recursively searches for a file within the given directory and its subdirectories.
     *
     * @param directory The directory to search for the file.
     * @param fileName  The name of the file to be found.
     * @return The absolute path of the file if found, else returns "File not found".
     */
    private static String searchFiles(File directory, String fileName) {
        if (directory.list() == null) {
            return "File not found";
        }

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                String result = searchFiles(file, fileName);
                if (!result.equals("File not found")) {
                    return result;
                }
            } else if (file.getName().equals(fileName)) {
                return file.getAbsolutePath();
            }
        }

        return "File not found";
    }
}
