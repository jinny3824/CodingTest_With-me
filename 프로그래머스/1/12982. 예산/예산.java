import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int sum = 0, result = 0;
        Arrays.sort(d); // 어레이 소트 메소드로 오름차순 정렬
        for(int i = 0; i < d.length; i++){
            if(d[i]+sum <= budget){
                sum+=d[i]; 
                result++;}
            else{break;}
            }
        
        return result;
    }
}