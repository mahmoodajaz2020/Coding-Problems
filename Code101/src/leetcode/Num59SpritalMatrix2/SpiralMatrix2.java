package leetcode.Num59SpritalMatrix2;

public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] arr= new int[n][n];
        rec(arr, n*n, 1, 0, n-1, 0, n-1, n);
        return arr;
    }
    void rec(int[][] arr, int max, int num, int rowS,int rowE, int colS,int colE, int n){
        System.out.println(" Running for r="+ rowS + ", "+ rowE+ "  // c=="+ colS+ ", "+colE);
        if(rowS>rowE || colS>colE){
            return;
        }
        int colDownNum=rowRight(rowS, colS, colE, arr, num);
        int rowLeftNum=colDown(colE, rowS, rowE, arr, colDownNum);
        int colUpNum=rowLeft(rowE, colE, colS,arr, rowLeftNum );
        int nextCallNum=colUp(colS, rowE, rowS, arr,colUpNum);
        rec(arr, max, nextCallNum, rowS+1, rowE-1, colS+1, colE-1, n);
    }
    int rowRight(int r, int colS, int colE, int[][] arr, int num){
        for(int i=colS; i<=colE; i++){
            arr[r][i]=num;
            num++;
        }
        return num;
    }
    int colDown(int c, int rowS, int rowE, int[][] arr, int num){
        for(int i=rowS+1; i<rowE; i++){
            arr[i][c]=num;
            num++;
        }
        return num;
    }
    int rowLeft(int r, int colS, int colE, int[][] arr, int num){
        for(int i=colS; i>colE; i--){
            arr[r][i]=num;
            num++;
        }
        return num;
    }
    int colUp(int c, int rowS, int rowE, int[][] arr, int num){
        for(int i=rowS; i>rowE; i--){
            arr[i][c]=num;
            num++;
        }
        return num;
    }
}
