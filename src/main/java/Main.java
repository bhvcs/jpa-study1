import java.util.*;
import java.io.*;

public class Main{
    public static int N = 0;
    public static int[][] arr;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());

        arr = new int[N+1][N+1];

        int i, j, current = 1;

        for(i=0; i<N; i++){
            current = makeSnail(i, current);
        }
        for(i = 1; i < N+1; i++){
            for(j =1; j < N+1; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        int number = Integer.parseInt(br.readLine());
        findNumber(number);
    }
    public static int makeSnail(int i, int current){
        int s,t;
        for(s = N-i+1; s <= N+i; s++){
            arr[N-i][s] = current++;
        }
        for(s = N-i+1; s <= N+i; s++){
            arr[s][N+i] = current++;
        }
        for(s = N+i-1; s >= N-i; s--){
            arr[N+i][s] = current++;
        }
        for(s = N+i-1; s >= N-i; s--){
            arr[N-i][s] = current++;
        }
        return current;
    }

    public static void findNumber(int number) {
        int i, s;
        for(i = 1; i <= N; i++){
            if(number >= i*i && number < (i+1) * (i+1)) break;
        }
        for(s = N-i+1; s <= N+i; s++){
            if( arr[N-i][s] == number ){
                System.out.println(s + " " + (N-i));
                return;
            }
        }
        for(s = N-i+1; s <= N+i; s++){
            if( arr[s][N+i] == number ){
                System.out.println((N+i) + " " + s);
                return;
            }
        }
        for(s = N+i-1; s >= N-i; s--){
            if( arr[N+i][s] == number ){
                System.out.println(s + " " + (N+i));
                return;
            }
        }
        for(s = N+i-1; s >= N-i; s--){
            if( arr[N-i][s] == number ){
                System.out.println(s + " " + (N-i));
                return;
            }
        }
    }
}