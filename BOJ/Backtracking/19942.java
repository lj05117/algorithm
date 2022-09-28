import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	static boolean[] visited;
	static boolean[] resultVisited;
	static int[][] nutri;
	static int[] needli=new int[4];
	static int N;
	static int cost=Integer.MAX_VALUE;
	static void permu(int p, int f, int s, int v, int c, int i) {
		
		if(p>=needli[0] && f>=needli[1] && s>=needli[2] && v>=needli[3]) {
			if(c<cost) {
				cost=c;
				for(int j=0;j<N;j++) {
					resultVisited[j]=visited[j];
				}
			}
			return;
		}
		
		if(i<N-1) {
			visited[++i]=true;
			permu(p+nutri[i][0], f+nutri[i][1], s+nutri[i][2], v+nutri[i][3], c+nutri[i][4], i );
			visited[i]=false;
			permu(p,f,s,v,c,i);
		}
			
//		for(int i=ind;i<6;i++) {
//			if(visited[i]) continue;
//			visited[i]=true;
//			permu(p+nutri[i][0], f+nutri[i][1], s+nutri[i][2], v+nutri[i][3], c+nutri[i][4] );
//			visited[i]=false;
//		}
		
		
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String[] str=br.readLine().split(" ");
		for(int i=0;i<4;i++) {
			needli[i]=Integer.parseInt(str[i]);
		}
		nutri=new int[N][5];
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<5;j++) {
				nutri[i][j]=Integer.parseInt(str[j]);
			}
		}
		visited=new boolean[N];
		resultVisited=new boolean[N];
		permu(0,0,0,0,0,-1);
		
		if(cost==Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(cost);
		for(int i=0;i<N;i++) {
			if(resultVisited[i]) {
				System.out.print((i+1)+" ");
			}
		}

	}

	

}
