class Solution {
    public String solution(String cipher, int code) {
        String[] s = cipher.split("");
        
        String answer = "";
        
        for (int i=0;i<s.length;i++){
            if ((i+1) % code == 0) {
                answer += s[i];
            }
        }
        
        return answer;
    }
}