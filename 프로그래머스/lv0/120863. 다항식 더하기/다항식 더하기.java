import java.util.*;

class Solution {
    public String solution(String polynomial) {
        String[] s = polynomial.split(" \\+ ");

        int numbers = 0;
        int xs = 0;
        for (String num : s){
            if (num.contains("x")){
                num = num.replace("x","");
                
                if (num.equals("")){
                    xs += 1;
                } else {
                    xs += Integer.parseInt(num);
                }
            } else {
                    numbers += Integer.parseInt(num);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        if (xs==0){
            
        } else if (xs==1) {
            sb.append("x");
        } else {
            sb.append(xs + "x");
        }
        
        if (numbers == 0){
            return sb.toString();
        } else if (xs == 0 && numbers != 0) {
            return sb.append(numbers).toString();
        } else {
            sb.append(" + " + numbers);
        }
        
        return sb.toString();
    }
}