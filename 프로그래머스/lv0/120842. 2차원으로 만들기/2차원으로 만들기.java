class Solution {
    public int[][] solution(int[] nums, int n) {
        
        int[][] answer = new int[nums.length/n][n];
        
        int index = -1;
        for (int i=0;i<nums.length/n;i++){
            for (int j=0;j<n;j++){
                index++;
                answer[i][j] = nums[index];
            }
        }
        
        return answer;
        
    }
}