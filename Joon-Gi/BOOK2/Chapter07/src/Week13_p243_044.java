// [BOJ] 1033_칵테일
// 칵테일 만드는데 필요한 각 재료의 최소 질량을 0번 재료부터 출력
// 모든 재료를 하나의 기준 재료로 통일
/*
예시 풀이
1) 4:0 = 1:1, 4:1 = 3:1, 4:2 = 5:1, 4:3 = 7:1 [N = 5]
--> 105 35 21 15 105

2) 0:1 = 6:4 [N = 2]
--> 3 2

3) 0:1 = 9:8, 1:2 = 9:8, '0:2 = 81:64' [N = 3]
1*9 = 0*8, 1*8 = 2*9
1 = 8/9*0, 8/9*0*8 = 2*9
            0*64/9 = 2*9
            0*64 = 2*81
---> 81 72 64

4) 2:3 = 6:8, 0:1 = 9:3, 3:0 = 7:5, '2:0 = 21:20' [N = 4]
3*5 = 0*7
3 = 0*7/5
2:3 = 3:4
2*4 = 3*3
2*4 = 0*7/5*3
      0*21/5
2*20 = 0*21

0:1 = 3:1, 0:2 = 20:21, 0:3 = 5:7
---> 60 20 63 84
*/

import java.util.*;

public class Week13_p243_044 {
    static ArrayList<int[]>[] arr; // 비율 연결 정보 DFS
    static long[] amount;
    static boolean[] visited;
    static long startValue;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        arr = new ArrayList[N];
        for (int i = 0; i< N; i++) {
            arr[i] = new ArrayList<>();
        }
        amount = new long[N];
        visited = new boolean[N];
        startValue = 1;

        for (int i = 0; i < N - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int p = sc.nextInt();
            int q = sc.nextInt();
            arr[a].add(new int[]{b, p, q});
            arr[b].add(new int[]{a, q, p}); // 반대 방향(양방향)
            startValue *= (p * q / gcd(p, q));
        }

        amount[0] = startValue;
        DFS(0);

        long gcd = amount[0];
        for (int i = 1; i < N; i++) gcd = gcd(gcd, amount[i]);

        // 모든 질량을 최대공약수로 나눠주기
        for (int i = 0; i < N; i++) {
            System.out.print(amount[i] / gcd + " ");
        }
    }

    public static void DFS(int s) {
        visited[s] = true;

        for(int[] next : arr[s]) {
            int to = next[0];
            int p = next[1];
            int q = next[2];
            if(!visited[to]) {
                // amount[s] : amount[to] = p : q 라는 뜻이므로,
                // amount[to] = amount[s] * q / p 이다.
                amount[to] = amount[s] * q / p;
                DFS(to);
            }
        }
    }

    public static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
