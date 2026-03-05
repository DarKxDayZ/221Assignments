import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class TwoSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int [] arr = new int[N];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        
        int l =0, r = N-1;
        boolean found = false;

        while (l<r) {
            if ((long)arr[l]+(long)arr[r] == target) {
                found = true;
                break;
            }
            else if ((long)arr[l]+(long)arr[r]< target) {
                l++;
            }
            else{
                r--;
            }
        }
        if (found) {
            System.out.println(l+1 +" "+ (r+1));
        }
        else{
            System.out.println(-1);
        }

    }
}
