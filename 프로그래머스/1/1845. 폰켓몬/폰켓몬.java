import java.util.*;

class Solution {
    public int solution(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        
        int availableNums = nums.length/2; // 가져갈 수 있는 포켓몬 수 = 슬롯
        int totalSpecies = numsSet.size(); // 총 포켓몬 종류
        
        if (availableNums <= totalSpecies) { // 가능한 슬롯보다 실제 종류가 많으면
            return availableNums; // 슬롯 수만 반환 
        }
        
        return totalSpecies; // 슬롯이 더 많으면 실제 종류 수 반환
    }
}