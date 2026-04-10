import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class a4p6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] x_moves ={-1,-1,-1,0,1,1,0,1};
        int[] y_moves ={-1,0,1,1,0,-1,-1,1};
        
        List<int[]> moves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            int nx = x + x_moves[i];
            int ny = y + y_moves[i];
            boolean x_valid = nx >= 1 && nx <= N;
            boolean y_valid = ny >= 1 && ny <= N;
            if (x_valid && y_valid) {
                moves.add(new int[]{nx, ny});
            }
        }

        moves.sort((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        sb.append(moves.size()).append("\n");

        for (int i = 0; i < moves.size(); i++) {
            int[] move = moves.get(i);
            sb.append(move[0]).append(" ").append(move[1]).append("\n");
        }
        System.out.print(sb);

    }
}
