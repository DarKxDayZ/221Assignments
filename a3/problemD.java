import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problemD {
    static final long MOD = 1000000007L;

    static long[][] multiply(long[][] A, long[][] B) {
        long[][] R = new long[2][2];

        R[0][0] = ( (A[0][0] * B[0][0]) % MOD + (A[0][1] * B[1][0]) % MOD ) % MOD;
        R[0][1] = ( (A[0][0] * B[0][1]) % MOD + (A[0][1] * B[1][1]) % MOD ) % MOD;
        R[1][0] = ( (A[1][0] * B[0][0]) % MOD + (A[1][1] * B[1][0]) % MOD ) % MOD;
        R[1][1] = ( (A[1][0] * B[0][1]) % MOD + (A[1][1] * B[1][1]) % MOD ) % MOD;

        return R;
    }

    static long[][] power(long[][] A, long x) {
        if (x == 1) {
            return A;
        }

        long[][] half = power(A, x / 2);
        long[][] result = multiply(half, half);

        if (x % 2 == 1) {
            result = multiply(result, A);
        }

        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long a11 = Long.parseLong(st.nextToken());
            long a12 = Long.parseLong(st.nextToken());
            long a21 = Long.parseLong(st.nextToken());
            long a22 = Long.parseLong(st.nextToken());

            long X = Long.parseLong(br.readLine());

            long[][] A = {
                {a11 % MOD, a12 % MOD},
                {a21 % MOD, a22 % MOD}
            };

            long[][] ans = power(A,X);

            sb.append(ans[0][0]).append(" ").append(ans[0][1]).append("\n");
            sb.append(ans[1][0]).append(" ").append(ans[1][1]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
