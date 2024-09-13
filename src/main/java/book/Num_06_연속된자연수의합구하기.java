package book;

import java.io.IOException;
import java.util.Scanner;

public class Num_06_연속된자연수의합구하기 { //백준에서는 Main으로 class명을 설정해야함.
    // 투 포인터 이동 원칙
    // sum > N 
    // sum = sum - start_index; start_index++;
    // sum < N
    // end_index++; sum = sum + end_index;
    // sum == N
    // end_index++; sum = sum + end_index; count++;

    // N 변수 저장
    // 사용 변수 초기화(count = 1. start_index = 1, end_index = 1, sum = 1)
    // while(end_index != N){
    // if(sum == N) count 증가, end_index 증가, sum 값 변경
    // else if(sum > N) sum 값 변경, start_index 증가
    // else if(sum < N) end_index 증가, sum 값 변경
    // }
    // count 출력

    public static void main(String[] args) throws IOException{ 
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int count = 1;
    int start_index = 1;
    int end_index = 1;
    int sum = 1;

    while(end_index != N){
        if(sum == N){
            end_index++; 
            sum = sum + end_index; 
            count++; 
        }else if(sum > N){
            sum = sum - start_index; 
            start_index++;
        }else{
            end_index++; 
            sum = sum + end_index;
        }
    }
    System.out.println(count);    
    }
}
