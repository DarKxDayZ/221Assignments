import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2 {
    static long count = 0;

    static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        for (int j = 0; j < right.length; j++) {
            long sq = (long) right[j] * right[j];
            int lo = 0, hi = left.length;
            while (lo < hi) {
                int mid2 = (lo + hi) / 2;
                if (left[mid2] <= sq){
                    lo = mid2 + 1;
                } 
                else{
                    hi = mid2;
                } 
            }
            count += (left.length - lo);
        }

        return merge(left, right);
    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            }
            else{
                result[k++] = right[j++];
            } 
        }
        while (i < left.length){
            result[k++] = left[i++];
        } 
        while (j < right.length){
            result[k++] = right[j++];
        } 
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx]= Integer.parseInt(st.nextToken());
            idx++;
        }

        mergeSort(arr);
        System.out.println(count);
    }
}
