#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

// arr_len은 배열 arr의 길이입니다.
int* solution(int arr[], size_t arr_len) {
    // stk 배열과 stk의 현재 크기를 저장할 변수
    int* stk = (int*)malloc(sizeof(int) * arr_len);
    int stk_size = 0;
    
    // i를 0으로 초기화
    int i = 0;
    
    // i가 arr의 길이보다 작을 때까지 반복
    while (i < arr_len) {
        // stk가 비어있으면
        if (stk_size == 0) {
            stk[stk_size++] = arr[i];
            i++;
        }
        // stk의 마지막 원소가 arr[i]보다 작으면
        else if (stk[stk_size - 1] < arr[i]) {
            stk[stk_size++] = arr[i];
            i++;
        }
        // stk의 마지막 원소가 arr[i]보다 크거나 같으면
        else {
            stk_size--;  // 마지막 원소 제거
        }
    }
    
    // 실제 사용된 크기만큼 재할당 (선택사항)
    stk = (int*)realloc(stk, sizeof(int) * stk_size);
    
    return stk;
}