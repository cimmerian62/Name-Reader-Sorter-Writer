import java.util.Collections;
import java.util.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.Scanner;


class readerSorterWriter {
    
    readerSorterWriter() {
        
    }
    
    public ArrayList readLines() {
        File fileIn = new File("resources/Sort Me.txt");   //finds the file to sort from
        
       
        ArrayList<String> linesIn = new ArrayList<String>();
        try { 
            Scanner sc = new Scanner(fileIn);  //names in the file are read in
            while(sc.hasNext()){
                linesIn.add(sc.next());
            }
        } catch (IOException e) {
               e.printStackTrace();     
          }
        return linesIn;
    }
    
    public  String sortLines(ArrayList<String> linesIn) {
        String toWrite = "";
        
        Collections.sort(linesIn, Comparator.comparing(String::length)); //the list is sorted by length

        int listLength = linesIn.size();
        List<String> linesOut = new ArrayList<String>();
        
        for (int i = 0; i < listLength-1; i++) {
            linesOut.add(linesIn.get(i));  //names of the same length are added to the lines out list
            if (linesIn.get(i).length() < linesIn.get(i+1).length()) {
                Collections.sort(linesOut); //linesOut is sorted alphabetically
                for (String s: linesOut) {
                    toWrite += s+"\r\n"; //the names in lines out are put into a string
                }
                linesOut.clear(); //lines out is cleared to allow the next group of names of equal length to be added
            }
        }
        
        linesOut.add(linesIn.get(listLength-1)); //the last group of lines is processes
        Collections.sort(linesOut);
        
        for (String s: linesOut) {
            toWrite += s+"\r\n";
        }
        
        return toWrite;
    }
    public  String sortLinesReverse(ArrayList<String> linesIn) {
        String toWrite = "";
        
        Collections.sort(linesIn, Comparator.comparing(String::length));

        int listLength = linesIn.size();
        List<String> linesOut = new ArrayList<String>();
        
        for (int i = listLength-1; i > 0; i--) { //the list is read backward to get the lngest names first
            linesOut.add(linesIn.get(i));
            if (linesIn.get(i).length() > linesIn.get(i-1).length()) {
                Collections.sort(linesOut);
                Collections.reverse(linesOut); //the list is reversed to get the names sorted in reverse alphabetical order
                for (String s: linesOut) {
                    toWrite += s+"\r\n";
                }
                linesOut.clear();
            }
        }
        
        linesOut.add(linesIn.get(0));
        Collections.sort(linesOut);
        Collections.reverse(linesOut);
        
        for (String s: linesOut) {
            toWrite += s+"\r\n";
        }
        
        return toWrite;
    }
    
    public void writeLines(String toWrite) {
        File fileOut = new File("resources/I'mSorted.txt"); //file path of the file the names will be written to is specified
        
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


class Csc499Hw1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        String res = "";
        readerSorterWriter rsw = new readerSorterWriter();

        System.out.print("Data will be sorted, would you like it sorted in reverse? n or r: ");
        res = in.next().toLowerCase();
        in.nextLine();
        System.out.println();
        
        if (res.equals("r")) 
            rsw.writeLines(rsw.sortLinesReverse(rsw.readLines()));
        else
            rsw.writeLines(rsw.sortLines(rsw.readLines()));
        System.out.println("Data has been sorted");
    }
}
    



