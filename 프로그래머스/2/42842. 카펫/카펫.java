class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        
        for(int i = 3; i <= total / i; i++) {  // (i = 세로길이) <= (j = 가로길이)
             if (total % i == 0) {  // 높이가 total의 약수인 경우
                int j = total / i;  
                
                // 노란색 격자 일치 확인
                if ((i - 2) * (j - 2) == yellow) {
                    answer[0] = j; 
                    answer[1] = i; 
                    break;
                }
            }
        }
        return answer;
    }
}