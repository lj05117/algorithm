package ws1108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2573_G4 {
    static int section, year, N, M;
    static int[] x= {-1,0,1,0};
    static int[] y= {0,-1,0,1};
    static boolean[][] visited;
    static int[][] map;
    public static void chech_section(int i, int j) {
        visited[i][j]=true;
        for(int d=0;d<4;d++) {
            int dx=i+x[d];
            int dy=j+y[d];
            if(0<=dx && dx<N && 0<=dy && dy<M
                    && !visited[dx][dy]
                            && map[dx][dy]!=0) {
                chech_section(dx, dy);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        N=Integer.parseInt(str[0]);
        M=Integer.parseInt(str[1]);
        map=new int[N][M];
        for(int i=0;i<N;i++) {
            str=br.readLine().split(" ");
            for(int j=0;j<M;j++) {
                map[i][j]=Integer.parseInt(str[j]);
            }
        }
        //-----입력 끝
        year=0;
        int[][] temp=new int[N][M];
        while(section<2) {
            section=0;
            visited=new boolean[N][M];
            //영역 수 체크
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    if(map[i][j]!=0 && !visited[i][j]) {
                        //체크하는 함수로 가기
                        section+=1;
                        chech_section(i,j); //dfs로 해보자
                    }
                }
            }
            if(section==0) { //얼음 다 녹았으면 실패
                year=0;
                break;
            }else if(section>1) {
            	break;
            }
            //-------이제 얼음 녹이기
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    temp[i][j]=0;
                    if(map[i][j]!=0) {
                        int minus=0;
                        for(int d=0;d<4;d++) {
                            int dx=i+x[d];
                            int dy=j+y[d];
                            if(0<=dx && dx<N && 0<=dy && dy<M) {
                            	if(map[dx][dy]==0) {
                                    minus+=1;
                                }
                            }
                            
                        }
                        temp[i][j]=Math.max(map[i][j]-minus,0);
                    }
                }
            }
            for(int i=0;i<N;i++) {
            	for(int j=0;j<M;j++) {
            		map[i][j]=temp[i][j];
            	}
            }
            year+=1;
        }
        System.out.println(year);
        
        //
    }

}
