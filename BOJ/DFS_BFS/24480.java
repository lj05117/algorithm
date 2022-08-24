import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main{
	static List<List<Integer>> list;
	static boolean[] visited;
	static int[] visitedPrint;
	static int N, M, cnt;
	static void dfs(int start) {
		visited[start]=true;
		visitedPrint[start]=++cnt;
		for(int i=0;i<list.get(start).size();i++) {
			if(visited[list.get(start).get(i)]!=true) {
				dfs(list.get(start).get(i));
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
		list=new ArrayList<>();
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<>());
		}
		visited=new boolean[N+1];
		visitedPrint=new int[N+1];
		for(int i=0;i<M;i++) {
			str=br.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		for(int i=1;i<=N;i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		dfs(R);
		for(int i=1;i<=N;i++) {
			System.out.println(visitedPrint[i]);
		}
	}
	

}
