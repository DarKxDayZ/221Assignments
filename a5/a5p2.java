import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class a5p2 {
    public static void main(String[] args) throws IOException{
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

         int[] from = new int[m];
         int[] to = new int[m];
         st  =new StringTokenizer(br.readLine());
         for (int i = 0; i < m; i++) {
            from[i]= Integer.parseInt(st.nextToken());            
         }
         st  =new StringTokenizer(br.readLine());
         for (int i = 0; i < m; i++) {
            to[i]= Integer.parseInt(st.nextToken());            
         }

         for (int i = 0; i < to.length; i++) {
            int u = from[i];
            int v = to[i];
            adj[u].add(v);
            adj[v].add(u);
         }

         Stack<Integer> dfs = new Stack<>();
         dfs.push(1);
         
         while (!dfs.isEmpty()) {
            int u = dfs.pop();
            if (vis[u]==0) {
                vis[u]=1;
                sb.append(u).append(" ");
                for (int i = 0; i < adj[u].size(); i++) {
                    int v = adj[u].get(i);
                    if (vis[v]==0) {
                        dfs.push(v);
                    }
                }
            }

         }
         System.out.println(sb);
    }
}
