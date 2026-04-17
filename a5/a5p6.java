import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class a5p6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] adj = new ArrayList[n+1];
        int[] subtreeS = new int[n + 1];
        int[] parent = new int[n + 1];
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

        Stack<int[]> s = new Stack<>();
        ArrayList<Integer> dfs = new ArrayList<>();
        s.push(new int[]{r,0});
        parent[r]=-1;

        while (!s.isEmpty()) {
            int[] curr = s.pop();
            int node = curr[0];
            int par = curr[1];

            parent[node]=par;
            dfs.add(node);
            subtreeS[node]=1;
            for (int i = 0; i < adj[node].size(); i++) {
                int child = adj[node].get(i);
                if (child == par) {
                    continue;
                }
                s.push(new int[]{child, node});
            }
        }

        Collections.reverse(dfs);

        for (int i = 0; i < dfs.size(); i++) {
            int node = dfs.get(i);
            int par = parent[node];
            if (par!=-1) {
                subtreeS[par]+=subtreeS[node];
            }
        }
        st = new StringTokenizer(br.readLine());
        int q = Integer.parseInt(st.nextToken());

        while (q-->0) {
            st = new StringTokenizer(br.readLine());
            sb.append(subtreeS[Integer.parseInt(st.nextToken())]).append("\n");
        }
        System.out.println(sb);

    }
}
