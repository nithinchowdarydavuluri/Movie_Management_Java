package org.example.util;

import java.io.*;

public class FileUtil {
    public static void writeToFile(String filePath,String content){
        File file = new File(filePath);

        try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(content);
            System.out.println("File written successfully");

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void readFromFile(String Path){
        File file = new File(Path);
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
        }catch (Exception e){
            System.out.println(e.getMessage());

        }

    }
}
