import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Search {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
        
            String[] parts = br.readLine().split(" ");
            long k = Long.parseLong(parts[0]);
            long x = Long.parseLong(parts[1]);

            long low = 1;
            long high = k*x;
            long answer = 0;

            while (low <= high) {
                long mid = (low+high) /2;
                long valid = mid-mid /x;

                if (valid >= k) {
                    answer = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            out.write(answer + "\n");
        }

        out.flush();
    }
}
