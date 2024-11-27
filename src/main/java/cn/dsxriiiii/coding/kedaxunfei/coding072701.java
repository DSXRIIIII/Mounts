package cn.dsxriiiii.coding.kedaxunfei;

import java.util.*;

/**
 * @PackageName: cn.dsxriiiii.coding.kedaxunfei
 * @Author: DSXRIIIII
 * @Email: 1870066109@qq.com
 * @Date: Created in  2024/11/12 20:04
 * @Description:
 **/
public class coding072701 {
    static class house {
        long comfort;
        long price;
        public house (long comfort,long price) {
            this.comfort = comfort;
            this.price = price;
        }
    }
    public static void main(String[] args) {
        TreeMap<Long,Integer> friend = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            long value = scanner.nextLong();
            friend.put(value,friend.getOrDefault(value,0) + 1);
        }
        List<house> list = new ArrayList<>();
        while(m-->0){
            String[] s = scanner.nextLine().split(" ");
            list.add(new house(Long.parseLong(s[0]),Long.parseLong(s[1])));
        }
        list.sort((a,b) -> Long.compare(b.price,a.price));
        long maxComfortSum = 0;
        for(house myhouse : list){
            Map.Entry<Long, Integer> ent = friend.ceilingEntry(myhouse.price);
            if (ent != null) {
                maxComfortSum += myhouse.comfort;
                Integer value = ent.getValue();
                if (value <= 1){
                    friend.remove(ent.getKey());
                }else{
                    friend.put(ent.getKey(),ent.getValue() - 1);
                }
            }
        }
        System.out.println(maxComfortSum);
    }
}
