import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
public class g {
    public static int[] in;
    public static int[] pre;
    public static int index=0;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        in=new int[n];
        pre=new int[n];
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            in[i]=Integer.parseInt(st.nextToken());
        }
        
        st=new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            pre[i]=Integer.parseInt(st.nextToken());
        
        }
        print(0,n-1);
        bw.flush();
    }
    public static void print(int l,int r) throws IOException{
        if(l>r){
            return;
        }
        int root=pre[index++];
        int x=l;
        while(x<=r&&in[x]!=root){
            x++;
        }
        print(l, x-1);
        print(x+1, r);
        bw.write(root+" ");
    }
}
