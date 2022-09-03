import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static int N, M;
	static ArrayList<Integer>[] area;
	static int[] people;
	static boolean[] visited;
	static int min=Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		area=new ArrayList[N+1];
		people=new int[N+1];
		for(int i=1;i<=N;i++) {
			area[i]=new ArrayList<>();
		}
		String[] str=br.readLine().split(" ");
		for(int i=1;i<=N;i++) {
			people[i]=Integer.parseInt(str[i-1]);
		}
		for(int i=1;i<=N;i++) {
			str=br.readLine().split(" ");
			M=Integer.parseInt(str[0]);
			for(int j=1;j<=M;j++) {
				area[i].add(Integer.parseInt(str[j]));
				area[Integer.parseInt(str[j])].add(i);
			}
		}
		visited=new boolean[N+1];
		subset(1);
		System.out.println(min==Integer.MAX_VALUE?-1:min);
	}
	private static void subset(int cnt) {
		if(cnt==N) {
			ArrayList<Integer> a=new ArrayList<>();
			ArrayList<Integer> b=new ArrayList<>();
			for(int i=1;i<=N;i++) {
				if(visited[i]) {
					a.add(i);
				}else {
					b.add(i);
				}
			}
			if(a.size()+b.size()!=N)return;
			if(a.size()==0 || b.size()==0)return;
			if(isPossible(a,'a') && isPossible(b,'b')) {
				int sum=0;
				for(int i=0;i<a.size();i++) {
					sum+=people[a.get(i)];
				}
				int sum2=0;
				for(int i=0;i<b.size();i++) {
					sum2+=people[b.get(i)];
				}
				min=Math.min(min, Math.abs(sum-sum2));
			}
			return;
		}
		visited[cnt]=true;
		subset(cnt+1);
		visited[cnt]=false;
		subset(cnt+1);
	}
	private static boolean isPossible(ArrayList<Integer> a, char team) {
		boolean[] connect=new boolean[N+1];
		int cur=a.get(0);
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(cur);
		connect[cur]=true;
		while(q.size()!=0) {
			int temp=q.poll();
			for(int j=0;j<area[temp].size();j++) {
				int next=area[temp].get(j);
				if(connect[next]) continue;
				if((team=='a'&&visited[next])||(team=='b'&& visited[next]==false)) {
					q.add(next);
					connect[next]=true;
				}
			}
		}
		for(int i=0;i<a.size();i++) {
			if(!connect[a.get(i)])return false;
		}
		return true;
	}
}
