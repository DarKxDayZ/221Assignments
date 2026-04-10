import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;

public class a4p8 {
    
    public static int gcd(int x,int y){
        while (y!=0) {
            int temp = y;
            y = x%y;
            x = temp;
        }
        return x;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i <=n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 1; i <=n; i++) {
            for (int j = i+1; j <=n; j++) {
                if (gcd(i, j)==1) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            List<Integer> list = adj.get(x);
            if (list.size()<k) {
               sb.append(-1).append("\n"); 
            }
            else{
                sb.append(list.get(k-1)).append("\n");
            }
        }
        
        System.out.println(sb);            
    }

}
