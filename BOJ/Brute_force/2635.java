import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2635_S5 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		String result="";
		String temp;
		int maxNum=1;
		int num=1;
		for(int i=0;i<=N;i++) {
			num=1;
			int now=i;
			int pastNum=N;
			temp=Integer.toString(N);
			while(now>=0) {
				temp+=" "+Integer.toString(now);
				num+=1;
				int swap=now;
				now=pastNum-now;
				pastNum=swap;
			}
			if(num>maxNum) {
				maxNum=num;
				result=temp;
			}
		}
		System.out.println(maxNum);
		System.out.println(result);
		
	}

}
