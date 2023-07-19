class Solution {
    public int solution(int i, int j, int k) {
        int count = 0;
        
        for (int a=i;a<=j;a++){
            String s = String.valueOf(a);
            for (int b=0;b<s.length();b++){
                if (s.charAt(b)-'0' == k) {
                    count++;
                }
            }
        }
        
        return count;
    }
}