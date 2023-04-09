import leetcode.Num54SpiralMatrix.Solution;

public class Main {
    public static void main(String[] args) {
        Solution sol= new Solution();
        int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
        int[][] matrix2={{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(sol.spiralOrder(matrix));
        System.out.println(sol.spiralOrder(matrix2));

    }
}