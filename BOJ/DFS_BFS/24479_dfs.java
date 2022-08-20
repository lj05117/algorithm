import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
	static int N, M;
	static boolean[] visited;
	static int[] visitPrint;
	static int cnt;
	static List<List<Integer>> line=new ArrayList<>();
	static void dfs(int R) {
		visited[R]=true;
		visitPrint[R]=++cnt;
		int lineSize=line.get(R).size();
		for(int i=0;i<lineSize;i++) {
			if(visited[line.get(R).get(i)]!=true) {
				dfs(line.get(R).get(i));
			}
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" ");
		N=Integer.parseInt(str[0]);
		M=Integer.parseInt(str[1]);
		int R=Integer.parseInt(str[2]);
		for(int i=0;i<=N;i++) {
			line.add(new ArrayList<>());
		}
		visited=new boolean[N+1];
		visitPrint=new int[N+1];
		for(int i=0;i<M;i++) {
			str=br.readLine().split(" ");
			line.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			line.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		for(int i=0;i<=N;i++) {
			Collections.sort(line.get(i));
		}
		dfs(R);
		for(int i=1;i<=N;i++) {
			System.out.println(visitPrint[i]);
		}
	}

}
