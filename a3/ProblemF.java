import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class ProblemF {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int idx=0;
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());   
        }

        TreePrint(arr, 0, arr.length-1);
        bw.flush();
    }

    static void TreePrint(int[] arr,int l,int r) throws IOException{
        if (l>r) {
            return;
        }
        int mid = (l+r)/2;
        bw.write(arr[mid] + " ");
        TreePrint(arr, l, mid-1);
        TreePrint(arr, mid+1, r);
        
    }
}
