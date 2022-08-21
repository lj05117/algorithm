import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static int N, M;
	static StringBuilder sb=new StringBuilder();
	static boolean[] visited;
	static void NM(int now, int cnt) {
		if(now!=0) {
			visited[now]=true;
		}
		if(cnt==M) {
			for(int i=1;i<=N;i++) {
				if(visited[i]==true)
					System.out.print(i+" ");
			}
			System.out.println();
			return;
		}
		for(int i=now+1;i<=N;i++) {
			NM(i, cnt+1);
			visited[i]=false;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		visited=new boolean[N+1];
		NM(0,0);
	}

}
