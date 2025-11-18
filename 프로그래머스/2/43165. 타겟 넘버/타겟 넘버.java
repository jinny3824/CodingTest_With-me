class Solution {
    private int answer = 0;  // 클래스 멤버 변수
    
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0, 0);
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int index, int currentSum) {
        // 모든 숫자를 다 사용한 경우
        if (index == numbers.length) {
            if (currentSum == target) {
                answer++;
            }
            return;
        }
        
        // 현재 숫자를 더하는 경우
        dfs(numbers, target, index + 1, currentSum + numbers[index]);
        
        // 현재 숫자를 빼는 경우
        dfs(numbers, target, index + 1, currentSum - numbers[index]);
    }
}