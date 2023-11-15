class Solution {
    public int[] solution(String s) {
        int[] answer = new int [s.length()];
        answer[0] = -1;
        
        for (int i=1;i<s.length();i++){
            int count = 0;
            
            for (int j=0;j<i;j++){
                if (s.charAt(i) == s.charAt(j)){
                    count++;
                    answer[i] = i-j;
                } 
            }
            
            if (count == 0){
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}