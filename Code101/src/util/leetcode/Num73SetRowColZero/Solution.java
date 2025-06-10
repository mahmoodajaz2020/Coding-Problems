package util.leetcode.Num73SetRowColZero;

import java.util.*;

public class Solution {
    public void setZeroes(int[][] matrix) {
        HashMap<Integer, Integer> rowZMap= new HashMap<>();
        HashMap<Integer, Integer> colZMap= new HashMap<>();
        Set<List<Integer>> setOriginal= new HashSet<>();
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){

                if(matrix[i][j]==0){
                    ArrayList<Integer> list1=  new ArrayList<>();
                    list1.add(i);
                    list1.add(j);
                    setOriginal.add(list1);
                }
            }
        }
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[i].length; j++){
                ArrayList<Integer> list1=  new ArrayList<>();
                list1.add(i);
                list1.add(j);
                if(matrix[i][j]==0 && setOriginal.contains(list1)){
                    if(colZMap.get(j)==null){
                        setColZero(matrix, j);
                        colZMap.put(j, 1);
                    }
                    if(rowZMap.get(i)==null){
                        setRowZero(matrix, i);
                        rowZMap.put(i, 1);
                    }
                }
            }
        }
    }
    static void setRowZero(int[][] matrix, int rowN){
        for(int i=0; i<matrix[rowN].length; i++){
            matrix[rowN][i]=0;
        }
    }
    static void setColZero(int[][] matrix, int colN){
        for(int i=0; i<matrix.length; i++){
            matrix[i][colN]=0;
        }
    }
}
