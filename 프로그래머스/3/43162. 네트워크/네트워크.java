class Solution {
    private boolean[] visited;  // 방문 여부 체크
    
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        // 모든 컴퓨터를 순회
        for (int i = 0; i < n; i++) {
            // 방문하지 않은 컴퓨터를 발견하면
            if (!visited[i]) {
                dfs(i, computers);  // 해당 네트워크 전체 탐색
                answer++;           // 네트워크 개수 증가
            }
        }
        
        return answer;
    }
    
    private void dfs(int node, int[][] computers) {
        visited[node] = true;  // 현재 노드 방문 처리
        
        // 현재 노드와 연결된 모든 노드 탐색
        for (int i = 0; i < computers.length; i++) {
            // 연결되어 있고, 아직 방문하지 않았다면
            if (computers[node][i] == 1 && !visited[i]) {
                dfs(i, computers);  // 재귀적으로 탐색
            }
        }
    }
}