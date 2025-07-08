class Solution {
    public String solution(String code) {
        String ret = ""; 
        int mode = 0;
        
        for (int i = 0; i < code.length(); i++) {
            if (code.charAt(i) == '1') {
                mode = 1 - mode;  // 0→1, 1→0 토글
            } else {
                if (mode == 0 && i % 2 == 0) {
                    ret += code.charAt(i);
                } else if (mode == 1 && i % 2 == 1) {
                    ret += code.charAt(i);
                }
            }
        }
        
        return ret.isEmpty() ? "EMPTY" : ret;
    }
}
