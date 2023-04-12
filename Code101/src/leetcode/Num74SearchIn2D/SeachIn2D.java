package leetcode.Num74SearchIn2D;

public class SeachIn2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        return binarySearch(matrix, 0, (matrix.length*matrix[0].length)-1,target);
    }

    boolean binarySearch(int[][] matrix, int start, int end, int target){
        System.out.println(" Running for start="+ start + " AND end="+end);

        int mid=(end+start)/2;
        int midIndexR= mid/matrix[0].length;
        int midIndexC=mid% matrix[0].length;
        if(matrix[midIndexR][midIndexC]==target){
            return true;
        }
        int sIR=start/matrix[0].length;
        int sIC=start% matrix[0].length;
        int eIR=end/matrix[0].length;
        int eIC=end% matrix[0].length;
        if(end==start+1){
            if(target==matrix[sIR][sIC] || target==matrix[eIR][eIC]){
                return true;
            }
            return false;
        }
        if(target<matrix[sIR][sIC] || target> matrix[eIR][eIC]){
            return false;
        }
        if(matrix[midIndexR][midIndexC]<target){
            start=mid;
        }
        else {
            end=mid;
        }
        return binarySearch(matrix, start, end, target);
    }
}
