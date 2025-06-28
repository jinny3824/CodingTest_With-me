class Solution {
    public int solution(int n) {
        int evensum = 0, oddsum = 0;
            
        for(int i = 0; i <= n; i++)
            if(i % 2 == 0)
                evensum = evensum+(i*i);
            else 
                oddsum = oddsum + i;
    
        return (n % 2 == 0) ? evensum : oddsum;
    }
}