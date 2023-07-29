class Solution {
    public int solution(int[] array) {
        String s = "";
        
        for (int a : array){
            s += a + "";
        }
        
        int answer = 0;
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='7'){
                answer++;
            }
        }
        
        return answer;
    }
}