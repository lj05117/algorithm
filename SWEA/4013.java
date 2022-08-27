import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution{

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String[] str;
		Queue<Integer> queue = new LinkedList<>();
		for (int t = 1; t <= T; t++) {
			int K = Integer.parseInt(br.readLine());
			int[][] gear = new int[4][8];
			for (int i = 0; i < 4; i++) {
				str = br.readLine().split(" ");
				for (int j = 0; j < 8; j++) {
					gear[i][j] = Integer.parseInt(str[j]);
				}
			}
			int[] change = new int[4];
			for (int k = 1; k <= K; k++) {
				str = br.readLine().split(" ");
				int[] moveGear = new int[2];
				moveGear[0] = Integer.parseInt(str[0]) - 1;
				moveGear[1] = Integer.parseInt(str[1])*(-1);
				boolean[] visited = new boolean[4];
				int[] temp = new int[4];

				queue.add(moveGear[0]);
				temp[moveGear[0]] = moveGear[1];

				while (queue.size() != 0) {
					int nowGearNum = queue.poll();
					visited[nowGearNum] = true;

					if (nowGearNum > 0 
							&& visited[nowGearNum-1] != true 
							&& gear[nowGearNum][(30 + change[nowGearNum])% 8] != gear[nowGearNum - 1][(26 + change[nowGearNum - 1]) % 8]) {
						temp[nowGearNum - 1] = temp[nowGearNum] * (-1);
						queue.add(nowGearNum - 1);
					}
					if (nowGearNum < 3 
							&& visited[nowGearNum + 1] != true 
							&& gear[nowGearNum][(26 + change[nowGearNum])% 8] != gear[nowGearNum + 1][(30 + change[nowGearNum + 1]) % 8]) {
						temp[nowGearNum + 1] = temp[nowGearNum] * (-1);
						queue.add(nowGearNum + 1);
					}

				}
				for (int i = 0; i < 4; i++) {
					change[i]+=temp[i];
				}
			}
			
			System.out.println("#"+t+" "+(gear[0][(24+change[0])%8]+2*gear[1][(24+change[1])%8]+4*gear[2][(24+change[2])%8]+8*gear[3][(24+change[3])%8]));
		}
	}
}
