
import java.util.Arrays;

public class RadixSort_LLM {

    // Radix Sort本体
    public static void sort(int[] arr) {

        // 配列の最大値を取得
        int max = getMax(arr);

        // 桁ごとにソート
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    // 指定された桁でCounting Sortを行う
    private static void countingSort(int[] arr, int exp) {

        int n = arr.length;
        int[] output = new int[n];
        int[] count = new int[10];

        // 指定された桁の数字を数える
        for (int i = 0; i < n; i++) {
            int digit = (arr[i] / exp) % 10;
            count[digit]++;
        }

        // 累積カウントを作成
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // 後ろから取り出して安定ソート
        for (int i = n - 1; i >= 0; i--) {
            int digit = (arr[i] / exp) % 10;
            output[count[digit] - 1] = arr[i];
            count[digit]--;
        }

        // 元の配列に戻す
        System.arraycopy(output, 0, arr, 0, n);
    }

    // 最大値を取得
    private static int getMax(int[] arr) {
        int max = arr[0];

        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }

    // 動作確認
    public static void main(String[] args) {

        int[] data = {170, 45, 75, 90, 802, 24, 2, 66};

        System.out.println("ソート前: " + Arrays.toString(data));

        sort(data);

        System.out.println("ソート後: " + Arrays.toString(data));
    }
}