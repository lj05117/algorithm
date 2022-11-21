package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class pos_1949{
	int x, y;
	pos_1949(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Solution_1949_모의SW역량테스트 {
	static int N, K, res;
	static int[][] map;
	static int[] dr= {0,-1,0,1};
	static int[] dc= {-1,0,1,0};
	static boolean[] visited;
	static List<pos_1949> maxPos;
	static void findLoad(int x,int y, boolean k, int cnt) {
		if(cnt>res) res=cnt;
		
		for(int i=0;i<4;i++) {
			int r=x+dr[i];
			int c=y+dc[i];
			if(0<=r && r<N && 0<=c && c<N
					&& !visited[r*N+c]) {
				if(map[x][y]>map[r][c]) {
					visited[r*N+c]=true;
					findLoad(r,c,k,cnt+1);
					visited[r*N+c]=false;
				}else if(k==false){
					for(int kk=1;kk<=K;kk++) {
						if((map[r][c]-kk)<map[x][y]) {
							visited[r*N+c]=true;
							map[r][c]-=kk;
							findLoad(r,c,true,cnt+1);
							map[r][c]+=kk;
							visited[r*N+c]=false;
						}
					}
					
				}
			}
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1;t<=T;t++) {
			str=br.readLine().split(" ");
			N=Integer.parseInt(str[0]);
			K=Integer.parseInt(str[1]);
			maxPos=new LinkedList<>();
			map=new int[N][N];
			int maxNum=0;
			for(int i=0;i<N;i++) {
				str=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(str[j]);
					if(maxNum<map[i][j]) {
						maxNum=map[i][j];
						maxPos.clear();
						maxPos.add(new pos_1949(i,j));
					}else if(maxNum==map[i][j]) {
						maxPos.add(new pos_1949(i,j));
					}
				}
			}
			res=1;
			int posLen=maxPos.size();
			for(int p=0;p<posLen;p++) {
				pos_1949 now=maxPos.get(p);
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(i==now.x && j==now.y) {
							visited=new boolean[N*N];
							visited[i*N+j]=true;
							findLoad(i,j, false,1);							
						}
					}
				}
			}
			System.out.println("#"+t+" "+res);
		}
	}
}
