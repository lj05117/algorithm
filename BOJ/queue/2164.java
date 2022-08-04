import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Queue<Integer> queue=new LinkedList<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			queue.add(i);
		}
		for(int i=0;i<T-1;i++) {
			queue.poll();
			int temp=queue.poll();
			queue.add(temp);
		}
		System.out.println(queue.poll());
	}

}
