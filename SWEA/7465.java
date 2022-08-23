import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution{
	static boolean[] visited;
	static int[] map;
	static int N, M, cnt;
	static List<List<Integer>> LinkedLine;
	static void dfs(int node, boolean first) {
		if(visited[node]!=true) {
			visited[node]=true;
		}
		for(int i=0;i<LinkedLine.get(node).size();i++){
			if(visited[LinkedLine.get(node).get(i)]!=true) {
				dfs(LinkedLine.get(node).get(i), false);
			}
		}
		if(first==true) {
			cnt++;
		}
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1;t<=T;t++) {
			str=br.readLine().split(" ");
			N=Integer.parseInt(str[0]);
			visited=new boolean[N+1];
			M=Integer.parseInt(str[1]);
			LinkedLine=new ArrayList<>();
			for(int i=0;i<=N;i++) {
				LinkedLine.add(new ArrayList<>());
			}
			cnt=0;
			map=new int[N+1];
			for(int i=0;i<M;i++) {
				str=br.readLine().split(" ");
				LinkedLine.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
				LinkedLine.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
			}
			for(int i=1;i<=N;i++) {
				if (visited[i]!=true) {
					dfs(i, true);
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}

}
