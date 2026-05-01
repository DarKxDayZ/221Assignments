import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Queue;

public class a7p6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
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
        int[][] dis = new int[n+1][2];
        for (int i = 0; i < dis.length; i++) {
            dis[i][0]=Integer.MAX_VALUE;
            dis[i][1]=Integer.MAX_VALUE;
        }
        int[] count = new int[n+1];
        dis[s][0]=0;
        Queue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{s,0});
        while (!q.isEmpty()) {
            int [] curr = q.poll();
            int u = curr[0], w = curr[1];
            count[u]++;
            if (count[u]>2) {
                continue;
            }
            if (u==d && count[u]==2) {
                break;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int[] node = adj[u].get(i);
                int v = node[0],cost = node[1];
                int sum = cost+w;
                if (sum<dis[v][0]) {
                    dis[v][1]=dis[v][0];
                    dis[v][0]=sum;
                    q.add(new int[]{v,sum});
                }
                else if (sum<dis[v][1]) {
                    dis[v][1]=sum;
                    q.add(new int[]{v,sum});
                }
            }
        }
        int result = dis[d][1];
        if (result==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
    }
}
