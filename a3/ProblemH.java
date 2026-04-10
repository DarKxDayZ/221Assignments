import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class ProblemH {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int idx=0;
        int[] in = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            in[idx++] = Integer.parseInt(st.nextToken());
        }
        idx = 0;
        st = new StringTokenizer(br.readLine());
        int [] post = new int[n];
        while (st.hasMoreTokens()) {
            post[idx++]=Integer.parseInt(st.nextToken());
        }
        
        Post(in, post, 0, n-1, 0, n-1);

       
        bw.flush();

    }
    public static int findIndex(int[] arr, int target,int inStart, int inEnd) {
        for (int i = inStart; i < inEnd+1; i++) {
            if (arr[i] == target) {
                return i; 
            }
        }
        return -1;
    }
    static void Post(int[] in,int[] post,int inS,int inE,int postS,int postE) throws IOException{

        if (inS>inE) {
            return;
        }
        int root = post[postE];

        int root_in = findIndex(in, root, inS, inE);
        int leftsize = root_in - inS;
        
        bw.write(root+" ");

        Post(in, post, inS, root_in-1, postS, postS+leftsize-1);
        Post(in, post, root_in+1, inE, postS+leftsize, postE-1);

    }
}
