package lanqiaomoni;

import java.util.Scanner;

public class main11 {
    public static void main(String[] args) {
        Scanner lu=new Scanner(System.in);
        int n=lu.nextInt(),m=lu.nextInt();
        int [][] arr=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                arr[i][j]=lu.nextInt();
            }
        }
        int i=0,j=0,k=0,h=n-1,w=m-1;
        for(;(i!=h&&j!=w);){
            k=k+arr[i][j];
            int max=0;
            int x,y;
            if(i!=j||j!=w){
                x=0;y=1;
            }else{
                x=0;y=0;
            }
            for(int cout=0;cout<9;cout++){
                int p=arr[i+x][j+y];
                max=Math.max(max,p);
                if(y+j+1<=w){
                    if(x==0&&y==3){
                        if(x+1+i<=h)
                        {
                            x=1;
                            y=0;
                            x=1;
                        }
                        else{
                            break;
                        }
                    }
                    if(x==1&&y==2){
                        if(x+1+i<=h){
                            x=2;y=0;
                        }
                        else{
                            break;
                        }
                    }
                    if(x==2&&y==1){
                        break;
                    }
                    y++;
                }
                else{
                    break;
                }
            }
            x=0;y=1;
            for(int cout=0;cout<9;cout++){
                int p=arr[i+x][j+y];
                if(p==max){
                    break;
                }
                if(y+j+1<=w){
                    if(x==0&&y==3){
                        if(x+1+i<=h)
                        {
                            x=1;y=0;
                        }
                        else{
                            break;
                        }
                    }
                    if(x==1&&y==2){
                        if(x+1+i<=h){
                            x=2;y=0;
                        }
                        else{
                            break;
                        }
                    }
                    if(x==2&&y==1){
                        break;
                    }
                    y++;
                }
                else{
                    break;
                }
            }
            i=i+x;j=j+y;
        }
        System.out.println(k);
    }
}
