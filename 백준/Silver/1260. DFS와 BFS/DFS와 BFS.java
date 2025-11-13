import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 시작 정점
        
        // 그래프 초기화
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 입력 (양방향)
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 작은 번호부터 방문하기 위해 정렬
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        // DFS 수행
        visited = new boolean[N + 1];
        dfs(V);
        sb.append("\n");
        
        // BFS 수행
        visited = new boolean[N + 1];
        bfs(V);
        
        System.out.print(sb);
    }
    
    // DFS - 재귀 방식
    static void dfs(int node) {
        visited[node] = true;
        sb.append(node).append(" ");
        
        // 인접한 정점들을 작은 번호부터 방문
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
    
    // BFS - 큐 사용
    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int node = queue.poll();
            sb.append(node).append(" ");
            
            // 인접한 정점들을 작은 번호부터 방문
            for (int next : graph[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}