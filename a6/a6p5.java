import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class a6p5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n,m,s,q=0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());
        int[] source = new int[s];
        int[] des = new int[q];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        for (int i = 0; i < adj.length; i++) {
            adj[i]= new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }
        int[] dis = new int[n+1];
        int[] vis = new int[n+1];
        Queue<Integer> que = new LinkedList<>();
        st = new StringTokenizer(br.readLine());
        Arrays.fill(dis, -1);
        for (int i = 0; i < source.length; i++) {
            source[i]=Integer.parseInt(st.nextToken());
            dis[source[i]]=0;
            vis[source[i]]=1;
            que.add(source[i]);
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < des.length; i++) {
            des[i]=Integer.parseInt(st.nextToken());
        }

        while (!que.isEmpty()) {
            int u = que.poll();
            int d = dis[u];
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (vis[v]==0) {
                    vis[v]=1;
                    dis[v]=d+1;
                    que.add(v);
                }
            }
        }
        for (int i = 0; i < des.length; i++) {
            int d = des[i];
            sb.append(dis[d]).append(" ");

        }
        System.out.println(sb);
    }
}
