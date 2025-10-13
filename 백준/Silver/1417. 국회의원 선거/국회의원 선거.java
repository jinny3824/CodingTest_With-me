import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int dasom = Integer.parseInt(br.readLine());
        
        // 후보가 1명이면 매수 불필요
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        // 다른 후보들의 득표수를 리스트에 저장
        ArrayList<Integer> votes = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            votes.add(Integer.parseInt(br.readLine()));
        }
        
        int count = 0;
        
        // 다솜이가 1등이 될 때까지 반복
        while (true) {
            // 최댓값 찾기
            int max = Collections.max(votes);
            
            // 다솜이가 최댓값보다 크면 종료
            if (dasom > max) {
                break;
            }
            
            // 최댓값의 인덱스 찾기
            int maxIndex = votes.indexOf(max);
            
            // 최댓값에서 1표 빼앗기
            votes.set(maxIndex, max - 1);
            dasom++;
            count++;
        }
        
        System.out.println(count);
    }
}