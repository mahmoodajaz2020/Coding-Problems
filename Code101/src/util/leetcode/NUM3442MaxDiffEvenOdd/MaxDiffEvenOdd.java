package util.leetcode.NUM3442MaxDiffEvenOdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MaxDiffEvenOdd {
    public int maxDifference(String s) {
        Map<Character, Integer> map = new HashMap();
        List<Character> list = new ArrayList();
        for(int i=0; i<s.length(); i++){
            char ch= s.charAt(i);
            if(map.get(ch)==null){
                list.add(ch);
                map.put(ch, 1);
            }
            else{
                map.put(ch, map.get(ch)+1);
            }
        }
        int max=0;
        int min=Integer.MAX_VALUE;
        for(char ch: list){
            int num=map.get(ch);
            if(num%2!=0){
                if(num>max){
                    max=num;
                }
            }
            else{
                if(num<min){
                    min=num;
                }
            }
        }
        return max-min;
    }

}
