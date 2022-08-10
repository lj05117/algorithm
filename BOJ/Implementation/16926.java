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
		int[][] map=new int[N][M];
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(str[j]);
			}
		}
		int gap=0;
		int round=(N<M)?N/2:M/2;
		int[] dr= {0,1,0,-1};
		int[] dc= {1, 0,-1,0};
		for(int a=0;a<R;a++) {
			for(int i=0;i<round;i++) {
				int r=i;
				int c=i;
				int temp=0;
				for(int k=0;k<4;k++) {
					r+=dr[k];
					c+=dc[k];
					while(i<=r&&r<(N-i)&&i<=c&&c<(M-i)) {
						temp=map[r-dr[k]][c-dc[k]];
						map[r-dr[k]][c-dc[k]]=map[r][c];
						map[r][c]=temp;
						r+=dr[k];
						c+=dc[k];
					}
					r-=dr[k];
					c-=dc[k];
				}
				temp=map[i][i];
				map[i][i]=map[i+1][i];
				map[i+1][i]=temp;
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
