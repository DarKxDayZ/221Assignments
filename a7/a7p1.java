import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class a7p1 {
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
        int [] dis = new int[n+1];
        int [] path = new int[n+1];
        boolean[] vis = new boolean[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<int []> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{s,0});
        dis[s]=0;
        while (!q.isEmpty()) {
            int [] curr = q.poll();
            int u = curr[0];
            if (vis[u]) {
                continue;
            }
            vis[u]=true;
            if (u==d) {
                break;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int[] neib = adj[u].get(i);
                int v = neib[0];
                int weig = neib[1];
   
                if (dis[u]+weig<dis[v]) {
                    dis[v]= dis[u]+weig;
                    path[v]=u;
                    q.add(new int[]{v,dis[v]});
                }
                
            }
        }
        if (dis[d]==Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> route = new ArrayList<>();
        int curr = d;
        while (curr!=s) {
            route.add(curr);
            curr = path[curr];
        }
        route.add(s);
        Collections.reverse(route);
        StringBuilder sb = new StringBuilder();
        sb.append(dis[d]).append('\n');
        for (int i = 0; i < route.size(); i++) {
            sb.append(route.get(i)).append(' ');
        }
        System.out.println(sb);
    }
}
