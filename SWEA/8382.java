import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution{
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		int[] xy=new int[4];
		int[] startX=new int[4];
		int[] startY=new int[4];
		for(int t=1;t<=T;t++) {
			str=br.readLine().split(" ");
			for(int i=0;i<4;i++) {
				xy[i]=Integer.parseInt(str[i]);
				startX[i]=Integer.parseInt(str[i]);
				startY[i]=Integer.parseInt(str[i]);
			}
			int minX = 0, minY=0;
			if(xy[0]!=xy[2] || xy[1]!=xy[3]) {
				int i=0;
				while(startX[0]!=startX[2] || startX[1]!=startX[3]) {
					if(startX[i]>startX[i+2]) {
						startX[i]-=1;
					}else {
						startX[i]+=1;
					}
					i=(i+1)%2;
					minX+=1;
				}
				
				while(startY[0]!=startY[2] || startY[1]!=startY[3]) {
					if(startY[i]>startY[i+2]) {
						startY[i]-=1;
					}else {
						startY[i]+=1;
					}
					i=(i+1)%2;
					minY+=1;
				}
			}
			int result=minX>minY?minY:minX;
			System.out.println("#"+t+" "+result);
		}
	}

}
