import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;

public class h {
    public static int[] in;
    public static int[] po;
    public static int postx; 
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        in = new int[n];
        po = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            in[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            po[i] = Integer.parseInt(st.nextToken());
        }

        postx = n - 1; 
        buildPreorder(0, n-1);

        bw.newLine();
        bw.flush();
    }

    public static void buildPreorder(int l, int r) throws IOException {
        if(l > r) return;

        int root = po[postx--]; 
       
        int x = l;
        while(x <= r && in[x] != root){
            x++;
        }

        buildPreorder(x+1, r);
        buildPreorder(l, x-1);
        bw.write(root + " ");
    }
}