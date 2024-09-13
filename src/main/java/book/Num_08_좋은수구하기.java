package book;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

public class Num_08_좋은수구하기{ //백준에서는 Main으로 class명을 설정해야함.
    /*
     * 투 포인터 이동 원칙
     * A[i] + [j] > K:
     * j--; 
     * 
     * A[i] + A[j] < K: 
     * i++;
     * 
     * A[i] + A[j] == k: 
     * i++; j--; count++;
     * 
     */
    public static void main(String[] args) throws NumberFormatException, IOException{ 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bf.readLine());
        int answer = 0;
        long A[] = new long[N];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Long.parseLong(st.nextToken());
        }
        Arrays.sort(A);

        for (int k = 0; k < N; k++) {
            long findK = A[k];
            int i = 0;
            int j = N - 1;

            while (i < j) { // i == j 같아지면 멈춰짐
                if(A[i] + A[j] == findK){
                    // k인지 아닌지 확인하고, 카운트하기
                    if(i != k && j != k){
                        answer++;
                        break;
                    }else if(i == k){
                        i++;
                    }else if(j == k){
                        j--;
                    }
                }else if(A[i] + A[j] < findK){
                    i++;
                }else{
                    j--;
                }                   
            }
        }
        System.out.println(answer);
        bf.close();
    }
}
