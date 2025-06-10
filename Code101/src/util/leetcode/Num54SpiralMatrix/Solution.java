package util.leetcode.Num54SpiralMatrix;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list1= new ArrayList<>();
        rec(matrix, 0,matrix.length-1,0, matrix[0].length-1, list1);
        return list1;
    }
    static void rec(int[][] matrix, int rowStart, int rowEnd,
                             int colStart, int colEnd, List<Integer> list1){
        if(rowEnd<rowStart || colEnd<colStart){
            return;
        }
        //run uprow-right
        //run col down
        //run row left
        //run col up
        //repeat
        runRowRight(matrix, rowStart, colStart, colEnd, list1);
        runColDown(matrix, colEnd, rowStart, rowEnd, list1);
        if(rowStart<rowEnd) {
            runRowLeft(matrix, rowEnd, colStart, colEnd, list1);
        }
        if(colStart<colEnd) {
            runColUp(matrix, colStart, rowStart, rowEnd, list1);
        }
        rec(matrix, ++rowStart, --rowEnd, ++colStart, --colEnd, list1);
    }
    static void runRowRight(int[][] matrix, int rowN,
                                     int colStart, int colEnd, List<Integer> list1){
        for(int i=colStart; i<=colEnd; i++){
            list1.add(matrix[rowN][i]);
        }
    }
    static void runColDown(int[][] matrix, int colN,
                            int rowStart, int rowEnd, List<Integer> list1){
        for(int i=rowStart+1; i<=rowEnd; i++){
            list1.add(matrix[i][colN]);
        }
    }
    static void runRowLeft(int[][] matrix, int rowN,
                            int colStart, int colEnd, List<Integer> list1){
        for(int i=colEnd-1; i>=colStart; i--){
            list1.add(matrix[rowN][i]);
        }
    }
    static void runColUp(int[][] matrix, int colN,
                           int rowStart, int rowEnd, List<Integer> list1){
        for(int i=rowEnd-1; i>rowStart; i--){
            list1.add(matrix[i][colN]);
        }
    }
}