package util.leetcode.Num90Subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return rec(nums, 0, nums.length-1, new HashSet<>());
    }
    static List<List<Integer>> rec(int[] nums, int start, int end, HashSet<List<Integer>> set1){
        if(end<start){
            List<Integer> emptyList= new ArrayList<>();
            List<List<Integer>> retList= new ArrayList<>();
            retList.add(emptyList);
            return retList;
        }
        List<List<Integer>> retBelow= rec(nums, start, end-1, set1);
        List<List<Integer>> retList= new ArrayList<>();
        retList.addAll(retBelow);
        List<Integer> oneList= new ArrayList<>();
        oneList.add(nums[end]);
        if(!set1.contains(oneList)){
            retList.add(oneList);
            set1.add(oneList);
        }
        for(int i=0; i<retBelow.size(); i++){
            List<Integer> innerListBelow=  new ArrayList<>(  retBelow.get(i));
            innerListBelow.add(nums[end]);
            if(!set1.contains(innerListBelow)){
                retList.add(innerListBelow);
                set1.add(innerListBelow);
            }
        }
        return retList;
    }
}
