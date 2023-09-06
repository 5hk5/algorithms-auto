class Solution {
    public long solution(int a, int b) {
        if (a == b) return a;
        
        int temp = 0;
        if (a > b) {
            temp = a;
            a = b;
            b = temp;
        } 
        
        long answer = 0;
        for (int i=a;i<=b;i++){
            answer += i;
        }
        
        return answer;
    }
}