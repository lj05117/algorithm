package ws1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1953 {
	static int[][] direct= {{},{0,1,2,3},{1,3},{0,2},{1,2},{2,3},{0,3},{0,1}};
//	static boolean[][] connect= {{},{},{},{},{},{},{},{}};
	static int[] x= {0,-1,0,1};
	static int[] y= {-1,0,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1;t<=T;t++) {
			str=br.readLine().split(" ");
			int N=Integer.parseInt(str[0]);
			int M=Integer.parseInt(str[1]);
			int R=Integer.parseInt(str[2]);
			int C=Integer.parseInt(str[3]);
			int L=Integer.parseInt(str[4]);
			int[][] map=new int[N][M];
			for(int i=0;i<N;i++) {
				str=br.readLine().split(" ");
				for(int j=0;j<M;j++) {
					map[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			boolean[][] visited=new boolean[N][M];
			Queue<pos> queue=new LinkedList<>();
			int cnt=1;
			int time=1;
			int qSize=1;
			queue.add(new pos(R,C));
			visited[R][C]=true;
			while(time<L) {
				time+=1;
				for(int q=0;q<qSize;q++) {
					pos now=queue.poll();
//					visited[now.x][now.y]=true;
//					cnt+=1;
					int I=direct[map[now.x][now.y]].length;
					int num=map[now.x][now.y];
					for(int i=0;i<I;i++) {
						int dx=x[direct[num][i]]+now.x;
						int dy=y[direct[num][i]]+now.y;
						if(0<=dx && dx<N && 0<=dy && dy<M
								&& !visited[dx][dy]
										&& map[dx][dy]!=0) {
							if(direct[num][i]==0 && 
									(map[dx][dy]==1|| map[dx][dy]==3 ||map[dx][dy]==4 ||map[dx][dy]==5)) {
								queue.add(new pos(dx,dy));
								visited[dx][dy]=true;
								cnt+=1;
							}else if(direct[num][i]==1 &&
									(map[dx][dy]==1|| map[dx][dy]==2 ||map[dx][dy]==5 ||map[dx][dy]==6)) {
								queue.add(new pos(dx,dy));
								visited[dx][dy]=true;
								cnt+=1;
							}else if(direct[num][i]==2
									&& (map[dx][dy]==1|| map[dx][dy]==3 ||map[dx][dy]==6 ||map[dx][dy]==7)) {
								queue.add(new pos(dx,dy));
								visited[dx][dy]=true;
								cnt+=1;
							}else if(direct[num][i]==3
									&&(map[dx][dy]==1|| map[dx][dy]==2 ||map[dx][dy]==4 ||map[dx][dy]==7)){
								queue.add(new pos(dx,dy));
								visited[dx][dy]=true;
								cnt+=1;
							}
//							queue.add(new pos(dx,dy));
//							visited[dx][dy]=true;
//							cnt+=1;
						}
					}
				}
				qSize=queue.size();
				
			}
			
			System.out.println("#"+t+" "+cnt);
		}
	}

}
class pos{
	int x, y;
	pos(int x, int y){
		this.x=x;
		this.y=y;
	}
}
