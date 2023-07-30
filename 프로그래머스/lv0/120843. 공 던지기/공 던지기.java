class Solution {
    public int solution(int[] numbers, int k) {
        int index = 2 * k - 2;
        
        if (index < numbers.length){
            return numbers[index];
        }
        
        int indexN = index % numbers.length;
        
        return numbers[indexN];
    }
}