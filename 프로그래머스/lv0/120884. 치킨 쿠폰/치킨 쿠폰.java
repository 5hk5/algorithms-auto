class Solution {
    public int solution(int chicken) {
        // 1치킨 1쿠폰 발급
        // 10쿠폰 1서비스 치킨 (1서비스 치킨에도 1쿠폰 발급)
        
        int coupon = chicken; //새로 받은 쿠폰
        int leftCoup = 0; //남은 쿠폰
        int serviceChick = 0; //서비스치킨 수
        
        while (coupon + leftCoup >= 10){ //쿠폰 10개 미만될 때까지
            int temp1 = (coupon + leftCoup) / 10;
            int temp2 = (coupon + leftCoup) % 10;
            
            coupon = temp1;
            leftCoup = temp2;
            
            serviceChick += coupon;
        }
        
        return serviceChick;
    }
}