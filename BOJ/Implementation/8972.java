package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class pos{
    int x;
    int y;
    pos(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Main_8972_G3{
    static int[] y= {0,-1,0,1,-1,0,1,-1,0,1};
    static int[] x= {0,1,1,1,0,0,0,-1,-1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str=br.readLine().split(" ");
        int N=Integer.parseInt(str[0]);
        int M=Integer.parseInt(str[1]);
        char[][] map=new char[N][M];
        char[][] temp=new char[N][M];
        boolean[][] visited=new boolean[N][M];
        String strr;
        int ix=0;
        int iy=0;
        LinkedList<pos> whereR=new LinkedList<>();
        for(int i=0;i<N;i++) {
            strr=br.readLine();
            for(int j=0;j<M;j++) {
                map[i][j]=strr.charAt(j);
                if(map[i][j]=='I') {
                    ix=i;
                    iy=j;
                }else if(map[i][j]=='R') {
                    whereR.add(new pos(i,j));
                }
            }
        }
        int stop=0;
        strr=br.readLine();
        for(int l=0;l<strr.length();l++) {
        	stop=0;
            temp=new char[N][M];
            visited=new boolean[N][M];
            int direction=strr.charAt(l)-'0';
            //I부터 이동시키기
            int tempx=ix+x[direction];
            int tempy=iy+y[direction];
            temp[tempx][tempy]='I';
            ix=tempx;
            iy=tempy;
            //R이동시키기 - temp배열에 이동 시키기
            int rLen=whereR.size();
            for(int d=0;d<rLen;d++) {
            	int minDistance=Integer.MAX_VALUE;
            	int rx=0;
            	int ry=0;
                pos nowR = whereR.pop();
                for(int i=1;i<10;i++) {
                	if(0<=(nowR.x+x[i]) && (nowR.x+x[i])<N && 0<=nowR.y+y[i] && nowR.y+y[i]<M) {
                		if(Math.abs(nowR.x+x[i]-tempx)+Math.abs(nowR.y+y[i]-tempy)<minDistance) {
                    		minDistance=Math.abs(nowR.x+x[i]-tempx)+Math.abs(nowR.y+y[i]-tempy);
                    		rx=nowR.x+x[i];
                    		ry=nowR.y+y[i];
                    		
                    	}
                		
                	}
                	
                	
                }
                if(temp[rx][ry]=='I') {
        			System.out.println("kraj "+(l+1));
        			stop=1;
        			break;
        		}
                
                if(!visited[rx][ry]) {
                	visited[rx][ry]=true;
                	temp[rx][ry]='R';
                }else {
                	temp[rx][ry]='.';
                }
            }
            
            //팔방탐색해가지고 최소값 측정하기
            
            
            //배열 복사하기
            for(int i=0;i<N;i++) {
                for(int j=0;j<M;j++) {
                    map[i][j]=temp[i][j];
                    if(temp[i][j]=='R') {
                    	 whereR.add(new pos(i,j));
                    }
                }
            }
            if(stop==1) break;
        }
        if(stop!=1)
        for(int i=0;i<N;i++) {
        	for(int j=0;j<M;j++) {
        		if((map[i][j]-'A')>26 || (map[i][j]-'A')<1) {
        			map[i][j]='.';
        		}
        		System.out.print(map[i][j]);
        	}
        	System.out.println();
        }
        
    }

}
