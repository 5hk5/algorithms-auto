class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int maxHor = board[0]/2;
        int maxVer = board[1]/2;
        
        int[] location = {0,0};
        
        for (String key : keyinput){            
            if (key.equals("up") && location[1] < maxVer){
                location[1]++;
            } else if (key.equals("down") && location[1] > -maxVer){
                location[1]--;
            } else if (key.equals("right") && location[0] < maxHor){
                location[0]++;
            } else if (key.equals("left") && location[0] > -maxHor){
                location[0]--;
            }
        }

        return location;
    }
}