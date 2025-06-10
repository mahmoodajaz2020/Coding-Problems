package util.leetcode.Num77Combinations2;

import java.util.ArrayList;
import java.util.List;

public class Combinations2 {
    public List<List<Integer>> combine(int n, int k) {
        return rec(k, n, k);
    }
    List<List<Integer>> rec (int k, int n, int maxK){
        System.out.println(" Calling, k="+ k+ " /n="+n);
        List<List<Integer>> listF= new ArrayList<>();
        if(k==1){
            for(int i=1; i<=n-maxK+1; i++){
                List<Integer> listInner= new ArrayList<>();
                listInner.add(i);
                System.out.println(" added"+ listInner);
                listF.add(listInner);
            }
            return listF;
        }
        List<List<Integer>> listBelow= rec(k-1, n, maxK);
        for(List<Integer> listInnerBelow: listBelow){
            int sizeBelow=listInnerBelow.size();
            int sizeLeft= maxK-sizeBelow;
            System.out.println(" running for "+ listInnerBelow);
            if(sizeBelow==maxK){
                return listBelow;
            }
            int maxBelow=listInnerBelow.get(listInnerBelow.size()-1);
            int i=maxBelow+1;
            while(n-i+1>=sizeLeft){
                List<Integer> listInnerNew= new ArrayList<>(listInnerBelow);
                listInnerNew.add(i);
                System.out.println(" added"+ listInnerNew);
                listF.add(listInnerNew);
                i++;
            }
        }
        return listF;
    }
}
