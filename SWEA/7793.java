package ws1007;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
 
class pos{
    int x, y;
    public pos(int x, int y){
        this.x=x;
        this.y=y;
    }
}
public class Solution_7793 {
     
    static int[] r= {0,-1,0,1};
    static int[] c= {-1,0,1,0};
     
    public static void main(String[] args) throws NumberFormatException, IOException {
         
        // TODO Auto-generated method stub
//      long beforeTime=System.currentTimeMillis();
 
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        String[] str;
        int T=Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++) {
            str=br.readLine().split(" ");
            int N=Integer.parseInt(str[0]);
            int M=Integer.parseInt(str[1]);
            char [][] map=new char[N][M];
            LinkedList<pos> devil=new LinkedList<>();
            LinkedList<pos> suyon=new LinkedList<>();
             
            String st;
            for(int i=0;i<N;i++) {
                st=br.readLine();
                for(int j=0;j<M;j++) {
                    map[i][j]=st.charAt(j);
                    if(map[i][j]=='*') {
                        devil.add(new pos(i,j));
                    }else if(map[i][j]=='S') {
                        suyon.add(new pos(i,j));
                    }
                }
            }
            boolean visit=false;
            int cnt=0;
             
            while(suyon.size()>0 && !visit) {
                cnt+=1;
              
                int d=devil.size();
                for(int a=0;a<d;a++) {
                    pos now =devil.poll();
                    for(int i=0;i<4;i++) {
                        int dr=now.x+r[i];
                        int dc=now.y+c[i];
                        if(0<=dr && dr<N && 0<=dc && dc<M
                                &&( map[dr][dc]=='.'
                                || map[dr][dc]=='S')) {
                            map[dr][dc]='*';
                            devil.add(new pos(dr,dc));
                        }
                    }
                }
                 
 
                int s=suyon.size();
                for(int a=0;a<s;a++){
                    pos now=suyon.poll();
                    for(int i=0;i<4;i++) {
                        int dr=now.x+r[i];
                        int dc=now.y+c[i];
                        if(0<=dr && dr<N && 0<=dc && dc<M) {
                            if( map[dr][dc]=='.') {
                            	map[dr][dc]='S';
                                suyon.add(new pos(dr,dc));
                            }
                            else if(map[dr][dc]=='D') {
                                visit=true;
                                break;
                            }
                            
                        }
                    }
                }
            }
             
            if(visit)
                System.out.println("#"+t+" "+cnt);
            else
                System.out.println("#"+t+" GAME OVER");
//          long afterTime=System.currentTimeMillis();
//          long secDiffTime=(afterTime-beforeTime)/100;
//          System.out.println("**"+secDiffTime);
        }
         
    }
 
}
