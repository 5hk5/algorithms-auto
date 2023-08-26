class Solution {
    public int solution(String[] babbling) {
        int count = 0;
        
        for (int i=0;i<babbling.length;i++){
            if (babbling[i].replaceAll("aya|ye|woo|ma","").equals("")){
                count++;
            }
        }
        
        return count;
    }
}