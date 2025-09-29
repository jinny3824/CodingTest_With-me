import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙
        int soldiers = n;
        
        for (int i = 0; i < enemy.length; i++) {
            // 1. 일단 현재 적을 병사로 막는다고 가정
            soldiers -= enemy[i];
            heap.add(enemy[i]);  // 힙에 추가
            
            // 2. 병사가 부족한가?
            if (soldiers < 0) {
                if (k > 0) {
                    // 지금까지 막은 것 중 가장 큰 것을 무적권으로 변경
                    int maxEnemy = heap.poll();  // 최대값 추출
                    soldiers += maxEnemy;  // 병사 돌려받음
                    k--;  // 무적권 사용
                } else {
                    // 무적권도 없고 병사도 부족 -> 게임 종료
                    return i;  // 현재 라운드 직전까지만 클리어
                }
            }
        }
        
        // 모든 라운드 클리어
        return enemy.length;
    }
}