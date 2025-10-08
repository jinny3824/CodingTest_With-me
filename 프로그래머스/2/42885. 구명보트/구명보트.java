import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int totalCount = 0;
        
        // 오름차순 정렬 (그대로 유지)
        Arrays.sort(people);
        
        // 투 포인터: 가장 가벼운 사람(left), 가장 무거운 사람(right)
        int left = 0;
        int right = people.length - 1;
        
        // 모든 사람을 태울 때까지 반복
        while (left <= right) {
            // 가장 무거운 사람 + 가장 가벼운 사람 <= limit?
            if (people[left] + people[right] <= limit) {
                // 둘 다 태울 수 있음
                left++;   // 가벼운 사람 태웠으니 다음으로
                right--;  // 무거운 사람 태웠으니 다음으로
            } else {
                // 무거운 사람만 혼자 태움
                right--;  // 무거운 사람만 태웠으니 다음으로
            }
            
            // 어쨌든 보트 1개 사용
            totalCount++;
        }
        
        return totalCount;
    }
}