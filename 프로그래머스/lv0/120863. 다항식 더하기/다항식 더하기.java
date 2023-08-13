import java.util.regex.Pattern;

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
                if (num.equals("")){
                    numbers += 1;
                } else {
                    numbers += Integer.parseInt(num);
                }
            }
        }
        
        if (numbers == 0 & xs == 0) {
            return "" + 0;
        }
        
        if (xs == 1 && numbers == 0) {
            return "x";
        }
        
        if (xs ==1 && numbers != 00) {
            return "x + " + numbers;
        }
        
        if (numbers == 0){
            return xs + "x";
        }
        
        if (xs == 0) {
            return "" + numbers;
        } 
        
        return xs + "x + " + numbers;
    }
}