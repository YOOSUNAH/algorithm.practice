package book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Num_12_오큰수구하기{ //백준에서는 Main으로 class명을 설정해야함.
    /*
     * A[index] > A[top]  현재까지 쌓인 stack 중 마지막 것.
     * pop으로 오큰수 저장, 데이터 push
     * 
     * N (수열 개수) A[](수열배열) ans[](정답 배열)
     * 수열 배열 채우기 
     * 최초 스택 초기화하기 
     * for(N만큼 반복){
     *   while(스택이 비어 있지 않고, 현재 수열 값이 top에 해당하는 수열보다 클때까지){
     *     pop
     *     정답 배열에 오큰수를 현재 수열로 저장하기   
     *  }
     *   현재 수열을 스택에 push
     * }
     * while(스택이 빌 때까지){
     *  스택에 있는 인덱스의 정답 배열에 -1 저장하기 
     * }
     * 정답 배열 출력하기 
     * 
     */


    public static void main(String[] args) throws IOException{ 
      BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
      int n = Integer.parseInt(bf.readLine());  // 4
      int[]A = new int[n]; // 수열 배열 생성
      int[]ans = new int[n]; // 정답 배열 생성 
      
      String[] str = bf.readLine().split(" ");
      for (int i = 0; i < n; i++) {
        A[i] = Integer.parseInt(str[i]); // 3, 5, 2, 7 
      }
    
      Stack<Integer> myStack = new Stack<>();
      myStack.push(0); // 처음에는 항상 스택이 비어있으므로 최초값을 push 해 초기화 
      for (int i = 1; i < n; i++) {
        // 스택이 비어있지 않고, 현재 수열이 > 스택 top 인덱스가 가리키는 수열보다 클 경우 
            while(!myStack.isEmpty() &&  A[myStack.peek()] < A[i]){
               ans[myStack.pop()] = A[i];
            }
            myStack.push(i);
      }

      while (!myStack.empty()) {
        ans[myStack.pop()] = -1;
      }

      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
      for (int i = 0; i < n; i++) {
        bw.write(ans[i] + " ");
      }
      bw.write("\n");
      bw.flush();
    }
}
