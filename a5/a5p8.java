import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class a5p8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        char[][] map = new char[r][h];

        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < h; j++) {
                map[i][j] = temp.charAt(j);
            }
        }
        int maxD = 0;
        boolean [][] vis = new boolean[r][h];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < h; j++) {
                int[] curr = new int[]{i,j};
                int dcount = 0;
                if (map[curr[0]][curr[1]]=='#'|| vis[i][j]) {
                    continue;
                }
                Queue<int[]> q = new LinkedList<>();
                q.add(curr);
                vis[i][j]=true;
                while (!q.isEmpty()) {
                    int [] cur = q.poll();
                    int rpos = cur[0];
                    int cpos = cur[1];
                    if (map[rpos][cpos]=='D') {
                        dcount++;
                    }
                    boolean up = rpos-1 >= 0;
                    boolean down = rpos+1 < r;
                    boolean left = cpos-1 >= 0;
                    boolean right = cpos+1 < h;
                    if (up && map[rpos-1][cpos] != '#' && vis[rpos-1][cpos]==false) {
                        vis[rpos-1][cpos]=true;
                        q.add(new int[]{rpos-1,cpos});
                    }                    
                    if (down && map[rpos+1][cpos]!= '#' && vis[rpos+1][cpos]==false) {
                        vis[rpos+1][cpos]=true;
                        q.add(new int[]{rpos+1,cpos});
                    }                    
                    if (left && map[rpos][cpos-1] != '#' && vis[rpos][cpos-1]==false) {
                        vis[rpos][cpos-1]=true;
                        q.add(new int[]{rpos,cpos-1});
                    }                    
                    if (right && map[rpos][cpos+1] != '#' && vis[rpos][cpos+1]==false) {
                        vis[rpos][cpos+1]=true;
                        q.add(new int[]{rpos,cpos+1});
                    }                    

                }
                maxD= Math.max(maxD, dcount);
            }
        }

        System.out.println(maxD);

    }
}
