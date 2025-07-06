class Solution {
    public int solution(int a, int d, boolean[] included) {
        int sum = 0; int ap[] = new int[included.length];
        
        for(int i = 0; i<included.length; i++) {
            if(i == 0) ap[i] = a;
            else ap[i] = ap[i-1] + d;
            
        sum = (i == 0 && included[i] == true) ? sum + a : (included[i] == true) ? sum+ap[i] : sum+0;

        }
            
            
        return sum;
    }
}