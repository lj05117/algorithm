import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	static class dust {
		int r, c, value;

		public dust(int r, int c, int value) {
			this.r = r;
			this.c = c;
			this.value = value;
		}
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		int R = Integer.parseInt(str[0]);
		int C = Integer.parseInt(str[1]);
		int T = Integer.parseInt(str[2]);
		int[][] room = new int[R][C];
		int airCleaner = 0;
		int[] dR = { -1, 0, 1, 0 };
		int[] dC = { 0, 1, 0, -1 };
		int[] cleanerUR = { 0, -1, 0, 1 };
		int[] cleanerUC = { 1, 0, -1, 0 };
		int[] cleanerDR = { 0, 1, 0, -1 };
		int[] cleanerDC = { 1, 0, -1, 0 };
		Queue<dust> queue = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < C; j++) {
				room[i][j] = Integer.parseInt(str[j]);
				if (room[i][j] == -1) {
					airCleaner = i - 1;
				} else if (room[i][j] != 0) {
					queue.add(new dust(i, j, room[i][j]));
				}
			}
		}

		for (int t = 0; t < T; t++) {
			int queuesize = queue.size();
			int[][] dustSpread = new int[R][C];
			for (int i = 0; i < queuesize; i++) {
				dust temp = queue.poll();
//				int dCnt = 0;
				int valueForMinus=0;
				for (int d = 0; d < 4; d++) {
					int r = dR[d] + temp.r;
					int c = dC[d] + temp.c;
					if (0 <= r && r < R && 0 <= c && c < C && !(r == airCleaner && c == 0)
							&& !(r == airCleaner + 1 && c == 0)) {
						valueForMinus+=temp.value / 5;
						dustSpread[r][c] += temp.value / 5;
					}
				}
				dustSpread[temp.r][temp.c] += temp.value - valueForMinus;
//				if((temp.value-temp.value/5*dCnt)>4) {
//					queue.add(new dust(temp.r, temp.c, temp.value-temp.value/5*dCnt));
//				}
				// queue에 넣기
			}
			room = dustSpread;
			room[airCleaner][0]=-1;
			room[airCleaner+1][0]=-1;
//			for (int i = 0; i < R; i++) {
//				for (int j = 0; j < C; j++) {
//					if (dustSpread[i][j] > 0) {
//						queue.add(new dust(i, j, room[i][j]));
//					}
//
//				}
//			}

			// 공기청정기 돌리기
			int upR = airCleaner;
			int upC = 0;
			int changeValue = 0, temp = 0;
			for (int d = 0; d < 4; d++) {
				upR += cleanerUR[d];
				upC += cleanerUC[d];
				while (0 <= upR && upR < R && 0 <= upC && upC < C 
						&& !((upR == airCleaner) && (upC == 0))) {
					temp = room[upR][upC];
					room[upR][upC] = changeValue;
					changeValue = temp;
					upR+=cleanerUR[d];
					upC+=cleanerUC[d];
				}
				upR -= cleanerUR[d];
				upC -= cleanerUC[d];
			}
			int downR = airCleaner + 1;
			int downC = 0;
			changeValue = 0;
			temp = 0;
			for (int d = 0; d < 4; d++) {
				downR += cleanerDR[d];
				downC += cleanerDC[d];
				while (0 <= downR && downR < R && 0 <= downC && downC < C 
						&& !((downR == airCleaner+1) && (downC == 0))) {
					temp = room[downR][downC];
					room[downR][downC] = changeValue;
					changeValue = temp;
					downR += cleanerDR[d];
					downC += cleanerDC[d];
				}
				downR -= cleanerDR[d];
				downC -= cleanerDC[d];
			}
			
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (dustSpread[i][j] > 0) {
						queue.add(new dust(i, j, room[i][j]));
					}

				}
			}
			
		}
		int sum=2;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sum+=room[i][j];
			}
		}
		System.out.println(sum);
	}

}
