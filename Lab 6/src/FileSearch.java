import java.io.File;

public class FileSearch {

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
