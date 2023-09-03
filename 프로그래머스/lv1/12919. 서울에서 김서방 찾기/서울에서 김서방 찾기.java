class Solution {
    public String solution(String[] seoul) {
        //값이 Kim인 요소의 index 찾기
        
        int answer = 0;
        
        for (int i=0;i<seoul.length;i++){
            if (seoul[i].equals("Kim")) {
                answer = i;
                break;
            }
        }
        
        return "김서방은 " + answer + "에 있다";
    }
}