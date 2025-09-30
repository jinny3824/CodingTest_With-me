import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BigInteger N = new BigInteger(sc.next());
        
        // 이진 탐색
        BigInteger left = BigInteger.ZERO;
        BigInteger right = N;
        BigInteger answer = BigInteger.ZERO;
        
        while (left.compareTo(right) <= 0) {
            BigInteger mid = left.add(right).divide(BigInteger.TWO);
            BigInteger square = mid.multiply(mid);
            
            int cmp = square.compareTo(N);
            
            if (cmp == 0) {
                answer = mid;
                break;
            } else if (cmp < 0) {
                answer = mid;
                left = mid.add(BigInteger.ONE);
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
        }
        
        System.out.println(answer);
    }
}