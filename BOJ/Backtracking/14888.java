import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] operList;
	static int N;
	static boolean[] check;
	static int[] numList;
	static int max=Integer.MIN_VALUE;
	static int min=Integer.MAX_VALUE;
	static int[] combinationList;
	static void calculation(int cnt, int index) {
		if(index>=0 
				&& index<N) {
			check[index]=true;
			combinationList[cnt-1]=index;
		}
		if(cnt==N-1) {
			int sum=numList[0];
			for(int i=0;i<N-1;i++) {
				if(operList[combinationList[i]]==0) {
					sum+=numList[i+1];
				}else if(operList[combinationList[i]]==1) {
					sum-=numList[i+1];
				}else if(operList[combinationList[i]]==2) {
					sum*=numList[i+1];
				}else {
					if(sum<0) {
						sum=(sum*(-1)/numList[i+1])*(-1);
					}else if(sum==0) {
						continue;
					}else {
						sum/=numList[i+1];
					}
				}
			}
			if (sum>max) max=sum;
			if(sum<min) min=sum;
		}
		
		for(int i=0;i<operList.length;i++) {
			if(check[i]!=true) {
				calculation(cnt+1, i);
			}
		}
		if(index!=-1)
			check[index]=false;
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine());
		numList=new int[N];
		String[] str=br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			numList[i]=Integer.parseInt(str[i]);
		}
		str=br.readLine().split(" ");
		combinationList=new int[N-1];
		operList=new int[N-1];
		check=new boolean[N-1];
		
		int ind=0;
		for(int i=0;i<4;i++) {
			if(Integer.parseInt(str[i])!=0) {
				int strI=Integer.parseInt(str[i]);
				for(;strI>0;strI--) {
					operList[ind]=i;
					ind++;
				}
			}
		}
		calculation(0,-1);
		System.out.println(max);
		System.out.println(min);
	} 

}
