import java.util.*;


class Solution {
    public static int solution(int[] elements) {
        Set<Integer> sums = new HashSet<>();
        
        // 각 시작 위치에서 모든 길이의 부분 수열을 확인
        for (int start = 0; start < elements.length; start++) {
            int sum = 0;
            
            // 길이 1부터 n까지의 부분 수열
            for (int length = 1; length <= elements.length; length++) {
                
                int index = (start + length - 1) % elements.length;   // 서큘러 인덱스

                sum += elements[index];
                sums.add(sum);  // 중복제거
            }
        }
        
        return sums.size();
    }
}