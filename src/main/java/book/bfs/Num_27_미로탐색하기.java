package book.bfs;

import java.util.*;

public class Num_27_미로탐색하기 {

    private static List<List<Integer>> A;
    private static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N  = sc.nextInt(); // 노드 개수
        int M  = sc.nextInt(); // 에지 개수
        int Start = sc.nextInt(); // 시작점

        A = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
           A.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();

            A.get(s).add(e);
            A.get(e).add(s);
        }

        // 방문할 수 있는 노드가 여러개일 경우에는 번호가 작은 것을 먼저 방문하기 위해 정렬하기
        for (int i = 1; i <= N; i++) {
            // 각 노드와 관련된 에지를 정렬하기
            Collections.sort(A.get(i));
        }

        // visited 초기화
        visited = new boolean[N + 1];
        BFS(Start);
    }

    // BFS 구현하기
    private static void BFS(int Node){
        // 큐 자료 구조에 시작 노드 삽입하기 (add 연산)
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(Node);

        // visted 배열에 현재 노드 방문하기
        visited[Node] = true;

        // 큐가 빌 때까지 계속 탐색
        while(!queue.isEmpty()){
            // 큐에서 노드 데이터 가져오기  (poll연산)
            int nowNode = queue.poll();
            // 가져온 노드 출력하기
            System.out.print(nowNode + " ");

            // 현재 노드의 연결 노드 중 미방문 노드를 큐에 삽입하고 방문 배열에 기록하기
            for(int i : A.get(nowNode)){

                if(!visited[i]){
                    // 아직 방문하지 않은 노드를 큐에 넣고 방문 표시
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
