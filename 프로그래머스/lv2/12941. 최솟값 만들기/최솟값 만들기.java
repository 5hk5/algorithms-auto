import java.util.*;

class Solution
{
    public int solution(int []A, int []B)
    {
        PriorityQueue<Integer> newA = new PriorityQueue<>();
        PriorityQueue<Integer> newB = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i=0;i<A.length;i++){
            newA.add(A[i]);
            newB.add(B[i]);
        }
        
        int sum = 0;
        for (int i=0;i<A.length;i++){
            sum += newA.poll() * newB.poll();
        }
        
        return sum;
    }
}