
public class Driver {
    private static final int MAX_NUMBER_OF_FILES_TO_FIND = 10;

    public static void main(String args[]){
        String targetFile = "Driver.java";
        String pathToSearch ="C:\\";
        FindFile finder = new FindFile(MAX_NUMBER_OF_FILES_TO_FIND);
        try{
            finder.directorySearch(targetFile, pathToSearch);
        }
        catch(IllegalArgumentException e){}
        System.out.println(finder.toString());

    }
}