package algorithm2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_S2_24444_알고리즘수업_너비우선탐색1 {
	static int[][] line;
	static int[] print;
	static int cnt,N, M;
	static Queue<Integer> queue=new LinkedList<>();
	static List<List<Integer>> list=new ArrayList<>();
	static void bfs(int R) {
		queue.add(R);
		print[R]=++cnt;
		while(queue.size()!=0) {
			int u=queue.poll();
			for(int i=0;i<list.get(u).size();i++) {
				int next=list.get(u).get(i);
				if(print[next]!=0) 
					continue;
				queue.add(next);
				print[next]=++cnt;
				
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
		for(int i=0;i<N+1;i++) {
			list.add(new ArrayList<>());
		}
		print=new int[N+1];
		for(int i=0;i<M;i++) {
			str=br.readLine().split(" ");
			list.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			list.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(list.get(i));
		}
		
		bfs(R);
		for(int i=1;i<=N;i++) {
			System.out.println(print[i]);
		}
	}
}
