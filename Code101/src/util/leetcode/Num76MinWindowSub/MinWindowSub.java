package util.leetcode.Num76MinWindowSub;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Re do
public class MinWindowSub {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> countInT = new HashMap<>();
        for (char ch : t.toCharArray()) {
            if (countInT.get(ch) == null) {
                countInT.put(ch, 1);
            } else {
                countInT.put(ch, countInT.get(ch) + 1);
            }
        }
        System.out.println(countInT);
        List<Integer> validStarts= new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            if(countInT.get(s.charAt(i))!=null){
                validStarts.add(i);
            }
        }
        System.out.println(validStarts);
        int kk=0;
        int start= validStarts.get(kk);
        String currentMin=s;
        String minMin=s;
        boolean found=false;
        while(start<=s.length()-t.length()){
            System.out.println(" Upper loop for start="+start);
            currentMin="";
            HashMap<Character, Integer> countChecker = new HashMap<>(countInT);
            for(int i=start; i<s.length(); i++){
                System.out.println("        Inner loop for i="+i);
                System.out.println("            countch="+countChecker);
                if(countChecker.get(s.charAt(i))!=null){
                    if(countChecker.get(s.charAt(i))==1){
                        countChecker.remove(s.charAt(i));
                    }
                    else{
                        countChecker.put(s.charAt(i), countChecker.get(s.charAt(i))-1);
                    }
                }
                if(countChecker.isEmpty()){
                    found=true;
                    currentMin=s.substring(start, i+1);
                    if(currentMin.length()<minMin.length()){
                        minMin=currentMin;
                    }
                    break;
                }
                if(countChecker.size()>s.length()-i){
                    break;
                }
            }
            kk++;
            if(kk<validStarts.size()) {
                start = validStarts.get(kk);
            }
            else{
                break;
            }
        }
        if(!found){
            return "";
        }
        return minMin;
    }
}
