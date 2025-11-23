class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        // 각 자릿수를 오른쪽부터 처리
        while (storey > 0) {
            int digit = storey % 10;      // 현재 자릿수 추출
            storey /= 10;                  // 다음 자릿수로 이동
            
            if (digit < 5) {
                // 내림: 현재 자릿수만큼 빼기
                answer += digit;
                
            } else if (digit > 5) {
                // 올림: (10-자릿수)만큼 더하고 다음 자리 올림
                answer += (10 - digit);
                storey++;  // 올림 처리
                
            } else {  // digit == 5
                // 5일 때는 다음 자릿수 확인
                if (storey % 10 >= 5) {
                    // 다음 자릿수가 5 이상 → 올림이 유리
                    answer += 5;
                    storey++;
                } else {
                    // 다음 자릿수가 5 미만 → 내림
                    answer += 5;
                }
            }
        }
        
        return answer;
    }
}