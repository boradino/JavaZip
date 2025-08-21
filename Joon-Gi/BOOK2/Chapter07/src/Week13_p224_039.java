// [BOJ] 1747_소수 & 팰린드롬
// N은 1,000,000까지지만 답은 1,000,000보다 클 수 있음

import java.util.*;

public class Week13_p224_039 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int i = N;
        while(true) {
            if (isPalindrome(i) && isPrime(i)) {
                System.out.println(i);
                break;
            }
            i++;
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindrome(int number) {
        char[] temp = String.valueOf(number).toCharArray();

        int start = 0, end = temp.length - 1;
        while (start < end) {
            if (temp[start] == temp[end]) {
                start++;
                end--;
            } else {
                return false;
            }
        }
        return true;
    }
}
