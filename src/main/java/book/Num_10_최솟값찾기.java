package book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Num_10_최솟값찾기{ //백준에서는 Main으로 class명을 설정해야함.
    /*
     * 슈도코드 작성하기 
     * N (데이터 개수) 
     * L (최소값을 구하는 범위)
     * Dequeue<Node> mydeque (데이터를 담을 덱 자료구조)
     * 배열 선언하기 
     * 
     * for(N만큼 반복){
     * now(현재 데이터 값)
     *     덱의 마지막 위치에서부터 now보다 큰 값은 덱에서 제거하기
     *     덱의 마지막 위치에 now값 저장하기
     *     덱의 1번째 위치에서부터 L의 범위를 벗어난 값(now index - L <= index)을 덱에서 제거하기
     *     덱의 1번째 데이터 출력하기
     * }
     * 
     * 덱에 저장할 노드 클래스 별도 생성하기 
     * 노드 클래스에서 index(자신의 위치), value(자신의 값) 담기
     *  
     */


    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException{ 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 버퍼에 넣고 한번에 출력하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 숫자의 갯수
        int L = Integer.parseInt(st.nextToken()); // 슬라이딩 윈도우 크기 
        st = new StringTokenizer(br.readLine()); // 숫자들
        Deque<Node> mydeque =new LinkedList<>();

        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            
            // 새로운 값이 들어올때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거해 시간 복잡도를 줄임
            while (!mydeque.isEmpty() && mydeque.getLast().value > now) {
              mydeque.removeLast();   
            }

            // 덱의 마지막 위치에 now값 저장하기
            mydeque.addLast(new Node(now, i));

            // 범위에서 벗어난 값은 덱에서 제거
            if(mydeque.getFirst().index <= i - L){
                mydeque.removeFirst();
            }
            // 덱의 1번째 데이터 출력하기
            bw.write(mydeque.getFirst().value + " ");
        }

        bw.flush();
        bw.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
