import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a5p3 {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n,m,s,d=0;
         StringTokenizer st = new StringTokenizer(br.readLine());
         StringBuilder sb =  new StringBuilder();
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         s = Integer.parseInt(st.nextToken());
         d = Integer.parseInt(st.nextToken());
         int [] vis = new int[n+1];
         int [] path = new int[n+1];
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

         for (int i = 0; i < adj.length; i++) {
            Collections.sort(adj[i]);
         }

         Queue<Integer> q = new LinkedList<>();
         q.add(s);
         vis[s]=1;
         path[s]=-1;

         while (!q.isEmpty()) {
            int u = q.poll();

            if (u == d) {
                break;
            }

            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (vis[v]==0) {
                    path[v]=u;
                    vis[v]=1;
                    q.add(v);
                }
            }
        }

        boolean exist = false;
        int curr =d;
        int length=0;
        ArrayList<Integer> res = new ArrayList<>();

        for (int i = 0; i < path.length; i++) {
            if (path[curr]==-1) {
                res.add(curr);                
                exist=true;
                break;
            }
            res.add(curr);                
            length++;
            curr = path[curr];
        }

        if (exist) {
            Collections.reverse(res);
            for (int i = 0; i < res.size(); i++) {
                sb.append(res.get(i)).append(" ");
                
            }
            System.out.println(length);
            System.out.println(sb);
        }
        else{
            System.out.println(-1);
        }

    }
}
