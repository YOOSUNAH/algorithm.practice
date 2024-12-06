package book.dfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Num_25_친구관계파악하기 {
    private static List<List<Integer>> A;
    private static boolean[] visited;
    private static boolean arrive;

    public static void main(String[] args) throws IOException{
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  // 사람의 수
        int m = sc.nextInt();  // 친구 관계의 수

        A = new ArrayList<>();
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            A.add(new ArrayList<>()); // 그래프 초기화
        }

        for (int i = 0; i < m; i++) { // 친구 관계
            int s = sc.nextInt();
            int e = sc.nextInt();

            // 양방향 간선 추가
            A.get(s).add(e);
            A.get(e).add(s);
        }

        for (int i = 0; i < n; i++) { // n은 사람의 수이기 때문에, 모든 사람에 대해 한 번씩 DFS를 실행
            dfs(i, 1);

            if(arrive) // arrive가 true로 설정되면, 5명의 연속된 친구 관계가 이미 발견되었다는 의미
                break;  // 친구 관계가 발견되면 더 이상 탐색할 필요 없음
        }

        if(arrive){
            System.out.println("1");
        }else {
            System.out.println("0");
        }
    }

    // DFS 함수
    private static void dfs(int now, int depth){

        // DFS의 종료 조건
        // 깊이가 5가 되면,
        // or 연속된 친구 관계가 발견되면
        if(depth == 5 || arrive){
            arrive = true;
            return;
        }

        // 방문 배열에 현재 노드 방문 기록하기
        visited[now] = true;

        // 현재 노드의 연결 노드 중 방문하지 않은 노드로 DFS 실행하기
        // (호출할 때마다 depth +1)
        for (int i : A.get(now)) {
            if (!visited[i]) {
                dfs(i, depth + 1); // 호출마다 depth는 1씩 증가
            }
        }

        // dfs 탐색을 끝나고 나서는 다시 false 로 설정해, 다른 경로에서 이 노드를 다시 방문할 수 있게 한다.
        visited[now] = false;
        // DFS에서 한 번 방문한 노드는 다시 방문하지 않도록 해야 하므로,
        // DFS를 시작할 때 해당 노드를 visited[now] = true;로 표시하고,
        //
        // 탐색이 끝난 후 다시 그 노드를 visited[now] = false;로 설정하여
        // 다른 경로에서 이 노드를 다시 방문할 수 있도록 한다.
    }
}