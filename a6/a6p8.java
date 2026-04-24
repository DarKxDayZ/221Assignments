import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.PriorityQueue;


public class a6p8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        String [] words = new String[n];
        ArrayList<Character> letters = new ArrayList<>();
        boolean[] seen = new boolean[26];
        for (int i = 0; i < words.length; i++) {
            String line = br.readLine();
            words[i]= line;
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (seen[c-'a']==false) {
                    seen[c-'a']=true;
                    letters.add(c);
                }
            }
        }
        
        int [] indeg = new int[letters.size()];
        int[] charToidx= new int[26];
        @SuppressWarnings("unchecked")
        ArrayList<Character>[] adj = new ArrayList[letters.size()];
        for (int i = 0; i < letters.size(); i++) {
            char c = letters.get(i);
            charToidx[c-'a']=i;
            adj[i]= new ArrayList<>();
        }

        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i];
            String w2 = words[i+1];
            int length = Math.min(w1.length(), w2.length());
            boolean found = false;
            for (int j = 0; j < length; j++) {
                char c1 = w1.charAt(j);
                char c2 = w2.charAt(j);
                if (c1!=c2) {
                    adj[charToidx[c1-'a']].add(c2);
                    indeg[charToidx[c2-'a']]++;
                    found = true;
                    break;
                }
            }
            if (!found && w1.length()>w2.length()) {
                System.out.println(-1);
                return;
            }
        }
        Queue<Character> que = new PriorityQueue<>();
        for (int i = 0; i < letters.size(); i++) {
            char c = letters.get(i);
            if (indeg[charToidx[c-'a']]==0) {
                que.add(c);
            }
        }
        int count = 0;
        while (!que.isEmpty()) {
            char c = que.poll();
            sb.append(c);
            count++;
            for (int i = 0; i < adj[charToidx[c-'a']].size(); i++) {
                char v =  adj[charToidx[c-'a']].get(i);
                indeg[charToidx[v-'a']]--;
                if (indeg[charToidx[v-'a']]==0) {
                    que.add(v);
                }
            }
        }
        if (count<letters.size()) {
            System.out.println(-1);
        }
        else{
            System.out.println(sb);
        }
    }
}
