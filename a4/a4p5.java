import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class a4p5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M=0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());
        StringTokenizer st2 ;
        int [] in = new int[N+1];
        int [] out = new int[N+1];


        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            out[Integer.parseInt(st1.nextToken())]++;
            in[Integer.parseInt(st2.nextToken())]++;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i = 1; i < in.length; i++) {
            bw.write(in[i]-out[i]+" ");
        }
        bw.flush();
        
    }
}
