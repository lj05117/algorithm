package ws1013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1952 {
	static int[] cost=new int[4]; 
	static int[] month=new int[13];
	static int result;
	static Queue<calc> months;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		cost=new int[4];
		month=new int[13];
		String[] str;
		for(int t=1;t<=T;t++) {
			str=br.readLine().split(" ");
			for(int i=0;i<4;i++) {
				cost[i]=Integer.parseInt(str[i]);
			}
			str=br.readLine().split(" ");
			months=new LinkedList<>();
			for(int i=1;i<13;i++) {
				month[i]=Integer.parseInt(str[i-1]);
				months.add(new calc(i,Integer.parseInt(str[i-1])));
			}
			
			result=Integer.MAX_VALUE;
			bfs();
			System.out.println("#"+t+" "+result);
		}
	}
	static void bfs() {
		Queue<calc> que=new LinkedList<>();
		que.add(new calc(0,0));
		while(que.size()!=0) {
			calc now=que.poll();
			
			if(now.month>=12) {
				if(result>now.cost)
					result=now.cost;
				continue;
			}
			que.add(new calc(now.month+1, now.cost+cost[0]*month[now.month+1]));
			que.add(new calc(now.month+1, now.cost+cost[1]));
			que.add(new calc(now.month+3, now.cost+cost[2]));
			que.add(new calc(now.month+12, now.cost+cost[3]));
			
		}
	}

}
class calc{
	int month, cost;
	calc(int month, int cost){
		this.month=month;
		this.cost=cost;
	}
}
