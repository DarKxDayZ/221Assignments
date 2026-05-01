import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Queue;

public class a7p3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        @SuppressWarnings("unchecked")
        ArrayList<int[]>[] adj = new ArrayList[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i]= new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adj[from].add(new int[]{to,weight});
            adj[to].add(new int[]{from,weight});
        }

        int [] d_level = new int[n+1];
        Arrays.fill(d_level, Integer.MAX_VALUE);
        d_level[1]=0;
        Queue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{1,0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], dis = curr[1];
            if (dis>d_level[u]) {
                continue;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int[] node = adj[u].get(i);
                int v = node[0], w = node[1];
                if (Math.max(d_level[u], w)<d_level[v]) {
                    d_level[v]= Math.max(d_level[u], w);
                    q.add(new int[]{v,d_level[v]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < d_level.length; i++) {
            if (d_level[i]==Integer.MAX_VALUE) {
                sb.append(-1).append(" ");
            }
            else{
                sb.append(d_level[i]).append(" ");
            }
        }
        System.out.println(sb);       
    }
}
