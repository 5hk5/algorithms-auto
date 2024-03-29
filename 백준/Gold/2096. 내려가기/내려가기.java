import java.io.*;
import java.util.StringTokenizer;

/*
* N행 3열 내려가기 - 아래, 대각선으로만 이동하며 누적합 최소값, 최대값 구하기
* 입력 1 : N
* 입력 2 : 행렬
* 출력 : 최대값 최소값
* */
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        // sliding window 알고리즘으로 갱신해갈 dp 배열
        int[] maxArr = new int[3];
        int[] minArr = new int[3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int num0 = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if (i == 0) { // 초기값 세팅
                maxArr[0] = minArr[0] = num0;
                maxArr[1] = minArr[1] = num1;
                maxArr[2] = minArr[2] = num2;
            } else {
                // max
                int originalMax0 = maxArr[0], originalMax2 = maxArr[2];
                maxArr[0] = Math.max(maxArr[0], maxArr[1]) + num0; // DP[i][0] = Math.max(DP[i-1][0], DP[i-1][1]) + newInput[i][0]
                maxArr[2] = Math.max(maxArr[1], maxArr[2]) + num2;
                maxArr[1] = Math.max(Math.max(originalMax0, maxArr[1]), originalMax2) + num1;

                // min
                int originalMin0 = minArr[0], originalMin2 = minArr[2];
                minArr[0] = Math.min(minArr[0], minArr[1]) + num0;
                minArr[2] = Math.min(minArr[1], minArr[2]) + num2;
                minArr[1] = Math.min(Math.min(originalMin0, minArr[1]), originalMin2) + num1;
            }
        }

        bw.write(Math.max(maxArr[0], Math.max(maxArr[1], maxArr[2])) + " ");
        bw.write(Math.min(minArr[0], Math.min(minArr[1], minArr[2])) + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

}

