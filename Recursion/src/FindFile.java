import java.io.*;

public class FindFile{
    private int maxNumFiles;
    private String[] files;
    private int count = 0;


    public FindFile(int maxFiles){
        this.maxNumFiles = maxFiles;
        this.files = new String[this.maxNumFiles];
    }

    public void directorySearch(String targetFile, String pathToSearch) throws IllegalArgumentException {
        isValid(pathToSearch);
        File[] tempFiles = new File(pathToSearch).listFiles();

        try{
            for(File tempFile : tempFiles) {
                if(this.count == this.maxNumFiles) {
                    throw new IllegalArgumentException();
                }

                if(tempFile.getName().equals(targetFile)) {
                    this.files[count] = tempFile.getAbsolutePath();
                    this.count++;
                } else if(tempFile.isDirectory()) {
                    directorySearch(targetFile, tempFile.getAbsolutePath());
                }

            }
        }
        catch(Exception ignored){

        }
    }

    public int getCount(){
        return this.count;
    }

    public String[] getFiles(){
        return this.files;
    }

    public void isValid(String path){
        File check = new File(path);
        if(!check.exists()){
            System.out.println(path + " is not a valid directory.");
            System.exit(0);
        }
    }
}