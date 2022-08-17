import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int N,M;
	static int[] li;
	static void N_M(int i, int cnt, boolean check) {
		if(i>N) return;
		if(check) {
			li[cnt-1]=i;
		}
		if(cnt==M) {
			for(int a=0;a<M;a++) {
				System.out.print(li[a]+" ");
			}
			System.out.println();
			return;
		}
		
		N_M(i+1, cnt+1, true);
		
		N_M(i+1, cnt, false);
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		
		li=new int[M];
		N_M(0,0, false);
	}

}
