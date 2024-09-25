class Solution {
    
    private static int answer = 0;
    
    public int solution(int[] numbers, int target) {        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    // 재귀
    // 정수 배열, 타겟 넘버, depth, 계산합
    private static void dfs(int[] numbers, int target, int depth, int sum){
        if (depth == numbers.length){
            if (target == sum) answer++;
            return;
        }
        
        dfs(numbers, target, depth+1, sum-numbers[depth]);
        dfs(numbers, target, depth+1, sum+numbers[depth]);
    }
}