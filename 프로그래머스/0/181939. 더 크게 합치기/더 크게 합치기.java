class Solution {
    public int solution(int a, int b) {
       String answer_str1 = "", answer_str2 = "";
        int answer = 0;
        
        answer_str1 = Integer.toString(a) + Integer.toString(b);
        answer_str2 = Integer.toString(b) + Integer.toString(a); 
        
        int answer1 = Integer.parseInt(answer_str1);
        int answer2 = Integer.parseInt(answer_str2);
        
        if(answer1 >= answer2){
            answer = answer1;
        }
        else answer = answer2;
        
        return answer;
    }
}