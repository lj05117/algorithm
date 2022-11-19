package ws1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

class info{
	int x, y, n, d;
	info(int x, int y, int n, int d){
		this.x=x;
		this.y=y;
		this.n=n;
		this.d=d;
	}
}
public class Solution_2382_모의SW역량테스트 {
	static int[] r= {0,-1,1,0,0};
	static int[] c= {0,0,0,-1,1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=1; t<=T;t++) {
			str=br.readLine().split(" ");
			int N=Integer.parseInt(str[0]);
			int M=Integer.parseInt(str[1]);
			int K=Integer.parseInt(str[2]);
			int[] map;
			boolean[] visited;
			List<info> lists=new LinkedList<>();
			List<info> temp=new LinkedList<>();
			for(int k=0;k<K;k++) {
				str=br.readLine().split(" ");
				lists.add(new info(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]), Integer.parseInt(str[3])));
			}
			for(int m=0;m<M;m++) {
				map=new int[N*N];
				visited=new boolean[N*N];
				int ls=lists.size();
				for(int l=0;l<ls;l++) {
					info now = lists.get(l);
					now.x=now.x+r[now.d];
					now.y=now.y+c[now.d];
					if(now.x==0 || now.y==0|| now.x==N-1 || now.y==N-1) {
						now.n=now.n/2;
						if(now.d%2==1) {
							now.d+=1;
						}else {
							now.d-=1;
						}
					}
					if(!visited[now.x*N+now.y]) {
						visited[now.x*N+now.y]=true;
						map[now.x*N+now.y]=now.n;
						temp.add(now);
					}else { //방문했으면
						if(map[now.x*N+now.y]<now.n) {//현재가 더 크다
							map[now.x*N+now.y]=now.n;
							int ts=temp.size();
							for(int i=0;i<ts;i++) {
								if(temp.get(i).x==now.x
										&& temp.get(i).y==now.y) {
									temp.get(i).x=-1;
									temp.get(i).y=-1;
									now.n+=temp.get(i).n;
									break;
								}
							}
							temp.add(now);
						}else {//이전께 더 크다
							int ts=temp.size();
							for(int i=0;i<ts;i++) {
								if(temp.get(i).x==now.x&&
										temp.get(i).y==now.y) {
									temp.get(i).n+=now.n;
									break;
								}
							}
						}
					}
				}
				
				
//				for(int i=0;i<N*N;i++) {
//					if(visited[i]) {
//						if(map[i]==lists.get(i).n) {
//							temp.add(lists.get(i));
//						}else {
//							
//						}
//					}
//				}
				
				lists.clear();
				int ts=temp.size();
				for(int s=0;s<ts;s++) {
					if(temp.get(s).x!=-1)
						lists.add(temp.get(s));
				}
				temp.clear();
			}
			int result=0;
			int ls=lists.size();
			for(int i=0;i<ls;i++) {
				result+=lists.get(i).n;
			}
			System.out.println("#"+t+" "+result);
		}
	}
}
