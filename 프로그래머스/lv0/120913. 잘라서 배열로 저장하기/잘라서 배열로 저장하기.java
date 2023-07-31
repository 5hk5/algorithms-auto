class Solution {
    public String[] solution(String s, int n) {
        int arrayLength = (int) Math.ceil((double) s.length() / n);
        
        String[] answer = new String[arrayLength];
    
        int count = 0;
        for (int i=0;i<s.length();i+=n){
            if (i + n > s.length()){
                answer[count] = s.substring(i);
            } else {
                answer[count] = s.substring(i,i+n);
            }
            count++;
        }
        
        return answer;
    
    }
}