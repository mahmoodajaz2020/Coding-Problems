package leetcode.Num75SortColors;

import java.util.HashMap;

public class SortColors {
    public void sortColors(int[] nums) {
        HashMap<Integer, Integer> map1= new HashMap<>();
        map1.put(0, 0);
        map1.put(1, 0);
        map1.put(2,0);
        for(int i=0; i<nums.length; i++){
            map1.put(nums[i], map1.get(nums[i])+1);
        }
        int pointer=0;
        for(int i=0; i<3; i++){
            while(map1.get(i)>0){
                nums[pointer]=i;
                map1.put(i, map1.get(i)-1);
                pointer++;
            }
        }

    }
}
