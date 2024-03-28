import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
* 온도 연속 합 최대값
* 입력 1 : N K (N: 온도 측정 날짜 수, K : 합 구하기 위한 연속된 날짜 수) (2<=N<=100000, 1<=K<=N)
* 입력 2 : 매일 측정한 온도 배열 (-100<=x<=100)
* 출력 : 온도 수열 중 K일 동안의 온도 합 최대값 출력
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int arrLength = Integer.parseInt(st.nextToken()); // 온도 측정일 수
        int baseDays = Integer.parseInt(st.nextToken()); // 기준 연속일수

        st = new StringTokenizer(br.readLine(), " ");
        int[] temperature = new int[arrLength];
        for (int i=0;i<arrLength;i++){
            temperature[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getMaxSum(baseDays, temperature));
    }

    // temperature 배열 중 baseDays 길이의 연속 수열 최대 합
    private static int getMaxSum(int baseDays, int[] temperature) {
        int start = 0, end = start+baseDays-1, tempSum = 0;

        // 초기값 세팅
        for (int i=0;i<=end;i++){
            tempSum += temperature[i];
        }
        int max = tempSum;

        // 투 포인터
        while(end < temperature.length - 1){
            tempSum += temperature[++end];
            tempSum -= temperature[start++];

            max = Math.max(max, tempSum);
        }

        return max;
    }

}
