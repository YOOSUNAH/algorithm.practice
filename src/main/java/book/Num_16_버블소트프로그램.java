package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num_16_버블소트프로그램 {
    /*
     * for(N만큼 반복하기)
     * {
     *    A[i]의 정렬 전 index - 정렬 후 index 계산의 최댓값을 찾아 저장하기
     * }
     * 최댓값 + 1을 정답으로 출력하기 
     * 
     * 별도 클래스 선언하기 
     * mData(데이터 표현)
     * {
     *   index, value를 가지며
     *   value 기준 오름차순 정렬 함수 Comparable 구현하기 
     * }
     */
    
    public static void main(String[] args) throws IOException {
       BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
       int N = Integer.parseInt(reader.readLine());
       mData[] A = new mData[N];

        for (int i = 0; i < N; i++) {
           A[i] = new mData(Integer.parseInt(reader.readLine()), i);
        }

        Arrays.sort(A);
        int Max = 0;
        for (int i = 0; i < N; i++) {
            if(Max < A[i].index - i) // 정렬 전 index - 정렬 후 index 계산의 최댓값 저장하기 
            Max = A[i].index - i;
        }
        System.out.println(Max + 1);
    }
}

class mData implements Comparable<mData>{
    int value;
    int index;

    public mData(int value, int index){
        super();
        this.value = value;
        this.index = index;
    }

    @Override
    public int compareTo(mData o){ // value 기준으로 오름차순 정렬하기
        return this.value - o.value;
    }
}
