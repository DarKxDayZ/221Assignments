import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemE {
static long a, m;

    static long[] solve(long n) {

        if (n == 1) {
            long val = a%m;
            return new long[]{val, val};
        }

        long[] half = solve(n/2);

        long p = half[0]; 
        long s = half[1]; 

        long power = (p*p)%m;
        long sum = (s+(p*s)%m)% m;

        if (n % 2 == 1) {
            power = (power*a)%m;
            sum = (sum+power)%m;
        }

        return new long[]{power, sum};
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            
            StringTokenizer st = new StringTokenizer(br.readLine());
    
            a = Long.parseLong(st.nextToken());
            long n = Long.parseLong(st.nextToken());
            m = Long.parseLong(st.nextToken());
    
            long[] ans=solve(n);
    
            out.append(ans[1]%m).append('\n');
        } 

        

        System.out.print(out);
    }
}
