// [BOJ] 1456_거의 소수

import java.util.*;

public class Week13_p220_038 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();
        boolean[] isPrime = new boolean[(int) Math.pow(10, 7) + 1];
        for (int i = 2; i < isPrime.length; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= Math.sqrt(B); j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int answer = 0;
        for (int i = 2; i <= Math.sqrt(B); i++) {
            if (isPrime[(int) i]) {
                long temp = i;
                while (temp <= B) {
                    if (temp >= A) answer++;

                    temp *= i;
                }
            }
        }

        System.out.println(answer);
    }
}
