import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static int N, M;
	static boolean[] visited;
	static StringBuilder sb=new StringBuilder();
	static void NM(int m, int cnt) {
		if(m!=0) {
			if(visited[m]!=true) {
				visited[m]=true;
				sb.append(m+" ");
			}else return;
		}
		if(cnt==M) {
			System.out.println(sb);
			return;
		}
		for(int i=1;i<=N;i++) {
			if(visited[i]!=true) {
				NM(i,cnt+1);
				visited[i]=false;
				sb.setLength(sb.length()-2);
			}
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
