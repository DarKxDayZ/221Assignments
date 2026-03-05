import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TwoSumReload {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int N =0 , M = 0;
       long k = 0;
       N = Integer.parseInt(st.nextToken());
       M = Integer.parseInt(st.nextToken());
       k = Long.parseLong(st.nextToken());
      
       st = new StringTokenizer(br.readLine());
       int [] arr1 = new int[N];
       int idx = 0;
       while (st.hasMoreTokens()) {
        arr1[idx++] = Integer.parseInt(st.nextToken());
       }
       
       st = new StringTokenizer(br.readLine());
       int [] arr2 = new int[M];
       idx = 0;
       while (st.hasMoreTokens()) {
        arr2[idx++] = Integer.parseInt(st.nextToken());
       }
       
       int i = 0 , j = M-1;
       long bestDiff = Long.MAX_VALUE;
       int bestI =-1, bestj = -1;
       while (i<N && j>=0) {
        long sum = (long)arr1[i]+(long)arr2[j];
        long diff = Math.abs(sum-k);
        if (diff<bestDiff) {
            bestDiff = diff;
            bestI = i;
            bestj = j;
        }
        if (sum>k) {
            j--;
        }
        else if (sum<k) {
            i++;
        }
        else if (sum==k){
            break;
        }
       }
       System.out.println((bestI+1)+" "+(bestj+1));
    }
}
