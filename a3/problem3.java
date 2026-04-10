import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long M = 107;
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        System.out.println(mod(a,b,M));
    }

    static long mod(long a,long b,long M){
        if (b==0) {
            return 1;
        }
        else if (b%2==0) {
            long x =mod(a, b/2, M);
            return (x*x)%M;
        }
        else{
            long y=mod(a, b-1, M);
            long temp = a%M;
            return (y*temp)%M;
        }
    }
}
