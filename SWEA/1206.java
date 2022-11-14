package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_1206_D3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str;
		for(int t=1;t<=10;t++) {
			int N=Integer.parseInt(br.readLine());
			int[] building=new int[N];
			str=br.readLine().split(" ");
			for(int i=0;i<N;i++) {
				building[i]=Integer.parseInt(str[i]);
			}
			int result=0;
			for(int i=2;i<N-2;i++) {
				int now=building[i];
				while(true) {
					if(now>building[i-1] &&
							now>building[i-2]
									&& now>building[i+1]
											&& now > building[i+2]) {
						result+=1;
						now-=1;
					}else break;
				}
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
