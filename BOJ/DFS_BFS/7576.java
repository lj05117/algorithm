import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class tomato{
	int x, y;
	tomato(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Main {
	static int N, M;
	static int[][] storage;
	static int[] dr= {-1,0,1,0};
	static int[] dc= {0,1,0,-1};
	static Queue<tomato> queue=new LinkedList<>();
	static int ripening() {
		while(queue.size()!=0) {
			tomato t=queue.remove();
			int x=t.x;
			int y=t.y;
			for(int i=0;i<4;i++) {
				int dx=x+dr[i];
				int dy=y+dc[i];
				if(0<=dx && dx<N && 0<=dy && dy<M) {
					if(storage[dx][dy]==0) {
						queue.add(new tomato(dx, dy));
						storage[dx][dy]=storage[x][y]+1;
					}
				}
			}
		}
		int result=0;
		int b=0;
		for(int i=0;i<N;i++) {
			if(b==1) break;
			for(int j=0;j<M;j++) {
				if(storage[i][j]==0) {
					result=0;
					b=1;
					break;
				}
				result=Math.max(result, storage[i][j]);
			}
		}
		return result-1;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		M=Integer.parseInt(str[0]);
		N=Integer.parseInt(str[1]);
		storage=new int[N][M]; 
		for(int i=0;i<N;i++) {
			str=br.readLine().split(" ");
			for(int j=0;j<M;j++) {
				storage[i][j]=Integer.parseInt(str[j]);
				if(storage[i][j]==1) {
					queue.add(new tomato(i, j));
				}
			}
		}
		System.out.println(ripening());
	}
}
