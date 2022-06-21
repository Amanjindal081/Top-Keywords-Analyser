package utility;

import java.io.File;
import java.io.IOException;

public class FileUtility {
    public static boolean createFile(String filenamewithpath){
        File file = new File(filenamewithpath);
        boolean filecreated=false;
        try {
            filecreated = file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filecreated;


    }

    public static void main(String[] args) {
        String nameoffile = "C:\\Users\\ajind\\Downloads\\untitled2\\data\\practice\\file"+"create-file.txt";
        boolean created = createFile(nameoffile);
        System.out.println("file created"+created);
    }
}
