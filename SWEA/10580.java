package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_10580_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1;t<=T;t++) {
			int N=Integer.parseInt(br.readLine());
			int[][] line=new int[N][2];
			for(int i=0;i<N;i++) {
				str=br.readLine().split(" ");
				line[i][0]=Integer.parseInt(str[0]);
				line[i][1]=Integer.parseInt(str[1]);
			}
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=i+1;j<N;j++) {
					if((line[i][0]<line[j][0]&&line[i][1]>line[j][1])
							||(line[i][0]>line[j][0] && line[i][1]<line[j][1])) {
						cnt+=1;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
