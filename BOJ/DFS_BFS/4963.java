package ws1119;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_4963_S2 {
	static int[] x= {0,-1,-1,-1,0,1,1,1};
	static int[] y= {-1,-1,0,1,1,1,0,-1};
	static int[][] map;
	static int N, M;
	static boolean[] visited;
	static void find(int ii, int jj) {
		for(int d=0;d<8;d++) {
			int dr=ii+x[d];
			int dc=jj+y[d];
			if(0<=dr && dr<N && 0<=dc && dc<M
					&& map[dr][dc]==1
					&& !visited[dr*M+dc]) {
				visited[dr*M+dc]=true;
				find(dr, dc);				
			}
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		while(true) {
			str=br.readLine().split(" ");
			M = Integer.parseInt(str[0]);
			N=Integer.parseInt(str[1]);
			if(N==0 && M==0) break;
			visited=new boolean[N*M];
			map=new int[N][M];
			for(int i=0;i<N;i++) {
				str=br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(str[j]);
				}
			}
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1
							&& !visited[i*M+j]) {
						visited[i*M+j]=true;
						find(i,j);
						cnt+=1;
					}
				}
			}
			System.out.println(cnt);
		}
	}

}
