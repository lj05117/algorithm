import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] li=new int[N+1][N+1];
		int[][] sumli=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=1;j<=N;j++) {
				li[i][j]=Integer.parseInt(st.nextToken());
				sumli[i][j]=li[i][j]+sumli[i-1][j]+sumli[i][j-1]-sumli[i-1][j-1];
			}
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int[] arrli=new int[4];
			for(int j=0;j<4;j++) {
				arrli[j]=Integer.parseInt(st.nextToken());
			}
			System.out.println(sumli[arrli[2]][arrli[3]]-sumli[arrli[2]][arrli[1]-1]-sumli[arrli[0]-1][arrli[3]]+sumli[arrli[0]-1][arrli[1]-1]);
		}
		
	}

}
