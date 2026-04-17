import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class a5p1 {
    public static void main(String[] args) throws IOException {
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n,m=0;
         StringTokenizer st = new StringTokenizer(br.readLine());
         StringBuilder sb =  new StringBuilder();
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         int [] vis = new int[n+1];
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
         
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        vis[1]=1;

        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u).append(" ");
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (vis[v]==0) {
                    vis[v]=1;
                    q.add(v);
                }
            }
        }

        System.out.println(sb);
    }
}
