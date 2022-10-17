import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		String[] str=br.readLine().split(" "); 
		StringBuilder sb=new StringBuilder();
		int N=Integer.parseInt(str[0]); //신청한 동아리 수 입력
		int S=Integer.parseInt(str[1]); //팀원 3명의 능력 합 가입 조건 
		int M=Integer.parseInt(str[2]); //개인의 능력 가입 조건
		int[][] people=new int[N][3]; //모든 사람의 능력을 입력받을 배열 
		for(int n=0;n<N;n++) {
			str=br.readLine().split(" "); //한 줄 씩 입력받아서
			for(int i=0;i<3;i++) {
				people[n][i]=Integer.parseInt(str[i]); // 배열에 입력값 넣기
			}
		}
		//-----------------------------------입력 끝
		int cnt=0; //스마트클럽 가입이 가능한 동아리 수
		boolean ok=true; // 팀원 각각의 능력이 가입조건에 부합하는지 체크할 변수
		int sum=0; //팀원 3명의 능력을 측정하기 위한 변수
		boolean[] visited=new boolean[N]; //동아리에 든 학생들의 능력치를 출력하기 위해 만든 배열
		for(int i=0;i<N;i++) {
			sum=0; //새로운 팀 시작. 팀 능력치 초기화 해주기
			ok=true; //개인의 능력을 체크하기 위한 변수 초기화 해주기
			for(int j=0;j<3;j++) {
				if(people[i][j]<M) { //개인 능력이 미흡한가
					ok=false; //지금 동아리의 팀 능력을 보지 않게 하기 위해 false로 변경
					break; //다음 동아리 보러가기
				}
				sum+=people[i][j]; //개인능력이 되면 팀원 능력을 보기 위해 더해줍니다
			}
			if(ok && sum>=S) { // 개인능력도 되고, 팀원 능력도 조건에 부합하는가 
				cnt+=1; //가능한 동아리 수 증가
				if(cnt==1) sb.append(people[i][0]+" "+people[i][1]+" "+people[i][2]);
				else sb.append(" "+people[i][0]+" "+people[i][1]+" "+people[i][2]);
			}
		}
		
		System.out.println(cnt);
		System.out.println(sb.toString());
//		for(int i=0;i<N;i++) {
//			if(visited[i] && i!=N-1) { //모든 조건에 부합하는가
//				for(int j=0;j<3;j++) {
//					System.out.print(people[i][j]+" "); //동아리원의 개인 능력 출력
//				}
//			}
//			if(visited[i] && i==N-1) {
//				System.out.print(people[i][0]+" "+people[i][1]+" "+people[i][2]);
//			}
//		}
	}
}
