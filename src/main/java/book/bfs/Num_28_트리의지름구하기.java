package book.bfs;

import java.io.IOException;
import java.util.*;

public class Num_28_트리의지름구하기 {

    private static boolean[] visited;
    private static int[] distance;

    // A 인접리스트에, 트리구조 저장, 각 노드마다 연결된 노드와 거리 정보를 저장합니다.
    private static ArrayList<Edge>[] A;

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
       // 노드 개수
       int N = sc.nextInt();
        A = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) { // 노드 번호 1 부터 시작
            A[i] = new ArrayList<>();
        }


        // 1 3 2 -1
        // 3과 2는 에지 정보
        // 1 --- (3, 2) 노드 1은  노드 3과 거리가 2인 에지로 연결됨.
        for (int i = 0; i < N; i++) {
        // 인접 리스트에 저장하기
            int S = sc.nextInt(); // 노드 번호 : 1
            while(true){
                int E = sc.nextInt(); // 노드 번호 : 3
                if(E == -1) // 더이상 노드가 없다 종료한다.
                    break;
                int V = sc.nextInt(); // 거리 : 2
                A[S].add(new Edge(E, V)); // 1 --- (3,2)
            }
        }

        distance = new int[N + 1];
        visited = new boolean[N + 1];

        // 임의점으로 BFS 수행
        BFS(1);

        // 가장 먼 노드찾기
        int maxNode = 1;
        for (int i = 2; i <= N; i++) {
            if(distance[maxNode] < distance[i]){
                maxNode = i;
            }
        }

        // 초기화
        distance = new int[N + 1];
        visited = new boolean[N + 1];

        // 가장 먼 노드에서 다시 BFS 수행
        BFS(maxNode);

        // 트리의 지름 찾기 (최대 거리)
        int diameter = 0;
        for (int i = 1; i <= N; i++) {
            diameter = Math.max(diameter, distance[i]);
        }
        System.out.println(diameter);
    }

    public static void BFS(int index){
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(index);

        visited[index] = true;

        while(!queue.isEmpty()){
            int now = queue.poll();

            for(Edge i : A[now]){
                int e = i.e; // 연결된 노드
                int v = i.value; // 거리

                if(!visited[e]){
                    visited[e] = true;
                    queue.add(e);

                    // 거리 배열 업데이트 하기
                    // 현재 노드까지의 거리 + 다음 노드로 가는 간선 거리
                    distance[e] = distance[now] + v;
                }
            }
        }
    }
    public static class Edge{
        int e; // 연결된 노드
        int value;  // 거리

        public Edge(int e, int value){
            this.e = e;
            this.value = value;
        }
    }
}
