package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Tree1_easy {
    static class Tree {
        Map<Integer, List<Integer>> tree;

        public Tree(){
            tree = new HashMap<>();
            tree.put(1, new ArrayList<>());
        }

        public void insert(int X, int Y) {
           if(!tree.containsKey(X)){
               tree.put(X, new ArrayList<>());
           }
            tree.get(X).add(Y);
        }

        public List<Integer> printChild(int X) {
            return tree.get(X);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Tree tree = new Tree();

        for (int i = 0; i < N; i++) {
            String[] command = sc.nextLine().split(" ");
            if(command[0].equals("insert")){
                int X = Integer.parseInt(command[1]);
                int Y = Integer.parseInt(command[2]);
                tree.insert(X, Y);
            } else if (command[0].equals("printChild")) {
                int X = Integer.parseInt(command[1]);
                List<Integer> printChild = tree.printChild(X);
                for(int child : printChild){
                    System.out.print(child + " ");
                }
            }
        }
        sc.close();
    }
}




