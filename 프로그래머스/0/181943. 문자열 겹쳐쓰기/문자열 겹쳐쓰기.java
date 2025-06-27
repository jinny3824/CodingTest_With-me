class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        
        
        char[] my_string_arr = my_string.toCharArray();
        char[] overwrite_string_arr = overwrite_string.toCharArray();

       for(int i= s; i < s + overwrite_string.length(); i++){
           
           
           my_string_arr[i] = overwrite_string_arr[i-s];
       }
        
        answer = String.valueOf(my_string_arr);
        
        return answer;
    }
}