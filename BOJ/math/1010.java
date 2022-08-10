import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		String[] str;
		for(int t=0;t<T;t++) {
			str=br.readLine().split(" ");
			int N=Integer.parseInt(str[0]);
			int M=Integer.parseInt(str[1]);
			long n=1;
			long r=1;
			long n_r=1;
			int mul=M-N;
			if(N<(M-N)) {
				mul=N;
				N=M-N;
			}
			for(int i=2;i<=M;i++) {
				if(i>N) n*=i;
				if(i<=mul) n_r*=i;
			}
			System.out.println(n/n_r);
		}
	}

}
