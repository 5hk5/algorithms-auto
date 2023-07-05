import java.lang.*;

class Solution {
    public int solution(int n) {
        if ( Math.sqrt(n) == (double) Math.floor(Math.sqrt(n)) ) {
            return 1;
        } else {
            return 2;
        }
    }
}