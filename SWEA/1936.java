import java.util.Scanner;
public class Solution{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A=sc.nextInt();
		int B=sc.nextInt();
		if (A>B) {
			if (A-B==1) {
				System.out.print('A');
			}
			else {
				System.out.print('B');
			}
		}
		else {
			if (B-A==1) {
				System.out.print('B');
			}
			else {
				System.out.print('A');
			}
			
		}
		sc.close();
	}
}
