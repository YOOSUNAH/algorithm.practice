package book;

import java.util.Scanner;
import java.util.Stack;

public class Num_11_스택으로오름차순수열만들기{ //백준에서는 Main으로 class명을 설정해야함.
    /*
     * 첫번째 줄에 수열의 개수 : n
     * n개의 줄에는 수열을 이루는 정수 1개씩 
     * push 연산은 +
     * pop 연산은 -
     * 불가능할때는 NO 출력
     * 
     * 
     * N : 수열 개수
     * A[] : 수열 배열
     * 수열 배열 채우기 
     * for(N만큼 반복)
     * {
     *   if(현재 수열 값 >= 오름차순 자연수){
     *    while(값이 같아질 때까지)
     *    {
     *     push()
     *     (+) 저장
     *  }
     *  pop()
     * (-)저장
     * }
     * else (현재 수열 값 < 오름차순 자연수){
     *   pop()
     *   if(스택 pop 결과값 > 수열의 수) NO 출력
     *   else(-) 저장
     *  }
     * }
     *if(-값을 출력한적이 없으면) 저장한 값 출력  
     */


    public static void main(String[] args){ 
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }
       
        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int num = 1; // 오름차순 수 
        boolean result = true;

        for (int i = 0; i < A.length; i++) {
            int su = A[i]; // 현재 수열의 수 
            if(su >= num){
                while(su >= num){
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }else{
                int n = stack.pop();
                if(n > su){
                    System.out.println("NO");
                    result = false;
                    break;
                }
                else{
                    bf.append("-\n");
                }
            }
        }
        if(result) System.out.println(bf.toString());
    }
}
