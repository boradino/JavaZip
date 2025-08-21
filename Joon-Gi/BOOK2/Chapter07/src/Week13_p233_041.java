// [BOJ] 11689_GCD(n, k) = 1
// 오일러 피 함수 P[N]: 1부터 N까지 N과 서로소인 자연수의 개수

import java.util.*;

public class Week13_p233_041 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long temp = n;
        for (long i = 2; i <= Math.sqrt(n); i++) {
            // if (isPrime(i) && (n % i == 0)) {
            if (n % i == 0) {
                temp = temp - (temp / i);

                while (n % i == 0) {
                    n /= i; // 중복 작업 제거
                }
            }
        }

        if (n > 1) {
            temp = temp - (temp / n);
        }
        System.out.println(temp);
    }

    public static boolean isPrime(long number) {
        if (number < 2) return false;

        for (long i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
