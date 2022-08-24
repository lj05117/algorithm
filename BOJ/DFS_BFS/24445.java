import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main{
	static int N, M, cnt;
	static Queue<Integer> queue=new LinkedList<>();
	static List<Integer>[] line;
	static boolean[] visited;
	static int[] visitedPrint;
	static void bfs(int start) {
		queue.add(start);
		visited=new boolean[N+1];
		visited[start]=true;
		while(queue.size()!=0) {
			int nowNum=queue.poll();
			visitedPrint[nowNum]=++cnt;
			for(int i=0;i<line[nowNum].size();i++) {
				int next=line[nowNum].get(i);
				if(!visited[next]) {
//					visited[next]=true;
					queue.add(next);
					visited[next]=true;
				}
			}
		}
		for(int i=1;i<=N;i++) {
			System.out.println(visitedPrint[i]);
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		int R=Integer.parseInt(str[2]);
		line=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			line[i]=new ArrayList<>();
		}
		visitedPrint=new int[N+1];
		for(int i=0;i<M;i++) {
			str=br.readLine().split(" ");
			line[Integer.parseInt(str[0])].add(Integer.parseInt(str[1]));
			line[Integer.parseInt(str[1])].add(Integer.parseInt(str[0]));
		}
		for(int i=1;i<=N;i++) {
			Collections.sort(line[i], Collections.reverseOrder());
		}
		bfs(R);
		
	}

}
