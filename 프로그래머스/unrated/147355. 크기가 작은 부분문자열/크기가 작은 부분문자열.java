class Solution {
    public int solution(String t, String p) {
        int pLength = p.length();
        long pNum = Long.parseLong(p);
        
        int answer = 0;
        for (int i=0;i<=t.length()-pLength;i++){
            int startIndex = i;
            int endIndex = i + pLength;
            
            if (Long.parseLong(t.substring(startIndex, endIndex)) <= pNum){
                answer++;
            }
        }
        
        return answer;
    }
}