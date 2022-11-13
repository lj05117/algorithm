import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main{
	static char[][] map=new char[5][5];
	static boolean[] visited=new boolean[25];
	static boolean[] visitedA;
	static int[] selected;
	static int result;
	static int[] dx= {-1,0,1,0};
	static int[] dy= {0,1,0,-1};
	static Queue<Integer> que;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		for(int i=0;i<5;i++) {
			map[i]=br.readLine().toCharArray();
		}
		selected=new int[7];
		find(0,0,0);
		System.out.println(result);
	}
	private static void find(int idx, int cnt, int cnts) {
		if(cnt==7) {
			if(cnts>=4) {
				if(check()) {
					result+=1;
				}
				return;
			}
			return;
		}
		for(int i=idx;i<25;i++) {
			visited[i]=true;
			selected[cnt]=i;
			if(map[i/5][i%5]=='S')
				find(i+1, cnt+1, cnts+1);
			else
				find(i+1, cnt+1, cnts);
			visited[i]=false;
		}
	}
	private static boolean check() {
		int cnt=1;
		visitedA=new boolean[25];
		que=new LinkedList<>();
		que.add(selected[0]);
		while(!que.isEmpty()) {
			int now = que.poll();
			visitedA[now]=true;
			for(int d=0;d<4;d++) {
				int xx=(now/5)+dx[d];
				int yy=(now%5)+dy[d];
				if(xx<0 || xx>=5 || yy<0 || yy>=5) continue;
				if(visitedA[xx*5+yy]) continue;
				if(!visited[xx*5+yy])continue;
				cnt++;
				visitedA[xx*5+yy]=true;
				que.add(xx*5+yy);
			}
		}
		if(cnt==7)return true;
		else return false;
		
	}

}
