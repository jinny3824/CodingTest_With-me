class Solution {
    public int solution(int n, String control) {
    for (int i = 0; i < control.length(); i++) {
    n = (control.charAt(i) == 'w') ? n+1 : (control.charAt(i) == 's') ? n-1 : (control.charAt(i) == 'd') ? n+10 : n-10;
}
        return n;
    }
}