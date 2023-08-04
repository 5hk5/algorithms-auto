class Solution {
    public int solution(String s) {
        s = s.replace(" ", "");
        
        String[] nums = s.split("[+-]");
        String[] operators = s.split("[0-9]+");
        
        int answer = Integer.parseInt(nums[0]);
        
        for (int i=1;i<nums.length;i++){
            if (operators[i].equals("+")){
                answer += Integer.parseInt(nums[i]);
            } else {
                answer -= Integer.parseInt(nums[i]);
            }
        }
        
        return answer;
    }
}