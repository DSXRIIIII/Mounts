import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapTest {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        while(n > 0){
            n--;
            boolean res = true;;
            int m = scan.nextInt();
            int[] key = new int[m];
            int[] value = new int[m];
            Map<Integer,Integer> map = new HashMap<>();
            for(int i = 0;i < m;i++){
                key[i] = scan.nextInt();
            }
            for(int j = 0;j < m;j++){
                value[j] = scan.nextInt();
            }
            //scan.nextInt();


            //为什么这里在第三次循环停止允许以下代码了

            //删除了多余的nextLine才解决
            for(int k = 0;k < m;k++){
                if(map.containsKey(key[k])){
                    if(map.get(key[k]) != value[k]){
                        res = false;
                        break;
                    }
                }else{
                    map.put(key[k],value[k]);
                }
            }
            System.out.println(res?"Yes":"No");
        }
        scan.close();
    }
}
