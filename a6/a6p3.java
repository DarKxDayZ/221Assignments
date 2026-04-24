import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class a6p3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int posx=Integer.parseInt(st.nextToken());
        int posy=Integer.parseInt(st.nextToken());
        int targetx=Integer.parseInt(st.nextToken());
        int targety=Integer.parseInt(st.nextToken());
        int level =0;

        int [] x_moves = {-2, -2, -1, -1,  1,  1,  2,  2};
        int [] y_moves = {-1,  1, -2,  2, -2,  2, -1,  1};

        boolean [][] board = new boolean[n+1][n+1];
        boolean found = false; 

        Queue<int []> q = new LinkedList<>();
        q.add(new int[]{posx,posy,0});
        board[posx][posy]=true;
        while (!q.isEmpty()) {
            int [] u = q.poll();
            for (int i = 0; i < 8; i++) {
                int nx = u[0]+ x_moves[i];
                int ny = u[1]+ y_moves[i];
                int l = u[2];
                if (nx==targetx && ny==targety) {
                    found=true;
                    level=l+1;
                    break;
                }
                boolean x_valid = nx>=1 && nx<=n;
                boolean y_valid = ny>=1 && ny<=n;
                if (y_valid&&x_valid) {
                    if (board[nx][ny]==false) {
                        q.add(new int[]{nx,ny,l+1});
                        board[nx][ny]=true;
                    }
                }
            }
            if (found) {
                break;
            }
        }
        if (found) {
            System.out.println(level);
        }
        else{
            System.out.println(-1);
        }

    }
}
