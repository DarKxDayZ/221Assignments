import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Ksubarr {
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

        int l = 0; int maxL = 0; int distinct = 0;
        int [] freq = new int[N+1];
        for (int r = 0; r < N; r++) {
           if (freq[arr[r]]==0) {
            distinct++;
           }
           freq[arr[r]]++;
           while (distinct>K) {
            freq[arr[l]]--;
            if (freq[arr[l]] == 0) {
                distinct--;
            }
            l++;
           }
           int currLength = r-l+1;
           maxL = Math.max(maxL, currLength);
        }
        System.out.println(maxL);
    }

}
