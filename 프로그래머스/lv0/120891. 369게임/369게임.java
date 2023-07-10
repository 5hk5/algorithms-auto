class Solution {
    public int solution(int order) {
        String s = String.valueOf(order);
        
        int count = 0;
        for (int i=0;i<s.length();i++){
            int num = s.charAt(i) - '0';
            if (num == 3 || num == 6 || num == 9){
                count++;
            }
        }
        
        return count;
    }
}