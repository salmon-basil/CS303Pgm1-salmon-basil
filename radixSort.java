import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class radixSort{

    //PRE:
    // sortStats is a non-null SortStats instance; 
    // fileName:names a readable file
    // containing comma-separated non-negative integers with at most 4 digits each

    //POST:
    // returns the integers from the file as Strings in ascending order; sortStats is
    // updated with sortName, fileName, comparisons, swaps, loops, and timeNano for the sort

    public static ArrayList<String> sort(SortStats sortStats,String fileName)
            throws FileNotFoundException{


        //read file
        ArrayList<String> list = new ArrayList<String>();

        Scanner scanner = new Scanner(new File(fileName));
        scanner.useDelimiter("[,\\s]+");

        while (scanner.hasNextInt()){
            String number = scanner.next();
            list.add(number);
        }

        scanner.close();

        sortStats.sortName = "Radix Sort";
        sortStats.fileName = fileName;

        long startTime = System.nanoTime();

        for(int digits = 4;digits >= 1;digits--){

            int num_of_researched = 0;
            sortStats.loops++;

            for(int reserch_number = 0;reserch_number <= 9;reserch_number++){
                sortStats.loops++;

                for(int i = num_of_researched;i < list.size();i++){
                    sortStats.loops++;

                    //Swap the investigated number with the next number of last number in investigated
                    int digit_index = list.get(i).length() - 5 + digits;
                    char digit_char = digit_index < 0 ? '0' : list.get(i).charAt(digit_index);
                    sortStats.comparison++;
                    if(digit_char == Character.forDigit(reserch_number, 10)){
                        String value = list.remove(i);
                        list.add(num_of_researched, value);
                        num_of_researched++;
                        sortStats.swaps++;
                    }
                }
            }
        }

        sortStats.timeNano = System.nanoTime() - startTime;

    return list;
    }


}
/* 
References

[1] Motisan. "Radix Sort Algorithm Explanation."
    https://motisan.info/it-word/radix-sort/
    Accessed September 15, 2026.

[2] Anthropic. "Claude Code AI Assistant Documentation."
    https://claude.ai/code
    Used for file I/O implementation (reading from file with Scanner and
    useDelimiter, writing to output file with PrintWriter).
    Accessed September 2026.

    */


