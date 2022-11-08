package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2468_S1 {
	static int[] x= {0,-1,0,1};
	static int[] y= {-1,0,1,0};
	static boolean[][] temp;
	static int N;
	public static void check(int i, int j) {
		temp[i][j]=false;
		for(int d=0;d<4;d++) {
			int di=i+x[d];
			int dj=j+y[d];
			if(0<=di && di<N && 0<=dj && dj<N
					&& temp[di][dj]) {
				check(di,dj);
			}
		}

	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String[] str;
		int[][] map=new int[N][N];
		int max=1;
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(str[j]);
				if(map[i][j]>max) max=map[i][j];
			}
		}
		//----------- 입력 끝
		int cnt, maxcnt=0;
		for(int l=0;l<max;l++) {
			cnt=0;
			temp=new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]>l) {
						temp[i][j]=true;
					}
				}
			}
			//-- 물에 잠기는 지역 체크---
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(temp[i][j]) {
						cnt+=1;
						//사방탐색 보내기
						check(i,j);
					}
				}
			}
			if(cnt>maxcnt) maxcnt=cnt;
		}
		System.out.println(maxcnt);
		
		

	}

}
