package ws1010;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_벌꿀채취 {
	static int[][] hive;
	static boolean[][] visited;
	static int result, maxL, maxR, C, M;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1;t<=T;t++) {
			str=br.readLine().split(" ");
			int N=Integer.parseInt(str[0]);
			M=Integer.parseInt(str[1]);
			C=Integer.parseInt(str[2]);
			hive=new int[N][N];
			visited=new boolean[N][N];
			result=0;
			for(int i=0;i<N;i++) {
				str=br.readLine().split(" ");
				for(int j=0;j<N;j++) {
					hive[i][j]=Integer.parseInt(str[j]);
				}
			}
			int i=0, j=0, k=0,l=M;
			if(l+(M-1)>=N) {
				k=1;
				l=0;
			}
			while(i<N && j<N && k<N && l<N) {
				comb(i,j,j, 0,0);
				int maxLeft=maxL;
				maxL=0;
				comb(k,l, l, 0,0);
				int maxRight=maxL;
				maxL=0;
				if(maxLeft+maxRight>result) {
					result=maxLeft+maxRight;
				}
				l+=1;
				if(l+M-1>=N) {
					k+=1;
					l=0;
				}
				if(k==N) {
					j+=1;
					if(j+M-1>=N) {
						i+=1;
						j=0;
					}
					k=i;
					l=j+M;
					if(l+M-1>=N) {
						k+=1;
						l=0;
					}
				}
			}
			
			System.out.println("#"+t+" "+result);
		}
	}
	static void comb(int i, int j,int m,int sum, int square) {
		if(sum>C) {
			return;
		}else {
			if(square>maxL) {
				maxL=square;
			}
		}
		for(int a=j;(a-m)<M;a++) {
			if(!visited[i][a]) {
				visited[i][a]=true;
				comb(i,a+1,m,sum+hive[i][a],square+(hive[i][a])*(hive[i][a]));
				comb(i,a+1,m,sum,square);
				visited[i][a]=false;
			}
		}
	}
}
