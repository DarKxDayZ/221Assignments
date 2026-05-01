import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class a7p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
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
        }

        int dis1[] = new int[n+1];
        int dis2[] = new int[n+1];
        Arrays.fill(dis1, Integer.MAX_VALUE);
        Arrays.fill(dis2, Integer.MAX_VALUE);
        
        dis1[s]=0;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        q.add(new int[]{s,0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], dis = curr[1];
            if (dis>dis1[u]) {
                continue;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int[] node = adj[u].get(i);
                int v = node[0], w = node[1];
                if (dis1[u]+w<dis1[v]) {
                    dis1[v]=dis1[u]+w;
                    q.add(new int[]{v,dis1[v]});
                }
            }
        }
        dis2[t]=0;
        q.add(new int[]{t,0});
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int u = curr[0], dis = curr[1];
            if (dis>dis2[u]) {
                continue;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int[] node = adj[u].get(i);
                int v = node[0], w = node[1];
                if (dis2[u]+w<dis2[v]) {
                    dis2[v]=dis2[u]+w;
                    q.add(new int[]{v,dis2[v]});
                }
            }
        }
        int min =Integer.MAX_VALUE; int index =0;
        for (int i = 1; i < n+1; i++) {
            int alice = dis1[i];
            int bob =dis2[i];
            if (alice==Integer.MAX_VALUE || bob==Integer.MAX_VALUE) {
                continue;
            }
            int x = Math.max(alice, bob);
            if (x<min) {
                min = x;
                index=i;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (index==0) {
            sb.append(-1);
        }
        else{
            sb.append(min).append(" ").append(index);
        }
        System.out.println(sb);

    }
}
