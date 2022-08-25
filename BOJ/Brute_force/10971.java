import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, nowPrice;
	static int result=Integer.MAX_VALUE;
	static int[] sequence;
	static boolean[] visited;
	static int[][] city;
	static void travel(int ind) {
//		if(ind>-1) visited[ind]=true;
		
		if(ind==N) {
			int price=0;
			for(int i=0;i<N-1;i++) {
				nowPrice=city[sequence[i]][sequence[i+1]];
				if(nowPrice==0) return;
				price+=nowPrice;
			}
			nowPrice=city[sequence[N-1]][sequence[0]];
			if(nowPrice==0) return;
			price+=nowPrice;
			if(price<result) result=price;
			return;
		}
		for(int i=0;i<N;i++) {
			if(visited[i]!=true) {
				visited[i]=true;
				sequence[ind]=i;
				travel(ind+1);
				visited[i]=false;
			}
		}
	}
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		sequence=new int[N];
		visited=new boolean[N];
		city=new int[N][N];
		String[] str;
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				city[i][j]=Integer.parseInt(str[j]);
			}
		}
		
		travel(0);
		System.out.println(result);
	}

}
