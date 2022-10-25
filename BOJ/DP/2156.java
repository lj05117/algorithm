package ws1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2156 {
	static int[] arr;
	static Integer[] dp;//Integer 타입은 null값 비교 가능
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int T=Integer.parseInt(br.readLine());
		dp=new Integer[T+1];
		arr=new int[T+1];
		for(int i=1;i<T+1;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		dp[0]=0;
		dp[1]=arr[1];
		if(T>1) {
			dp[2]=arr[1]+arr[2];
		}
		System.out.println(recur(T));
	}
	static int recur(int N) {
		if(dp[N]==null) {
			dp[N]=Math.max(Math.max(recur(N-2)
					, recur(N-3)+arr[N-1])+arr[N],
					recur(N-1));
		}
		return dp[N];
	}

}
