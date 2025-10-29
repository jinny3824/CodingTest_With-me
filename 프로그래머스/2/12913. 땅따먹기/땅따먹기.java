class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int[][] dp = new int[n][4];
        
        // 1단계: 첫 행 초기화
        for(int j = 0; j < 4; j++){
            dp[0][j] = land[0][j];
        }
        
        // 2단계: DP 테이블 채우기
        for(int i = 1; i < n; i++){
            for(int j = 0; j < 4; j++){
                // 현재 열 j를 선택할 때, 이전 행의 다른 열 중 최댓값 찾기
                for(int k = 0; k < 4; k++){
                    if(j != k){
                        dp[i][j] = Math.max(dp[i][j], dp[i-1][k] + land[i][j]);
                    }
                }
            }
        }
        
        // 3단계: 마지막 행에서 최댓값 찾기
        int answer = 0;
        for(int j = 0; j < 4; j++){
            answer = Math.max(answer, dp[n-1][j]);
        }
        
        return answer;
    }
}