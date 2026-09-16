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

        // Header
        writer.println("Sort Name\t\tFile\t\tswaps\tcomparison\t\tloops\t\t(timeNano)");
        writer.println("");

        for(String fileName : fileNames){
            SortStats sortStats = new SortStats();
            radixSort.sort(sortStats,fileName);

            writer.println(sortStats.sortName + "\t\t" + sortStats.fileName + "\t" + sortStats.swaps + "\t" + sortStats.comparison + "\t\t`\t" + sortStats.loops + "\t\t" + sortStats.timeNano);
        }
        writer.close();

    }
    
}
