import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] newArr1 = new String[n];
        String[] newArr2 = new String[n];
        
        // 2진수 배열 생성
        for (int i=0;i<n;i++){
            String temp = "" + Integer.toBinaryString(arr1[i]);
            String temp2 = "" + Integer.toBinaryString(arr2[i]);
            
            if (temp.length() < n) {
                temp = "0".repeat(n-temp.length()) + temp;
            }
            newArr1[i] = temp;
            
            if (temp2.length() < n) {
                temp2 = "0".repeat(n-temp2.length()) + temp2;
            }
            newArr2[i] = temp2;
        }
        
        String[] answer = new String[n];
        // #, 0 배열 생성
        for (int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder();
            
            for (int j=0;j<n;j++){
                if (newArr1[i].charAt(j) == '0' && newArr2[i].charAt(j) == '0'){
                    sb.append(" ");
                } else {
                    sb.append("#");
                }
            }
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}