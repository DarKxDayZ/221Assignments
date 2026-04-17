import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class a5p7 {
    public static void main(String[] args) throws IOException{
         BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         int n,m=0;
         StringTokenizer st = new StringTokenizer(br.readLine());
         n = Integer.parseInt(st.nextToken());
         m = Integer.parseInt(st.nextToken());
         int [] inDeg = new int[n+1];
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
            inDeg[to]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < inDeg.length; i++) {
            if (inDeg[i]==0) {
                q.add(i);
            }
        }
        int c = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            c++;
            for (int i = 0; i < adj[u].size(); i++) {
                int v=adj[u].get(i);
                inDeg[v]--;
                if (inDeg[v]==0) {
                    q.add(v);
                }
            }
        }
        if (c<n) {
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
