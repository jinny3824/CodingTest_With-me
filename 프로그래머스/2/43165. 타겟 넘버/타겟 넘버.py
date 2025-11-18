from collections import deque

def solution(numbers, target):
    # (현재 인덱스, 현재까지의 합)
    queue = deque([(0, 0)])
    answer = 0
    
    while queue:
        index, current_sum = queue.popleft()
        
        # 모든 숫자를 사용한 경우
        if index == len(numbers):
            if current_sum == target:
                answer += 1
            continue
        
        # 현재 숫자를 더하거나 빼는 경우
        queue.append((index + 1, current_sum + numbers[index]))
        queue.append((index + 1, current_sum - numbers[index]))
    
    return answer