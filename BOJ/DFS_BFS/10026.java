import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int cnt, cnt2, N;
	static char[][] map;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static boolean[][] visited;
	static void picture(int row, int column) {
		visited[row][column]=true;
		for(int i=0;i<4;i++) {
			int R=row+dr[i];
			int C=column+dc[i];
			while(0<=R && R<N && 0<=C && C<N 
					&& map[row][column]==map[R][C]) {
				if(visited[R][C]!=true) {
					picture(R,C);
				}
				R+=dr[i];
				C+=dc[i];
			}
		}
	}
	static void picture2(int row, int column) {
		visited[row][column]=true;
		char color=map[row][column];
		for(int i=0;i<4;i++) {
			int R=row+dr[i];
			int C=column+dc[i];
			while(0<=R && R<N && 0<=C && C<N) {
				if(((color=='R' || color=='G') && (map[R][C]=='R' || map[R][C]=='G'))
						||(color=='B' && map[R][C]=='B')) {
					if(visited[R][C]!=true) {
						picture2(R,C);
					}
					R+=dr[i];
					C+=dc[i];
				}else {
					break;
				}
				
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		String str;
		map=new char[N][N];
		for(int i=0;i<N;i++) {
			str=br.readLine();
			for(int j=0;j<N;j++) {
				map[i][j]=str.charAt(j);
			}
		}
		
		visited=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]!=true) {
					cnt+=1;
					picture(i,j);
				}
			}
		}
		visited=new boolean[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(visited[i][j]!=true) {
					cnt2+=1;
					picture2(i,j);
				}
			}
		}		System.out.println(cnt+" "+cnt2);
	}

}
