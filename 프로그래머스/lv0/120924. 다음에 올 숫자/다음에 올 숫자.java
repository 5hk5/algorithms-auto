class Solution {
    public int solution(int[] common) {
        int[] checkMinus = new int[common.length-1];
        int[] checkMultiple = new int[common.length-1];
        
        for (int i=0;i<common.length-1;i++){
            if (common[i]==0) {
                return common[common.length-1] + common[1] - common[0];
            } 
            
            checkMinus[i] = common[i+1] - common[i];
            checkMultiple[i] = common[i+1] / common[i];
        }
        
        if (checkMinus[0] == checkMinus[1]) {
            return common[common.length-1] + checkMinus[0];
        } else {
            return common[common.length-1] * checkMultiple[0];
        }
    }
}