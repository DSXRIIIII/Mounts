package cn.dsxriiiii.coding;

/**
 * @ProjectName: Mounts
 * @Author: DSXRIIIII
 * @CreateDate: 2024/8/10 14:54
 * @Email: lihh53453@hundsun.com
 * @Description:
 */
public enum pakage {
    A,B,C;
    private pakage(){
        System.out.println(1);
    }

    public static void main( String[] argv )
    {
        System.out.println(pakage.A);
    }

}

