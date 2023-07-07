class Solution {
    public int[] solution(int n, int[] numlist) {
        int count = 0;
        for (int i=0;i<numlist.length;i++){
            if (numlist[i] % n == 0) {
                count++;
            }
        }
        
        int[] newArray = new int[count];
        
        int arrayCount = 0;
        for (int i=0;i<numlist.length;i++){
            if (numlist[i] % n == 0) {
                newArray[arrayCount] = numlist[i]; 
                arrayCount++;
            }
        }
        
        return newArray;
    }
}