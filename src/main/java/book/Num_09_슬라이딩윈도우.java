package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Num_09_슬라이딩윈도우{ //백준에서는 Main으로 class명을 설정해야함.
    /*
     * 슈도코드 작성
     * S(문자열 크기) 
     * P(부분 문자열의 크기)
     * A(문자열 데이터)
     * checkArr(비밀번호 체크 배열) 
     * 변수 선언
     * myArr(현재 상태 배열)
     * checkSecret(몇 개의 문자와 관련된 개수를 충족했는지 판단하는 변수)
     * P 범위(0 ~ P - 1)만큼 S 배열에 적용하고, 유효한 비밀번호인지 판단하기 
     * for(i 를 P에서 S까지 반복){
     *   j 선언 (i - P)
     *   한칸씩 이동하면서 제거되는 문자열과 새로 들어오는 문자열을 처리하기 
     *   유효한 비밀번호인지 (checkSecret == 4) 판단해 결괏값에 업데이트하기 
     * }
     * 결과값 출력하기 
     * 
     * 별도 함수
     * Add(문자 더하기 함수){
     *   새로 들어온 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기 
     * }
     * Remove(문자 빼기 함수){
     *   제거되는 문자를 myArr에 업데이트하거나 checkSecret 값 변경하기 
     * }
     *   
     *  
     */

     static int checkArr[];
     static int myArr[];
     static int checkSecret;

    public static void main(String[] args) throws NumberFormatException, IOException{ 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int S = Integer.parseInt(st.nextToken()); // DNA 문자열의 길이
        int P = Integer.parseInt(st.nextToken());  // 부분 문자열의 길이
        
        int Result = 0;
        char A[] = new char[S];  // DNA 문자열 저장할 배열
        checkArr = new int[4]; // ACGT 최소 갯수 저장할 배열, 비밀번호 체크 배열
        myArr = new int[4];  // 현재 상태 배열
        checkSecret = 0;

        A = bf.readLine().toCharArray(); // DNA 문자열

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());  //  ACGT 최소 갯수 저장
            if (checkArr[i] == 0) {  // 해당 문자가 0개 이상 필요한 경우, 미리 조건 만족 처리
                checkSecret++;         
            }    
        }

        // 초기 P부분 문자열 처리 부분
        for (int i = 0; i < P; i++) {
            Add(A[i]);
        }
        if (checkSecret == 4) 
            Result++;

        // 슬라이딩 윈도우 처리 부분
        for (int i = P; i < S; i++) {
            int j = i - P;
            Add(A[i]);
            Remove(A[j]); // 이전 윈도우에서 빠져나간 문자 제외
            if(checkSecret == 4)
                Result++;
        }
        System.out.println(Result);
        bf.close();
    }


    private static void Add(char c){
        switch (c) {
            case 'A':
                myArr[0]++;
                if(myArr[0] == checkArr[0])
                   checkSecret++;
                break;
            case 'C':
                myArr[1]++;
                if(myArr[1] == checkArr[1])
                   checkSecret++;
                break;
            case 'G':
                myArr[2]++;
                if(myArr[2] == checkArr[2])
                   checkSecret++;
                break;    
            case 'T':
                myArr[3]++;
                if(myArr[3] == checkArr[3])
                   checkSecret++;
                break;        
        }
    }

    private static void Remove(char c){
        switch (c) {
            case 'A':
                if(myArr[0] == checkArr[0])
                   checkSecret--;
                myArr[0]--;                
                break;
            case 'C':
                if(myArr[1] == checkArr[1])
                   checkSecret--;
                myArr[1]--;                
                break;
            case 'G':
                if(myArr[2] == checkArr[2])
                   checkSecret--;
                myArr[2]--;                
                break;    
            case 'T':
                if(myArr[3] == checkArr[3])
                   checkSecret--;
                myArr[3]--;                
                break;    
        }
    }

}
