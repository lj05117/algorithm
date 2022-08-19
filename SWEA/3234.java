import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class Solution {
    static long cnt=0;
    static int N, sum;
    static int[] weightList, permList;
    static boolean[] temp;
    public static void scale(int[] output, int left, int right, int ind) {
        if(left<right) 
            return;
        if(ind==N-1) {
            cnt++;
            return;
        }
        int next=ind+1;
        scale(output, left, right+output[next], next);
        scale(output, left+output[next], right, next); 
    }
    public static void perm(boolean[] visited, int depth) {
        if(depth==N) {
            scale(permList, 0,0,-1);
            return;
        }
        for(int i=0;i<N;i++) {
            if(visited[i]!=true) {
                visited[i]=true;
                permList[depth]=weightList[i];
                perm(visited, depth+1);
                visited[i]=false;
            }
        }
    }
    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int T=Integer.parseInt(br.readLine());
        String[] str;
        for(int t=1;t<=T;t++) {
            N=Integer.parseInt(br.readLine());
            weightList=new int[N];
            permList=new int[N];
            temp=new boolean[N];
            str=br.readLine().split(" ");
            for(int i=0;i<N;i++) {
                weightList[i]=Integer.parseInt(str[i]);
                sum+=weightList[i];
            }
            cnt=0;
            perm(temp, 0);
            System.out.println("#"+t+" "+cnt);
        }
    }
}
