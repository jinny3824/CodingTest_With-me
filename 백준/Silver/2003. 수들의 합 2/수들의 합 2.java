import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
        
        int count = 0;
        for (int i = 0; i < N; i++) {
            int currentSum = 0;
            for (int j = i; j < N; j++) {
                currentSum += A[j];
                if (currentSum == M) {
                    count++;
                } else if (currentSum > M) {
                    break; // 더 이상 볼 필요 없음
                }
            }
        }
        
        System.out.println(count);
    }
}