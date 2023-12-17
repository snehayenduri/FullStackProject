/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TheBusiness;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author snehayenduri
 */
public class DataReader {
    
    private BufferedReader reader;
    private String[] header;
    
    public DataReader(String fileName) throws FileNotFoundException {
        reader = new BufferedReader(new FileReader(fileName));
//        if(!file.exists())
//            throw new FileNotFoundException("File not found at the path specified: "+fileName);
        
    }
    
    
    public String[] getNextRow(String split) throws IOException{
        if (header == null)
            header = getFileHeader();
        String line = "";
        if((line = reader.readLine()) != null){
//            System.out.println("TheBusiness.DataReader.getNextRow()"+line);
            String[] rows = line.split(split);
//            System.out.println(rows.length);
            return rows;
        }
        return null;
    }
    
    public String[] getFileHeader() throws IOException{
        if(header == null){
            String line = "";
            if((line = reader.readLine()) != null){
                String[] rows = line.split(",");
                header = rows;
            }
        }
        return header;
    }
    
}
