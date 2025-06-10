package util.leetcode.Num78Subsets;

import java.util.*;
import java.util.stream.Collectors;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        int min=nums[0];
        int max=nums[nums.length-1];
        List<Integer> set1= Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> listF= new ArrayList<>();
        List<Integer> listIn= new ArrayList<>();
        listF.add(listIn);
        listF.addAll(fn2(set1, new HashSet<>()));
        return listF;
    }
    List<List<Integer>> fn2(List<Integer> list1, HashSet<List<Integer>> set1){
        List<List<Integer>> listF= new ArrayList<>();
        if(list1.size()==0){
            return listF;
        }
        for(int i=list1.size()-1; i>=0; i--){
                List<Integer> listInnerSend = new ArrayList<>();
                int num=list1.get(i);
                for(int k=0; k<list1.size(); k++){
                    if(k!=i){
                        listInnerSend.add(list1.get(k));
                    }
                }
                List<List<Integer>> listLower = fn2(listInnerSend, set1);
                listF.addAll(listLower);
                for(int j=0; j<listLower.size(); j++){
                    List<Integer> innerList= new ArrayList<>(listLower.get(j));
                    innerList.add(num);
                    if(!set1.contains(innerList)) {
                        listF.add(innerList);
                        set1.add(innerList);
                    }
                }
                List<Integer> numList= new ArrayList<>();
                numList.add(num);
                if(!set1.contains(numList)) {
                    listF.add(numList);
                    set1.add(numList);
                }
            }
        return listF;
    }
}
