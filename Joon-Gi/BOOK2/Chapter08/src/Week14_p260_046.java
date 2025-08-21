// [BOJ] 18352_특정 거리의 도시 찾기

import java.util.*;

public class Week14_p260_046 {
    static int[] visited;
    static ArrayList<Integer>[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 도시 개수
        int M = sc.nextInt(); // 도로 개수
        int K = sc.nextInt(); // 거리 정보
        int X = sc.nextInt(); // 출발 도시 번호

        visited = new int[N + 1];
//        for (int i = 0; i <= N; i++) {
//            visited[i] = -1;
//        }
        Arrays.fill(visited, -1);

        arr = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            arr[A].add(B); // 단방향 그래프
        }

        BFS(X);

        boolean check = false;
        for (int i = 1; i <= N; i++) {
            if (visited[i] == K) {
                System.out.println(i);
                check = true;
            }
        }

        if (!check) {
            System.out.println(-1);
        }
    }

    private static void BFS(int n) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n]++;

        while (!queue.isEmpty()) {
            int temp = queue.poll();
            for (int i : arr[temp]) {
                if (visited[i] == -1) {
                    visited[i] = visited[temp] + 1;
                    queue.add(i);
                }
            }
        }
    }
}
