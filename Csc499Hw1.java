import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;

class Csc499Hw1 {
    public static void main(String[] args) {
        File fileIn = new File("resources/Sort Me.txt");
        File fileOut = new File("resources/I'mSorted.txt");
        String toWrite = "";
       
        List<String> linesIn = new ArrayList<String>();
        try { 
            Scanner sc = new Scanner(fileIn);
            while(sc.hasNext()){
                linesIn.add(sc.next());
            }
        } catch (IOException e) {
               e.printStackTrace();     
          }
        
        Collections.sort(linesIn, Comparator.comparing(String::length));

        int listLength = linesIn.size();
        List<String> linesOut = new ArrayList<String>();
        
        for (int i = 0; i < listLength-1; i++) {
            linesOut.add(linesIn.get(i));
            if (linesIn.get(i).length() < linesIn.get(i+1).length()) {
                Collections.sort(linesOut);
                for (String s: linesOut) {
                    toWrite += s+"\r\n";
                }
                linesOut.clear();
            }
        }
        
        linesOut.add(linesIn.get(listLength-1));
        Collections.sort(linesOut);
        
        for (String s: linesOut) {
            toWrite += s+"\r\n";
        }
        
        
        try{ 
            FileWriter fstream = new FileWriter (fileOut);
            BufferedWriter lineWriter = new BufferedWriter(fstream);
            lineWriter.write(toWrite);
            lineWriter.close();
        } catch(Exception e){
          e.printStackTrace();
        }
    }
}
    
