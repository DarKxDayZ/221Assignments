import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.Queue;


public class a7p5 {
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
        int [] from = new int[m];
        int [] to = new int[m];
        int [] weight = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weight.length; i++) {
            from[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weight.length; i++) {
            to[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < weight.length; i++) {
            weight[i]=Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < weight.length; i++) {
            int f=from[i];
            int t=to[i];
            int w=weight[i];
            adj[f].add(new int[]{t,w});
        }

        int [][] dis = new int[n+1][2];
        for (int i = 1; i < dis.length; i++) {
            dis[i][0]=Integer.MAX_VALUE;
            dis[i][1]=Integer.MAX_VALUE;
        }
        Queue<int []> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        dis[1][0]=0;
        dis[1][1]=0;
        q.add(new int[]{1,0,0});
        q.add(new int[]{1,0,1});
        while (!q.isEmpty()) {
            int [] curr = q.poll();
            int u = curr[0];
            int W = curr[1];
            int pair = curr[2];
            if (W>dis[u][pair]) {
                continue;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int [] node = adj[u].get(i);
                int v = node[0], cost = node[1];
                int newpair = cost %2;
                if (newpair==pair) {
                    continue;
                }
                int sum = dis[u][pair]+cost;
                if (sum<dis[v][newpair]) {
                    dis[v][newpair]=sum;
                    q.add(new int[]{v,sum,newpair});
                }
            }

        }
        int result = Math.min(dis[n][0], dis[n][1]);
        if (result==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
    }
}
