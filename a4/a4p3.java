import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;


public class a4p3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] adj = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            for (int j = 0; j < t; j++) {
                adj[i][Integer.parseInt(st.nextToken())] = 1;
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int rows = adj.length;
        int cols = adj[0].length;

        for (int i = 0; i <rows; i++) {
            for (int j = 0; j <cols; j++) {
                bw.write(adj[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
    }
}
