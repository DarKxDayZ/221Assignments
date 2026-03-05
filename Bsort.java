import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Bsort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr1 = new int[N];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr1[idx++] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr2 = new int[M];
        idx = 0;
        while (st.hasMoreTokens()) {
            arr2[idx++] = Integer.parseInt(st.nextToken());
        }

        int[] finalarr = new int[N+M];
        int i = 0 ,j = 0, k = 0;
        while(j<N && k<M) {
            if (arr1[j]<arr2[k]) {
                finalarr[i++] =arr1[j++];
            }
            else{
                finalarr[i++] =arr2[k++];
            }
        }
        while (j < N) {
            finalarr[i++] = arr1[j++];
        }
        while (k < M) {
            finalarr[i++] = arr2[k++];
        }

        StringBuilder sb = new StringBuilder();
        for(int val : finalarr) {
            sb.append(val).append(" ");
        }
        System.out.println(sb);
    }
}
