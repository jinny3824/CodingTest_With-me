import java.util.*;

class Solution {
    public String solution(String number, int k) {
       
        StringBuilder answer = new StringBuilder();
        
        // 최종 결과의 길이 = 원래 길이 - 제거할 개수
        // 예: "1231234" (7자리) - 3개 제거 = 4자리
        int resultLength = number.length() - k;
        
        // 현재 탐색을 시작할 위치 (처음엔 0부터)
        int start = 0;
        
        // 결과의 각 자리를 하나씩 채워나감 (그리디!)
        for (int i = 0; i < resultLength; i++) {
            // 현재 자리 포함해서 아직 채워야 할 자리 수
            // 예: 4자리 중 첫 번째(i=0)면 remainingCount = 4
            int count = resultLength - i;
            
        
            // = 전체 길이 - 남은 자릿수 (뒤에 충분한 숫자를 남겨둬야 함)
            int end = number.length() - count;
            
            // 현재 범위에서 찾은 최댓값 (일단 '0'으로 초기화)
            char maxChar = '0';
            
            // 최댓값이 위치한 인덱스
            int maxIndex = start;
            
            // 범위에서 max값 찾기
            for (int j = start; j <= end; j++) {
                if (number.charAt(j) > maxChar) {
                    maxChar = number.charAt(j);
                    maxIndex = j;
                }
            }
            
            answer.append(maxChar);
            
            // 다음 탐색은 셀렉된 숫자의 바로 다음부터 (순서유지)            
            start = maxIndex + 1;
        }
        
        return answer.toString();
    }
}