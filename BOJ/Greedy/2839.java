
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		int fiveNum=N/5;
		int need=-1;
		while(fiveNum>=0) {
			if((N-5*fiveNum)%3==0) { 
				need=fiveNum+((N-5*fiveNum)/3);
				break;
			}
			fiveNum-=1;
		}
		System.out.println(need);
		
	}

}
