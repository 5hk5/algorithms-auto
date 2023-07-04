class Solution {
    public int solution(int n) {        
        int sum=0; //숫자 합
        
        for (int i=0;i<String.valueOf(n).length();i++){
            sum += String.valueOf(n).charAt(i)-'0';
        }
        
        return sum;
    }
}