import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Gcounting {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int [] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        int[][] query = new int[q][2];
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            query[i][0] = Integer.parseInt(st.nextToken());
            query[i][1] = Integer.parseInt(st.nextToken());                            
        }
        int [] freq = new int[q];
        for (int i = 0; i < freq.length; i++) {
            int x = query[i][0], y = query[i][1];
            int xidx=N, yidx=-1;

            int low = 0 , high = N-1;
            while (low<=high) {
                int mid = (low+high)/2;
                if (arr[mid]>= x) {
                    xidx = mid;
                    high = mid -1;
                }
                else{
                    low = mid+1;
                }
            }
            low = 0; high = N-1;
            while (low<=high) {
                int mid = (low+high+1)/2;
                if (arr[mid]<= y) {
                    yidx = mid;
                    low = mid+1;
                }
                else{
                    high = mid-1;
                }
            }
            if (yidx >= xidx) {
                freq[i] = yidx - xidx + 1;
            } 
            else {
                freq[i] = 0;
            }
        }

        for (int i = 0; i < freq.length; i++) {
            System.out.println(freq[i]);
        }
    }
}
