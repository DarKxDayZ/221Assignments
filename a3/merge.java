import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class merge {

    static long Inversion = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        int idx = 0;
        while (st.hasMoreTokens()) {
            arr[idx++] = Integer.parseInt(st.nextToken());
        }
        arr = mergeSort(arr);
        StringBuilder sb = new StringBuilder();
        for(int val : arr) {
            sb.append(val).append(" ");
        }
        System.out.println(Inversion);
        System.out.println(sb);

    }

    static int[] mergeSort(int[] Arr){
        if (Arr.length==1) {
            return Arr;
        }
        else{
            int mid = Arr.length/2;
            int [] a = new int[mid];
            int [] b = new int[Arr.length-mid];
            for (int i = 0; i < mid; i++) {
                a[i] = Arr[i];
            }
            for (int i = 0; i < Arr.length-mid; i++) {
                b[i] = Arr[mid+i];
            }
            a = mergeSort(a);
            b = mergeSort(b);

            return mergeArr(a, b);
        }
    }
    static int[] mergeArr(int[] a,int[] b){
        int[] finalarr = new int[a.length+b.length];
        int i = 0 ,j = 0, k = 0;
        while(j<a.length && k<b.length) {
            if (a[j]<=b[k]) {
                finalarr[i++] =a[j++];
            }
            else{
                finalarr[i++] =b[k++];
                Inversion += a.length-j;
            }
        }
        while (j < a.length) {
            finalarr[i++] = a[j++];
        }
        while (k < b.length) {
            finalarr[i++] = b[k++]; 
        }
        return finalarr;
    }    
}

