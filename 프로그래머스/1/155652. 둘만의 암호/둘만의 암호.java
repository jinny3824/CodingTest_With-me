class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            char newChar = shiftChar(currentChar, skip, index);
            result.append(newChar);
        }
        
        return result.toString();
    }
    
    private char shiftChar(char start, String skip, int index) {
        char current = start;
        int count = 0;
        
        while (count < index) {
            current++;
            // z를 넘어가면 a로 돌아감
            if (current > 'z') {
                current = 'a';
            }
            
            // skip에 포함된 문자가 아닐 때만 카운트 증가
            if (skip.indexOf(current) == -1) {
                count++;
            }
        }
        
        return current;
    }
}