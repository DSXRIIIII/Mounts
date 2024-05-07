package cn.dsxriiiii.LanQiao.tryfirst.A1707;
import java.util.Scanner;

public class Main {
    static int nowLocation = 0;
    static String s;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        s = scanner.nextLine();
        scanner.close();
        System.out.println(dfs());
    }
    public static int dfs(){
        int MaxNum = 0;
        int temp = 0;
        while(nowLocation<s.length()){
            if(s.charAt(nowLocation) == '('){
                nowLocation++;
                temp += dfs();
            }else if(s.charAt(nowLocation) == 'x'){
                temp++;
                nowLocation++;
            }else if(s.charAt(nowLocation) == '|'){
                MaxNum = Math.max(temp,MaxNum);
                temp = 0;
                nowLocation++;
            }else if(s.charAt(nowLocation) == ')'){
                nowLocation++;
                return Math.max(MaxNum,temp);
            }
        }
        return Math.max(temp,MaxNum);
    }
}
