package tech.codingclub.utility;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

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
    public static ArrayList<String> readfileaslist(String filepath){
        ArrayList<String> list = new ArrayList<String>();
        FileInputStream fstream = null;
        try {
            fstream = new FileInputStream(filepath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

            String strLine;

//Read File Line By Line
            while ((strLine = br.readLine()) != null)   {
                // Print the content on the console - do what you want to do
                list.add(strLine);

            }
            fstream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
//Close the input stream

    }
    public static void readAndPrint(String filename){
        Scanner scanner = null;
        try{
            File file = new File(filename);
            scanner = new Scanner(file);
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if(scanner!=null){
                scanner.close();
            }
        }
    }
    public static void appending(String filename,String content){
        try
        {
            String file= filename;
            FileWriter fw = new FileWriter(file,true); //the true will append the new data
            fw.write(content);//appends the string to the file
            fw.close();
        }
        catch(IOException ioe)
        {
            System.err.println("IOException: " + ioe.getMessage());
        }
    }
    public static void main(String[] args) {
        String nameoffile = "C:\\Users\\ajind\\Downloads\\untitled2\\data\\practice\\file"+"create-file.txt";
        boolean created = createFile(nameoffile);
        System.out.println("file created"+created);
        readAndPrint(nameoffile);
        appending(nameoffile,"myslelf aman");
    }
}
