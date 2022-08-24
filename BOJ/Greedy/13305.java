import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
	static int N;
	static int[] price;
	static int[] city;	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		price=new int[N-1];
		String[] str=br.readLine().split(" ");
		for(int i=0;i<N-1;i++) {
			price[i]=Integer.parseInt(str[i]);
		}
		str=br.readLine().split(" ");
		city=new int[N];
		for(int i=0;i<N;i++) {
			city[i]=Integer.parseInt(str[i]);
		}
		long sum=0;
		long mincost=city[0];
		for(int i=0;i<N-1;i++) {
			if(city[i]<mincost) {
				mincost=city[i];
			}
			sum+=(mincost*price[i]);
		}
		System.out.println(sum);
	}
}
