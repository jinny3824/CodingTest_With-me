import java.util.*;
class Solution {
    public int solution(int x, int y, int n) {
        
        
        if (x == y) { // 시작부터 같을 때 예외처리
            return 0;
        }
        
        Queue<int[]> queue = new LinkedList<>(); //BFS 큐
        Set<Integer> visited = new HashSet<>();  // 방문 체크 set
        
        // 초기값
        queue.add(new int[]{x, 0}); // {현재값, 연산횟수}
        visited.add(x);
        
        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int currentValue = current[0];
            int steps = current[1];
            
            // 3가지 연산 수행
            int[] nextValues = {
                currentValue + n,    // 덧셈
                currentValue * 2,    // 2배
                currentValue * 3     // 3배
            };
            
            for (int nextValue : nextValues) {
                // 목표값에 도달했으면 연산횟수 반환
                if (nextValue == y) {
                    return steps + 1;  // 0부터 시작했으니까
                }
                
                // 범위 체크 및 방문 체크
                // 곱셈의 경우 y를 넘으면 더 이상 의미 없음
                // 덧셈의 경우 y보다 조금 클 수도 있지만 너무 크면 비효율적
                if ( nextValue <= y * 2 && !visited.contains(nextValue)) {
                    visited.add(nextValue);
                    queue.add(new int[]{nextValue, steps + 1});
                }
            }
        }
        
        // y에 도달할 수 없는 경우
        return -1;
    }
}