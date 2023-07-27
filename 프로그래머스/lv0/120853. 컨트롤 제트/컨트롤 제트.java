import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String[] sArray = s.split(" ");
        List<Integer> list = new ArrayList<>();
        
        for (int i=0;i<sArray.length;i++){
            if (sArray[i].equals("Z")){
                list.remove(list.size()-1);
            } else {
                list.add(Integer.parseInt(sArray[i]));               
            }
        }
        
        for (int i=0;i<list.size();i++){
            answer += list.get(i);
        }
        
        return answer;
    }
}