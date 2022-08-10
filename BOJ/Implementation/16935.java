import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		int N=Integer.parseInt(str[0]);
		int M=Integer.parseInt(str[1]);
		int R=Integer.parseInt(str[2]);
		int maxround=(N>M)?N:M;
		int[][] map=new int[maxround][maxround];
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(str[j]);
			}
		}
		str=br.readLine().split(" ");
		for(int i=0;i<R;i++) {
			if(Integer.parseInt(str[i])==1) {
				for(int j=0;j<N/2;j++) {
					int[] temp=map[j];
					map[j]=map[N-1-j];
					map[N-1-j]=temp;
				}
			}else if(Integer.parseInt(str[i])==2) {
				for(int j=0;j<M/2;j++) {
					for(int k=0;k<N;k++) {
						int temp=map[k][j];
						map[k][j]=map[k][M-1-j];
						map[k][M-1-j]=temp;
					}
				}
			}else if(Integer.parseInt(str[i])==3) {
				int[] temp=new int[N];
				int[][] tempmap=new int[maxround][maxround];
				for(int j=0;j<N;j++) {
					temp=map[N-1-j];
					for(int k=0;k<M;k++) {
						tempmap[k][j]=temp[k];
					}
				}
				
				map=tempmap;
				int numtemp=N;
				N=M;
				M=numtemp;
			}else if(Integer.parseInt(str[i])==4) {
				int[] temp=new int[N];
				int[][] tempmap=new int[maxround][maxround];
				for(int j=0;j<N;j++) {
					temp=map[j];
					for(int k=0;k<M;k++) {
						tempmap[M-1-k][j]=temp[k];
					}
				}
				
				map=tempmap;
				int numtemp=N;
				N=M;
				M=numtemp;
			}else {
				int[][] temp1=new int[N/2][M/2];
				int[][] temp2=new int[N/2][M/2];
				int[][] temp3=new int[N/2][M/2];
				int[][] temp4=new int[N/2][M/2];
				for(int j=0;j<N/2;j++) {
					for(int k=0;k<M/2;k++) {
						temp1[j][k]=map[j][k];
					}
					for(int k=M/2;k<M;k++) {
						temp2[j][k-M/2]=map[j][k];
					}
				}
				for(int j=N/2;j<N;j++) {
					for(int k=0;k<M/2;k++) {
						temp4[j-N/2][k]=map[j][k];
					}
					for(int k=M/2;k<M;k++) {
						temp3[j-N/2][k-M/2]=map[j][k];
					}
				}
				int[][] tempmap=new int[maxround][maxround];
				if(Integer.parseInt(str[i])==6) {
					int[][] sw=temp1;
					temp1=temp3;
					temp3=sw;
					sw=temp2;
					temp2=temp4;
					temp4=sw;
				}
				for(int j=0;j<N/2;j++) {
					for(int k=0;k<M/2;k++) {
						tempmap[j][k]=temp4[j][k];
					}
					for(int k=M/2;k<M;k++) {
						tempmap[j][k]=temp1[j][k-M/2];
					}
				}
				for(int j=N/2;j<N;j++) {
					for(int k=0;k<M/2;k++) {
						tempmap[j][k]=temp3[j-N/2][k];
					}
					for(int k=M/2;k<M;k++) {
						tempmap[j][k]=temp2[j-N/2][k-M/2];
					}
				}
				map=tempmap;

			}
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}

}
