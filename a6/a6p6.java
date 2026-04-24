import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class a6p6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int S = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[] forbidden = new boolean[10000];
        boolean[] visited   = new boolean[10000];

        int n = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < n; i++)
            forbidden[Integer.parseInt(br.readLine().trim())] = true;

        // BFS
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{S, 0});
        visited[S] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int combo = curr[0], dist = curr[1];

            if (combo == C) { System.out.println(dist); return; }

            // extract 4 digits
            int[] d = new int[4];
            d[0] = combo / 1000;
            d[1] = (combo / 100) % 10;
            d[2] = (combo / 10)  % 10;
            d[3] = combo % 10;

            // try all 8 neighbors (4 wheels x 2 directions)
            for (int i = 0; i < 4; i++) {
                int original = d[i];

                // try +1 and -1 on wheel i
                int[] turns = {(original + 1) % 10, (original + 9) % 10};

                for (int t = 0; t < 2; t++) {
                    d[i] = turns[t];
                    int next = d[0]*1000 + d[1]*100 + d[2]*10 + d[3];
                    if (!visited[next] && !forbidden[next]) {
                        visited[next] = true;
                        q.add(new int[]{next, dist + 1});
                    }
                }
                d[i] = original; // restore
            }
        }

        System.out.println(-1);
    }
}