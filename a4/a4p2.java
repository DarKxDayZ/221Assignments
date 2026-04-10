import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

public class a4p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }

        int[] u = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            u[i] = Integer.parseInt(st.nextToken());
        }

        int[] v = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            v[i] = Integer.parseInt(st.nextToken());
        }

        int[] w = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            adj.get(u[i]).add(new int[]{v[i], w[i]});
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i <= N; i++) {
            bw.write(i + ": ");
            
            for (int j = 0; j < adj.get(i).size(); j++) {
                int[] edge = adj.get(i).get(j);
                bw.write("(" + edge[0] + "," + edge[1] + ") ");
            }
            
            bw.newLine();
        }
        bw.flush();
    }
}
