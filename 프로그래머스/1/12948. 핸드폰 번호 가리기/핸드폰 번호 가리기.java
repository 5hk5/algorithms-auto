class Solution {
    public String solution(String p) {
        String str = "*";
        int pLength = p.length();
        
        return str.repeat(pLength-4)  + p.substring(pLength-4, pLength);
    }
}