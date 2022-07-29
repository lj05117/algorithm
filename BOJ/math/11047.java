import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int[] NN=new int[N];
		int sum=0;
		for(int i=N-1;i>=0;i--) {
			NN[i]=sc.nextInt();
		}
		for(int i=0;i<N;i++) {
			if(NN[i]<=K) {
				sum+=(K/NN[i]);
				K%=NN[i];
			}
		}
		System.out.println(sum);
	}
}
