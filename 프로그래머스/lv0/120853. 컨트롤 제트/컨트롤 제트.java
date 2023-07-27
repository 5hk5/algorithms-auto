import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] sArray = s.split(" ");
        Stack<Integer> stack = new Stack<>(); //스택 사용
        
        for (int i=0;i<sArray.length;i++){
            if (sArray[i].equals("Z")){
                stack.pop();
            } else {
                stack.push(Integer.parseInt(sArray[i]));               
            }
        }
        
        while (!stack.isEmpty()){
            answer += stack.pop();
        }    
        
        return answer;
    }
}