package cn.dsxriiiii.lanQiao.answer.practice.C.A1904;

import java.util.*;

public class Main {
    static int[][] dirs = {{1,0},{0,-1},{0,1},{-1,0}};
    static char[] path = {'D','L','R','U'};
    static int[][] visit = new int[30][50];
    static int[][] dis = new int[30][50];
    static StringBuilder route = new StringBuilder();

    static Queue<Integer> queue = new LinkedList<>();
    static void dfs(String[] maze,int i,int j){
        visit[i][j] = 1;
        int m = maze.length;
        int n = maze[0].length();
        if(i == 29 && j == 49){
            return;
        }
        for(int temp = 0;temp < dirs.length;temp++){
            int next_x = dirs[temp][0] + i;
            int next_y = dirs[temp][1] + j;
            if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n && maze[next_x].charAt(next_y) == '0' && visit[next_x][next_y] == 0){
                route.append(path[temp]);
                visit[next_x][next_y] = 1;
                dfs(maze,next_x,next_y);
            }
        }
    }
    static void bfs(String[] maze){
        int i,j;
        int m = maze.length;
        int n = maze[0].length();
        while(!queue.isEmpty()){
            int node = queue.poll();
            i = node / 50;
            j = node % 50;
            for(int temp = 0;temp < dirs.length;temp++){
                int next_x = dirs[temp][0] + i;
                int next_y = dirs[temp][1] + j;
                if(next_x >= 0 && next_x < m && next_y >= 0 && next_y < n && maze[next_x].charAt(next_y) == '0' && dis[i][j] == 0){
                    dis[next_x][next_y] = dis[i][j];
                    queue.add(next_x*50 +next_y);
                    if(next_x == 0 && next_y == 0){
                        break;
                    }
                }
            }

        }
    }
    public static void main(String[] args) {
        String[] maze = {
                "01010101001011001001010110010110100100001000101010",
                "00001000100000101010010000100000001001100110100101",
                "01111011010010001000001101001011100011000000010000",
                "01000000001010100011010000101000001010101011001011",
                "00011111000000101000010010100010100000101100000000",
                "11001000110101000010101100011010011010101011110111",
                "00011011010101001001001010000001000101001110000000",
                "10100000101000100110101010111110011000010000111010",
                "00111000001010100001100010000001000101001100001001",
                "11000110100001110010001001010101010101010001101000",
                "00010000100100000101001010101110100010101010000101",
                "11100100101001001000010000010101010100100100010100",
                "00000010000000101011001111010001100000101010100011",
                "10101010100001101010100101000010100000111011101001",
                "10000000101100010000101100101101001011100000000100",
                "10101001000000010100100001000100000100011110101001",
                "00101001010101101001010100011010101101110000110101",
                "11001010000100001100000010100101000001000111000010",
                "00001000110000110101101000000100101001001000011101",
                "10100101000101000000001110110010110101101010100001",
                "00101000010000110101010000100010001001000100010101",
                "10100001000110010001000010101001010101011111010010",
                "00000100101000000110010100101001000001000000000010",
                "11010000001001110111001001000011101001011011101000",
                "00000110100010001000100000001000011101000000110011",
                "10101000101000100010001111100010101001010000001000",
                "10000010100101001010110000000100101010001011101000",
                "00111100001000010000000110111000000001000000001011",
                "10000001100111010111010001000110111010101101111000"
        };
        queue.add(29*50+49);
        bfs(maze);
        System.out.println(dis);
    }

}
