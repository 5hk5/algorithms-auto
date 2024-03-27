
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 연속 부분수열의 합
 * 입력 1 : N M (N: 정수 개수, M: 부분수열 합) (1 ≤ N ≤ 10,000, 1 ≤ M ≤ 300,000,000)
 * 입력 1 : 부분수열 (자연수<=30,000)
 * 출력 : 합이 M인 부분수열 개수
 * */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int num = Integer.parseInt(st.nextToken()); // 부분수열 배열 length
        int sum = Integer.parseInt(st.nextToken()); // 부분수열 합

        st = new StringTokenizer(br.readLine(), " ");
        int[] subsequence = new int[num];
        for (int i=0;i<num;i++){
            subsequence[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(countByPointers(sum, subsequence));
    }

    // target 보다 크면 start++, sum-=start
    // target 보다 작으면 end++, sum+=end
    private static int countByPointers(int target, int[] subsequence) {
        int count = 0;

        int start = 0;
        int end = 0;

        int currentSum = 0;
        while (true){
            if (currentSum >= target) {
                currentSum -= subsequence[start++];
            } else if (end >= subsequence.length) {
                break;
            } else {
                    currentSum += subsequence[end++];
            }

            if (currentSum == target) count++;
        }

        return count;
    }

}