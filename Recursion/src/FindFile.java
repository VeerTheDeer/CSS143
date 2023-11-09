import java.io.File;

/**
 * The FindFile class provides functionality to search for specific files within directories.
 * Author: Veer Saini
 */
public class FindFile {
    private int maxNumFiles;
    private String[] files;
    private int count = 0;

    /**
     * Constructor to initialize the FindFile object with a maximum number of files to search for.
     *
     * @param maxFiles The maximum number of files to search within directories.
     */
    public FindFile(int maxFiles) {
        this.maxNumFiles = maxFiles;
        this.files = new String[this.maxNumFiles];
    }

    /**
     * Recursively searches for a target file within the specified directory.
     *
     * @param targetFile    The file name to be found.
     * @param pathToSearch  The directory path where the search is performed.
     * @throws IllegalArgumentException If the maximum number of files to search is reached or if the path is invalid.
     */
    public void directorySearch(String targetFile, String pathToSearch) throws IllegalArgumentException {
        isValid(pathToSearch);
        File[] tempFiles = new File(pathToSearch).listFiles();

        try {
            for (File tempFile : tempFiles) {
                if (this.count == this.maxNumFiles) {
                    throw new IllegalArgumentException("Maximum number of files reached.");
                }

                if (tempFile.getName().equals(targetFile)) {
                    this.files[count] = tempFile.getAbsolutePath();
                    this.count++;
                } else if (tempFile.isDirectory()) {
                    directorySearch(targetFile, tempFile.getAbsolutePath());
                }
            }
        } catch (Exception ignored) {
            // Catching exceptions if encountered during the search.
        }
    }

    /**
     * Retrieves the count of files found during the directory search.
     *
     * @return The count of files found.
     */
    public int getCount() {
        return this.count;
    }

    /**
     * Retrieves the array of files found during the directory search.
     *
     * @return The array containing the paths of found files.
     */
    public String[] getFiles() {
        return this.files;
    }

    /**
     * Checks if the provided path is a valid directory.
     *
     * @param path The directory path to be validated.
     */
    public void isValid(String path) {
        File check = new File(path);
        if (!check.exists() || !check.isDirectory()) {
            System.out.println(path + " is not a valid directory.");
            System.exit(0);
        }
    }
}
