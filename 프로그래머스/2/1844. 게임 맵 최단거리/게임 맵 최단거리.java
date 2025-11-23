import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;        // 행 개수
        int m = maps[0].length;     // 열 개수
        
        // 상하좌우 이동 방향 벡터
        int[] dx = {-1, 1, 0, 0};   // 상, 하
        int[] dy = {0, 0, -1, 1};   // 좌, 우
        
        // BFS를 위한 큐 (x좌표, y좌표, 거리)
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 1});  // 시작점 삽입
        maps[0][0] = 0;  // 시작점 방문 처리
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];
            
            // 목적지 도착 확인
            if (x == n-1 && y == m-1) {
                return dist;
            }
            
            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 체크 & 갈 수 있는 길 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1) {
                    maps[nx][ny] = 0;  // 방문 처리
                    queue.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        
        // 도착 불가능
        return -1;
    }
}