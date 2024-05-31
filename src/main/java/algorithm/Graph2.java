package algorithm;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph2 {

    static class Graph {

        private int[][] arr;  // 인접 행렬
        private Map<Integer, Integer> map; // 인접행렬과 정점 매핑
        private int vertexCount;  // 정점의 개수
        private int edgeCount; // 간선의 개수
        private Map<String, String> edgeInfo; // 간선 정보 저장

        public Graph(int N) {
            arr = new int[N][N];
            map = new HashMap<>();
            edgeInfo = new LinkedHashMap<>();
            vertexCount = 0;
            edgeCount = 0;
        }

        // 정점을 그래프에 추가
        public void addVertex(int vertex) {
            if (!map.containsKey(vertex)) {
                map.put(vertex, vertexCount++);  // 정점 개수 증가
            }
        }

        /*
         * 두 정점 사이에 간선 추가
         *  이미 간선이 존재하거나, 정점이 존재하지 않으면 false를 반환
         * */
        public boolean addEdge(int from, int to, String info) {
            // 정점의 인덱스를 각각 얻음  (정점이 그래프에 존재하는지 확인하기 위해서 가져오는 것)
            Integer fromIdx = map.get(from);
            Integer toIdx = map.get(to);

            // 정점이 존재하지 않으면 false를 반환
            if (fromIdx == null || toIdx == null) {
                return false;
            }

            // 이미 간선이 존재하면 false 반환
            if (arr[fromIdx][toIdx] == 1) {
                return false;
            }

            // 간선 추가  (무향이니 양쪽에)
            arr[fromIdx][toIdx] = 1;
            arr[toIdx][fromIdx] = 1;
            edgeCount++; // 간선 개수 증가

            // 간선 정보 저장 (양쪽 저장하면, 출력 두번씩 됨, 한쪽만 저장하기)
            edgeInfo.put(from + "-" + to, info);

            return true;
        }

        // 정점의 개수
        public int getVertexCount() {
            return vertexCount;
        }

        // 간선의 개수
        public int getEdgeCount() {
            return edgeCount;
        }

        public boolean delete(int L) {
            Integer idx = map.get(L);
            if (idx == null) {
                return false; // 정점이 존재하지 않으면 false
            }
            // 연결된 간선 제거 하기
            for (int i = 0; i < arr.length; i++) {
                if (arr[idx][i] == 1) {
                    arr[idx][i] = 0;
                    arr[i][idx] = 0;
                    edgeCount--; // 간선 개수 감소

                    // 간선 정보 삭제
                    edgeInfo.remove(L + "-" + getKey(i));
                    edgeInfo.remove(getKey(i) + "-" + L);
                }
            }
            // 정점 삭제
            map.remove(L);
            return true;
        }

        // 인덱스로 정점 찾기
        private int getKey(int value) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue().equals(value)) {
                    return entry.getKey();
                }
            }
            return -1;
        }

        // 모든 간선 정보
        public String getInfo() {
            StringBuilder sb = new StringBuilder();
            for (String info : edgeInfo.values()) {
                sb.append(info).append(" ");
            }
            return sb.toString().trim();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 정점의 개수
        int M = sc.nextInt();   // 간선의 개수
        int K = sc.nextInt();  // 삭제할 정점 개수

        Graph graph = new Graph(N);

        for (int i = 0; i < N; i++) {
            int I = sc.nextInt();
            graph.addVertex(I);
        }
        sc.nextLine(); // 줄바꿈 제거

        for (int j = 0; j < M; j++) {
            int from = sc.nextInt(); // S
            int to = sc.nextInt(); // D
            String info = sc.nextLine(); // U

            if (!graph.addEdge(from, to, info)) {
                System.out.println(-1);
            }
        }
        // 정점의 개수 , 간선의 개수
        System.out.println(graph.getVertexCount() + " " + graph.getEdgeCount());

        // 삭제할 정점
        for (int i = 0; i < K; i++) {
            int L = sc.nextInt();
            if (!graph.delete(L)) {
                System.out.println(-1);
            } else {
                System.out.println(graph.getEdgeCount() + " " + graph.getInfo());
            }
        }
        sc.close();
    }
}




