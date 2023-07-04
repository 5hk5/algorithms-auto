class Solution {
    public int solution(String s) {
        int sum = 0;
        
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)>='0' && s.charAt(i)<='9'){ //0~9까지의 자연수면
                sum += s.charAt(i)-'0'; //더함
            }
        }
        
        return sum;
    }
}