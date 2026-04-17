import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class a5p4 {
    public static void main(String[] args) throws IOException {
        int n,m,s,d,k=0;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        int [] vis1 = new int[n+1];
        int [] vis2 = new int[n+1];
        int [] path1 = new int[n+1];
        int [] path2 = new int[n+1];
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
        }

        Queue<Integer> q1 = new LinkedList<>();
        q1.add(s);
        vis1[s]=1;
        path1[s]=-1;
        boolean p1=false;
        
        while (!q1.isEmpty()) {
            int u = q1.poll();
            if (u == k) {
                p1=true;
                break;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (vis1[v]==0) {
                    path1[v]=u;
                    vis1[v]=1;
                    q1.add(v);
                }
            }
        }
        
        Queue<Integer> q2 = new LinkedList<>();
        q2.add(k);
        vis2[k]=1;
        path2[k]=-1;
        boolean p2=false;
        
        while (!q2.isEmpty()) {
            int u = q2.poll();
            if (u == d) {
                p2=true;
                break;
            }
            for (int i = 0; i < adj[u].size(); i++) {
                int v = adj[u].get(i);
                if (vis2[v]==0) {
                    path2[v]=u;
                    vis2[v]=1;
                    q2.add(v);
                }
            }
        }

        if (!(p1&&p2)) {
            System.out.println(-1);
            return;
        }
        ArrayList<Integer> part1 = new ArrayList<>();
        int curr = k;
        while (curr != -1) {
            part1.add(curr);
            curr = path1[curr];
        }
        Collections.reverse(part1); 
        ArrayList<Integer> part2 = new ArrayList<>();
        curr = d;
        while (curr != -1) {
            part2.add(curr);
            curr = path2[curr];
        }
        Collections.reverse(part2); 
        ArrayList<Integer> res = new ArrayList<>();
        res.addAll(part1);
        for (int i = 1; i < part2.size(); i++) {
            res.add(part2.get(i));
        }
        
        for (int i = 0; i < res.size(); i++) {
            sb.append(res.get(i)).append(" ");        
        }
        System.out.println(res.size()-1);
        System.out.println(sb);
    }
}
