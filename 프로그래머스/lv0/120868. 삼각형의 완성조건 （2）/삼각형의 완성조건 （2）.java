class Solution {
    public int solution(int[] sides) { //가장 긴 변 < 다른 두 변 길이 합
        int count = 0;
        
        int shorter = Math.min(sides[0], sides[1]);
        int longer = Math.max(sides[0], sides[1]);
        
        int other = longer - shorter + 1;
        //1. 배열 내 가장 긴 변 있을 때
        //longer < shorter + X
        while (other <= longer){
            count++;
            other++;
        }
        
        other = shorter + longer - 1;
        //2. 배열에 가장 긴 변 없을 때
        //X < shorter + longer
        while (other!= longer && other > 0){
            count++;
            other--;
        }
        
        return count;
    }
}