import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Tripple {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        int [] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }

        arrObj [] list = new arrObj[n];
        for (int i = 0; i < list.length; i++) {
            list[i] = new arrObj(arr[i] , i );
        }

        Arrays.sort(list, Comparator.comparingInt(obj -> obj.value));
        boolean found= false;
        int orgI = -1 , orgJ = -1 , orgK = -1;
        for (int i = 0; i < list.length-2; i++) {
            int temp =list[i].value;
            int secondTarget = x-temp;
            int l = i+1;
            int r = n-1;
            while (l<r) {
                if(list[l].value+list[r].value == secondTarget){
                    found = true;
                    orgI=i;
                    orgJ=l;
                    orgK=r;
                    break;
                }
                else if (list[l].value+list[r].value < secondTarget) {
                    l++;
                }
                else{
                    r--;
                }
            }
            if(found){
                break;
            }
        }
        if (found) {
            System.out.println((list[orgI].Oidx+1) +" "+ (list[orgJ].Oidx+1) +" "+(list[orgK].Oidx+1));
        }
        else{
            System.out.println(-1);
        }

    }
    static class arrObj{
        int value;
        int Oidx;
        arrObj(int value,int Oidx){
            this.Oidx = Oidx;
            this.value = value;
        }
    }
}
