package org.example.util;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.example.Model.Movie;

import java.io.*;
import java.util.List;

public class CSVUtil {
    public static void writeMovies(List<Movie> movies, String Path){
        File file = new File(Path);
        try(CSVWriter cw = new CSVWriter(new FileWriter(file))){
            String[] header = {"id","name","genre","price"};
            cw.writeNext(header);
            for(Movie mov:movies){
                String[] data = {
                        String.valueOf(mov.getId()),
                        mov.getName(),
                        mov.getGenre(),
                        String.valueOf(mov.getPrice())
                };
                cw.writeNext(data);
            }
        }catch (IOException e){
            System.out.println(e.getMessage());

        }
    }
    public static  void ReadMoviesCSV(String Path){
        File file = new File(Path);
        try(CSVReader cr = new CSVReader(new FileReader(file))){
            String[] str;
            while((str = cr.readNext())!=null){
                for(String st : str){
                    System.out.print(st+" ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
