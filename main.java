import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class main {
    // PRE: data1.txt, data2.txt, and data3.txt exist in the working directory and contain
    //      comma-separated non-negative integers
    // POST: output.txt is created (overwritten) containing the SortStats results
    //       (sortName, fileName, comparisons, swaps, loops, timeNano) for each of the three files
    public static void main(String[] args) throws FileNotFoundException {



        String[] fileNames = {"data1.txt", "data2.txt", "data3.txt"};

        PrintWriter writer = new PrintWriter("output.txt");
        for(String fileName : fileNames){
            SortStats SS = new SortStats();
            ArrayList<String> a = radixSort.sort(SS,fileName);

            writer.println("sortName=" + SS.sortName);
            writer.println("fileName=" + SS.fileName);
            writer.println("comparison=" + SS.comparison);
            writer.println("swaps=" + SS.swaps);
            writer.println("loops=" + SS.loops);
            writer.println("timeNano=" + SS.timeNano);
            writer.println();
        }
        writer.close();

    }
    
}
