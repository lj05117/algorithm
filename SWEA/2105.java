package ws1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2105 {
	static int N, startI, startJ;
	static int[][] map;
	static int result=-1;
	static int[] x= {-1,-1,1,1};
	static int[] y= {-1,1,1,-1};
	static boolean[] direct=new boolean[4];
	static boolean[][] visited=new boolean[N][N];
	static boolean[] dessert=new boolean[101];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1;t<=T;t++) {
			N=Integer.parseInt(br.readLine());
			map=new int[N][N];
			for(int i=0;i<N;i++) {
				str=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(str[j]);
				}
			}
			
			result=-1;
			for(int i=0;i<N;i++) {
				startI=i;
				for(int j=0;j<N;j++) {
					visited=new boolean[N][N];
//					direct=new boolean[4];
					startJ=j;
					dessert=new boolean[101];
					visited[i][j]=true;
					dessert[map[i][j]]=true;
					eat(i,j, 1, 0);
				}
			}
			System.out.println("#"+t+" "+result);
		}

	}
	static void eat(int i, int j, int cnt, int preD) { //cnt는 이전까지의 디저트 값
		
		for(int d=preD;d<4;d++) {
			int dX=x[d]+i;
			int dY=y[d]+j;
			if(0<=dX && dX<N && 0<=dY && dY<N) {
				if((dX==startI) && (dY==startJ) && cnt>2) {
					result=Math.max(result, cnt);
				}
				if(!dessert[map[dX][dY]] && !visited[dX][dY]) {
					dessert[map[dX][dY]]=true;
					visited[dX][dY]=true;
					eat(dX, dY, cnt+1, d);
					dessert[map[dX][dY]]=false;
					visited[dX][dY]=false;
				}
			}
			
		}
//		if(preD!=-1) {
//			
//		}
//		if(!visited[i][j]) {
//			if(!desert[map[i][j]]) {
//				visited[i][j]=true;
//				desert[map[i][j]]=true;
//			}else 
//				return;			
//		}else if(direct[0] && direct[1] && direct[2] && direct[3]
//				&&i==startI && j==startJ) {
//			result=Integer.max(result, cnt);
//		}else return;
//		
//		for(int d=0;d<4;d++) {
//			int dX=x[d]+i;
//			int dY=y[d]+j;
//			if(dX<0 || dX>=N || dY<0 || dY>=N) continue;
//			if(d<preD) continue;
//			direct[d]=true;
//			eat(dX, dY, cnt+1, d);
//			visited[dX][dY]=false;
//			desert[map[dX][dY]]=false;
//			if(preD!=-1
//					&& preD!=d) {
//				direct[d]=false;
//			}
//		}
	}
}
