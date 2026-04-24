import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;


public class a6p4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i]= new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }
        int[] vis = new int[n+1];
        int[] dis = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1]=1;
        dis[1]=0;
        while (!q.isEmpty()) {
            int u = q.poll();
            int d = dis[u];
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (vis[v]==0) {
                    vis[v]=1;
                    dis[v]=d+1;
                    q.add(v);
                }
            }
        }
        int idx=0;
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < dis.length; i++) {
            if (dis[i]>max) {
                idx=i;
                max=dis[i];
            }
        }
        int[] vis2 = new int[n+1];
        int[] dis2 = new int[n+1];
        q.add(idx);
        vis2[idx]=1;
        dis2[idx]=0;
        while (!q.isEmpty()) {
            int u = q.poll();
            int d = dis2[u];
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (vis2[v]==0) {
                    vis2[v]=1;
                    dis2[v]=d+1;
                    q.add(v);
                }
            }
        }
        int idx2=0;
        max = Integer.MIN_VALUE;
        for (int i = 1; i < dis2.length; i++) {
            if (dis2[i]>max) {
                idx2 =i;
                max = dis2[i];
            }
        }
        sb.append(max).append("\n").append(idx+" "+idx2);
        System.out.println(sb);
    }
}
