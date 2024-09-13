package book;


import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;


public class Num_04_구간합구하기2 { //백준에서는 Main으로 class명을 설정해야함.
    // D[i][j]의 값을 채우는 구간 합 공식
    // D[i][j] = D[i][j -1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j]
    // X1, Y1, X2, Y2 에 대한 답을 구간 합으로 구하는 방법
    // D[X2][Y2] - D[X1 -1][Y2] - D[X2][Y1 - 1] + D[X1 - 1][Y1 -1]
    

    // N (배열 크기) , M (질의 수) 지정하기 
    // for(N만큼 반복하기){
    //   for(N만큼 반복하기){
    //     원본 배열 저장하기   
    // } }

    // for(N만큼 반복하기){
    //   for(N만큼 반복하기){
    //     합 배열 저장하기   
    //     D[i][j] =D[i][j - 1] + D[i -1][j] - D[i - 1][j - 1] + A[i][j];
    // } }
    // for(M만큼 반복하기){
    //   질의 계산 및 출력하기 
    //   결과 = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 -1] + D[x1 -1][y1 -1];
    // }


    public static void main(String[] args) throws Exception{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A[][] = new int[N + 1][N + 1];

        // 원본 배열 저장하기 
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 합 배열 저장하기
        int D[][] = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                D[i][j] = D[i][j - 1] + D[i - 1][j] - D[i - 1][j - 1] + A[i][j];
            }
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 구간 합 배열로 질의에 답변하기 
            int result = D[x2][y2] - D[x1 - 1][y2] - D[x2][y1 - 1] + D[x1 - 1][y1 - 1];
            System.out.println(result);
        } 
    }
}
