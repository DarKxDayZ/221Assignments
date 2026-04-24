import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class a6p6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String a = st.nextToken();
        String b = st.nextToken();
        String [] words = new String[n];
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] list = new ArrayList[26];
        for (int i = 0; i < list.length; i++) {
            list[i]= new ArrayList<>();
        }
        int start_idx = -1, end_idx=-1;
        for (int i = 0; i < n; i++) {
            words[i] = br.readLine();
            if (words[i].equals(a)) {
                start_idx=i;
            }
            if (words[i].equals(b)) {
                end_idx=i;
            }
            list[words[i].charAt(0)-'A'].add(i);
        }

        int[] vis = new int[n];
        int[] letters = new int[26];

        vis[start_idx]=1;
        Queue<Integer> q = new LinkedList<>();
        q.add(start_idx);

        while (!q.isEmpty()) {
            int u = q.poll();
            if (u==end_idx) {
                System.out.println("YES");
                return;
            }
            int lastL = words[u].charAt(words[u].length()-1)-'A';
            if (letters[lastL]==0) {
                letters[lastL]=1;
                for (int i = 0; i < list[lastL].size(); i++) {
                    int v = list[lastL].get(i);
                    if (vis[v]==0) {
                        vis[v]=1;
                        q.add(v);
                    }
                }
            }
        }
        System.out.println("NO");
    }
}
