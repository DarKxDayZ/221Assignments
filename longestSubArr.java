import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class longestSubArr {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int l = 0; int maxL = 0; long sum = 0;

        for (int r = 0; r < N; r++) {
            sum+= arr[r];
            
            while (sum>K) {
                sum-=arr[l];
                l++;
            }

            int currLength = r-l +1;
            if (maxL<currLength) {
                maxL = currLength;
            }
        }

        System.out.println(maxL);
    }
}
