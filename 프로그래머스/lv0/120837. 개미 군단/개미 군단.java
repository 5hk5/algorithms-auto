class Solution {
    public int solution(int hp) {
        int general = 5; //장군개미
        int soldier = 3; //병정개미
        int worker = 1; //일개미
        
        int count = 0; //총 병력
        
        count += hp / general; //장군개미 수
        count += (hp % general) / soldier; //병정개미 수
        count += hp % general % soldier; //일개미 수

        return count;
    }
}