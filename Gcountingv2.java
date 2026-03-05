import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Gcountingv2 {
        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

            String[] firstLine = br.readLine().split(" ");
            int N = Integer.parseInt(firstLine[0]);
            int Q = Integer.parseInt(firstLine[1]);

            int[] arr = new int[N];
            String[] parts = br.readLine().split(" ");
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(parts[i]);
            }

            for (int qi = 0; qi < Q; qi++) {
                parts = br.readLine().split(" ");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);

                int low = 0, high = N - 1;
                int xidx = N; 
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr[mid] >= x) {
                        xidx = mid;
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }

                low = 0; high = N - 1;
                int yidx = -1; 
                while (low <= high) {
                    int mid = (low + high) / 2;
                    if (arr[mid] <= y) {
                        yidx = mid;
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }

                int count;
                if (yidx >= xidx) {
                    count = yidx - xidx + 1;
                } else {
                    count = 0;
                }

                out.write(count + "\n");
            }

            out.flush();
        }
}
