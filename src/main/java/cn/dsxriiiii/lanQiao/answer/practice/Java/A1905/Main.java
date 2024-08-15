package cn.dsxriiiii.lanQiao.answer.practice.Java.A1905;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] tree = new int[num];
        for(int i = 0;i<num;i++){
            tree[i] = scanner.nextInt();
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        int level = 1;
        int max = tree[0];
        int ans = level;
        while(!queue.isEmpty()){
            int size = queue.size();
            int temp = 0;
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                temp+=tree[node];
                int left = (node<<1) + 1;
                int right = (node<<1) + 2;
                if(left < num){
                    queue.add(left);
                }
                if(right < num){
                    queue.add(right);
                }
            }
            if(temp > max){
                max = temp;
                ans = level;
            }
            level++;
        }
        System.out.println(ans);
    }
}
