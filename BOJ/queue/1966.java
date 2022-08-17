import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		String[] strr;
		Queue<Integer> queue;
		PriorityQueue<Integer> maxHeap;
		for(int t=0;t<T;t++) {
			str=br.readLine().split(" ");
			strr=br.readLine().split(" ");
			queue=new LinkedList<>();
			maxHeap=new PriorityQueue<>(Collections.reverseOrder());
			int I=Integer.parseInt(str[0]);
			for(int i=0;i<I;i++) {
				queue.add(Integer.parseInt(strr[i]));
				maxHeap.add(Integer.parseInt(strr[i]));
			}
			int ind=Integer.parseInt(str[1]);
			int indNow=0;
			int cnt=0;
			
			while(cnt<I) {
				int temp=queue.poll();
				int tempMax=maxHeap.poll();
				if(temp==tempMax) {
					cnt++;		
					if(ind==0) break;
				}else {
					queue.add(temp);
					maxHeap.add(tempMax);
				}
				
				ind--;
				if(ind<0) ind=queue.size()-1;
			}
			System.out.println(cnt);
		}
	}

}
