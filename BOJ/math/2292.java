import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
		int N=sc.nextInt();
		int sum=1;
		int n=1;
		int tot=1;
		while(tot<N) {
			sum++;
			tot+=n*6;
			n++;
		}
		System.out.println(sum);
	}
}
