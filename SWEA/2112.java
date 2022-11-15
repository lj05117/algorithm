package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_2112_모의SW역량테스트 {
	static int D, W, K, result;
	static int[][] map, temp;
	static int[] injection;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1;t<=T;t++) {
			str=br.readLine().split(" ");
			D=Integer.parseInt(str[0]);
			W=Integer.parseInt(str[1]);
			K=Integer.parseInt(str[2]);
			map=new int[D][W];
			temp=new int[D][W];
			injection=new int[D];
			for(int i=0;i<D;i++) {
				injection[i]=-1;
			}
			result=Integer.MAX_VALUE;
			for(int i=0;i<D;i++) {
				str=br.readLine().split(" ");
				for(int j=0;j<W;j++) {
					map[i][j]=Integer.parseInt(str[j]);
					temp[i][j]=Integer.parseInt(str[j]);
				}
			}
			check(0,0,0);
			System.out.println("#"+t+" "+result);
		}
	}

	private static void check(int ab, int cnt, int idx) {
		if(idx==D) {
			for(int i=0;i<W;i++) {
				int n=0;
				for(int j=1;j<D;j++) {
					int j_1=map[j-1][i];
					int j_0=map[j][i];
					if(injection[j-1]!=-1) {
						j_1=injection[j-1];
					}
					if(injection[j]!=-1) {
						j_0=injection[j];
					}
					if(j_1==j_0) n+=1;
					else n=0;
					
					if(n==K-1) break;
				}
				if(n!=K-1) return;
			}
			result=(result>cnt)?cnt:result;
			return;
		}
		check(-1,cnt,idx+1);
		
		injection[idx]=0;
		check(0,cnt+1, idx+1);
			
		injection[idx]=1;
		check(1,cnt+1, idx+1);
			
		injection[idx]=-1;
	}
}
