class Solution {
    public int solution(int n, int[] money) {
        // dp[i] = 금액 i를 만드는 방법의 수
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 0원: 아무것도 안 쓰기 (1가지)
        
        // 각 동전에 대해
        for (int coin : money) {
            // 해당 동전으로 만들 수 있는 모든 금액 업데이트
            for (int i = coin; i <= n; i++) {
                dp[i] = (dp[i] + dp[i - coin]) % 1000000007;
            }
        }
        
        return dp[n];
    }
}