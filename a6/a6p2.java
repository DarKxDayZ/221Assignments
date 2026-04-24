import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class a6p2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
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
        int[] flag = new int[n+1];
        int[] team = new int[n+1];
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (flag[i]==0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                flag [i] = 1;
                team [i] = 1;
                int robot =0;
                int human =0;
                robot++;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int j = 0; j < adj[u].size(); j++) {
                        int v = adj[u].get(j);
                        if (flag[v]==0) {
                            flag[v]=1;
                            q.add(v);
                            if (team[u]==1) {
                                team[v]=2;
                                human++;
                            }
                            else if (team[u]==2) {
                                team[v]=1;
                                robot++;
                            }
                        }
    
                    }
                }
                
                max+=Math.max(human, robot);
            }
            
        }
        System.out.println(max);


    }
}
