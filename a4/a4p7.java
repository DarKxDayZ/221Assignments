import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a4p7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int kn = Integer.parseInt(st.nextToken());

        int [] x_moves = {-2, -2, -1, -1,  1,  1,  2,  2};
        int [] y_moves = {-1,  1, -2,  2, -2,  2, -1,  1};
        int [][] kn_pos = new int[kn][2];
        
        boolean [][] board = new boolean[row+1][col+1];
        
        
        for (int i = 0; i < kn_pos.length; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            kn_pos[i][0] = x;
            kn_pos[i][1] = y;
            board[x][y] = true;
        }
        boolean atk = false;
        for (int i = 0; i < kn_pos.length-1; i++) {
            int x = kn_pos[i][0];
            int y = kn_pos[i][1];
            for (int j =0; j < 8; j++) {
                int nx = x + x_moves[j];
                int ny = y + y_moves[j];
                boolean x_valid = nx >= 1 && nx <= row;
                boolean y_valid = ny >= 1 && ny <= col;
                if (x_valid && y_valid) {
                    if (board[nx][ny]) {
                        atk=true;
                        break;
                    }
                }
                if (atk) {
                    break;
                }
            }
            if (atk) {
                break;
            }
        }
        if (atk) {
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }

    }
}
