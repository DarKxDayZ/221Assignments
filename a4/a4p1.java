import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a4p1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M=0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        int [][] adj = new int[N][N];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            adj[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = Integer.parseInt(st.nextToken());
        }
        StringBuilder sb = new StringBuilder();

        int rows = adj.length;
        int cols = adj[0].length;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                sb.append(adj[i-1][j-1]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
