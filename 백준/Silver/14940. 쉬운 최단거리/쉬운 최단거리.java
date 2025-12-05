import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int[][] grid = new int[n][m];
        int[][] distance = new int[n][m];
        int targetX = 0, targetY = 0;
        
        // 거리 배열 초기화 및 지도 입력
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = -1;
                
                if (grid[i][j] == 2) {
                    targetX = i;
                    targetY = j;
                }
            }
        }
        
        // BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{targetX, targetY});
        distance[targetX][targetY] = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (grid[nx][ny] == 1 && distance[nx][ny] == -1) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 0) {
                    sb.append(0);
                } else {
                    sb.append(distance[i][j]);
                }
                
                if (j < m - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        
        System.out.print(sb);
    }
}