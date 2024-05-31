package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Graph1_easy {

    static class Graph {

        private int[][] arr;  // 인접 행렬
        private Map<Integer, Integer> map; // 인접행렬과 정점 매핑
        private int vertexCount;  // 정점의 개수
        private int edgeCount; // 간선의 개수

        public Graph(int N) {
            arr = new int[N][N];
            map = new HashMap<>();
            vertexCount = 0;
            edgeCount = 0;
        }

        // 정점을 그래프에 추가
        public void addVertex(int vertex) {
            if (!map.containsKey(vertex)){
                map.put(vertex, vertexCount++);  // 정점 개수 증가
            }
        }

        /*
        * 두 정점 사이에 간선 추가
        *  이미 간선이 존재하거나, 정점이 존재하지 않으면 false를 반환
        * */
        public boolean addEdge(int from, int to){
           // 정점의 인덱스를 각각 얻음  (정점이 그래프에 존재하는지 확인하기 위해서 가져오는 것)
            Integer fromIdx = map.get(from);
            Integer toIdx = map.get(to);

            // 정점이 존재하지 않으면 false를 반환
            if(fromIdx == null || toIdx == null){
                return false;
            }

            // 이미 간선이 존재하면 false 반환
            if(arr[fromIdx][toIdx] == 1){
                return false;
            }

            // 간선 추가  (무향이니 양쪽에)
            arr[fromIdx][toIdx] = 1;
            arr[toIdx][fromIdx] = 1;
            edgeCount++; // 간선 개수 증가

            return true;
        }

        // 정점의 개수
        public int getVertexCount(){
            return vertexCount;
        }

        // 간선의 개수
        public int getEdgeCount(){
            return edgeCount;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();   // 정점의 개수 5
        int M = sc.nextInt();   // 간선의 개수 9

        Graph graph = new Graph(N);

        for (int i = 0; i < N; i++) {
            int I = sc.nextInt(); // 5 20 952 1 45
            graph.addVertex(I);
        }
            for (int k = 0; k < M; k++) {
                int from = sc.nextInt(); // S
                int to = sc.nextInt(); // D

                if (!graph.addEdge(from, to)){
                    System.out.println(-1);
                }
        }
            // 정점의 개수 , 간선의 개수
        System.out.println(graph.getVertexCount() + " " + graph.getEdgeCount());

        sc.close();
    }
}




