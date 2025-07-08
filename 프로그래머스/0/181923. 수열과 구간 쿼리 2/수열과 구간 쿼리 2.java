

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length]; 
    
        for (int i = 0; i < queries.length; i++) {
            int s = queries[i][0];  // start index
            int e = queries[i][1];  // end index
            int k = queries[i][2];  // comparison value
            
            List<Integer> candidates = new ArrayList<>();
            
        
            for(int j = s; j <= e; j++) { 
                if (arr[j] > k) { 
                    candidates.add(arr[j]);
                }
            }
            
            if(candidates.isEmpty()) {
                answer[i] = -1;
            } else {
                answer[i] = candidates.stream().min(Integer::compareTo).get();
            }
        }        
        return answer;
    }
}