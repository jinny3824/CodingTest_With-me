class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        
        // 1. 상하 조작 횟수 (알파벳 변경)
        for (int i = 0; i < len; i++) {
            char c = name.charAt(i);
            // 위로 가기 vs 아래로 가기 중 최소
            int up = c - 'A';
            int down = 'Z' - c + 1;
            answer += Math.min(up, down);
        }
        
        // 2. 좌우 조작 횟수 (커서 이동)
        int minMove = len - 1;  // 기본: 순방향으로 쭉 가기
        
        for (int i = 0; i < len; i++) {
            int next = i + 1;
            
            // 현재 위치 다음부터 A가 아닌 문자 찾기
            while (next < len && name.charAt(next) == 'A') {
                next++;
            }
            
            // 3가지 이동 전략 비교
            // 1) 순방향: len - 1 (이미 minMove 초기값)
            // 2) i까지 갔다가 되돌아와서 끝에서부터 접근
            int moveRight = i * 2 + (len - next);
            // 3) 끝에서부터 왔다가 i로 접근
            int moveLeft = (len - next) * 2 + i;
            
            minMove = Math.min(minMove, Math.min(moveRight, moveLeft));
        }
        
        answer += minMove;
        return answer;
    }
}