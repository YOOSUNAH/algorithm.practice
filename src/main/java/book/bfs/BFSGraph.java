package book.bfs;

import java.util.*;

public class BFSGraph {
        private static List<List<Integer>> A;
        private static boolean[] visited;

        public static void main(String[] args) {
            // 노드 수는 7, 간선 수는 9 (예시 간선 수)
            int N = 7; // 노드 개수
            A = new ArrayList<>();

            // 인접 리스트 초기화 (0번 인덱스를 사용하지 않음)
            for (int i = 0; i <= N; i++) {
                A.add(new ArrayList<>());
            }

            // 간선 추가 (양방향)
            A.get(1).add(2); A.get(2).add(1);
            A.get(1).add(3); A.get(3).add(1);
            A.get(2).add(3); A.get(3).add(2);
            A.get(2).add(4); A.get(4).add(2);
            A.get(2).add(6); A.get(6).add(2);
            A.get(3).add(6); A.get(6).add(3);
            A.get(3).add(7); A.get(7).add(3);
            A.get(4).add(5); A.get(5).add(4);
            A.get(6).add(7); A.get(7).add(6);

            // 방문 기록 초기화
            visited = new boolean[N + 1];

            // BFS 탐색 시작 (1번 노드부터 시작)
            BFS(1);
        }

        // BFS 구현
        private static void BFS(int start) {
            // 큐 생성 및 시작 노드 추가
            Queue<Integer> queue = new LinkedList<>();
            queue.add(start); // 시작점 넣기

            // 방문 처리
            visited[start] = true;

            // 큐가 빌 때까지 반복
            while (!queue.isEmpty()) {
                int node = queue.poll(); // 큐에서 노드 꺼내기
                System.out.print(node + " "); // 노드 출력

                // 인접 노드들 탐색
                for (int neighbor : A.get(node)) {

                    if (!visited[neighbor]) { // 방문하지 않았다면
                        queue.add(neighbor); // 큐에 추가
                        visited[neighbor] = true; // 방문 처리
                    }
                }
            }
        }

}
