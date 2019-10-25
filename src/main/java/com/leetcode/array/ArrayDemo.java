package com.leetcode.array;

import org.junit.Test;

public class ArrayDemo {
    /**
     * 1232. Check If It Is a Straight Line
     * @param coordinates
     * @return
     * demo
     *
     * Input: coordinates = [[1,2],
                         * [2,3],
                         * [3,4],
                         * [4,5],
                         * [5,6],
                         * [6,7]]
     * Output: true
     */
    @Test
    public void testCheckStraightLine(){
        int[][] coordinates3 = {{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        //[[-4,-3],[1,0],[3,-1],[0,-1],[-5,2]]
        int[][] coordinates2 = {{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
        //[[-3,-2],[-1,-2],[2,-2],[-2,-2],[0,-2]]
        int[][] coordinates = {{-3,-2},{-1,-2},{2,-2},{-2,-2},{0,-2}};
        System.out.println((double)3/(double)5);
        ArrayDemo arrayDemoD = new ArrayDemo();
        System.out.println(arrayDemoD.checkStraightLine(coordinates));
    }

    /**
     * 思路：连续两个坐标的斜率是相同的，需要注意的是被除数为0的情况，实际上在坐标轴上就是一条竖线
     * 根本要素还是要考虑到 斜率的特殊情况，说到底还是边界问题
     */
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates[1][0]-coordinates[0][0]==0){
            for(int i = 1; i < coordinates.length-1; i++) {
                if(coordinates[i+1][0]-coordinates[i][0]!=0){
                    return false;
                }
            }
            return true;
        }
        double xielv =  (double)(coordinates[1][1]-coordinates[0][1])/(double)(coordinates[1][0]-coordinates[0][0]);

        for(int i = 1; i < coordinates.length-1; i++) {
            if(coordinates[i+1][0]-coordinates[i][0]==0){
                return false;
            }
            if(((coordinates[i+1][1]-coordinates[i][1])/(coordinates[i+1][0]-coordinates[i][0]))!=xielv){
                return false;
            }
        }
        return true;
    }
}


