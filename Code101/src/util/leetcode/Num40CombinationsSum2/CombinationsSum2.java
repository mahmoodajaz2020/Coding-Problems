package util.leetcode.Num40CombinationsSum2;

import java.util.*;

public class CombinationsSum2 {
    static int counter=0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        HashSet<List<Integer>> set1= new HashSet<>();
        List<Integer> listInner= new ArrayList<>();
        rec(candidates, 0, target, listInner, set1, new HashSet<>());
        List<List<Integer>> listFinal = new ArrayList<>(set1);
        return listFinal;

    }

    void rec(int[] arr, int index , int target, List<Integer> listIndices, HashSet<List<Integer>> set1, HashSet<List<Integer>> setChecked){
        System.out.println("------RUNNING count="+ ++counter);
        System.out.println(" Running for index="+ index+  " /target="+target);
        System.out.println("    list="+listIndices);
        if(index>=arr.length){
            return;
        }
        if(target<=0){
            return;
        }
        boolean found=false;
        int c=0;
        for(int i=index; i<arr.length; i++){
            if(arr[i]==target){
                c=i;
                found=true;
                break;
            }
        }
        if(found){
            List<Integer> foundCombination= new ArrayList<>();
            for (int a : listIndices) {
                foundCombination.add(arr[a]);
            }
            foundCombination.add(target);
            System.out.println("                                     Found at index="+c+ "  adding"+ foundCombination);
            set1.add(foundCombination);
        }
        for(int i=index; i<arr.length; i++){
            int targetBelow=target-arr[i];
            if(targetBelow<=0){
                break;
            }
            List<Integer> listIndicesNew= new ArrayList<>(listIndices);
            listIndicesNew.add(i);
            List<Integer> listCh= new ArrayList<>();
            for(int j=0; j<listIndicesNew.size(); j++){
                listCh.add(arr[listIndicesNew.get(j)]);
            }
            System.out.println("       listchekced="+ listCh);
            if(!setChecked.contains(listCh)) {
                setChecked.add(listCh);
                rec(arr, i + 1, targetBelow, listIndicesNew, set1, setChecked);
            }
        }
    }
}
