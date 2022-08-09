
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int cnt=N;
		if(N>99) {
			cnt=99;
			for(int i=100;i<=N;i++) {
				if((i/100==0)||((i/100-i/10%10)==(i/10%10-i%10)))
					cnt++;

			}
		}
		System.out.println(cnt);
	}

}
