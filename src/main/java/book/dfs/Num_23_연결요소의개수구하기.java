package book.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Num_23_연결요소의개수구하기 {

    static ArrayList<Integer>[] A;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        A = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        //  정점 번호는 1 ~ n까지 주어지니, 0부터 n 까지 하면 안된다.

        for (int i = 1; i < n + 1; i++) { // 인접 리스트 초기화하기
            A[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            // 주어진 간선을 읽어서 양방향 그래프를 구성
            A[s].add(e);
            A[e].add(s); // 반대 방향 간선도 추가
        }

        int count = 0;
        for (int i = 1; i < n + 1 ; i++) {  // 모든 정점을 하나씩 확인하면서 방문하지 않은 정점이 있으면 새로운 연결 요소를 발견한 것으로 간주합니다.

            if(!visited[i]){ // 방문하지 않은 노드가 없을때까지 반복하기

                count++; // count: 연결 요소의 개수를 세는 변수
                DFS(i);   //방문하지 않은 정점을 기준으로 DFS를 호출하여 해당 연결 요소를 모두 탐색합니다
            }
        }
        System.out.println(count);
    }

    //  DFS 함수 :  정점 v에서 시작해 연결된 모든 정점을 탐색
    static void DFS(int v){
        if(visited[v]){
            return;
        }
        visited[v] = true; // 탐색 중 방문한 모든 정점은 visited[v] = true로 표시

        for(int i : A[v]){
            // !visited[i]만 재귀적으로 탐색 (false인것만 : 방문하지 않은 것만)
            if(!visited[i]){ // 연결 노드 중 방문하지 않았던 노드만 탐색하기
                DFS(i);
            }
        }
    }
}