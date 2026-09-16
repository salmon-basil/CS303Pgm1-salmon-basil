
import java.util.Arrays;

public class RadixSort_LLM {

    public static void sort(int[] arr) {

        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }
    private static void countingSort(int[] arr, int exp) {

        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }
        System.arraycopy(output, 0, arr, 0, n);
    }
    private static int getMax(int[] arr) {
        int max = arr[0];

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
    public static void main(String[] args) {

        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("before: " + Arrays.toString(data));

        sort(data);

        System.out.println("after: " + Arrays.toString(data));
    }
}