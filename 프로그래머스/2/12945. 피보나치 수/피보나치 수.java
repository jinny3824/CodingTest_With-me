
class Solution {
    public int solution(int n) {
        // 기저 조건
        if (n == 0) return 0;
        if (n == 1) return 1;
        
        // F(0) = 0, F(1) = 1로 시작
        int prev2 = 0;  // F(0)
        int prev1 = 1;  // F(1)
        int current = 0;
        
        // F(2)부터 F(n)까지 계산
        for (int i = 2; i <= n; i++) {
            current = (prev1 + prev2) % 1234567;  // 나머지 연산으로 오버플로우 방지
            prev2 = prev1;  // 이전 값들 업데이트
            prev1 = current;
        }
        
        return current;
    }
}
