import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        while(n >= 0){
            if(n % 5 == 0){  // n을 5로 나눈 나머지
                cnt += n / 5;
                System.out.println(cnt);
                return;  // 반드시 종료!
            }
            n -= 3;
            cnt++;
        }
        
        System.out.println(-1);  // while 탈출 = 불가능
    }
}
