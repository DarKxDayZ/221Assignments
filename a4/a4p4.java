import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class a4p4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N,M=0;
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 ;
        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        int[] degree = new int[N+1];

        st1 = new StringTokenizer(br.readLine());
 
        st2 = new StringTokenizer(br.readLine());


        for (int i = 0; i <M; i++) {
            degree[Integer.parseInt(st1.nextToken())]+=1;
            degree[Integer.parseInt(st2.nextToken())]+=1;
        }
        int count = 0;
        for (int i = 1; i <degree.length; i++) {
            if(count>2){
                break;
            }
            if (degree[i]%2!=0) {
                count++;
            }
        }
        if (count == 0 || count == 2) {
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }
}
