import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 나무 필요 => 높이 제한선 지정 시 그 위로 잘린 부분만 가져감
    // ex. 20, 15, 10, 17m 나무 => 제한선 15면 5+2=7m 가져감
    // 입력 1 : treeNum neededHeight (treeNum: 나무 수, neededHeight: 필요한 나무 길이) (1 ≤ treeNum ≤ 1,000,000, 1 ≤ neededHeight ≤ 2,000,000,000)
    // 입력 2 : 각 나무 길이
    // 출력 : 필요한 나무 길이 이상 가져갈 수 있도록 하는 제한선 최대값
    // => 배열 최대값 기준 이진탐색, 꼭대기 값들 합 구해감
    // => 절단 나무 길이 합 - 필요 나무 길이 비교, 최대 제한선 구함 (합>=neededHeight)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int treeNum = Integer.parseInt(st.nextToken());
        int neededLength = Integer.parseInt(st.nextToken());

        int maxHeight = 0;
        int[] trees = new int[treeNum];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i=0;i<treeNum;i++){
            trees[i] = Integer.parseInt(st.nextToken());
            if (trees[i] > maxHeight) maxHeight = trees[i];
        }

        System.out.println(binarySearch(trees, 0, maxHeight, neededLength));
    }

    // 제한선 위 나무길이 합(최소값) >= 필요 길이 일 때, 제한선 구하기
    private static int binarySearch(int[] trees, int bottom, int top, int neededLength) {
        int answer = 0;

        while (bottom <= top){
            int mid = (top - bottom) / 2 + bottom;
            long sum = sumTreeLength(mid, trees); // 제한선 위 나무 길이 합

            if (sum >= neededLength){
                answer = mid;
                bottom = mid + 1;
            } else if (sum < neededLength){
                top = mid - 1;
            }
        }

        return answer;
    }

    // 제한선 위 나무 길이 합 = Σ(trees[i]-제한선)
    private static long sumTreeLength(int line, int[] trees) {
        long sum = 0;

        for (int i=0;i<trees.length;i++){
            if (line < trees[i]){
                sum += trees[i] - line;
            }
        }

        return sum;
    }

}