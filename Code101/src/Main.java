import leetcode.Num2309RemoveStars.RemoveStars;
import leetcode.Num70SimplifyPath.SimplifyPath;
import leetcode.Num73SetRowColZero.Solution;
import leetcode.Num74SearchIn2D.SeachIn2D;
import leetcode.Num75SortColors.SortColors;
import leetcode.Num76MinWindowSub.MinWindowSub;
import leetcode.Num90Subsets.Subsets2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[]nums={0,1,2,0,0,0,1,1,1};
        SortColors sortColors= new SortColors();
        sortColors.sortColors(nums);
        System.out.println(Arrays.toString(nums));

    }
}