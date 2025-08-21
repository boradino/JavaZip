// [BOJ] 1016_제곱 ㄴㄴ 수
// max - min + 1 - 총 숫자 개수
// 총 숫자 개수에서 나누어 떨어지는 걸 빼자

import java.util.*;

public class Week13_p227_040 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();
        int all_count = (int) (max - min + 1);

        boolean[] isNoNo = new boolean[all_count]; // 기본값 false

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long pow = i * i;
            // min, pow: 12 / min: 12, pow: 9 / min: 12, pow: 16
            long start = (min % pow == 0) ? min : (min / pow + 1) * pow;
            for (long j = start; j <= max; j += pow) {
                isNoNo[(int) (j - min)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i < all_count; i++) {
            if (!isNoNo[i]) answer++;
        }
        System.out.println(answer);
    }
}

