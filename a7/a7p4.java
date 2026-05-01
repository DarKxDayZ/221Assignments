import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;


public class a7p4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i]= new ArrayList<>();
        }
        int [] dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int [] edge_w = new int[n+1];
        st = new StringTokenizer(br.readLine());
        int c=1;
        while (st.hasMoreTokens()) {
            edge_w[c]=Integer.parseInt(st.nextToken());
            c++;
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
        }

        dis[s]=edge_w[s];

        PriorityQueue<int[]> q = new PriorityQueue<>((a,b)->a[1]-b[1]);
        q.add(new int[]{s,edge_w[s]});
        
        while (!q.isEmpty()) {
            int [] curr = q.poll();
            int u = curr[0], weight = curr[1];
            if (weight>dis[u]) {
                continue;
            }
            if (u==d) {
                break;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                int w = edge_w[v];
                if (dis[u]+w<dis[v]) {
                    dis[v]=weight+w;
                    q.add(new int[]{v,dis[v]});
                }
            }
        }
        if (dis[d]==Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else{
            System.out.println(dis[d]);
        }

    }
}
