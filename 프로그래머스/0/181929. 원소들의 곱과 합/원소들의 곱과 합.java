class Solution {
    public int solution(int[] num_list) {
        int product = 1, sum = 0, sum2 = 0;
        
        for(int i = 0; i < num_list.length; i++){
            product *= num_list[i];
            sum += num_list[i];
        }
        
        sum2 = sum * sum;
        return (product<sum2)?1:0;
    }
}