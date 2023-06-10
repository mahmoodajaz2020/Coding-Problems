package leetcode.Num47Permutations2;

import java.util.*;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list1= new ArrayList<>();
        for (int num : nums) {
            list1.add(num);
        }
        Set<List<Integer>> set1= new HashSet<>();

        List<List<Integer>> listF= new ArrayList<>( helper(list1, set1));
        return listF;
    }
    public HashSet<List<Integer>> helper(List<Integer> list1, Set<List<Integer>> set1){
        HashSet<List<Integer>> listF= new HashSet<>();
        if(list1.size()==0){
            List<Integer> listInner= new ArrayList<>();
            listF.add(listInner);
            return listF;
        }
        for(int i=0; i<list1.size(); i++){
            List<Integer> list2= new ArrayList<>(list1);
            int removedInt=list2.get(i);
            list2.remove(i);
            List<List<Integer>> listBelow= new ArrayList<>(helper(list2, set1));
            for(int j=0; j<listBelow.size(); j++){
                List<Integer> listInner= new ArrayList<>(listBelow.get(j));
                listInner.add(removedInt);
                listF.add(listInner);
            }
        }
        return listF;
    }
}
