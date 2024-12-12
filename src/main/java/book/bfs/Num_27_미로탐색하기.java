package book.bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Num_27_미로탐색하기 {

    // 1은 이동 할 수 있는 칸
    // 0은 이동하 수 없는 칸
    // 서로 인접한 칸으로만 이동할 수 있다 .
    // 이동한 칸을 셀때는 시작 위치와 도착 위치를 포함한다.
    // (1,1) ~ (4,6) ->15칸을 지나야 한다.
    // (1,1) ~ (N, M) -> 지나야 하는 칸수의 최솟 값
    // 코드에서는 (0,0) ~ (N - 1) ~ (M - 1)

    // 인접한 칸의 숫자가 1이면서 아직 방문하지 않았다면 큐에 삽입
    // 종료 지점(N, M)에서 BFS를 종료하며 깊이를 출력한다.
    // (1,1) 에서 출발해 상, 하 , 좌, 우 순서로 노드를 큐에 삽입하며 방문 배열에 체크한다.

    // 상하 좌우를 탐색하기 위한 배열 선언하기
    static int[] dN = {0, 1, 0, -1};  // row(세로) (아래로)
    static int[] dM = {1, 0, -1, 0};  // column(가로) (오른쪽으로)
    //인덱스 0 : dN[0], dM[0]은 (0, 1) 오른쪽 방향
    //인덱스 1 : dN[1], dM[1]은 (1, 0) 아래 방향
    //인덱스 2 : dN[2], dM[2]은 (0, -1) 왼쪽 방향
    //인덱스 3 : dN[3], dM[3]은 (-1, 0) 위쪽 방향

    // N * M 짜리 미로
    private static int N; // row 행 -> 세로
    private static int M; // column 열 -> 가로
    private static int[][] A; // 미로 정보 저장
    private static boolean[][] visited;  // 방문 저장


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // row
        M = Integer.parseInt(st.nextToken()); // column
        A = new int[N][M];
        visited = new boolean[N][M];


//        // v1
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine()); //  101111
//            String line = st.nextToken();  // "101111"
//
//            for (int j = 0; j < M; j++) {
//                A[i][j] = Integer.parseInt(line.substring(j, j + 1)); // 1글자씩 잘라 숫자로 변환 후 배열에 저장
//                //j = 0: line.substring(0, 1) → "1"
//                //j = 1: line.substring(1, 2) → "0"
//                //j = 2: line.substring(2, 3) → "1"
//            }
//        }

        // v2
        // line.charAt(j) - '0'은 문자(char)를 숫자로 변환하는 방법
        //문자는 내부적으로 유니코드 값을 가지고 있습니다. '0'의 유니코드 값은 48이고, '1'의 유니코드 값은 49입니다.
        //따라서 '1' - '0'은 49 - 48 = 1, 즉 숫자 1이 됩니

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            for (int j = 0; j < M; j++) {
                A[i][j] = line.charAt(j) - '0'; // 1, 0을 직접 숫자로 변환하여 저장
            }
        }


        BFS(0, 0);
        System.out.println(A[N - 1][M - 1]);
    }


    public static void BFS(int i, int j) {
        Queue<int[]> queue = new LinkedList<>(); // 정수 배열을 큐에 집어 넣기
        // 큐에 시작 노드 삽입 : 시작점 (0, 0)
        queue.offer(new int[]{i, j});

        //  방문 처리
        visited[i][j] = true;

        // 큐가 비어있을 때까지
        while (!queue.isEmpty()) {

            // 큐에서 현재 좌표를 꺼냄
            int[] now = queue.poll();
            int x = now[0]; // 현재 행
            int y = now[1]; // 현재 열

            for (int k = 0; k < 4; k++) { // 상, 하, 좌, 우 탐색
                int nx = x + dN[k];
                int ny = y + dM[k];
                //    int[] dN = {0, 1, 0,-1};  // row(세로) (아래로)
                //    int[] dM = {1, 0, -1, 0};  // column(가로) (오른쪽으로)
                //    //인덱스 0 : dN[0], dM[0]은 (0, 1) 오른쪽 방향
                //    //인덱스 1 : dN[1], dM[1]은 (1, 0) 아래 방향
                //    //인덱스 2 : dN[2], dM[2]은 (0, -1) 왼쪽 방향
                //    //인덱스 3 : dN[3], dM[3]은 (-1, 0) 위쪽 방향

                if (nx >= 0 && ny >= 0 && nx < N && ny < M && // 유효한 좌표인지 확인 -> 미로 안에 있는지 확인
                        A[nx][ny] == 1 && !visited[nx][ny]  // 이동 가능  : 숫자1이고 & 방문하지 않은 칸
                ) {
                    visited[nx][ny] = true;            // 방문 처리

                    A[nx][ny] = A[x][y] + 1;          // 이동 거리 기록 (그전에서 + 1)
                    // (A[1][0] = A[0][0] + 1)

                    queue.offer(new int[]{nx, ny});   // 다음 칸을 큐에 추가

                }
            }
        }
    }


}
