// [BOJ] 1850_최대 공약수 구하기

import java.util.*;

public class Week13_p237_043 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long A = sc.nextLong();
        long B = sc.nextLong();

        long gcd = GCD(A, B);
        System.out.println(gcd);

        StringBuilder sb = new StringBuilder();
        while (gcd > 0) {
            sb.append(1);
            gcd--;
        }
        System.out.println(sb.toString());
    }

    public static long GCD(long a, long b) {
        long temp = 0L;

        while (b != 0) {
            temp = b % a;
            a = b;
            b = temp;
        }
        return a;
    }
}
